package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Medical;
import com.lua.service.DoctorService;
import com.lua.service.MedicalService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月26日 上午10:41:31
 * 类说明
 */
public class MedicalAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Medical medical;
	private Pagination pagination;
	private List<Medical> list;
	private String pageNum;
	private int i;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

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
	public Medical getMedical() {
		return medical;
	}
	public void setMedical(Medical medical) {
		this.medical = medical;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public List<Medical> getList() {
		return list;
	}
	public void setList(List<Medical> list) {
		this.list = list;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	
	public String execute() throws Exception{
		StringBuffer sql = new StringBuffer();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		int state = Integer.parseInt(((DoctorBaseInfo)session.getAttribute("doctorBaseInfo")).getState());
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		DoctorService doctorService = new DoctorService();
		if(state==1){
			switch (id) {
			case 0:
				pagination = doctorService.showMedical(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 1:
				sql.append(" and medical.medical_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showMedical(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 2:
				sql.append(" and medical.patient_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showMedical(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 3:
				sql.append(" and medical.registered_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showMedical(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 4:
				sql.append(" and medical.doctorInfo_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showMedical(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 5:
				sql.append(" and medical.medical_time= '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showMedical(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			case 6:
				int i;
				if (search_id.equals("确认")) {
					i = 1;
				}else {
					i = 0;
				}
				sql.append(" and medical.medical_state= ");
				sql.append(i);
				pagination = doctorService.showMedical(sql.toString(),doctorInfo_ID,pageNum,2);
				break;
			default:
				break;
			}
		}else {
			switch (id) {
			case 0:
				pagination = doctorService.showAllMedical(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 1:
				sql.append(" and medical.medical_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showAllMedical(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 2:
				sql.append(" and medical.patient_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showAllMedical(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 3:
				sql.append(" and medical.registered_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showAllMedical(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 4:
				sql.append(" and medical.doctorInfo_ID = '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showAllMedical(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 5:
				sql.append(" and medical.medical_time= '");
				sql.append(search_id);
				sql.append("'");
				pagination = doctorService.showAllMedical(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 6:
				int i;
				if (search_id.equals("确认")) {
					i = 1;
				}else {
					i = 0;
				}
				sql.append(" and medical.medical_state= ");
				sql.append(i);
				pagination = doctorService.showAllMedical(sql.toString(),hospital_ID,pageNum,2);
				break;
			default:
				break;
			}
		}
		i=i;
		return "medicalShow";
	}
	
	public String modifyMedical() throws Exception{
		MedicalService medicalService = new MedicalService();
		medical = medicalService.findById(medical.getMedical_ID());
		return "modifyMedicalBefore";
	}
	
	public String modifyMedicalAfter() throws Exception{
		MedicalService medicalService = new MedicalService();
		i = medicalService.modifyMedical(medical);
		return "modifyMedicalAfter";
	}

}
