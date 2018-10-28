package com.lachesis.mnis.datasync.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 
 * 血糖值
 * 
 * @author lei.lei
 *
 */ 
public class Glucose {
	private int id;

	private String glucose_id; //业务主键
	private String pat_code;// 患者ID
	private String pat_name;// 患者姓名
	private String bed_code; // 床位号

	private String nurse_code;// 测量护士ID
	private String nurse_name;// 测量忽视姓名
	private String device_code;// 设备识别码
	private String device_name;// 设备名称
	private String value; // 血糖值
	private String unit; // 單位

	private String time; // 测量时间
	private String updateTime;// 上传时间
	private String type; // 血糖类型
	private String typeCode;
	private String flag; // 是否为异常值
	private String range; // 正常值范围
	private String is_valid; //是否有效
	private String his_success = "0";// 添加HIS系统是否成功 0：失败 1：成功
	private int isMsg;
	private int isRead;
	private String is_handle; //是否处理，1：已处理  0：未处理
	private String remark;
	private Patient patient;
	private BigDecimal maxValue;
	private BigDecimal minValue;
	
	private String hospitalNo;
	private boolean selected;
    private String upload; // "0" 表示未上传，"1"表示已上传
    private int status; 
    private String typeStr;

	private String wardCode;
	//血糖时间 6点血糖为6:00 随机为NDA当前时间
	@JsonProperty("glucose_time")
	private String glucoseTime;
	
    
	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public String getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getGlucose_id() {
		return glucose_id;
	}

	public void setGlucose_id(String glucose_id) {
		this.glucose_id = glucose_id;
	}

	public String getIs_handle() {
		return is_handle;
	}

	public void setIs_handle(String is_handle) {
		this.is_handle = is_handle;
	}

	public String getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}

	public int getIsMsg() {
		return isMsg;
	}

	public void setIsMsg(int isMsg) {
		this.isMsg = isMsg;
	}

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBed_code() {
		return bed_code;
	}

	public void setBed_code(String bed_code) {
		this.bed_code = bed_code;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPat_code() {
		return pat_code;
	}

	public void setPat_code(String pat_code) {
		this.pat_code = pat_code;
	}

	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getNurse_code() {
		return nurse_code;
	}

	public void setNurse_code(String nurse_code) {
		this.nurse_code = nurse_code;
	}

	public String getNurse_name() {
		return nurse_name;
	}

	public void setNurse_name(String nurse_name) {
		this.nurse_name = nurse_name;
	}

	public String getDevice_code() {
		return device_code;
	}

	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getHis_success() {
		return his_success;
	}

	public void setHis_success(String his_success) {
		this.his_success = his_success;
	}

	public BigDecimal getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	@Override
	public String toString() {
		return "Glucose [id=" + id + ", glucose_id=" + glucose_id + ", pat_code=" + pat_code + ", pat_name=" + pat_name
				+ ", bed_code=" + bed_code + ", nurse_code=" + nurse_code + ", nurse_name=" + nurse_name
				+ ", device_code=" + device_code + ", device_name=" + device_name + ", value=" + value + ", unit="
				+ unit + ", time=" + time + ", updateTime=" + updateTime + ", type=" + type + ", typeCode=" + typeCode
				+ ", flag=" + flag + ", range=" + range + ", is_valid=" + is_valid + ", his_success=" + his_success
				+ ", isMsg=" + isMsg + ", isRead=" + isRead + ", is_handle=" + is_handle + ", remark=" + remark
				+ ", patient=" + patient + ", maxValue=" + maxValue + ", minValue=" + minValue + ", hospitalNo="
				+ hospitalNo + ", selected=" + selected + ", upload=" + upload + ", status=" + status + ", typeStr="
				+ typeStr + ", wardCode=" + wardCode + ", glucoseTime=" + glucoseTime + "]";
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	public String getGlucoseTime() {
		return glucoseTime;
	}

	public void setGlucoseTime(String glucoseTime) {
		this.glucoseTime = glucoseTime;
	}
	
	
}
