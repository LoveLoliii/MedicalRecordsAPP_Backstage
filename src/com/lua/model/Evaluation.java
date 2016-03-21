package com.lua.model;

import java.sql.Date;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午6:33:15
 * 类说明
 */
public class Evaluation {

	private int ID;
	private String evaluation_ID;
	private String patient_ID;
	private String doctorInfo_ID;
	private String evaluation_msg;
	private Date evaluation_time;
	private int evaluation_state;
	public int getEvaluation_state() {
		return evaluation_state;
	}
	public void setEvaluation_state(int evaluation_state) {
		this.evaluation_state = evaluation_state;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEvaluation_ID() {
		return evaluation_ID;
	}
	public void setEvaluation_ID(String evaluation_ID) {
		this.evaluation_ID = evaluation_ID;
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
	public String getEvaluation_msg() {
		return evaluation_msg;
	}
	public void setEvaluation_msg(String evaluation_msg) {
		this.evaluation_msg = evaluation_msg;
	}
	public Date getEvaluation_time() {
		return evaluation_time;
	}
	public void setEvaluation_time(Date evaluation_time) {
		this.evaluation_time = evaluation_time;
	}
}
