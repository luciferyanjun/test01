// package com.lachesis.mnis.datasync;
//
//import java.util.Date;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.lachesis.mnis.datasync.inter.nurse.service.IComSyncService;
//import com.lachesis.mnis.datasync.inter.nurse.service.IDataSyncService;
//import com.lachesis.mnis.datasync.timer.HISPatientDataSyncTask;
//import com.lachesis.mnis.datasync.utils.DateUtil;
//
//@RunWith(value = SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:/applicationContext-sync-test.xml")
//public class TestHisPatientDataSyncTask {// extends
//	// AbstractJUnit4SpringContextTests{
//	private static final Logger LOGGER = LoggerFactory.getLogger(HISPatientDataSyncTask.class);
//	@Autowired
//	private IDataSyncService dataSyncService;
//
//	@Autowired
//	private IComSyncService comSyncService;
////	@Test
//	public void testInject() {
//		IDataSyncService dataSyncService = applicationContext.getBean("dataSyncService", DataSyncServiceImpl.class);
//
//		Assert.assertNotNull(dataSyncService);
//	} 
//	@Test
//	public void testSavePatCurInfos() {
//		LOGGER.debug(" ----》his sync task start!");
//		System.out.println(
//				"----》his sync task start!" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
//		dataSyncService.savePatCurInfos();
//		System.out.println(
//				"----》his sync task end!" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
//		LOGGER.debug(" ----》his sync task end!" + DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
//	}  
//	  @Test public void testSaveUser() {
//	  LOGGER.debug(" ----》his sync task start!"); System.out.println(
//	  "----》his sync task start!" + DateUtil.formatDateToString(new Date(),
//	  DateUtil.DATE_FORMAT_FULL)); comSyncService.insertComUsers();
//	  System.out.println( "----》his sync task end!" +
//	  DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
//	  LOGGER.debug(" ----》his sync task end!" + DateUtil.formatDateToString(new
//	  Date(), DateUtil.DATE_FORMAT_FULL)); }
//	  
//	  @Test public void testSaveWard() {
//	  LOGGER.debug(" ----》his sync Ward start!"); System.out.println(
//	  "----》his sync Ward start!" + DateUtil.formatDateToString(new Date(),
//	  DateUtil.DATE_FORMAT_FULL)); comSyncService.insertComWards();
//	  System.out.println( "----》his sync Ward end!" +
//	  DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
//	  LOGGER.debug(" ----》his sync Ward end!" + DateUtil.formatDateToString(new
//	  Date(), DateUtil.DATE_FORMAT_FULL)); }
//	  
//	  @Test public void testSavePatLabTestMass() { System.out.println(
//	  "----》his LIS sync task start!" + DateUtil.formatDateToString(new Date(),
//	  DateUtil.DATE_FORMAT_FULL)); dataSyncService.savePatLabTestMas();
//	  System.out.println( "----》his LIS sync task end!" +
//	  DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL)); }
//	  
//	  // @Test public void testSaveOrder() { System.out.println(
//	  "----》his order sync task start!" + DateUtil.formatDateToString(new
//	  Date(), DateUtil.DATE_FORMAT_FULL)); dataSyncService.saveOrders();
//	  System.out.println( "----》his order sync task end!" +
//	  DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL)); }
//	  
//	  
//	  @Test public void testSaveBed() {
//	  LOGGER.debug(" ----》his sync bed start!"); System.out.println(
//	  "----》his sync bed start!" + DateUtil.formatDateToString(new Date(),
//	  DateUtil.DATE_FORMAT_FULL)); comSyncService.insertComBeds();
//	  System.out.println( "----》his sync bed end!" +
//	  DateUtil.formatDateToString(new Date(), DateUtil.DATE_FORMAT_FULL));
//	  LOGGER.debug(" ----》his sync bed end!" + DateUtil.formatDateToString(new
//	  Date(), DateUtil.DATE_FORMAT_FULL)); }
//}