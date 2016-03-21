package com.lua.model;

import java.sql.Date;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午6:16:19
 * 类说明
 */
public class DoctorVisit {

	private int ID;
	private String doctorVisit_ID;
	private String doctorVisit_timeType;
	private Date doctorVisit_date;
	private int doctorVisit_regNunber;
	private String doctorVisit_feedback;
	private int doctorVisit_confirmState;
	private int doctorVisit_state;
	private String doctorInfo_ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDoctorVisit_ID() {
		return doctorVisit_ID;
	}
	public void setDoctorVisit_ID(String doctorVisit_ID) {
		this.doctorVisit_ID = doctorVisit_ID;
	}
	public String getDoctorVisit_timeType() {
		return doctorVisit_timeType;
	}
	public void setDoctorVisit_timeType(String doctorVisit_timeType) {
		this.doctorVisit_timeType = doctorVisit_timeType;
	}
	public Date getDoctorVisit_date() {
		return doctorVisit_date;
	}
	public void setDoctorVisit_date(Date doctorVisit_date) {
		this.doctorVisit_date = doctorVisit_date;
	}
	public int getDoctorVisit_regNunber() {
		return doctorVisit_regNunber;
	}
	public void setDoctorVisit_regNunber(int doctorVisit_regNunber) {
		this.doctorVisit_regNunber = doctorVisit_regNunber;
	}
	public String getDoctorVisit_feedback() {
		return doctorVisit_feedback;
	}
	public void setDoctorVisit_feedback(String doctorVisit_feedback) {
		this.doctorVisit_feedback = doctorVisit_feedback;
	}
	public int getDoctorVisit_confirmState() {
		return doctorVisit_confirmState;
	}
	public void setDoctorVisit_confirmState(int doctorVisit_confirmState) {
		this.doctorVisit_confirmState = doctorVisit_confirmState;
	}
	public int getDoctorVisit_state() {
		return doctorVisit_state;
	}
	public void setDoctorVisit_state(int doctorVisit_state) {
		this.doctorVisit_state = doctorVisit_state;
	}
	public String getDoctorInfo_ID() {
		return doctorInfo_ID;
	}
	public void setDoctorInfo_ID(String doctorInfo_ID) {
		this.doctorInfo_ID = doctorInfo_ID;
	}
}
