package com.lua.model;
/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午6:35:29
 * 类说明
 */
public class DepartmentDeploy {

	private int ID;
	private String minordepartment_ID;
	private String doctorInfo_ID;
	private String hospital_ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMinordepartment_ID() {
		return minordepartment_ID;
	}
	public void setMinordepartment_ID(String minordepartment_ID) {
		this.minordepartment_ID = minordepartment_ID;
	}
	public String getDoctorInfo_ID() {
		return doctorInfo_ID;
	}
	public void setDoctorInfo_ID(String doctorInfo_ID) {
		this.doctorInfo_ID = doctorInfo_ID;
	}
	public String getHospital_ID() {
		return hospital_ID;
	}
	public void setHospital_ID(String hospital_ID) {
		this.hospital_ID = hospital_ID;
	}
}
