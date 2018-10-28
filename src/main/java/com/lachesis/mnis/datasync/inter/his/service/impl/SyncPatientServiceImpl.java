package com.lachesis.mnis.datasync.inter.his.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lachesis.mnis.datasync.entity.lis.PatLabTestDetail;
import com.lachesis.mnis.datasync.entity.lis.PatLabTestMas;
import com.lachesis.mnis.datasync.entity.order.PatOrderGroup;
import com.lachesis.mnis.datasync.entity.patient.PatCureInfo;
import com.lachesis.mnis.datasync.entity.pub.ComBed;
import com.lachesis.mnis.datasync.entity.pub.ComUser;
import com.lachesis.mnis.datasync.entity.pub.ComWard;
import com.lachesis.mnis.datasync.entity.pub.ComWardUser;
import com.lachesis.mnis.datasync.inter.his.mapper.HISDataMapper;
import com.lachesis.mnis.datasync.inter.his.mapper.HisOrdersDataMapper;
import com.lachesis.mnis.datasync.inter.his.service.ISyncPatientService;
import com.lachesis.mnis.datasync.inter.lis.mapper.LISDataMapper;
import com.lachesis.mnis.datasync.utils.DateUtil;

@Service("syncPatientService")
public class SyncPatientServiceImpl implements ISyncPatientService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SyncPatientServiceImpl.class);

	@Autowired
	private HISDataMapper hisDataMapper;

	@Autowired
	private HisOrdersDataMapper hisOrdersDataMapper;
	
	public List<PatCureInfo> getHisChangePatCureInfo(String wardCode, String upTime) {
		LOGGER.debug("----开始获取his变更信息----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		List<PatCureInfo> patCureInfos = hisDataMapper.getHisChangePatCureInfo(wardCode, upTime);

		LOGGER.debug("----结束后时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		int size = (patCureInfos != null ? patCureInfos.size() : 0);
		LOGGER.debug("----获取数据条数：" + size);

		return patCureInfos;
	}

	public List<PatCureInfo> getHisInAllPatCureInfo(String wardCode) {
		// 获取病区（科室）下所有在院病人
		LOGGER.debug("----开始获取病区时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		List<PatCureInfo> patCureInfos = hisDataMapper.getHisInAllPatCureInfo(wardCode);
		LOGGER.debug("----获取病区后时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));

		return patCureInfos;
	}

	public List<ComWard> getComWards(String upTime) {
		LOGGER.debug("----开始获取病区时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		List<ComWard> comWards = hisDataMapper.getComWards(upTime);
		LOGGER.debug("----获取病区后时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		return comWards;
	}

	public List<ComUser> getComUsers(String wardCode) {
		LOGGER.debug("----开始获取用户时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		List<ComUser> comUsers = hisDataMapper.getComUsers(wardCode);
		LOGGER.debug("----获取用户后时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		return comUsers;
	}

	public List<ComBed> getComBeds(String upTime) {
		LOGGER.debug("----开始获取床位时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		List<ComBed> comBeds = null;// hisDataMapper.getComBeds(upTime);
		LOGGER.debug("----获取床位后时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		return comBeds;
	}

	public List<ComWardUser> getComWardUsers() {
		LOGGER.debug("----开始获取用户病区设置时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		List<ComWardUser> comWardUsers = null;// hisDataMapper.getComWardUsers();
		LOGGER.debug("----获取用户病区设置后时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		return comWardUsers;
	}

	public Date getDatabaseServerTime() {
		return hisDataMapper.getDatabaseServerTime();
	}

	public List<PatOrderGroup> getPatInsulinOrder(String deptId,Date upTime) {
		LOGGER.debug("----开始胰岛素医嘱时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		List<PatOrderGroup> patOrderOriginals = hisOrdersDataMapper.getPatInsulinOrderGroups(deptId, upTime);
		LOGGER.debug("----结束获取胰岛素医嘱时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		return patOrderOriginals;
	}

	public List<PatOrderGroup> getPatOralOrder(String deptId,Date upTime) {
		LOGGER.debug("----开始口服药医嘱时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		List<PatOrderGroup> patOrderOriginals = hisOrdersDataMapper.getPatOralOrderGroups(deptId, upTime);
		LOGGER.debug("----结束获取口服药医嘱时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		return patOrderOriginals;
	}
}
