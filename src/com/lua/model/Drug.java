package com.lua.model;

import java.sql.Date;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午6:28:34
 * 类说明
 */
public class Drug {

	private int ID;
	private String drug_ID;
	private String drug_name;
	private int drug_num;
	private float drug_price;
	private Date drug_time;
	private float drug_period;
	private String drug_produce_factory;
	private String drug_style;
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
	public String getDrug_name() {
		return drug_name;
	}
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}
	public int getDrug_num() {
		return drug_num;
	}
	public void setDrug_num(int drug_num) {
		this.drug_num = drug_num;
	}
	public float getDrug_price() {
		return drug_price;
	}
	public void setDrug_price(float drug_price) {
		this.drug_price = drug_price;
	}
	public Date getDrug_time() {
		return drug_time;
	}
	public void setDrug_time(Date drug_time) {
		this.drug_time = drug_time;
	}
	public float getDrug_period() {
		return drug_period;
	}
	public void setDrug_period(float drug_period) {
		this.drug_period = drug_period;
	}
	public String getDrug_produce_factory() {
		return drug_produce_factory;
	}
	public void setDrug_produce_factory(String drug_produce_factory) {
		this.drug_produce_factory = drug_produce_factory;
	}
	public String getDrug_style() {
		return drug_style;
	}
	public void setDrug_style(String drug_style) {
		this.drug_style = drug_style;
	}
}
