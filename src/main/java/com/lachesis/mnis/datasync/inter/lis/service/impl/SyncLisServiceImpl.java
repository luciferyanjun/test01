package com.lachesis.mnis.datasync.inter.lis.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lachesis.mnis.datasync.entity.lis.PatLabTestMas;
import com.lachesis.mnis.datasync.inter.lis.mapper.LISDataMapper;
import com.lachesis.mnis.datasync.inter.lis.service.ISyncLisService;
import com.lachesis.mnis.datasync.utils.DateUtil;

@Service("syncLisService")
public class SyncLisServiceImpl implements ISyncLisService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SyncLisServiceImpl.class);

	@Autowired
	private LISDataMapper lisDataMapper;

	public List<PatLabTestMas> getLabTestMas(Date startTime) {
		
		LOGGER.debug("----开始获取检验主表数据时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		List<PatLabTestMas> labTestMas = lisDataMapper.getLabTestMas(startTime);
		LOGGER.debug("----获取检验主表后时间----------" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		
		return labTestMas;
	}

	public Date getDatabaseServerTime() {
		return lisDataMapper.getDatabaseServerTime();
	}

}
