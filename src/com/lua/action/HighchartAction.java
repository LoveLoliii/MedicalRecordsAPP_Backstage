package com.lua.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.HighchartUtil;
import com.lua.model.DocCount;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Num;
import com.lua.service.DepartmentService;
import com.lua.service.HighchartService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月12日 下午3:21:36
 * 类说明
 */
public class HighchartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	protected static final int 
	private List<Num> list;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private List list_newList;
	public List getList_newList() {
		return list_newList;
	}

	public void setList_newList(List list_newList) {
		this.list_newList = list_newList;
	}

	private List<Num> list2;
	private List<Num> listNums;
	private List<Num> listNums2;
	private String idTimeStart;
	private String idTimeEnd;
	public String getIdTimeStart() {
		return idTimeStart;
	}

	public void setIdTimeStart(String idTimeStart) {
		this.idTimeStart = idTimeStart;
	}

	public String getIdTimeEnd() {
		return idTimeEnd;
	}

	public void setIdTimeEnd(String idTimeEnd) {
		this.idTimeEnd = idTimeEnd;
	}

	public List<Num> getList() {
		return list;
	}
	
	public void setList(List<Num> list) {
		this.list = list;
	}
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		DepartmentService departmentService = new DepartmentService();
		list_newList = departmentService.list(doctorInfo_ID);
		return "highchartShow";
	}
	
	public String showRegHighchart() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		DepartmentService departmentService = new DepartmentService();
		list_newList = departmentService.list(doctorInfo_ID);
		return "showRegHighchart";
	}
	
	public String showDocHighchartFirst() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		DepartmentService departmentService = new DepartmentService();
		
		list_newList = departmentService.list(doctorInfo_ID);
		return "showDocHighchartFirst";
	}
	
	public String showDocHighchart() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		DepartmentService departmentService = new DepartmentService();
		list_newList = departmentService.list(doctorInfo_ID);
		id = id;
		idTimeStart = idTimeStart;
		idTimeEnd = idTimeEnd;
		return "showDocHighchart";
	}
	
	public String showDepartmentHighchart() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		DepartmentService departmentService = new DepartmentService();
		
		list_newList = departmentService.list(doctorInfo_ID);
		return "showDepartmentHighchart";
	}
	
	
	public String showDepartmentAfter(){
		return "showDepartmentAfter";
	}
	
	

	public String getLiString() throws Exception{
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		list = new ArrayList<Num>();
		HighchartService highchartService = new HighchartService();
		list = highchartService.showRegistered(hospital_ID);
		list2 = highchartService.showRegisteredOther(hospital_ID);
		HighchartUtil highchartUtil =  new HighchartUtil();
		listNums = highchartUtil.good(list);
		listNums2 = highchartUtil.good(list2);
		
		List listNew = new ArrayList<>();
		listNew.add(listNums);
		listNew.add(listNums2);
		
		/*ServletActionContext.getResponse().setContentType("text/xml;charset=utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");  
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print(JSONArray.fromObject(listNew));  */
		highchartUtil.outJson(listNew);
		return null;
	}
	
	public String getLiDocString() throws Exception{
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		HighchartService highchartService = new HighchartService();
		String minordepartment_ID = id;
		List<DocCount> list = highchartService.showDoctorInfo(hospital_ID,minordepartment_ID,idTimeStart,idTimeEnd);
		HighchartUtil highchartUtil =  new HighchartUtil();
		highchartUtil.outJson(list);
		return null;
	}
	
	public String getLiDepString() throws Exception{
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		HighchartService highchartService = new HighchartService();
		List<DocCount> list = highchartService.showDepartment(idTimeStart,idTimeEnd,hospital_ID);
		HighchartUtil highchartUtil =  new HighchartUtil();
		highchartUtil.outJson(list);
		return null;
	}
	

}
