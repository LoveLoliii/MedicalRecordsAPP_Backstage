package com.lua.model;
/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月6日 上午10:30:18
 * 类说明
 */
public class Registrationfee {
	private int ID;
	private String registrationfee_ID;
	private int doctorInfo_type;
	private float registrationfee_fee;
	private String hospital_ID;
	private String doctorInfo_typeName;
	public String getDoctorInfo_typeName() {
		return doctorInfo_typeName;
	}
	public void setDoctorInfo_typeName(String doctorInfo_typeName) {
		this.doctorInfo_typeName = doctorInfo_typeName;
	}
	public String getHospital_ID() {
		return hospital_ID;
	}
	public void setHospital_ID(String hospital_ID) {
		this.hospital_ID = hospital_ID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getRegistrationfee_ID() {
		return registrationfee_ID;
	}
	public void setRegistrationfee_ID(String registrationfee_ID) {
		this.registrationfee_ID = registrationfee_ID;
	}
	public int getDoctorInfo_type() {
		return doctorInfo_type;
	}
	public void setDoctorInfo_type(int doctorInfo_type) {
		this.doctorInfo_type = doctorInfo_type;
	}
	public float getRegistrationfee_fee() {
		return registrationfee_fee;
	}
	public void setRegistrationfee_fee(float registrationfee_fee) {
		this.registrationfee_fee = registrationfee_fee;
	}
}
