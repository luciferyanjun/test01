package com.lachesis.mnis.datasync.entity.patient;

import java.util.Date;

/**
 * 患者转床转科
 * @author qingzhi.liu 2015.05.15
 *
 */
public class PatTransfer {
	
	private Long id;   //转床转科ID
	private String pat_id;   //住院流水号
	private String execute_date;  //执行日期
	private String executor;   //执行人工号
	
	private String ward_code;   //病区代码
	private String bed_code;    //床位号码
	private String new_ward_code; //新病区代码
	private String new_bed_code;   //新床位号码
	
	private String flag;   //标记
	private Date sync_create;  //创建时间
	private Date sync_update;  //修改时间
	public PatTransfer() {
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
	public String getExecute_date() {
		return execute_date;
	}
	public void setExecute_date(String execute_date) {
		this.execute_date = execute_date;
	}
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
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
	public String getNew_ward_code() {
		return new_ward_code;
	}
	public void setNew_ward_code(String new_ward_code) {
		this.new_ward_code = new_ward_code;
	}
	public String getNew_bed_code() {
		return new_bed_code;
	}
	public void setNew_bed_code(String new_bed_code) {
		this.new_bed_code = new_bed_code;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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
		return "PatTransfer [id=" + id + ", pat_id=" + pat_id
				+ ", execute_date=" + execute_date + ", executor=" + executor
				+ ", ward_code=" + ward_code + ", bed_code=" + bed_code
				+ ", new_ward_code=" + new_ward_code + ", new_bed_code="
				+ new_bed_code + ", flag=" + flag + ", sync_create="
				+ sync_create + ", sync_update=" + sync_update + "]";
	}
	

}
