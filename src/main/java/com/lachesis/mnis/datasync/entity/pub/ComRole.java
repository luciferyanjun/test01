package com.lachesis.mnis.datasync.entity.pub;

/**
 * 角色表
 * @author qingzhi.liu 2015.05.13
 *
 */
public class ComRole {
	private Long id;   //角色ID
	private String code;   //角色代码
	private String name;   //角色名称
	private int level;   //角色级别
	private String remark;   //角色备注
	private String flag;   //标记  (0:无效,1:有效)
	
	public ComRole() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	@Override
	public String toString() {
		return "Com_Role [id=" + id + ", code=" + code + ", name=" + name
				+ ", level=" + level + ", remark=" + remark + ", flag=" + flag
				+ "]";
	}
	
	
	
}
