package com.lachesis.mnis.datasync.inter.nurse.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lachesis.mnis.datasync.entity.SysDataSync;
import com.lachesis.mnis.datasync.entity.SysDataSyncLog;
import com.lachesis.mnis.datasync.entity.pub.ComBed;
import com.lachesis.mnis.datasync.entity.pub.ComUser;
import com.lachesis.mnis.datasync.entity.pub.ComWard;
import com.lachesis.mnis.datasync.entity.pub.ComWardUser;
import com.lachesis.mnis.datasync.inter.his.service.ISyncPatientService;
import com.lachesis.mnis.datasync.inter.nurse.mapper.ComSyncMapper;
import com.lachesis.mnis.datasync.inter.nurse.service.IComSyncService;
import com.lachesis.mnis.datasync.utils.Constants;

@Service("comSyncService")
public class ComSyncServiceImpl implements IComSyncService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ComSyncServiceImpl.class);

	@Autowired
	private ComSyncMapper comSyncMapper;
	
	@Autowired
	private ISyncPatientService syncPatientService;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactoryNr;

	public void insertComBeds() {
		Date nowTime = syncPatientService.getDatabaseServerTime(); ; 
		SysDataSync dataSync = getDataSync(Constants.TABLE_COM_BED);
		if(dataSync==null){
			LOGGER.debug("参数为空！");
			return ;
		}
		int dataSize = 0;
		SqlSession session = null;
		try {
			List<ComBed> comBeds = syncPatientService.getComBeds(null);
			if (null != comBeds && comBeds.size() > 0) {
				session = openBatchSession();
				ComSyncMapper mapper = session.getMapper(ComSyncMapper.class);

				int i = 0;
				List<ComBed> list = new ArrayList<ComBed>();
				for (ComBed comBed : comBeds) {
					mapper.deleteComBed(comBed.getCode());  //先删除用户信息在重新插入
					list.add(comBed);
					i++;
					if (i % 50 == 0) {
						mapper.insertComBeds(list);
						dataSize = dataSize + list.size();
						if (i != comBeds.size()) {
							list = new ArrayList<ComBed>();
						}
					}
				}

				if (list != null && list.size() > 0) {
					int size = mapper.insertComBeds(list);
					System.out.println(size);
					dataSize = dataSize + list.size();
				}
				batchSessionCommit(session);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			dataSize=-1;
			System.out.println(e.getMessage());
		}finally{
			if(session!=null){
				session.close();
			}
		}
		/*if(dataSize>0){
			
		}*/
		updateDataSync(nowTime, dataSync);
		
		//同步患者更新日志
		saveSysDataSyncLog(nowTime, dataSize,Constants.TABLE_COM_BED);
	}

	/**
	 * 同步用户信息
	 */
	public void insertComUsers() {
		Date nowTime = syncPatientService.getDatabaseServerTime(); ; 
		SysDataSync dataSync = getDataSync(Constants.TABLE_COM_USER);
		if(dataSync==null){
			LOGGER.error("没有在sys_datasync表中配置TABLE_COM_USER");
			return ;
		}
		int dataSize = 0;
		SqlSession session = null;
		boolean flag = false;
		try {
			 List<ComWard> comWards = comSyncMapper.getComWards();
			if (null != comWards && comWards.size() > 0) {
				session = openBatchSession();
				for (ComWard comWard : comWards) {
					List<ComUser> comUsers = syncPatientService.getComUsers(comWard.getDept_code());
					if (null != comUsers && comUsers.size() > 0) {
						ComSyncMapper mapper = session.getMapper(ComSyncMapper.class);
						//mapper.removeUserAllNotIn(comUsers);
						for (ComUser comUser : comUsers) {
							List<ComUser> Users = mapper.getComUser(comUser.getCode());
							if(Users==null||Users.size()==0){
								mapper.insertComUser(comUser);
								mapper.insertComWardUser(comUser);
							}else{
								for (ComUser queryBean : Users) {
									if(comUser.getWard_code() != null){
										if(comUser.getWard_code().equals(queryBean.getWard_code())){
											flag = true;
										}
									}
								}
								ComWardUser comWardUser = new ComWardUser();
								comWardUser.setUser_code(comUser.getCode());
								comWardUser.setWard_code(comUser.getWard_code());
								if(flag){
									mapper.deleteComWardUser(comWardUser);
								}
								mapper.insertComWardUser(comUser);
								flag = false;
							}
						}
						batchSessionCommit(session);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
			dataSize=-1;
			System.out.println(e.getMessage());
		}finally{
			if(session!=null){
				session.close();
			}
		}
		/*if(dataSize>0){
			
		}*/
		updateDataSync(nowTime, dataSync);
		
		//同步患者更新日志
		saveSysDataSyncLog(nowTime, dataSize,Constants.TABLE_COM_USER);
		
		insertComWardUsers();

	}

	public void saveSysDataSyncLog(Date nowTime, int dataSize,String tableName) {
		SysDataSyncLog synclog = new SysDataSyncLog();
		synclog.setTableName(tableName);
		synclog.setStartTime(nowTime);
		synclog.setEndTime(new Date());
		synclog.setUpRows(dataSize);
		comSyncMapper.insertDataSyncLog(synclog);
	}

	public void updateDataSync(Date nowTime, SysDataSync dataSync) {
		dataSync.setStatus(0);
		dataSync.setUpTime(nowTime);
		comSyncMapper.upDataSync(dataSync);
	}
	
	
	public void insertComWardUsers(){
		int dataSize = 0;
		SqlSession session = null;
		try {
			List<ComWardUser> comWardUsers = syncPatientService.getComWardUsers();
			if (null != comWardUsers && comWardUsers.size() > 0) {
				session = openBatchSession();
				ComSyncMapper mapper = session.getMapper(ComSyncMapper.class);

				int i = 0;

				List<ComWardUser> list = new ArrayList<ComWardUser>();
				for (ComWardUser comWardUser : comWardUsers) {
					mapper.deleteComWardUser(comWardUser);  //先删除用户信息在重新插入
					list.add(comWardUser);
					i++;
					if (i % 100 == 0) {
						mapper.insertComWardUsers(list);
						dataSize = dataSize + list.size();
						if (i != comWardUsers.size()) {
							list = new ArrayList<ComWardUser>();
						}
					}
				}

				if (list != null && list.size() > 0) {
					int size = mapper.insertComWardUsers(list);
					System.out.println(size);
					dataSize = dataSize + list.size();
				}
				batchSessionCommit(session);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			dataSize=-1;
			System.out.println(e.getMessage());
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}

	/**
	 * 同步病区信息
	 */
	public void insertComWards() {
		
		Date nowTime = new Date() ; 
		SysDataSync dataSync = getDataSync(Constants.TABLE_COM_WARD);
		if(dataSync==null){
			LOGGER.error("没有在sys_datasync表中配置TABLE_COM_WARD");
			return ;
		}
		int dataSize = 0;
		SqlSession session = null;
		try {
			List<ComWard> comWards = syncPatientService.getComWards(null);
			if (null != comWards && comWards.size() > 0) {
				session = openBatchSession();
				ComSyncMapper mapper = session.getMapper(ComSyncMapper.class);
				mapper.removeWardAllNotIn(comWards);
				for (ComWard comWard : comWards) {
					dataSize++;
					ComWard queryBean = mapper.getComWardById(comWard.getDept_code());
					if(queryBean == null){
						mapper.insertComWard(comWard);
					}else{
						if(!"Y".equals(queryBean.getFlag())){
							mapper.updateComWard(comWard);
						}
					}
				}

				batchSessionCommit(session);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			dataSize=-1;
			session.rollback();
		}finally{
			if(session!=null){
				session.close();
			}
		}

		if(dataSize>0){
			updateDataSync(nowTime, dataSync);
		}
		
		//同步患者更新日志
		
		saveSysDataSyncLog(nowTime, dataSize, Constants.TABLE_COM_WARD);
	}
	
	
	/**
	 * 获取参数表信息 同时修改该表正在更新状态
	 * @param tableName
	 * @return
	 */
	public SysDataSync getDataSync(String tableName){
		SysDataSync dataSync = comSyncMapper.getDataSync(tableName);
//		if(null==dataSync||null==dataSync.getUpTime()){  //参数设置不全 先补全参数
//			return null;
//		}
		
//		dataSync.setStatus(1);//正在同步患者信息
//		comSyncMapper.upDataSync(dataSync); 
		return dataSync;
	}

	public SqlSession openBatchSession() { 
		return sqlSessionFactoryNr.openSession(ExecutorType.BATCH, false);
	}

	public void batchSessionCommit(SqlSession session) {
		// 手动每1000个一提交，提交后无法回滚
		session.commit();
		// 清理缓存，防止溢出
		session.clearCache();
	}

}
