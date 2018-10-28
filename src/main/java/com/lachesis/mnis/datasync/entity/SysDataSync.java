package com.lachesis.mnis.datasync.entity;

import java.util.Date;

/**
 * 数据同步类
 * @author qingzhi.liu  2015.05.18
 *
 */
public class SysDataSync {
	//tableName, upTime, upCount, syncAllC, status
	private String tableName;  //表名称
	private Date upTime;   //更新时间
	private int upCount;   //更新次数
	private int syncAllC;   //设定多少次全表更新(针对患者信息)
	private int status;  //更新状态(1: 正在更新   0:更新完毕)
	
	public SysDataSync() {
		super();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public int getUpCount() {
		return upCount;
	}

	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}

	public int getSyncAllC() {
		return syncAllC;
	}

	public void setSyncAllC(int syncAllC) {
		this.syncAllC = syncAllC;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
