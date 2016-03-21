package com.lua.model;
/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月8日 下午1:04:49
 * 类说明
 */
public class Drugandhospital {
	private int ID;
	private String drug_ID;
	private String hospital_ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDrug_ID() {
		return drug_ID;
	}
	public void setDrug_ID(String drug_ID) {
		this.drug_ID = drug_ID;
	}
	public String getHospital_ID() {
		return hospital_ID;
	}
	public void setHospital_ID(String hospital_ID) {
		this.hospital_ID = hospital_ID;
	}
}
