package com.lua.model;

import java.sql.Timestamp;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午6:26:41
 * 类说明
 */
public class Consultation {

	private int ID;
	private String consultation_ID;
	private String consultation_sendID;
	private String consultation_getID;
	private String consultation_msg;
	private Timestamp consultation_time;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getConsultation_ID() {
		return consultation_ID;
	}
	public void setConsultation_ID(String consultation_ID) {
		this.consultation_ID = consultation_ID;
	}
	public String getConsultation_sendID() {
		return consultation_sendID;
	}
	public void setConsultation_sendID(String consultation_sendID) {
		this.consultation_sendID = consultation_sendID;
	}
	public String getConsultation_getID() {
		return consultation_getID;
	}
	public void setConsultation_getID(String consultation_getID) {
		this.consultation_getID = consultation_getID;
	}
	public String getConsultation_msg() {
		return consultation_msg;
	}
	public void setConsultation_msg(String consultation_msg) {
		this.consultation_msg = consultation_msg;
	}
	public Timestamp getConsultation_time() {
		return consultation_time;
	}
	public void setConsultation_time(Timestamp consultation_time) {
		this.consultation_time = consultation_time;
	}
}
