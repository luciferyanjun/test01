package com.lachesis.mnis.datasync.entity.bean;

public class GlucoseForHisDel {

	private String patCode;
	private String glucoseId;
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getGlucoseId() {
		return glucoseId;
	}
	public void setGlucoseId(String glucoseId) {
		this.glucoseId = glucoseId;
	}
	@Override
	public String toString() {
		return "GlucoseForHisDel [patCode=" + patCode + ", glucoseId=" + glucoseId + "]";
	}
	
}
