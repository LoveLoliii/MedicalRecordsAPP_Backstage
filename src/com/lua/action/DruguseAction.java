package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Druguse;
import com.lua.service.DrugUseService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月8日 下午6:20:44
 * 类说明
 */
public class DruguseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pagination pagination;
	private String pageNum;
	private Druguse druguse;
	private List<Druguse> list;
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
	public Druguse getDruguse() {
		return druguse;
	}
	public void setDruguse(Druguse druguse) {
		this.druguse = druguse;
	}
	public List<Druguse> getList() {
		return list;
	}
	public void setList(List<Druguse> list) {
		this.list = list;
	}
	public String execute() throws Exception{
		StringBuffer sql = new StringBuffer();
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		
		DrugUseService drugUseService = new DrugUseService();
		switch (id) {
		case 0:
			pagination = drugUseService.showDrugUse(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 1:
			sql.append("and druguse.druguse_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = drugUseService.showDrugUse(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 2:
			sql.append("and druguse.medical_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = drugUseService.showDrugUse(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 3:
			sql.append("and druguse.drug_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = drugUseService.showDrugUse(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 4:
			sql.append("and druguse.druguse_num = ");
			sql.append(Integer.parseInt(search_id));
			pagination = drugUseService.showDrugUse(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 5:
			sql.append("and druguse.druguse_time = '");
			sql.append(search_id);
			sql.append("'");
			pagination = drugUseService.showDrugUse(sql.toString(),hospital_ID,pageNum,2);
			break;
		default:
			break;
		}
		i=i;
		return "drugShow";
	}
	
	public String modifyDrugUseBefore() throws Exception{
		DrugUseService drugUseService = new DrugUseService();
		druguse = drugUseService.modifyDrugUseBefore(druguse.getDruguse_ID());
		return "modifyDrugUseBefore";
	}
	
	public String modifyDrugUseAfter() throws Exception{
		DrugUseService drugUseService = new DrugUseService();
		i = drugUseService.modifyDrugUseAfter(druguse);
		return "modifyDrugUseAfter";
	}

}
