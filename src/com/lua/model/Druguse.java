package com.lua.model;

import java.sql.Date;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午6:25:28
 * 类说明
 */
public class Druguse {

	private int ID;
	private String druguse_ID;
	private String medical_ID;
	private String drug_ID;
	private int druguse_num;
	private Date druguse_time;
	public Date getDruguse_time() {
		return druguse_time;
	}
	public void setDruguse_time(Date druguse_time) {
		this.druguse_time = druguse_time;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDruguse_ID() {
		return druguse_ID;
	}
	public void setDruguse_ID(String druguse_ID) {
		this.druguse_ID = druguse_ID;
	}
	public String getMedical_ID() {
		return medical_ID;
	}
	public void setMedical_ID(String medical_ID) {
		this.medical_ID = medical_ID;
	}
	public String getDrug_ID() {
		return drug_ID;
	}
	public void setDrug_ID(String drug_ID) {
		this.drug_ID = drug_ID;
	}
	public int getDruguse_num() {
		return druguse_num;
	}
	public void setDruguse_num(int druguse_num) {
		this.druguse_num = druguse_num;
	}
}
