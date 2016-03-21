package com.lua.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.lua.javautil.Pagination;
import com.lua.javautil.PaginationNew;
import com.lua.model.DepartmentDeploy;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.MinorDepartment;
import com.lua.service.DepartmentService;
import com.lua.service.DoctorService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月2日 下午12:00:16
 * 类说明
 */
public class DepartmentanddoctorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pagination pagination;
	private String pageNum;
	private MinorDepartment minordepartment;
	private DepartmentDeploy departmentDeploy;
	private int i;
	private int i2;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getI2() {
		return i2;
	}

	public void setI2(int i2) {
		this.i2 = i2;
	}


	public DepartmentDeploy getDepartmentDeploy() {
		return departmentDeploy;
	}

	public void setDepartmentDeploy(DepartmentDeploy departmentDeploy) {
		this.departmentDeploy = departmentDeploy;
	}

	private List<MinorDepartment> list;
	public List<MinorDepartment> getList() {
		return list;
	}

	public void setList(List<MinorDepartment> list) {
		this.list = list;
	}

	private DoctorBaseInfo doctorBaseInfo;
	public DoctorBaseInfo getDoctorBaseInfo() {
		return doctorBaseInfo;
	}

	public void setDoctorBaseInfo(DoctorBaseInfo doctorBaseInfo) {
		this.doctorBaseInfo = doctorBaseInfo;
	}

	private PaginationNew paginationNew;
	private String pageNumNew;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PaginationNew getPaginationNew() {
		return paginationNew;
	}

	public void setPaginationNew(PaginationNew paginationNew) {
		this.paginationNew = paginationNew;
	}

	public String getPageNumNew() {
		return pageNumNew;
	}

	public void setPageNumNew(String pageNumNew) {
		this.pageNumNew = pageNumNew;
	}

	public MinorDepartment getMinordepartment() {
		return minordepartment;
	}

	public void setMinordepartment(MinorDepartment minordepartment) {
		this.minordepartment = minordepartment;
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
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		DepartmentService departmentservice = new  DepartmentService();
		pagination = departmentservice.showDepartmentandDoc(doctorInfo_ID,pageNum,2);
		i=i;
		i2=i2;
		return "departmentanddoctorAction";
	}
	
	public String showDoctor() throws Exception{
		DepartmentService departmentservice = new  DepartmentService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo.getDoctorInfo_ID();
		RegistrationfeeService service = new RegistrationfeeService();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		pagination = departmentservice.showDepartmentandDoc(doctorInfo_ID,pageNum,2);
		paginationNew = departmentservice.showDoctor(hospital_ID,minordepartment.getMinordepartment_ID(),pageNumNew,2);
		if (paginationNew.getListNew()==null || paginationNew.getListNew().size()==0) {
			id=0;
		}else {
			DoctorBaseInfo baseInfo = ((DoctorBaseInfo)(paginationNew.getListNew().get(0)));
			id = baseInfo.getID();
		}
		return "showDoctor";
	}
	
	public String modifyDepartmentAndDoctorBefore() throws Exception{
		DoctorService doctorService = new DoctorService();
		doctorBaseInfo = doctorService.findDoctorByID(doctorBaseInfo.getDoctorInfo_ID());
		DepartmentService departmentservice = new  DepartmentService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo1 = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo1.getDoctorInfo_ID();
		list = departmentservice.findAllMinorByID(doctorInfo_ID);
		minordepartment = departmentservice.findMinorByID(doctorBaseInfo.getDoctorInfo_ID());
		return "modifyDepartmentAndDoctorBefore";
	}
	
	public String modifyDepartmentAndDoctorAfter() throws Exception{
		DoctorService doctorService = new DoctorService();
		DepartmentService departmentservice = new DepartmentService();
		i = doctorService.updateBy(doctorBaseInfo);
		DepartmentDeploy departmentDeploy2 = departmentservice.findByDocID(doctorBaseInfo.getDoctorInfo_ID());
		departmentDeploy.setHospital_ID(departmentDeploy2.getHospital_ID());
		departmentDeploy.setID(departmentDeploy2.getID());
		departmentDeploy.setDoctorInfo_ID(doctorBaseInfo.getDoctorInfo_ID());
		i2 = departmentservice.update(departmentDeploy);
		return "modifyDepartmentAndDoctorAfter";
	}
}
