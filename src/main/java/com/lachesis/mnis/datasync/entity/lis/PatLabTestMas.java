package com.lachesis.mnis.datasync.entity.lis;

import java.util.Date;
import java.util.List;

/**
 * 检验报告
 * @author qingzhi.liu  2015.05.13
 *
 */
public class PatLabTestMas {
	private Long id;  //检验报告ID  自增长
	private String test_no;  //申请单号
	private String pat_id;  //住院病历号
	private String in_hosp_no;  //住院流水号
	private String test_subject;  //主题
	
	private String test_specimen;  //样本
	private String send_people;  //申请人
	private Date send_date;  //申请时间
	private String test_people;   //测试人
	
	private Date test_date;  //测试时间
	private String report_people;  //报告人
	private Date report_date;   //报告时间
	private String check_people;   //复核人
	private Date check_date;    //复核时间
	
	private String status;  //检查报告状态
	private Date sync_create;   //创建时间
	private Date sync_update;    //修改时间
	
	private List<PatLabTestDetail> items;
	
	public PatLabTestMas() {
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
	public String getTest_subject() {
		return test_subject;
	}
	public void setTest_subject(String test_subject) {
		this.test_subject = test_subject;
	}
	public String getTest_specimen() {
		return test_specimen;
	}
	public void setTest_specimen(String test_specimen) {
		this.test_specimen = test_specimen;
	}
	public String getSend_people() {
		return send_people;
	}
	public void setSend_people(String send_people) {
		this.send_people = send_people;
	}
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public String getTest_people() {
		return test_people;
	}
	public void setTest_people(String test_people) {
		this.test_people = test_people;
	}
	public Date getTest_date() {
		return test_date;
	}
	public void setTest_date(Date test_date) {
		this.test_date = test_date;
	}
	public String getReport_people() {
		return report_people;
	}
	public void setReport_people(String report_people) {
		this.report_people = report_people;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getCheck_people() {
		return check_people;
	}
	public void setCheck_people(String check_people) {
		this.check_people = check_people;
	}
	public Date getCheck_date() {
		return check_date;
	}
	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public String getTest_no() {
		return test_no;
	}
	public void setTest_no(String test_no) {
		this.test_no = test_no;
	}
	
	public List<PatLabTestDetail> getItems() {
		return items;
	}
	public void setItems(List<PatLabTestDetail> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "PatLabTestMas [id=" + id + ", pat_id=" + pat_id
				+ ", in_hosp_no=" + in_hosp_no + ", test_subject="
				+ test_subject + ", test_specimen=" + test_specimen
				+ ", send_people=" + send_people + ", send_date=" + send_date
				+ ", test_people=" + test_people + ", test_date=" + test_date
				+ ", report_people=" + report_people + ", report_date="
				+ report_date + ", check_people=" + check_people
				+ ", check_date=" + check_date + ", status=" + status
				+ ", sync_create=" + sync_create + ", sync_update="
				+ sync_update + "]";
	}
	
	
}
