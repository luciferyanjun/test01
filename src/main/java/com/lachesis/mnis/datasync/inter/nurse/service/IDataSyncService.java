package com.lachesis.mnis.datasync.inter.nurse.service;



/**
 * 同步数据到移动护理系统
 * @author qingzhi.liu 2015.05.14
 *
 */
public interface IDataSyncService {
	
	/**
	 * 同步his病人信息
	 * @return
	 */
	public boolean savePatCurInfos();
	
	/**
	 * 同步检验信息
	 */
	public void savePatLabTestMas();

	public void saveOrders();
	
}
