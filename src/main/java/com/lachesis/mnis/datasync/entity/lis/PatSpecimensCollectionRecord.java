package com.lachesis.mnis.datasync.entity.lis;

import java.util.Date;

/**
 * 标本采集记录
 * @author qingzhi.liu 2015.05.13
 *
 */
public class PatSpecimensCollectionRecord {
	private Long id;       //标本采集ID
	private String pat_id;       //住院病历号
	private String pat_name;       //患者姓名
	private String bed_code;       //床位号码
	
	private String specimen_barcode;       //标本条码
	private String requisition_state;       //申请状态
	private String test_order_name;       //测试项目名称
	private String sampling_person;       //样本要求
	
	private Date sampling_time;       //采样时间
	private String sample_class_name;   //样本类型名称
	private String sampling_user;       //采集人
	private String sampling_dept;       //采集科室
	public PatSpecimensCollectionRecord() {
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
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public String getBed_code() {
		return bed_code;
	}
	public void setBed_code(String bed_code) {
		this.bed_code = bed_code;
	}
	public String getSpecimen_barcode() {
		return specimen_barcode;
	}
	public void setSpecimen_barcode(String specimen_barcode) {
		this.specimen_barcode = specimen_barcode;
	}
	public String getRequisition_state() {
		return requisition_state;
	}
	public void setRequisition_state(String requisition_state) {
		this.requisition_state = requisition_state;
	}
	public String getTest_order_name() {
		return test_order_name;
	}
	public void setTest_order_name(String test_order_name) {
		this.test_order_name = test_order_name;
	}
	public String getSampling_person() {
		return sampling_person;
	}
	public void setSampling_person(String sampling_person) {
		this.sampling_person = sampling_person;
	}
	public Date getSampling_time() {
		return sampling_time;
	}
	public void setSampling_time(Date sampling_time) {
		this.sampling_time = sampling_time;
	}
	public String getSample_class_name() {
		return sample_class_name;
	}
	public void setSample_class_name(String sample_class_name) {
		this.sample_class_name = sample_class_name;
	}
	public String getSampling_user() {
		return sampling_user;
	}
	public void setSampling_user(String sampling_user) {
		this.sampling_user = sampling_user;
	}
	public String getSampling_dept() {
		return sampling_dept;
	}
	public void setSampling_dept(String sampling_dept) {
		this.sampling_dept = sampling_dept;
	}
	@Override
	public String toString() {
		return "PatSpecimensCollectionRecord [id=" + id + ", pat_id=" + pat_id
				+ ", pat_name=" + pat_name + ", bed_code=" + bed_code
				+ ", specimen_barcode=" + specimen_barcode
				+ ", requisition_state=" + requisition_state
				+ ", test_order_name=" + test_order_name + ", sampling_person="
				+ sampling_person + ", sampling_time=" + sampling_time
				+ ", sample_class_name=" + sample_class_name
				+ ", sampling_user=" + sampling_user + ", sampling_dept="
				+ sampling_dept + "]";
	}
	
	
}
