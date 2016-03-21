package com.lua.model;

import java.sql.Date;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午2:54:45
 * 类说明
 */
public class Registered {
	
	private int ID;
	private String registered_ID;
	private String registered_info;
	private int registered_state;
	private Date registered_time;
	private String doctorInfo_ID;
	private String patient_ID;
	private String doctorVisit_ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getRegistered_ID() {
		return registered_ID;
	}
	public void setRegistered_ID(String registered_ID) {
		this.registered_ID = registered_ID;
	}
	public String getRegistered_info() {
		return registered_info;
	}
	public void setRegistered_info(String registered_info) {
		this.registered_info = registered_info;
	}
	public int getRegistered_state() {
		return registered_state;
	}
	public void setRegistered_state(int registered_state) {
		this.registered_state = registered_state;
	}
	public Date getRegistered_time() {
		return registered_time;
	}
	public void setRegistered_time(Date registered_time) {
		this.registered_time = registered_time;
	}
	public String getDoctorInfo_ID() {
		return doctorInfo_ID;
	}
	public void setDoctorInfo_ID(String doctorInfo_ID) {
		this.doctorInfo_ID = doctorInfo_ID;
	}
	public String getPatient_ID() {
		return patient_ID;
	}
	public void setPatient_ID(String patient_ID) {
		this.patient_ID = patient_ID;
	}
	public String getDoctorVisit_ID() {
		return doctorVisit_ID;
	}
	public void setDoctorVisit_ID(String doctorVisit_ID) {
		this.doctorVisit_ID = doctorVisit_ID;
	}

}
