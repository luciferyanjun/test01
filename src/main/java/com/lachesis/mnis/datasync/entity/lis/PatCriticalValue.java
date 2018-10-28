package com.lachesis.mnis.datasync.entity.lis;

import java.util.Date;

/**
 * 患者危急值记录表  未处置记录重复提醒规则，需要LIS处置状态信息
 * @author qingzhi.liu 2015.05.13
 *
 */
public class PatCriticalValue {
	private Long id;      //危急值ID
	private String pat_id;      //住院病历号
	private String in_hosp_no;      //住院流水号
	private String ward_code;      //病区代码
	
	private String bed_code;    //床位号码
	private String send_people;  //发送人
	private Date   send_time;    //发送时间
	private String critical_value; //危急值内容
	
	private String dispose_nurse;   //处置护士
	private String dispose_date;   //护士处置时间
	private String dispose_doctor;  //处置医生
	private Date dispose_doctor_date;   // 医生处置时间
	
	private String dispose_status;   //处置状态
	private Date sync_create;   //创建时间
	private Date sync_update;   //修改时间
	
	public PatCriticalValue() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPat_id() {
		return pat_id;
	}

	public void setPat_id(String pat_id) {
		this.pat_id = pat_id;
	}

	public String getIn_hosp_no() {
		return in_hosp_no;
	}

	public void setIn_hosp_no(String in_hosp_no) {
		this.in_hosp_no = in_hosp_no;
	}

	public String getWard_code() {
		return ward_code;
	}

	public void setWard_code(String ward_code) {
		this.ward_code = ward_code;
	}

	public String getBed_code() {
		return bed_code;
	}

	public void setBed_code(String bed_code) {
		this.bed_code = bed_code;
	}

	public String getSend_people() {
		return send_people;
	}

	public void setSend_people(String send_people) {
		this.send_people = send_people;
	}

	public Date getSend_time() {
		return send_time;
	}

	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}

	public String getCritical_value() {
		return critical_value;
	}

	public void setCritical_value(String critical_value) {
		this.critical_value = critical_value;
	}

	public String getDispose_nurse() {
		return dispose_nurse;
	}

	public void setDispose_nurse(String dispose_nurse) {
		this.dispose_nurse = dispose_nurse;
	}

	public String getDispose_date() {
		return dispose_date;
	}

	public void setDispose_date(String dispose_date) {
		this.dispose_date = dispose_date;
	}

	public String getDispose_doctor() {
		return dispose_doctor;
	}

	public void setDispose_doctor(String dispose_doctor) {
		this.dispose_doctor = dispose_doctor;
	}

	public Date getDispose_doctor_date() {
		return dispose_doctor_date;
	}

	public void setDispose_doctor_date(Date dispose_doctor_date) {
		this.dispose_doctor_date = dispose_doctor_date;
	}

	public String getDispose_status() {
		return dispose_status;
	}

	public void setDispose_status(String dispose_status) {
		this.dispose_status = dispose_status;
	}

	public Date getSync_create() {
		return sync_create;
	}

	public void setSync_create(Date sync_create) {
		this.sync_create = sync_create;
	}

	public Date getSync_update() {
		return sync_update;
	}

	public void setSync_update(Date sync_update) {
		this.sync_update = sync_update;
	}

	@Override
	public String toString() {
		return "PatCriticalValue [id=" + id + ", pat_id=" + pat_id
				+ ", in_hosp_no=" + in_hosp_no + ", ward_code=" + ward_code
				+ ", bed_code=" + bed_code + ", send_people=" + send_people
				+ ", send_time=" + send_time + ", critical_value="
				+ critical_value + ", dispose_nurse=" + dispose_nurse
				+ ", dispose_date=" + dispose_date + ", dispose_doctor="
				+ dispose_doctor + ", dispose_doctor_date="
				+ dispose_doctor_date + ", dispose_status=" + dispose_status
				+ ", sync_create=" + sync_create + ", sync_update="
				+ sync_update + "]";
	}
	
	
}
