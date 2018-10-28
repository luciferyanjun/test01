package com.lachesis.mnis.datasync.entity.patient;

import java.util.Date;

/**
 * 患者过敏信息
 * 
 * @author qingzhi.liu 2015.15.13
 * 
 */
public class PatAllergy {

	private Long id; // 患者过敏信息ID
	private String pat_id; // 住院流水号
	private String start_date; // 开始日期
	private String end_date; // 结束日期
	private String allergen_code; // 过敏代码

	private String allergen; // 过敏信息
	private String adverse_reaction_drugs; // 不良反应药物

	private Date record_date; // 记录日期时间
	private String record_user_code; // 记录人
	private String status; // 状态

	public PatAllergy() {
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

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getAllergen_code() {
		return allergen_code;
	}

	public void setAllergen_code(String allergen_code) {
		this.allergen_code = allergen_code;
	}

	public String getAllergen() {
		return allergen;
	}

	public void setAllergen(String allergen) {
		this.allergen = allergen;
	}

	public Date getRecord_date() {
		return record_date;
	}

	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}

	public String getRecord_user_code() {
		return record_user_code;
	}

	public void setRecord_user_code(String record_user_code) {
		this.record_user_code = record_user_code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	public String getAdverse_reaction_drugs() {
		return adverse_reaction_drugs;
	}

	public void setAdverse_reaction_drugs(String adverse_reaction_drugs) {
		this.adverse_reaction_drugs = adverse_reaction_drugs;
	}

	@Override
	public String toString() {
		return "Pat_Allergy [id=" + id + ", pat_id=" + pat_id + ", start_date="
				+ start_date + ", end_date=" + end_date + ", allergen_code="
				+ allergen_code + ", allergen=" + allergen + ", record_date="
				+ record_date + ", record_user_code=" + record_user_code
				+ ", status=" + status + "]";
	}

}
