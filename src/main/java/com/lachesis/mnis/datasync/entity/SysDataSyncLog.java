package com.lachesis.mnis.datasync.entity;

import java.util.Date;

/**
 * 更新日志表
 * @author qingzhi.liu 2015.05.18
 *
 */
public class SysDataSyncLog {
	//tableName,startTime,endTime,upRows
	private String tableName;   //表名称
	private Date startTime;   //开始更新时间
	private Date endTime;    //结束更新时间
	private int upRows;   //更新条数
	public SysDataSyncLog() {
		super();
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getUpRows() {
		return upRows;
	}
	public void setUpRows(int upRows) {
		this.upRows = upRows;
	}
	
	
}
