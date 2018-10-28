package com.lachesis.mnis.datasync.entity.pub;

import java.util.Date;

/**
 * 病区表
 * @author qingzhi.liu 2015.05.14
 *
 */
public class ComWard {
	private String dept_code;   //科室代码
	private String name;   //病区名称
	private String search_code;   //病区查询代码
	
	private String tags;   //附加说明
	private String flag;   //标记  (0:无效,1:有效)
	private Date sync_create;   //创建时间
	private Date sync_update;   //修改时间
	private String is_dept;   //1：科室   其他：病区（护理单元）
	public ComWard() {
		super();
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
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
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
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
	public String getIs_dept() {
		return is_dept;
	}
	public void setIs_dept(String is_dept) {
		this.is_dept = is_dept;
	}
	@Override
	public String toString() {
		return "ComWard [dept_code=" + dept_code + ", name="
				+ name + ", search_code=" + search_code + ", tags=" + tags
				+ ", flag=" + flag + ", sync_create=" + sync_create
				+ ", sync_update=" + sync_update + ", is_dept=" + is_dept + "]";
	}
	
}
