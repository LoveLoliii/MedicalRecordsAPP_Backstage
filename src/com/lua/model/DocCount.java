package com.lua.model;
/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月13日 下午12:50:13
 * 类说明
 */
public class DocCount {
	private String docname;
	private int num;
	
	public DocCount(String docname, int num) {
		super();
		this.docname = docname;
		this.num = num;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
