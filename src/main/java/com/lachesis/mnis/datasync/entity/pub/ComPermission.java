package com.lachesis.mnis.datasync.entity.pub;

/**
 * 权限表
 * @author qingzhi.liu  2015.05.13
 *
 */
public class ComPermission {
	
	private Long id;   //权限表ID
	private String code;  // 权限代码
	private String name;  //权限名称
	private String flag;   //标记(0:无效,1:有效)
	
	public ComPermission() {
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Com_Permission [id=" + id + ", code=" + code + ", name=" + name
				+ ", flag=" + flag + "]";
	}
	
	
	
}
