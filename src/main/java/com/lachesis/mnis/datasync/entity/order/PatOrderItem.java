package com.lachesis.mnis.datasync.entity.order;

/**
 * 医嘱明细表
 * 
 * @author qingzhi.liu 2015.05.13
 *
 */
public class PatOrderItem {
	private Long mainId;    //主记录ID
	private String orderNo; // 医嘱号

	private String itemCode; // 药物代码
	private String itemName; // 药物名称
	private Double dosage; // 剂量

	private Integer medTime;  //用药时间段

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getDosage() {
		return dosage;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public Long getMainId() {
		return mainId;
	}

	public void setMainId(Long mainId) {
		this.mainId = mainId;
	}

	public Integer getMedTime() {
		return medTime;
	}

	public void setMedTime(Integer medTime) {
		this.medTime = medTime;
	}

}
