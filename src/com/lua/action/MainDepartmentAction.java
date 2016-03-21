package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.javautil.PaginationNew;
import com.lua.model.DepartmentDeploy;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.MainDepartment;
import com.lua.model.MinorDepartment;
import com.lua.service.DepartmentService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月29日 下午7:59:58
 * 类说明
 */
public class MainDepartmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainDepartment maindepartment;
	private MinorDepartment minordepartment;
	private int idd;
	private String search_id;
	private int i;
	private int i1;
	private int i2;
	public int getI2() {
		return i2;
	}
	public void setI2(int i2) {
		this.i2 = i2;
	}
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
	public MinorDepartment getMinordepartment() {
		return minordepartment;
	}
	public void setMinordepartment(MinorDepartment minordepartment) {
		this.minordepartment = minordepartment;
	}

	private List<MainDepartment> list;
	private Pagination pagination;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	private PaginationNew paginationNew;
	private String pageNumNew;
	public String getPageNumNew() {
		return pageNumNew;
	}
	public void setPageNumNew(String pageNumNew) {
		this.pageNumNew = pageNumNew;
	}
	public PaginationNew getPaginationNew() {
		return paginationNew;
	}
	public void setPaginationNew(PaginationNew paginationNew) {
		this.paginationNew = paginationNew;
	}

	private String pageNum;
	
	public MainDepartment getMaindepartment() {
		return maindepartment;
	}
	public void setMaindepartment(MainDepartment maindepartment) {
		this.maindepartment = maindepartment;
	}
	public List<MainDepartment> getList() {
		return list;
	}
	public void setList(List<MainDepartment> list) {
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
		StringBuffer sql = new StringBuffer();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		DepartmentService departmentService = new DepartmentService();
		switch (idd) {
		case 0:
			pagination = departmentService.showMaindepartment(sql.toString(),hospital_ID,pageNum,5);
			break;
		case 1:
			sql.append(" and main.maindepartment_ID = '");
			sql.append(search_id);
			sql.append("'");
			pagination = departmentService.showMaindepartment(sql.toString(),hospital_ID,pageNum,5);
			break;
		case 2:
			sql.append(" and main.maindepartment_name = '");
			sql.append(search_id);
			sql.append("'");
			pagination = departmentService.showMaindepartment(sql.toString(),hospital_ID,pageNum,5);
			break;

		default:
			break;
		}
		i=i;
		i1=i1;
		i2=i2;
		return "maindepartmentShow";
	}
	
	public String modifyMainDepartmentBefore() throws Exception{
		DepartmentService departmentService = new DepartmentService();
		maindepartment = departmentService.modifyMainDepartmentBefore(maindepartment.getMaindepartment_ID());
		return "modifyMainDepartmentBefore";
	}
	
	public String modifyMainDepartmentAfter() throws Exception{
		DepartmentService departmentService = new DepartmentService();
		i1 = departmentService.modifyMainDepartmentAfter(maindepartment);
		return "modifyMainDepartmentAfter";
	}
	
	public String insertMainDepartmentBefore(){
		return "insertMainDepartmentBefore";
	}
	
	public String insertMainDepartmentAfter() throws Exception{
		DepartmentService departmentService = new DepartmentService();
		i = departmentService.insertMainDepartmentAfter(maindepartment);
		return "insertMainDepartmentAfter";
	}
	
	public String deploymaindepartment() throws Exception{
		DepartmentService departmentService = new DepartmentService();
		pagination = departmentService.showALlMaindepartment(pageNum,7);
		//paginationNew = departmentService.showMinordepartment(pageNumNew,2);
		i=i;
		i1=i1;
		return "deploymaindepartment";
	}
	
	public String showMinordepartment() throws Exception{
		DepartmentService departmentService = new DepartmentService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		if (maindepartment.getMaindepartment_ID()==null  ||  maindepartment.getMaindepartment_ID().length()<=0) {
			paginationNew = departmentService.showMinordepartment(pageNumNew,2);
		}else{
			pagination = departmentService.showALlMaindepartment(pageNum,7);
			maindepartment = departmentService.showMaindepartmentByID(maindepartment.getMaindepartment_ID());
			paginationNew = departmentService.showMinordepartmentByID(doctorInfo_ID,maindepartment.getMaindepartment_ID(),pageNumNew,2);
			if (paginationNew.getListNew()==null || paginationNew.getListNew().size()==0) {
				id="00000000";
			}else {
				MinorDepartment department = ((MinorDepartment)(paginationNew.getListNew().get(0)));
				id = department.getMaindepartment_ID();
			}
		}
		return "showMinordepartment";
	}
	
	public String modifyMinorDepartmentBefore() throws Exception{
		DepartmentService departmentService = new DepartmentService();
		list = departmentService.showMaindepartment();
		minordepartment = departmentService.findMinordepartmentByID(minordepartment.getMinordepartment_ID());
		return "modifyMinorDepartmentBefore";
	}
	
	public String modifyMinorDepartmentAfter() throws Exception{
		DepartmentService departmentService = new DepartmentService();
		i2 = departmentService.modifyMinorDepartmentAfter(minordepartment);
		return "modifyMinorDepartmentAfter";
	}
	
	public String insertMinorDepartmentBefore() throws Exception{
		DepartmentService departmentService = new DepartmentService();
		list = departmentService.showMaindepartment();
		return "insertMinorDepartmentBefore";
	}
	
	public String insertMinorDepartmentAfter() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		
		DepartmentService departmentService = new DepartmentService();
		i = departmentService.inserMinordepartment(minordepartment);
		DepartmentDeploy departmentDeploy = new DepartmentDeploy();
		departmentDeploy.setMinordepartment_ID(minordepartment.getMinordepartment_ID());
		departmentDeploy.setDoctorInfo_ID(doctorInfo_ID);
		departmentDeploy.setHospital_ID(hospital_ID);
		i1 = departmentService.insertDepartmentDeploy(departmentDeploy);
		return "insertMinorDepartmentAfter";
	}
	
}
