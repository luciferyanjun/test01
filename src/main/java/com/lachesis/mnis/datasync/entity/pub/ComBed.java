package com.lachesis.mnis.datasync.entity.pub;

import java.util.Date;

/**
 * 床位
 * @author qingzhi.liu  2015.05.13
 *
 */
public class ComBed {
	
	private Long id;     //床位ID
	private String code;     //床位代码
	private String ward_code;     //病区代码
	private String bed_type;     //床位类型
	
	private String bed_type_name;     //床位类型名称
	private String bed_price;     //床位价格
	private Double tags;     //附加说明
	private String flag;     //标记 (0:无效,1:有效)
	
	private Date sync_create;     //创建时间
 	private Date sync_update;     //修改时间
	public ComBed() {
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
	public String getWard_code() {
		return ward_code;
	}
	public void setWard_code(String ward_code) {
		this.ward_code = ward_code;
	}
	public String getBed_type() {
		return bed_type;
	}
	public void setBed_type(String bed_type) {
		this.bed_type = bed_type;
	}
	public String getBed_type_name() {
		return bed_type_name;
	}
	public void setBed_type_name(String bed_type_name) {
		this.bed_type_name = bed_type_name;
	}
	public String getBed_price() {
		return bed_price;
	}
	public void setBed_price(String bed_price) {
		this.bed_price = bed_price;
	}
	public Double getTags() {
		return tags;
	}
	public void setTags(Double tags) {
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
	@Override
	public String toString() {
		return "Com_Bed [id=" + id + ", code=" + code + ", ward_code="
				+ ward_code + ", bed_type=" + bed_type + ", bed_type_name="
				+ bed_type_name + ", bed_price=" + bed_price + ", tags=" + tags
				+ ", flag=" + flag + ", sync_create=" + sync_create
				+ ", sync_update=" + sync_update + "]";
	}
 	
 	
 
}
