package com.lachesis.mnis.datasync.web;

import java.io.Serializable;
public class BaseVo implements Serializable{
	
	private static final long serialVersionUID = -7247823509891712543L;
	private String rslt="0";
	private String msg="success";

	public BaseVo() {
		super();
	}

	public BaseVo(String ackResult, String msg) {
		super();
		this.rslt = ackResult;
		this.msg = msg;
	}

	public String getRslt() {
		return rslt;
	}
	
	public void setRslt(String result) {
		this.rslt = result;
	}

	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
