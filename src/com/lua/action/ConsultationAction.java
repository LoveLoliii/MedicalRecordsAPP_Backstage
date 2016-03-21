package com.lua.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.Consultation;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.attention;
import com.lua.service.ConsultationService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月27日 下午2:45:08
 * 类说明
 */
public class ConsultationAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Consultation consultation;
	private List<Consultation> list;
	private List<attention> attentions;
	private attention attention;
	private Pagination pagination;
	public int getIdd() {
		return idd;
	}
	public void setIdd(int idd) {
		this.idd = idd;
	}
	public String getSearch_id() {
		return search_id;
	}
	public void setSearch_id(String search_id) {
		this.search_id = search_id;
	}

	private String pageNum;
	private int idd;
	private String search_id;
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

	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<attention> getAttentions() {
		return attentions;
	}
	public void setAttentions(List<attention> attentions) {
		this.attentions = attentions;
	}
	public attention getAttention() {
		return attention;
	}
	public void setAttention(attention attention) {
		this.attention = attention;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	public List<Consultation> getList() {
		return list;
	}
	public void setList(List<Consultation> list) {
		this.list = list;
	}
	public String execute() throws Exception{
		StringBuffer sql = new StringBuffer();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		int state = Integer.parseInt(((DoctorBaseInfo)session.getAttribute("doctorBaseInfo")).getState());
		ConsultationService consultationService = new ConsultationService();
		if(state==1){
			String consultation_sendID = ((DoctorBaseInfo)session.getAttribute("doctorBaseInfo")).getDoctorInfo_ID();
			String consultation_getID = id;
			list = consultationService.showConsultationByID(consultation_sendID,consultation_getID);
			attentions = consultationService.showAttentions(consultation_sendID);
			return "consultationShow";
		}else {
			switch (idd) {
			case 0:
				pagination = consultationService.showConsultationElse(sql.toString(),hospital_ID,pageNum,7);
				break;
			case 1:
				sql.append("con.ID= ");
				sql.append(Integer.parseInt(search_id));
				sql.append("  ");
				pagination = consultationService.showConsultationElseElse(sql.toString(),pageNum,7);
				break;
			case 2:
				sql.append(" con.consultation_sendID= '");
				sql.append(search_id);
				sql.append("'  ");
				pagination = consultationService.showConsultationElseElse(sql.toString(),pageNum,7);
				break;
			case 3:
				sql.append(" con.consultation_getID= '");
				sql.append(search_id);
				sql.append("'  ");
				pagination = consultationService.showConsultationElseElse(sql.toString(),pageNum,7);
				break;

			default:
				break;
			}
			
			return "consultationShowElse";
		}
	}
	
	public String insert() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String consultation_sendID = ((DoctorBaseInfo)session.getAttribute("doctorBaseInfo")).getDoctorInfo_ID();
		ConsultationService consultationService = new ConsultationService();
		consultation.setConsultation_ID(String.valueOf(Math.random()*9000+1000));
		consultation.setConsultation_sendID(consultation_sendID);
		consultation.setConsultation_getID(id);
		Date d = new Date();  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateNowStr = sdf.format(d); 
		consultation.setConsultation_time(Timestamp.valueOf(dateNowStr));
		consultationService.insert(consultation);
		return "consultationShowAfter";
	}

}
