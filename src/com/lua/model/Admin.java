package com.lua.model;
/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午6:34:40
 * 类说明
 */
public class Admin {

	private int ID;
	private String admin_ID;
	private String admin_pwd;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAdmin_ID() {
		return admin_ID;
	}
	public void setAdmin_ID(String admin_ID) {
		this.admin_ID = admin_ID;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
}
