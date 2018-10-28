package com.lachesis.mnis.datasync.inter.nurse.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.lachesis.mnis.datasync.entity.SysDataSync;
import com.lachesis.mnis.datasync.entity.lis.PatLabTestMas;
import com.lachesis.mnis.datasync.entity.order.PatOrderGroup;
import com.lachesis.mnis.datasync.entity.order.PatOrderItem;
import com.lachesis.mnis.datasync.entity.patient.PatCureInfo;
import com.lachesis.mnis.datasync.entity.pub.ComWard;
import com.lachesis.mnis.datasync.inter.his.service.ISyncPatientService;
import com.lachesis.mnis.datasync.inter.lis.service.ISyncLisService;
import com.lachesis.mnis.datasync.inter.nurse.mapper.ComSyncMapper;
import com.lachesis.mnis.datasync.inter.nurse.mapper.DataSyncMapper;
import com.lachesis.mnis.datasync.inter.nurse.mapper.LabTestSyncMapper;
import com.lachesis.mnis.datasync.inter.nurse.service.IDataSyncService;
import com.lachesis.mnis.datasync.utils.Constants;
import com.lachesis.mnis.datasync.utils.DateUtil;
import com.lachesis.mnis.datasync.web.Interconnection;

@Service("dataSyncService")
public class DataSyncServiceImpl extends ComSyncServiceImpl implements IDataSyncService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataSyncServiceImpl.class);

	@Autowired
	private DataSyncMapper dataSyncMapper;

	@Autowired
	private ComSyncMapper comSyncMapper;

	@Autowired
	private ISyncPatientService syncPatientService;

	@Autowired
	private ISyncLisService syncLisService;
	
	@Autowired
	private  Interconnection interconnectionService;

	@Value(value = "${updateNew}")
	private boolean updateNew;

	/*
	 * @Autowired private SqlSessionFactory sqlSessionFactoryNr;
	 */

	public boolean savePatCurInfos() {

		SysDataSync dataSync = getDataSync(Constants.TABLE_PAT_CURE_INFO);
		if (dataSync == null) {
			LOGGER.error("没有在sys_datasync表中配置PAT_CURE_INFO");
			return false;
		}

		String upTime = null;
		try {
			upTime = DateUtil.formatDateToString(dataSync.getUpTime(), DateUtil.DATE_FORMAT_FULL);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Date nowTime = syncPatientService.getDatabaseServerTime(); // 当前日期，用于修改参数表中最后更新时间
		int dataSize = 0; // 实际更新数据条数

		// 添加参数控制 是增量更新还是全院更新（全院按科室为实例循环更新）
		// if(upCount>=syncAllC){
		List<ComWard> comWards = null;
		try {
			comWards = comSyncMapper.getComWards();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}

		if (comWards != null && comWards.size() > 0) {
			List<PatCureInfo> patCureInfos = null;
			for (ComWard comWard : comWards) { // 循环查询病区下所有病人信息
				patCureInfos = syncPatientService.getHisChangePatCureInfo(comWard.getDept_code(), upTime); 
				savePatCureInfos(comWard.getDept_code(), patCureInfos);
				dataSize = dataSize + patCureInfos.size();
			}
			 
		} else {
			throw new RuntimeException("没有配置科室");
		}
		
		/*
		 * }else{ //按照入院和出院日期增量更新 List<PatCureInfo> patCureInfos=
		 * syncPatientService.getHisChangePatCureInfo(upTime);
		 * 
		 * //保存患者信息 dataSize = savePatCureInfos(patCureInfos); upCount++; }
		 */

		// 同步患者最后更新信息

		updateDataSync(nowTime, dataSync);
		comSyncMapper.upDataSync(dataSync);

		// 同步患者更新日志
		saveSysDataSyncLog(nowTime, dataSize, Constants.TABLE_PAT_CURE_INFO);

		return true;
	}

	/**
	 * 保存患者信息
	 * 
	 * @param patCureInfos
	 */
	private int savePatCureInfos(String wardCode, List<PatCureInfo> patCureInfos) {

		int dataSize = 0;
		if (patCureInfos != null && patCureInfos.size() > 0) {
			SqlSession session = openBatchSession();
			//武汉市中心医院-互联互通接口调用
			 if(patCureInfos!=null && patCureInfos.size()>0){
				 interconnectionService.CallWs(patCureInfos.get(0).getHosp_no());
				// System.out.println("int savePatCureInfos;");
			} 
			try {
				if (!updateNew) {
					dataSyncMapper.updateAllToOut(wardCode, patCureInfos);
				}
				for (PatCureInfo patCureInfo : patCureInfos) {
					dataSize++;
					LOGGER.info(DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_YMDHMS) + "------用户"
							+ dataSize + "：" + patCureInfo.getWard_code() + ":" + patCureInfo.getPat_id() + ":"
							+ patCureInfo.getName() + ":" + patCureInfo.getBed_code() + ":"
							+ patCureInfo.getOut_date());

					PatCureInfo queryBean = dataSyncMapper.getPatByPatId(patCureInfo.getPat_id());
					if (queryBean == null) {
						dataSyncMapper.insertPatCurInfo(patCureInfo);
					} else {
						if (!patCureInfo.getWard_code().equals(queryBean.getWard_code())
								|| !"Y".equals(queryBean.getStatus())
								|| !patCureInfo.getBed_code().equals(queryBean.getBed_code())) {
							dataSyncMapper.updatePatCurInfo(patCureInfo);
						}
					}

				}
				batchSessionCommit(session);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				dataSize = -1;
				session.rollback();
				throw new RuntimeException(e);
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
		return dataSize;
	}

	/**
	 * 保存检验主表数据
	 */
	public void savePatLabTestMas() {

		Date nowTime = syncLisService.getDatabaseServerTime(); // 当前日期，用于修改参数表中最后更新时间
		SysDataSync dataSync = getDataSync(Constants.TABLE_PAT_LAB_TEST_MAS);
		if (dataSync == null) {
			LOGGER.debug(Constants.TABLE_PAT_LAB_TEST_MAS + "参数为空！");
			return;
		}
		SqlSession session = null;
		Date upTime = null;
		try {
			upTime = dataSync.getUpTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			List<PatLabTestMas> patLabTestMas = syncLisService.getLabTestMas(upTime);
			if (null != patLabTestMas && patLabTestMas.size() > 0) {
				session = openBatchSession();
				LabTestSyncMapper mapper = session.getMapper(LabTestSyncMapper.class);

				for (PatLabTestMas labTestMas : patLabTestMas) {
					PatLabTestMas queryBean = null;
					try {
						queryBean = mapper.findLabTestByNo(labTestMas);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// // 先删除信息在重新插入
					for (int i = 0; i < labTestMas.getItems().size(); i++) {
						labTestMas.getItems().get(i).setItem_no(i + 1);
					}
					if (queryBean == null) {
						mapper.insertPatLabTestMas(labTestMas);
						mapper.insetLabTestDetail(labTestMas.getItems());
					}
				}

				batchSessionCommit(session);
			}
			updateDataSync(nowTime, dataSync);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		} 
}

	/**
	 * 获取参数表信息 同时修改该表正在更新状态
	 * 
	 * @param tableName
	 * @return
	 */
	public SysDataSync getDataSync(String tableName) {
		SysDataSync dataSync = comSyncMapper.getDataSync(tableName);
		if (null == dataSync || null == dataSync.getUpTime()) { // 参数设置不全 先补全参数
			return null;
		}

		dataSync.setStatus(1);// 正在同步患者信息
		comSyncMapper.upDataSync(dataSync);
		return dataSync;
	}

	/**
	 * 同步his医嘱信息 2015.05.19
	 */
	public void saveOrders() {
		SysDataSync dataSync = getDataSync(Constants.TABLE_PAT_ORDER_ORIGINAL);
		if (dataSync == null) {
			LOGGER.error("没有在sys_datasync表中配置TABLE_PAT_ORDER_ORIGINAL");
			return;
		}
		SqlSession session = null;
		Date upTime = null;
		Date nowTime = syncPatientService.getDatabaseServerTime(); // 当前日期，用于修改参数表中最后更新时间
		try {
			upTime = dataSync.getUpTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<ComWard> comWards = null;
		try {
			comWards = comSyncMapper.getComWards();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}

		if (comWards != null && comWards.size() > 0) {
			for (ComWard comWard : comWards) { // 循环查询病区下所有病人信息
				List<PatOrderGroup> insulinOrderlist = syncPatientService.getPatInsulinOrder(comWard.getDept_code(),
						upTime);
				List<PatOrderGroup> oralOrderlist = syncPatientService.getPatOralOrder(comWard.getDept_code(), upTime);
				if (null != insulinOrderlist && null != oralOrderlist) {
					try {
						session = openBatchSession();
						for (PatOrderGroup insulinOrder : insulinOrderlist) {
							String queryBean = dataSyncMapper.findInsulinOrderByNo(insulinOrder.getOrderNo()); // 先删除信息在重新插入
							if (queryBean == null) {
								dataSyncMapper.insertInsulinOrder(insulinOrder);
								List<PatOrderItem> items = insulinOrder.getItems();
								for (Iterator iterator = items.iterator(); iterator.hasNext();) {
									PatOrderItem patOrderItem = (PatOrderItem) iterator.next();
									Date exeTime = insulinOrder.getExec_time();
									// 用药时间段
									int useFreqTime = parseUseTime(exeTime);
									patOrderItem.setMedTime(useFreqTime);
									patOrderItem.setMainId(insulinOrder.getId());
									dataSyncMapper.insertInsulinOrderItem(patOrderItem);
								}
							}
						}
						for (PatOrderGroup oralOrder : oralOrderlist) {
							String queryBean = dataSyncMapper.findOralOrderByNo(oralOrder.getOrderNo()); // 先删除信息在重新插入
							if (queryBean == null) {
								dataSyncMapper.insertOralOrder(oralOrder);
								List<PatOrderItem> items = oralOrder.getItems();
								for (Iterator iterator = items.iterator(); iterator.hasNext();) {
									PatOrderItem patOrderItem = (PatOrderItem) iterator.next();
									Date exeTime = oralOrder.getExec_time();
									// 用药时间段
									int useFreqTime = parseUseTime(exeTime);
									patOrderItem.setMedTime(useFreqTime);
									patOrderItem.setMainId(oralOrder.getId());
									dataSyncMapper.insertOralOrderItem(patOrderItem);
								}
							}
						}
						batchSessionCommit(session);
					} catch (Exception e) {
						LOGGER.debug(e.getMessage());
						System.out.println(e.getMessage());
					} finally {
						if (session != null) {
							session.close();
						}
					}

				}

				if (null != oralOrderlist && oralOrderlist.size() > 0) {
					try {
						session = openBatchSession();

						batchSessionCommit(session);
					} catch (Exception e) {
						LOGGER.debug(e.getMessage());
						System.out.println(e.getMessage());
					} finally {
						if (session != null) {
							session.close();
						}
					}

				}
			}
			updateDataSync(nowTime, dataSync);
		} else {
			throw new RuntimeException("没有配置科室");
		}

		// 同步原始医嘱

	}

	private int parseUseTime(Date exeTime) {
		Calendar c = Calendar.getInstance();
		c.setTime(exeTime);
		int time = c.get(Calendar.HOUR_OF_DAY);
		if (time < 8) {
			return 11;
		} else if (time < 14) {
			return 21;
		} else if (time < 20) {
			return 31;
		} else {
			return 41;
		}
	}
	 
}
