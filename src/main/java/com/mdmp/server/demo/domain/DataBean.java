package com.mdmp.server.demo.domain;

public class DataBean {
	
	//{app:"Android实例",
	//type:"Android"
	//category:"首页-产品列表-创建按钮", 
	//action:"onClick", 
	//ids: {"userId": ""} "
	//value":"1"}
	private String resumeTime;
	private String appKey;
	private String osType;
	private String category;
	private String action;
	private String dev_id;
	private String value;
	
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDev_id() {
		return dev_id;
	}
	public void setDev_id(String dev_id) {
		this.dev_id = dev_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getResumeTime() {
		return resumeTime;
	}
	public void setResumeTime(String resumeTime) {
		this.resumeTime = resumeTime;
	}
}
