package com.lachesis.mnis.datasync.inter.nurse.service;

/**
 * HIS数据同步到移动护理系统  公用表
 * 床位、部门（如果有病区的概念）、用户（护士信息）、病区（科室）  权限、角色
 * @author qingzhi.liu 2015.05.18
 *
 */
public interface IComSyncService {
	
	/**
	 * 更新床位信息 全表
	 */
	public void insertComBeds();
	
	/**
	 * 更新护士信息
	 */
	public void insertComUsers();
	
	/**
	 * 更新病区信息
	 */
	public void insertComWards();
	
}
