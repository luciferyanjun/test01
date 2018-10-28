package com.lachesis.mnis.datasync.entity.lis;

import java.util.Date;

/**
 * 检验报告详情
 * @author qingzhi.liu  2015.05.13
 *
 */
public class PatLabTestDetail {
	private long id;   //自增长
	private int item_no; //项目序号
	private String test_no;   //申请单号
	private String item_code;   //项目代码
	private String item_name;   //项目名称
	
	private String result_value;   //测试结果
	private String result_unit;   //单位
	private String ref_ranges;   //参考范围
	private String normal_flag;   //正常标志
	
	private Date sync_create;   //创建时间
	private Date sync_update;   //修改时间
	public PatLabTestDetail() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTest_no() {
		return test_no;
	}
	public void setTest_no(String test_no) {
		this.test_no = test_no;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getResult_value() {
		return result_value;
	}
	public void setResult_value(String result_value) {
		this.result_value = result_value;
	}
	public String getResult_unit() {
		return result_unit;
	}
	public void setResult_unit(String result_unit) {
		this.result_unit = result_unit;
	}
	public String getRef_ranges() {
		return ref_ranges;
	}
	public void setRef_ranges(String ref_ranges) {
		this.ref_ranges = ref_ranges;
	}
	public String getNormal_flag() {
		return normal_flag;
	}
	public void setNormal_flag(String normal_flag) {
		this.normal_flag = normal_flag;
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
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	@Override
	public String toString() {
		return "PatLabTestDetail [id=" + id + ", item_no=" + item_no
				+ ", test_no=" + test_no + ", item_code=" + item_code
				+ ", item_name=" + item_name + ", result_value=" + result_value
				+ ", result_unit=" + result_unit + ", ref_ranges=" + ref_ranges
				+ ", normal_flag=" + normal_flag + ", sync_create="
				+ sync_create + ", sync_update=" + sync_update + "]";
	}
	
	
	
}
