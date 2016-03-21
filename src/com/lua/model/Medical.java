package com.lua.model;

import java.sql.Date;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午6:21:49
 * 类说明
 */
public class Medical {

	private int ID;
	private String Medical_ID;
	private String patient_ID;
	private String doctorInfo_ID;
	private String registered_ID;
	private String medical_msg;
	private String medical_result;
	private Date medical_time;
	private int medical_state;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMedical_ID() {
		return Medical_ID;
	}
	public void setMedical_ID(String medical_ID) {
		Medical_ID = medical_ID;
	}
	public String getPatient_ID() {
		return patient_ID;
	}
	public void setPatient_ID(String patient_ID) {
		this.patient_ID = patient_ID;
	}
	public String getDoctorInfo_ID() {
		return doctorInfo_ID;
	}
	public void setDoctorInfo_ID(String doctorInfo_ID) {
		this.doctorInfo_ID = doctorInfo_ID;
	}
	public String getRegistered_ID() {
		return registered_ID;
	}
	public void setRegistered_ID(String registered_ID) {
		this.registered_ID = registered_ID;
	}
	public String getMedical_msg() {
		return medical_msg;
	}
	public void setMedical_msg(String medical_msg) {
		this.medical_msg = medical_msg;
	}
	public String getMedical_result() {
		return medical_result;
	}
	public void setMedical_result(String medical_result) {
		this.medical_result = medical_result;
	}
	public Date getMedical_time() {
		return medical_time;
	}
	public void setMedical_time(Date medical_time) {
		this.medical_time = medical_time;
	}
	public int getMedical_state() {
		return medical_state;
	}
	public void setMedical_state(int medical_state) {
		this.medical_state = medical_state;
	}
}
