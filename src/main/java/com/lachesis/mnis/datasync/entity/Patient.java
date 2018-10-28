package com.lachesis.mnis.datasync.entity;

/***
 * 病人信息
 *
 * @author yuliang.xu
 * @date 2015年6月11日 上午10:37:19
 */
public class Patient {

	/** 患者记录自增长号 */
	private int id;

	/*********** 核心数据 **************/
	/** 住院流水号 */
	private String patId;
	/** 姓名 */
	private String name;
	/** 住院号 */
	private String inHospNo;
	/** 床号 */
	private String bedCode;
	/** 病区代码 */
	private String deptCode;
	/** 病区名称 */
	private String deptName;

	private String wardCode;
	private String wardName;

	/*********** 核心数据 **************/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatId() {
		return patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInHospNo() {
		return inHospNo;
	}

	public void setInHospNo(String inHospNo) {
		this.inHospNo = inHospNo;
	}

	public String getBedCode() {
		return bedCode;
	}

	public void setBedCode(String bedCode) {
		this.bedCode = bedCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	public String getWardName() {
		return wardName;
	}

	public void setWardName(String wardName) {
		this.wardName = wardName;
	}

}
