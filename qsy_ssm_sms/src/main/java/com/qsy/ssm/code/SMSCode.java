package com.qsy.ssm.code;

import java.util.List;

public class SMSCode {
	private String respCode;
	private String respDesc;
	private String failCount;
	private List<?> failList;
	private String smsId;
	
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespDesc() {
		return respDesc;
	}
	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}
	public String getFailCount() {
		return failCount;
	}
	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}
	public List<?> getFailList() {
		return failList;
	}
	public void setFailList(List<?> failList) {
		this.failList = failList;
	}
	public String getSmsId() {
		return smsId;
	}
	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}
	 
	
}
