package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.PatientBaseInfo;
import com.lua.service.PatientService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午12:46:36
 * 类说明
 */
public class PatientInfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PatientBaseInfo patientBaseInfo;
	private List<PatientBaseInfo> list;
	private Pagination pagination;
	private String pageNum;
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
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public List<PatientBaseInfo> getList() {
		return list;
	}
	public void setList(List<PatientBaseInfo> list) {
		this.list = list;
	}
	public PatientBaseInfo getPatientBaseInfo() {
		return patientBaseInfo;
	}
	public void setPatientBaseInfo(PatientBaseInfo patientBaseInfo) {
		this.patientBaseInfo = patientBaseInfo;
	}
	
	public String execute()throws Exception{
		StringBuffer sql = new StringBuffer();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		PatientService patientService = new PatientService();
		int state = Integer.parseInt(((DoctorBaseInfo)session.getAttribute("doctorBaseInfo")).getState());
		if(state==1){
			switch (id) {
			case 0:
				pagination = patientService.show(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 1:
				sql.append(" and patient.patient_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.show(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 2:
				sql.append(" and patient.patient_name = '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.show(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 3:
				int i;
				if(search_id.equals("男")){
					i = 1;
				}else {
					i = 0;
				}
				sql.append(" and patient.patient_sex = ");
				sql.append(i);
				pagination = patientService.show(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 4:
				sql.append(" and patient.patient_birthday = '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.show(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 5:
				sql.append(" and patient.patient_phone= '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.show(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 6:
				sql.append(" and patient.patient_ID_card= '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.show(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			default:
				break;
			}
		}else {
			switch (id) {
			case 0:
				pagination = patientService.showAll(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 1:
				sql.append(" and patient.patient_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.showAll(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 2:
				sql.append(" and patient.patient_name = '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.showAll(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 3:
				int i;
				if(search_id.equals("男")){
					i = 1;
				}else {
					i = 0;
				}
				sql.append(" and patient.patient_sex = ");
				sql.append(i);
				pagination = patientService.showAll(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 4:
				sql.append(" and patient.patient_birthday = '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.showAll(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 5:
				sql.append(" and patient.patient_phone= '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.showAll(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 6:
				sql.append(" and patient.patient_ID_card= '");
				sql.append(search_id);
				sql.append("'");
				pagination = patientService.showAll(sql.toString(),hospital_ID,pageNum,2);
				break;
			default:
				break;
			}
			
		}
		return "patientInfoShow";
	}

}
