package com.lua.model;
/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月12日 下午8:08:18
 * 类说明
 */
public class Num {
	private int month;
	private Float number;
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Float getNumber() {
		return number;
	}
	public void setNumber(Float number) {
		this.number = number;
	}
	public Num(int month, Float number) {
		super();
		this.month = month;
		this.number = number;
	}
	
	

}
