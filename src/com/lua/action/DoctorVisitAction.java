package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.DoctorVisit;
import com.lua.service.DoctorService;
import com.lua.service.DoctorVisitService;
import com.lua.service.PatientService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月28日 下午3:44:04
 * 类说明
 */
public class DoctorVisitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DoctorVisit doctorVisit;
	private Pagination pagination;
	private String pageNum;
	private List<DoctorVisit> list;
	private int id;
	private String search_id;
	private int i;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
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
	public DoctorVisit getDoctorVisit() {
		return doctorVisit;
	}
	public void setDoctorVisit(DoctorVisit doctorVisit) {
		this.doctorVisit = doctorVisit;
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
	public List<DoctorVisit> getList() {
		return list;
	}
	public void setList(List<DoctorVisit> list) {
		this.list = list;
	}
	
	public String execute() throws Exception{
		StringBuilder sql = new StringBuilder(); 
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		int state = Integer.parseInt(((DoctorBaseInfo)session.getAttribute("doctorBaseInfo")).getState());
		DoctorVisitService doctorVisitService = new DoctorVisitService();
		if(state==1){
			if (id==0) {
				pagination = doctorVisitService.showDoctorVisitByID(sql.toString(),doctorInfo_ID,pageNum,2);
			}else{
				switch (id) {
				case 1:
					sql.append(" and doctorVisit_ID= '");
					sql.append(search_id);
					sql.append("'");
					pagination = doctorVisitService.showDoctorVisitByID(sql.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 2:
					sql.append(" and doctorvisit.doctorInfo_ID= '");
					sql.append(search_id);
					sql.append("'");
					pagination = doctorVisitService.showDoctorVisitByID(sql.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 3:
					sql.append(" and doctorvisit.doctorVisit_timeType= '");
					sql.append(search_id);
					sql.append("'");
					pagination = doctorVisitService.showDoctorVisitByID(sql.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 4:
					sql.append(" and doctorvisit.doctorVisit_regNunber= ");
					sql.append(search_id);
					pagination = doctorVisitService.showDoctorVisitByID(sql.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 5:
					int sex;
					if (search_id.equals("已确认")) {
						sex = 1;
					}else {
						sex = 0;
					}
					sql.append(" and doctorvisit.doctorVisit_confirmState= ");
					sql.append(sex);
					pagination = doctorVisitService.showDoctorVisitByID(sql.toString(),doctorInfo_ID,pageNum,2);
					break;
				case 6:
					int sexx;
					if (search_id.equals("已超时")) {
						sexx = 1;
					}else {
						sexx = 0;
					}
					sql.append(" and doctorvisit.doctorVisit_state= ");
					sql.append(sexx);
					pagination = doctorVisitService.showDoctorVisitByID(sql.toString(),doctorInfo_ID,pageNum,2);
					break;

				default:
					break;
				}
			}
		}else {
			if (id==0) {
				pagination = doctorVisitService.showAllDoctorVisits(sql.toString(),hospital_ID,pageNum,2);
			}else {
				switch (id) {
				case 1:
					sql.append(" and doctorVisit_ID= '");
					sql.append(search_id);
					sql.append("'");
					pagination = doctorVisitService.showAllDoctorVisits(sql.toString(),hospital_ID,pageNum,2);
					break;
				case 2:
					sql.append(" and doctorvisit.doctorInfo_ID= '");
					sql.append(search_id);
					sql.append("'");
					pagination = doctorVisitService.showAllDoctorVisits(sql.toString(),hospital_ID,pageNum,2);
					break;
				case 3:
					sql.append(" and doctorvisit.doctorVisit_timeType= '");
					sql.append(search_id);
					sql.append("'");
					pagination = doctorVisitService.showAllDoctorVisits(sql.toString(),hospital_ID,pageNum,2);
					break;
				case 4:
					sql.append(" and doctorvisit.doctorVisit_regNunber= ");
					sql.append(search_id);
					pagination = doctorVisitService.showAllDoctorVisits(sql.toString(),hospital_ID,pageNum,2);
					break;
				case 5:
					int sex;
					if (search_id.equals("已确认")) {
						sex = 1;
					}else {
						sex = 0;
					}
					sql.append(" and doctorvisit.doctorVisit_confirmState= ");
					sql.append(sex);
					pagination = doctorVisitService.showAllDoctorVisits(sql.toString(),hospital_ID,pageNum,2);
					break;
				case 6:
					int sexx;
					if (search_id.equals("已超时")) {
						sexx = 1;
					}else {
						sexx = 0;
					}
					sql.append(" and doctorvisit.doctorVisit_state= ");
					sql.append(sexx);
					pagination = doctorVisitService.showAllDoctorVisits(sql.toString(),hospital_ID,pageNum,2);
					break;
				default:
					break;
				}
			}
		}
		return "doctorVisitShow";
	}
	
	public String modifyDoctorVisitBefore() throws Exception{
		DoctorVisitService doctorVisitService = new DoctorVisitService();
		doctorVisit = doctorVisitService.findByID(doctorVisit.getDoctorVisit_ID());
		return "modifyDoctorVisitBefore";
	}
	
	public String modifydoctorVisitAfter() throws Exception{
		DoctorVisitService doctorVisitService = new DoctorVisitService();
		i = doctorVisitService.modifyDoctorVisit(doctorVisit);
		return "modifydoctorVisitAfter";
	}

}
