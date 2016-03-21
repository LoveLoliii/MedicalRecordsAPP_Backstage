package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Evaluation;
import com.lua.service.EvaluationService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月9日 下午2:27:45
 * 类说明
 */
public class EvaluationAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pagination pagination;
	private String pageNum;
	private Evaluation evaluation;
	private int i;
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
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
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
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	public List<Evaluation> getList() {
		return list;
	}
	public void setList(List<Evaluation> list) {
		this.list = list;
	}
	private List<Evaluation> list;
	
	public String execute() throws Exception{
		StringBuffer sql = new StringBuffer();
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		
		EvaluationService evaluationService = new EvaluationService();
		switch (id) {
		case 0:
			pagination = evaluationService.showEvaluation(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 1:
			sql.append(" and evaluation.evaluation_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = evaluationService.showEvaluation(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 2:
			sql.append(" and evaluation.patient_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = evaluationService.showEvaluation(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 3:
			sql.append(" and evaluation.doctorInfo_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = evaluationService.showEvaluation(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 4:
			int idd = 0;
			if (search_id.equals("好评")) {
				idd = 1;
			}else {
				idd = 0;
			}
			sql.append(" and evaluation.evaluation_state = ");
			sql.append(idd);
			pagination = evaluationService.showEvaluation(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 5:
			sql.append(" and evaluation.evaluation_time = '");
			sql.append(search_id);
			sql.append("'");
			pagination = evaluationService.showEvaluation(sql.toString(),hospital_ID,pageNum,2);
			break;

		default:
			break;
		}
		return "evaluationShow";
	}
	
	public String showEvaluationGood() throws Exception{
		StringBuffer sql = new StringBuffer();
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		
		EvaluationService evaluationService = new EvaluationService();
		switch (id) {
		case 0:
			pagination = evaluationService.showEvaluationGood(sql.toString(),hospital_ID,pageNum,2,i);
			break;
		case 1:
			sql.append(" and evaluation.evaluation_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = evaluationService.showEvaluationGood(sql.toString(),hospital_ID,pageNum,2,i);
			break;
		case 2:
			sql.append(" and evaluation.patient_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = evaluationService.showEvaluationGood(sql.toString(),hospital_ID,pageNum,2,i);
			break;
		case 3:
			sql.append(" and evaluation.doctorInfo_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = evaluationService.showEvaluationGood(sql.toString(),hospital_ID,pageNum,2,i);
			break;
		case 4:
			sql.append(" and evaluation.evaluation_time = '");
			sql.append(search_id);
			sql.append("'");
			pagination = evaluationService.showEvaluationGood(sql.toString(),hospital_ID,pageNum,2,i);
			break;

		default:
			break;
		}
		return "showEvaluationGood";
	}
	

}
