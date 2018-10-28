package com.lachesis.mnis.datasync.entity.pub;

import java.util.Date;

/**
 * 科室表
 * @author qingzhi.liu  2015.05.13
 */
public class ComDepartment {
	
	private int id;  //自增长序列号
	private String code;   //科室代码  主键
	private String name;   //科室名称
	private String search_code;  //科室查询代码
	
	private String flag;     //标记  (0:无效,1:有效)
	private Date sync_create;  //创建时间
	private Date sync_update;  //修改时间
	
	public ComDepartment() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSearch_code() {
		return search_code;
	}
	public void setSearch_code(String search_code) {
		this.search_code = search_code;
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
		return "ComDepartment [id=" + id + ", code=" + code + ", name=" + name
				+ ", search_code=" + search_code + ", flag=" + flag
				+ ", sync_create=" + sync_create + ", sync_update="
				+ sync_update + "]";
	}
	
	
}
