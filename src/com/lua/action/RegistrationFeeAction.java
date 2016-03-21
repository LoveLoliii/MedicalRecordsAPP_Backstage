package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Registrationfee;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月6日 上午10:35:42
 * 类说明
 */
public class RegistrationFeeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pagination pagination;
	private String pageNum;
	private Registrationfee registrationfee;
	private List<Registrationfee> list;
	private int id;
	private String search_id;
	private int i;
	private int i1;
	

	public int getI1() {
		return i1;
	}

	public void setI1(int i1) {
		this.i1 = i1;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getSearch_id() {
		return search_id;
	}

	public void setSearch_id(String search_id) {
		this.search_id = search_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Registrationfee getRegistrationfee() {
		return registrationfee;
	}

	public void setRegistrationfee(Registrationfee registrationfee) {
		this.registrationfee = registrationfee;
	}

	public List<Registrationfee> getList() {
		return list;
	}

	public void setList(List<Registrationfee> list) {
		this.list = list;
	}

	public String execute() throws Exception{
		StringBuffer sql = new StringBuffer();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		switch (id) {
		case 0:
			pagination = service.showRegistrationfee(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 1:
			sql.append(" and re.registrationfee_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = service.showRegistrationfee(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 2:
			sql.append(" and re.doctorInfo_typeName = '");
			sql.append(search_id);
			sql.append("'");
			pagination = service.showRegistrationfee(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 3:
			sql.append(" and re.registrationfee_fee = ");
			sql.append(Float.parseFloat(search_id));
			pagination = service.showRegistrationfee(sql.toString(),hospital_ID,pageNum,2);
			break;
		default:
			break;
		}
		i=i;
		i1=i1;
		return "registrationFeeShow";
	}
	
	public String modifyRegistrationFeeBefore() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		list = service.getAllDoctorInfoType(doctorInfo_ID);
		registrationfee = service.findRegistrationFeeByID(registrationfee.getRegistrationfee_ID());
		return "modifyRegistrationFeeBefore";
	}
	
	public String modifyRegistrationFeeAfter() throws Exception{
		RegistrationfeeService service = new RegistrationfeeService();
		i1 = service.modifyRegistrationFeeAfter(registrationfee);
		return "modifyRegistrationFeeAfter";
	}
	
	public String insertRegistrationFeeBefore() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		list = service.getAllDoctorInfoType(doctorInfo_ID);
		return "insertRegistrationFeeBefore";
	}
	
	public String insertRegistrationFeeAfter() throws Exception{
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		int max = service.createType(doctorInfo_ID);
		registrationfee.setDoctorInfo_type(max+1);
		registrationfee.setHospital_ID(hospital_ID);
		i = service.insertRegistrationFeeAfter(registrationfee);
		return "insertRegistrationFeeAfter";
	}
}
