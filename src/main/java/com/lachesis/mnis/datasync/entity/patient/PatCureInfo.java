package com.lachesis.mnis.datasync.entity.patient;

import java.util.Date;

/**
 * 患者信息表
 * 
 * @author qingzhi.liu
 * @time 2015.05.13
 */
public class PatCureInfo {
	private Long id; // 患者编号ID 自增长id
	private String pat_id; // 住院流水号
	private String hosp_no; // 住院病历号
	private String bed_code; // 床位代码
	private String show_bed_code;

	private String ward_code; // 病区代码
	private String barcode; // 患者条码
	private String name; // 姓名
	private String gender; // 性别 (F女 M男)

	private String person_id; // 身份证
	private Date birth_date; // 出生日期
	private String contact_person; // 联系人
	private String contact_phone; // 联系电话
	private String contact_address; // 联系地址

	private String is_baby; // 是否婴儿 (0否:1是)
	private String danger_level; // 危险级别(N:普通, S:病重, D:重危)
	private String nurse_level; // 护理级别 (0:特级,1:一级,2:二级,3:三级护理)
	private String charge_type; // 收费级别

	private String charge_type_name; // 收费类型名称
	private String doctor_code; // 医生代码
	private String doctor_name; // 医生姓名

	private String duty_nurse_code; // 责任护士代码
	private String duty_nurse_name; // 责任护士名称
	private Date in_date; // 入院日期

	private String in_diag; // 入院诊断
	private Date out_date; // 出院日期
	private String out_diag; // 出院诊断
	private String status; // 在院状态 (0否:1是)

	private String diet_name; // 饮食
	private String remark; // 备注
	private Date sync_create; // 创建时间 (his数据过来时间)
	private Date sync_update; // 修改时间 修改时间

	private String allergen; // 过敏药物
	private String adverse_reaction_drugs; // 不良反应药物
	
	//婚姻状况 职业 文化程度 籍贯 宗教 资料来源 日常照顾者 入院方式 
	private String marital_status;  //婚姻状况
	private String occupation;    //职业
	private String education;  //文化程度
	private String hometown;  //籍贯
	
	private String religion;  //宗教
	private String source;   //资料来源
	private String dailycaregivers;  //日常照顾者
	private String admissionmode;   //入院方式
	

	public PatCureInfo() {
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


	public String getHosp_no() {
		return hosp_no;
	}

	public void setHosp_no(String hosp_no) {
		this.hosp_no = hosp_no;
	}

	public String getBed_code() {
		return bed_code;
	}

	public void setBed_code(String bed_code) {
		this.bed_code = bed_code;
	}
	
	public String getShow_bed_code() {
		return show_bed_code;
	}

	public void setShow_bed_code(String show_bed_code) {
		this.show_bed_code = show_bed_code;
	}

	public String getWard_code() {
		return ward_code;
	}

	public void setWard_code(String ward_code) {
		this.ward_code = ward_code;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPerson_id() {
		return person_id;
	}

	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getContact_address() {
		return contact_address;
	}

	public void setContact_address(String contact_address) {
		this.contact_address = contact_address;
	}

	public String getIs_baby() {
		return is_baby;
	}

	public void setIs_baby(String is_baby) {
		this.is_baby = is_baby;
	}

	public String getDanger_level() {
		return danger_level;
	}

	public void setDanger_level(String danger_level) {
		this.danger_level = danger_level;
	}

	public String getNurse_level() {
		return nurse_level;
	}

	public void setNurse_level(String nurse_level) {
		this.nurse_level = nurse_level;
	}

	public String getCharge_type() {
		return charge_type;
	}

	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}

	public String getCharge_type_name() {
		return charge_type_name;
	}

	public void setCharge_type_name(String charge_type_name) {
		this.charge_type_name = charge_type_name;
	}

	public String getDoctor_code() {
		return doctor_code;
	}

	public void setDoctor_code(String doctor_code) {
		this.doctor_code = doctor_code;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public Date getIn_date() {
		return in_date;
	}

	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}

	public String getIn_diag() {
		return in_diag;
	}

	public void setIn_diag(String in_diag) {
		this.in_diag = in_diag;
	}

	public Date getOut_date() {
		return out_date;
	}

	public void setOut_date(Date out_date) {
		this.out_date = out_date;
	}

	public String getOut_diag() {
		return out_diag;
	}

	public void setOut_diag(String out_diag) {
		this.out_diag = out_diag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiet_name() {
		return diet_name;
	}

	public void setDiet_name(String diet_name) {
		this.diet_name = diet_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getDuty_nurse_code() {
		return duty_nurse_code;
	}

	public void setDuty_nurse_code(String duty_nurse_code) {
		this.duty_nurse_code = duty_nurse_code;
	}

	public String getDuty_nurse_name() {
		return duty_nurse_name;
	}

	public void setDuty_nurse_name(String duty_nurse_name) {
		this.duty_nurse_name = duty_nurse_name;
	}

	public String getAllergen() {
		return allergen;
	}

	public void setAllergen(String allergen) {
		this.allergen = allergen;
	}

	public String getAdverse_reaction_drugs() {
		return adverse_reaction_drugs;
	}

	public void setAdverse_reaction_drugs(String adverse_reaction_drugs) {
		this.adverse_reaction_drugs = adverse_reaction_drugs;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDailycaregivers() {
		return dailycaregivers;
	}

	public void setDailycaregivers(String dailycaregivers) {
		this.dailycaregivers = dailycaregivers;
	}

	public String getAdmissionmode() {
		return admissionmode;
	}

	public void setAdmissionmode(String admissionmode) {
		this.admissionmode = admissionmode;
	}

	@Override
	public String toString() {
		return "PatCureInfo [id=" + id + ", pat_id=" + pat_id + ", hosp_no="
				+ hosp_no + ", bed_code=" + bed_code + ", ward_code="
				+ ward_code + ", barcode=" + barcode + ", name=" + name
				+ ", gender=" + gender + ", person_id=" + person_id
				+ ", birth_date=" + birth_date + ", contact_person="
				+ contact_person + ", contact_phone=" + contact_phone
				+ ", contact_address=" + contact_address + ", is_baby="
				+ is_baby + ", danger_level=" + danger_level + ", nurse_level="
				+ nurse_level + ", charge_type=" + charge_type
				+ ", charge_type_name=" + charge_type_name + ", doctor_code="
				+ doctor_code + ", doctor_name=" + doctor_name
				+ ", duty_nurse_code=" + duty_nurse_code + ", duty_nurse_name="
				+ duty_nurse_name + ", in_date=" + in_date + ", in_diag="
				+ in_diag + ", out_date=" + out_date + ", out_diag=" + out_diag
				+ ", status=" + status + ", diet_name=" + diet_name
				+ ", remark=" + remark + ", sync_create=" + sync_create
				+ ", sync_update=" + sync_update + ", allergen=" + allergen
				+ ", adverse_reaction_drugs=" + adverse_reaction_drugs
				+ ", marital_status=" + marital_status + ", occupation="
				+ occupation + ", education=" + education + ", hometown="
				+ hometown + ", religion=" + religion + ", source=" + source
				+ ", dailycaregivers=" + dailycaregivers + ", admissionmode="
				+ admissionmode + "]";
	}

	

}
