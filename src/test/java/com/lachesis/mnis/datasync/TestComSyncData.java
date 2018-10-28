//package com.lachesis.mnis.datasync;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.lachesis.mnis.datasync.inter.nurse.service.IComSyncService;
//
//@RunWith(value=SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:/applicationContext-sync-test.xml")
//public class TestComSyncData {
//	
//	@Autowired
//	private IComSyncService comSyncService;
//	
//	//@Test
//	public void testInsertComUsers(){
//		System.out.println("----》Users sync task start!"+System.currentTimeMillis());
//		comSyncService.insertComUsers();
//		System.out.println("----》Users sync task end!"+System.currentTimeMillis());
//	}
//	
//	//@Test
//	public void testInsertComBeds(){
//		System.out.println("----》Beds sync task start!"+System.currentTimeMillis());
//		comSyncService.insertComBeds();
//		System.out.println("----》Beds sync task end!"+System.currentTimeMillis());
//	}
//	
//	//@Test
//	public void testInsertComWards(){
//		System.out.println("----》Wards sync task start!"+System.currentTimeMillis());
//		comSyncService.insertComWards();
//		System.out.println("----》Wards sync task end!"+System.currentTimeMillis());
//	}
//	
//
//}
