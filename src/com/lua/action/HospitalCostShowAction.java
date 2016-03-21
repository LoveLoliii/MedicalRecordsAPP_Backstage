package com.lua.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.HighchartUtil;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Num;
import com.lua.service.HighchartService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月15日 下午3:49:25
 * 类说明
 */
public class HospitalCostShowAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String timeYear;
	private List<Num> list;
	private List<Num> list2;
	private List<Num> listNums;
	private List<Num> listNums2;
	
	public List<Num> getList() {
		return list;
	}

	public void setList(List<Num> list) {
		this.list = list;
	}

	public String getTimeYear() {
		return timeYear;
	}

	public void setTimeYear(String timeYear) {
		this.timeYear = timeYear;
	}

	public String execute(){
		return "hospitalCostShow";
	}
	
	public String ShowYearHigh(){
		timeYear = timeYear;
		return "ShowYearHigh";
	}
	
	public String getLiString() throws Exception{
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		
		HighchartService highchartService = new HighchartService();
		list = highchartService.showHospitalCost(hospital_ID,timeYear);
		list2 = highchartService.showHospitalCostBefore(hospital_ID,timeYear);
		HighchartUtil highchartUtil =  new HighchartUtil();
		listNums = highchartUtil.good(list);
		listNums2 = highchartUtil.good(list2);
		
		List listNew = new ArrayList<>();
		listNew.add(listNums2);
		listNew.add(listNums);
		listNew.add(new Num(2015, Float.parseFloat(timeYear)-1));
		listNew.add(new Num(2016, Float.parseFloat(timeYear)));
		highchartUtil.outJson(listNew);
		return null;
	}
}
