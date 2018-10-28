package com.lachesis.mnis.datasync.entity.patient;

import java.util.Date;

/**
 * 患者诊断
 * @author qingzhi.liu  2015.05.13
 *
 */
public class PatDiagnosis {
	
	private Long id;   //诊断ID
	private String pat_id;   //住院流水号
	private String diagnosis_info;   //诊断信息
	private Date diagnosis_date;   //诊断日期
	
	private String is_in_diag;   //是否入院诊断
	private String record_user;   //记录人
	private Date record_date;   //记录日期
	private String flag;   //标记(0:无效,1:有效)
	public PatDiagnosis() {
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
	public String getDiagnosis_info() {
		return diagnosis_info;
	}
	public void setDiagnosis_info(String diagnosis_info) {
		this.diagnosis_info = diagnosis_info;
	}
	public Date getDiagnosis_date() {
		return diagnosis_date;
	}
	public void setDiagnosis_date(Date diagnosis_date) {
		this.diagnosis_date = diagnosis_date;
	}
	public String getIs_in_diag() {
		return is_in_diag;
	}
	public void setIs_in_diag(String is_in_diag) {
		this.is_in_diag = is_in_diag;
	}
	public String getRecord_user() {
		return record_user;
	}
	public void setRecord_user(String record_user) {
		this.record_user = record_user;
	}
	public Date getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Pat_diagnosis [id=" + id + ", pat_id=" + pat_id
				+ ", diagnosis_info=" + diagnosis_info + ", diagnosis_date="
				+ diagnosis_date + ", is_in_diag=" + is_in_diag
				+ ", record_user=" + record_user + ", record_date="
				+ record_date + ", flag=" + flag + "]";
	}
	
	
	
}
