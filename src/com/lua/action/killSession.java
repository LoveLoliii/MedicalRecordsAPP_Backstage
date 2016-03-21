package com.lua.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
SummerSama
2016年3月21日 下午11:24:05
2016
*/

public class killSession extends ActionSupport {
	public String execute(){
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession(false);
		session.invalidate();  
		return SUCCESS;
	}
}
