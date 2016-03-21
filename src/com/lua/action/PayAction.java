package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Pay;
import com.lua.service.PayService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月9日 下午1:22:30
 * 类说明
 */
public class PayAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pagination pagination;
	private String pageNum;
	private Pay pay;
	private List<Pay> list;
	private int id;
	private String search_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSearch_id() {
		return search_id;
	}
	public void setSearch_id(String search_id) {
		this.search_id = search_id;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	public List<Pay> getList() {
		return list;
	}
	public void setList(List<Pay> list) {
		this.list = list;
	}
	
	public String execute() throws Exception{
		StringBuffer sql = new StringBuffer();
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		PayService payService = new PayService();
		switch (id) {
		case 0:
			pagination = payService.showPay(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 1:
			sql.append(" and pay.pay_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = payService.showPay(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 2:
			sql.append(" and pay.druguse_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = payService.showPay(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 3:
			sql.append(" and pay.pay_cost = ");
			sql.append(search_id);
			pagination = payService.showPay(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 4:
			sql.append(" and pay.pay_time = '");
			sql.append(search_id);
			sql.append("'");
			pagination = payService.showPay(sql.toString(),hospital_ID,pageNum,2);
			break;

		default:
			break;
		}
		return "payShow";
	}

}
