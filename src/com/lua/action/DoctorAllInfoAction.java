package com.lua.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lua.javautil.Pagination;
import com.lua.model.DepartmentDeploy;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.MinorDepartment;
import com.lua.model.Registrationfee;
import com.lua.service.DepartmentService;
import com.lua.service.DoctorService;
import com.lua.service.DoctorVisitService;
import com.lua.service.EvaluationService;
import com.lua.service.MedicalService;
import com.lua.service.RegistrationfeeService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年1月21日 下午6:16:00
 * 类说明
 */
public class DoctorAllInfoAction extends ActionSupport{

	/**
	 * 
	 */
	private DoctorService doctorService;
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int i,i2,i3;
	public int getI3() {
		return i3;
	}
	public void setI3(int i3) {
		this.i3 = i3;
	}
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

	private DoctorBaseInfo doctorBaseInfo;
	private Pagination pagination;
	private String pageNum;
	private List<DoctorBaseInfo> list;
	private List<Registrationfee> listRegistrationfees;
	public List<Registrationfee> getListRegistrationfees() {
		return listRegistrationfees;
	}
	public void setListRegistrationfees(List<Registrationfee> listRegistrationfees) {
		this.listRegistrationfees = listRegistrationfees;
	}

	private List<MinorDepartment> listMin;
	private DepartmentDeploy departmentDeploy;
	private File file;//上传文件的file对象
	private String fileFileName;//上传文件的名称
	private String fileContentType;//上传文件的MIME类型
	private String description;//上传的描述信息
	private String uploadDir;//保存上传文件的目录
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUploadDir() {
		return uploadDir;
	}
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	public DepartmentDeploy getDepartmentDeploy() {
		return departmentDeploy;
	}
	public void setDepartmentDeploy(DepartmentDeploy departmentDeploy) {
		this.departmentDeploy = departmentDeploy;
	}
	public List<MinorDepartment> getListMin() {
		return listMin;
	}
	public void setListMin(List<MinorDepartment> listMin) {
		this.listMin = listMin;
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
	public List<DoctorBaseInfo> getList() {
		return list;
	}
	public void setList(List<DoctorBaseInfo> list) {
		this.list = list;
	}
	public DoctorBaseInfo getDoctorBaseInfo() {
		return doctorBaseInfo;
	}
	public void setDoctorBaseInfo(DoctorBaseInfo doctorBaseInfo) {
		this.doctorBaseInfo = doctorBaseInfo;
	}
	public String execute() throws Exception{
		StringBuilder sql = new StringBuilder(); 
		RegistrationfeeService service = new RegistrationfeeService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		String doctorInfo_ID = ((DoctorBaseInfo)(session.getAttribute("doctorBaseInfo"))).getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		if (id==0) {
			doctorService = new DoctorService();
			pagination = doctorService.showAllDoctor(sql.toString(),hospital_ID,pageNum,2);
		}else {
			switch (id) {
			case 1:
				sql.append("AND doctorinfo.doctorInfo_ID='");
				sql.append(search_id);
				sql.append("'");
				doctorService = new DoctorService();
				pagination = doctorService.showAllDoctor(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 2:
				sql.append("AND doctorinfo.doctorInfo_name='");
				sql.append(search_id);
				sql.append("'");
				doctorService = new DoctorService();
				pagination = doctorService.showAllDoctor(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 3:
				int sex;
				if (search_id.equals("男")) {
					sex = 1;
				}else {
					sex = 0;
				}
				sql.append("AND doctorinfo.doctorInfo_sex=");
				sql.append(sex);
				doctorService = new DoctorService();
				pagination = doctorService.showAllDoctor(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 4:
				sql.append("AND doctorinfo.doctorInfo_record='");
				sql.append(search_id);
				sql.append("'");
				doctorService = new DoctorService();
				pagination = doctorService.showAllDoctor(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 5:
				sql.append("AND doctorinfo.doctorInfo_position='");
				sql.append(search_id);
				sql.append("'");
				doctorService = new DoctorService();
				pagination = doctorService.showAllDoctor(sql.toString(),hospital_ID,pageNum,2);
				break;
			case 6:
				RegistrationfeeService registrationfeeService = new RegistrationfeeService();
				String doctorInfo_type = registrationfeeService.findByDocTypename(hospital_ID,search_id);
				sql.append("AND doctorinfo.doctorInfo_type='");
				sql.append(doctorInfo_type);
				sql.append("'");
				doctorService = new DoctorService();
				pagination = doctorService.showAllDoctor(sql.toString(),hospital_ID,pageNum,2);
				break;
			default:
				break;
			}
		}
		return "doctorAllInfoShow";
	}
	
	public void modifyID() throws Exception{
		String doctorInfo_ID = search_id;
		DoctorService doctorService = new DoctorService();
		pagination = doctorService.showDoctorByID(doctorInfo_ID,pageNum,2);
	}
	
	public void modifyName() throws Exception{
		String doctorInfo_name = search_id;
		DoctorService doctorService = new DoctorService();
		doctorService = new DoctorService();
		pagination = doctorService.showDoctorByName(doctorInfo_name,pageNum,2);
	}
	
	public String insertDoctorAllInfoBefore() throws Exception{
		RegistrationfeeService service = new RegistrationfeeService();
		DepartmentService departmentservice = new  DepartmentService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo1 = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String doctorInfo_ID = doctorBaseInfo1.getDoctorInfo_ID();
		String hospital_ID = service.findHospitalByID(doctorInfo_ID);
		listMin = departmentservice.findAllMinorByID(doctorInfo_ID);
		listRegistrationfees = service.listRegistrationfees(hospital_ID);
		return "insertDoctorAllInfoBefore";
	}
	
	public String insertDoctorAllInfoAfter() throws Exception{
		DoctorService doctorService = new DoctorService();
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo doctorBaseInfo1 = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		DepartmentService departmentservice = new DepartmentService();
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		if(file!=null){
			File savefile = new File(new File(realpath), fileFileName);
			if(!savefile.getParentFile().exists()) savefile.getParentFile().mkdirs();
			FileUtils.copyFile(file, savefile);
		}
		doctorBaseInfo.setDoctorInfo_photo(realpath+"\\"+fileFileName);
		i = doctorService.insertDoctor(doctorBaseInfo);
		DepartmentDeploy departmentDeploy2 = departmentservice.findByDocID(doctorBaseInfo1.getDoctorInfo_ID());
		departmentDeploy.setHospital_ID(departmentDeploy2.getHospital_ID());
		departmentDeploy.setDoctorInfo_ID(doctorBaseInfo.getDoctorInfo_ID());
		i2 = departmentservice.insertDepartmentDeploy(departmentDeploy);
		return "insertDoctorAllInfoAfter";
	}
	
	public String deleteDoctorinfo() throws Exception{
		DoctorService doctorService = new DoctorService();
		DepartmentService departmentService = new DepartmentService();
		DoctorVisitService doctorVisitService = new DoctorVisitService();
		EvaluationService evaluationService = new EvaluationService();
		MedicalService medicalService = new MedicalService();
		i3 = departmentService.deleteDepartment(doctorBaseInfo.getDoctorInfo_ID());
		i3 = doctorVisitService.deleteDoctVisit(doctorBaseInfo.getDoctorInfo_ID());
		i3 = evaluationService.deleteEvaluation(doctorBaseInfo.getDoctorInfo_ID());
		i3 = medicalService.deleteMedical(doctorBaseInfo.getDoctorInfo_ID());
		i3 = doctorService.deleteRegistered(doctorBaseInfo.getDoctorInfo_ID());
		i3 = doctorService.deleteDoctorinfo(doctorBaseInfo.getDoctorInfo_ID());
		return "deleteDoctorinfo";
	}
}
