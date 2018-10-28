package com.lachesis.mnis.datasync.entity.pub;

import java.util.Date;

/**
 * 用户表
 * @author qingzhi.liu  2015.05.13
 *
 */
public class ComUser {
	private String id;    //用户ID
	private String code;    //用户编号
	private String name;    //用户姓名 
	private String userType;
	private String password;    //密码
	private String loginName;
	
	private String gender;    //性别(F女  M男)
	private String phone;    //电话
	private String email;    //邮件
	private String remark;    //备注
	
	private String flag;    //标记 (0:无效,1:有效)
	private Date sync_create;    //同步创建时间
	private Date sync_update;    //数据同步修改时间
	
	private String ward_code;   //病区代码
	public ComUser() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
	public String getWard_code() {
		return ward_code;
	}
	public void setWard_code(String ward_code) {
		this.ward_code = ward_code;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		/*if("D".equals(userType)){
			this.userType = "doctor";
		}else if("N".equals(userType)){
			this.userType = "hsz";
		}else{
			this.userType = userType;
		}*/
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "Com_User [id=" + id + ", code=" + code + ", name=" + name + ",loginName=" + loginName + ",userType=" + userType
				+ ", password=" + password + ", gender=" + gender + ", phone="
				+ phone + ", email=" + email + ", remark=" + remark + ", flag="
				+ flag + ", sync_create=" + sync_create + ", sync_update="
				+ sync_update + "]";
	}
	
	
}
