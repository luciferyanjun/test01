package com.lachesis.mnis.datasync.entity.pub;

/**
 * 用户病区设置表
 * @author qingzhi.liu  2015.05.29
 *
 */
public class ComWardUser {
	private String	ward_code;   //病区代码
	private String user_code;    //用户代码
	public ComWardUser() {
		super();
	}
	public String getWard_code() {
		return ward_code;
	}
	public void setWard_code(String ward_code) {
		this.ward_code = ward_code;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	@Override
	public String toString() {
		return "ComWardUser [ward_code=" + ward_code + ", user_code="
				+ user_code + "]";
	}
	
	
	
}
