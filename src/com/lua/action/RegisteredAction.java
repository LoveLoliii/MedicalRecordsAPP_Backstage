package com.lua.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Registered;
import com.lua.service.DoctorService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午3:19:53
 * 类说明
 */
public class RegisteredAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	private Registered registered;
	private List<Registered> list;
	private Pagination pagination;
	private String pageNum;
	public Registered getRegistered() {
		return registered;
	}
	public void setRegistered(Registered registered) {
		this.registered = registered;
	}
	public List<Registered> getList() {
		return list;
	}
	public void setList(List<Registered> list) {
		this.list = list;
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
	
	public String execute() throws Exception{
		StringBuffer sqlBuffer = new StringBuffer();
		DoctorService doctorService = new DoctorService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		int state = Integer.parseInt(((DoctorBaseInfo)session.getAttribute("doctorBaseInfo")).getState());
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		if(state==1){
			if (id==0) {
				pagination = doctorService.showRegistered(sqlBuffer.toString(),doctorInfo_ID,pageNum,2);
			}else {
				switch (id) {
				case 1:
					sqlBuffer.append(" and registered.registered_ID= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showRegistered(sqlBuffer.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 2:
					sqlBuffer.append(" and registered.patient_ID= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showRegistered(sqlBuffer.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 3:
					sqlBuffer.append(" and registered.doctorInfo_ID= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showRegistered(sqlBuffer.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 4:
					sqlBuffer.append(" and registered.doctorVisit_ID= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showRegistered(sqlBuffer.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 5:
					sqlBuffer.append(" and registered.registered_time= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showRegistered(sqlBuffer.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 6:
					int i;
					if (search_id.equals("已就诊")) {
						i = 1;
					}else {
						i=0;
					}
					sqlBuffer.append(" and registered.registered_state= ");
					sqlBuffer.append(i);
					pagination = doctorService.showRegistered(sqlBuffer.toString(),doctorInfo_ID,pageNum,2);
					break;
				default:
					break;
				}
			}
			
		}else {
			if (id==0) {
				pagination = doctorService.showAllRegistered(sqlBuffer.toString(),hospital_ID,pageNum,2);
			}else {
				switch (id) {
				case 1:
					sqlBuffer.append(" and registered.registered_ID= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showAllRegistered(sqlBuffer.toString(),hospital_ID,pageNum,2);
					break;
				case 2:
					sqlBuffer.append(" and registered.patient_ID= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showAllRegistered(sqlBuffer.toString(),hospital_ID,pageNum,2);
					break;
				case 3:
					sqlBuffer.append(" and registered.doctorInfo_ID= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showAllRegistered(sqlBuffer.toString(),hospital_ID,pageNum,2);
					break;
				case 4:
					sqlBuffer.append(" and registered.doctorVisit_ID= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showAllRegistered(sqlBuffer.toString(),hospital_ID,pageNum,2);
					break;
				case 5:
					sqlBuffer.append(" and registered.registered_time= '");
					sqlBuffer.append(search_id);
					sqlBuffer.append("'");
					pagination = doctorService.showAllRegistered(sqlBuffer.toString(),hospital_ID,pageNum,2);
					break;
				case 6:
					int i;
					if (search_id.equals("已就诊")) {
						i = 1;
					}else {
						i=0;
					}
					sqlBuffer.append(" and registered.registered_state= ");
					sqlBuffer.append(i);
					pagination = doctorService.showAllRegistered(sqlBuffer.toString(),hospital_ID,pageNum,2);
					break;
				default:
					break;
				}
			}
		}
		return "registeredShow";
	}
	
	public String modifyRegistered() throws Exception{
		DoctorService doctorService = new DoctorService();
		doctorService.modifyRegistered(registered.getRegistered_ID());
		return "modifyRegistered";
		
		
	}

}
