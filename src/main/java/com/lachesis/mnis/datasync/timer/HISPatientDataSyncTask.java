package com.lachesis.mnis.datasync.timer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.lachesis.mnis.datasync.inter.nurse.service.IComSyncService;
import com.lachesis.mnis.datasync.inter.nurse.service.IDataSyncService;
import com.lachesis.mnis.datasync.utils.DateUtil;

@Component
@Lazy(false)
public class HISPatientDataSyncTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(HISPatientDataSyncTask.class);

	@Autowired
	private IDataSyncService dataSyncService;

	@Autowired
	private IComSyncService comSyncService;

	/**
	 * 同步患者数据
	 */
	public void doSyncPatCurInfos() {
		LOGGER.info("  ----》his sync task start! ------->"
				+ DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		System.out.println("  ----》his sync task start! ------->"
				+ DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		boolean result = dataSyncService.savePatCurInfos();
		LOGGER.info("  ----》his sync task end!   result:" + result + "------->"
				+ DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		System.out.println("  ----》his sync task end!   result:" + result + "------->"
				+ DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
	}

	/**
	 * 同步公用数据
	 */
	 public void doSyncPub() {
		LOGGER.info(
				"  ----》his Pub start! ------->" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		comSyncService.insertComWards();
		LOGGER.info(
				"  ----》ward task end! ------->" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		comSyncService.insertComUsers();
		LOGGER.debug("  ----》his Pub task end! ------->"
				+ DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
	}

	 /*
	 * 同步检验
	 */
	public void doSyncLabTest() {
		System.out.println(
				"----》his LIS sync task start!" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		dataSyncService.savePatLabTestMas();
		System.out.println(
				"----》his LIS sync task end!" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
	}

	/** 
	 * 同步医嘱
	 *//*
*/	public void doSyncOrder() {
		System.out.println(
				"----》his order sync task start!" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
		dataSyncService.saveOrders();
		System.out.println(
				"----》his order sync task end!" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
	} 
}
