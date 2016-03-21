package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Drug;
import com.lua.service.DrugService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月8日 下午1:08:18
 * 类说明
 */
public class DrugAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pagination pagination;
	private String pageNum;
	private Drug drug;
	private List<Drug> list;
	private int id;
	private String search_id; 
	private int i;
	private int i1;
	private int i2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSearch_id() {
		return search_id;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getI1() {
		return i1;
	}
	public void setI1(int i1) {
		this.i1 = i1;
	}
	public int getI2() {
		return i2;
	}
	public void setI2(int i2) {
		this.i2 = i2;
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
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	public List<Drug> getList() {
		return list;
	}
	public void setList(List<Drug> list) {
		this.list = list;
	}
	public String execute() throws Exception{
		StringBuffer sql = new StringBuffer();
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		DrugService drugService = new DrugService();
		switch (id) {
		case 0:
			pagination = drugService.drugShow(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 1:
			sql.append(" and drug.drug_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = drugService.drugShow(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 2:
			sql.append(" and drug.drug_name = '");
			sql.append(search_id);
			sql.append("'");
			pagination = drugService.drugShow(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 3:
			sql.append(" and drug.drug_num = ");
			sql.append(Integer.parseInt(search_id));
			pagination = drugService.drugShow(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 4:
			sql.append(" and drug.drug_price = ");
			sql.append(Float.parseFloat(search_id));
			pagination = drugService.drugShow(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 5:
			sql.append(" and drug.drug_time = '");
			sql.append(search_id);
			sql.append("'");
			pagination = drugService.drugShow(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 6:
			sql.append(" and drug.drug_period = ");
			sql.append(Float.parseFloat(search_id));
			pagination = drugService.drugShow(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 7:
			sql.append(" and drug.drug_produce_factory = '");
			sql.append(search_id);
			sql.append("'");
			pagination = drugService.drugShow(sql.toString(),hospital_ID,pageNum,2);
			break;
		case 8:
			sql.append(" and drug.drug_style = '");
			sql.append(search_id);
			sql.append("'");
			pagination = drugService.drugShow(sql.toString(),hospital_ID,pageNum,2);
			break;
		default:
			break;
		}
		return "drugShow";
	}
	
	public String modifyDrugBefore() throws Exception{
		DrugService drugService = new DrugService();
		drug = drugService.modifyDrugBefore(drug.getDrug_ID());
		return "modifyDrugBefore";
	}
	
	public String modifyDrugAfter() throws Exception{
		DrugService drugService = new DrugService();
		i = drugService.modifyDrugAfter(drug);
		return "modifyDrugAfter";
	}
	
	public String insertDrugBefore(){
		return "insertDrugBefore";
	}
	
	public String insertDrugAfter() throws Exception{
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		
		DrugService drugService = new DrugService();
		i1 = drugService.insertDrugAfter(drug);
		i2 = drugService.insertHos(drug.getDrug_ID(),hospital_ID);
		return "insertDrugAfter";
	}
}
