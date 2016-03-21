package com.interceptor; 

import javax.servlet.http.HttpServletRequest; 

import org.apache.struts2.ServletActionContext; 

import com.opensymphony.xwork2.Action;
 import com.opensymphony.xwork2.ActionInvocation;
 import com.opensymphony.xwork2.interceptor.Interceptor; 

/** 
 * sessionÎª¿ÕÀ¹½ØÆ÷ 
 */
 public class SessionNullInterceptor implements Interceptor {
 private static final long serialVersionUID = 1L; 

public void destroy() {
 } 

public void init() {
 } 

public String intercept(ActionInvocation invocation) throws Exception {
    HttpServletRequest req = ServletActionContext.getRequest();
    if (req.getSession().getAttribute("doctorBaseInfo") == null) {
     return "loginfailed";
    } else {
     return invocation.invoke();
    }
 } 

} 
