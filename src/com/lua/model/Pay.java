package com.lua.model;

import java.sql.Date;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午6:31:31
 * 类说明
 */
public class Pay {

	private int ID;
	private String pay_ID;
	private String druguse_ID;
	private int pay_cost;
	private Date pay_time;
	private int pay_state;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPay_ID() {
		return pay_ID;
	}
	public void setPay_ID(String pay_ID) {
		this.pay_ID = pay_ID;
	}
	public String getDruguse_ID() {
		return druguse_ID;
	}
	public void setDruguse_ID(String druguse_ID) {
		this.druguse_ID = druguse_ID;
	}
	public int getPay_cost() {
		return pay_cost;
	}
	public void setPay_cost(int pay_cost) {
		this.pay_cost = pay_cost;
	}
	public Date getPay_time() {
		return pay_time;
	}
	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
	public int getPay_state() {
		return pay_state;
	}
	public void setPay_state(int pay_state) {
		this.pay_state = pay_state;
	}
}
