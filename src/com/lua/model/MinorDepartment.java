package com.lua.model;
/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月29日 下午7:53:52
 * 类说明
 */
public class MinorDepartment {
	private int ID;
	private String minordepartment_ID;
	private String minordepartment_name;
	private String maindepartment_ID;
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
	public String getMinordepartment_name() {
		return minordepartment_name;
	}
	public void setMinordepartment_name(String minordepartment_name) {
		this.minordepartment_name = minordepartment_name;
	}
	public String getMaindepartment_ID() {
		return maindepartment_ID;
	}
	public void setMaindepartment_ID(String maindepartment_ID) {
		this.maindepartment_ID = maindepartment_ID;
	}
}
