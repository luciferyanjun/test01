package com.lachesis.mnis.datasync.entity.order;

import java.util.Date;
import java.util.List;

/**
 * 医嘱组，存储和医嘱相关的公共信息
 * 
 * @author qingzhi.liu 2015.05.13
 *
 */
public class PatOrderGroup {
	private Long id;

	private String patId; // 住院流水号
	private String orderNo; // 医嘱号

	private Date exec_time; // 执行时间
	private List<PatOrderItem> items;

	public String getPatId() {
		return patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getExec_time() {
		return exec_time;
	}

	public void setExec_time(Date exec_time) {
		this.exec_time = exec_time;
	}

	public List<PatOrderItem> getItems() {
		return items;
	}

	public void setItems(List<PatOrderItem> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
