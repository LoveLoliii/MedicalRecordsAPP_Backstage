package com.lua.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lua.model.DoctorBaseInfo;
import com.lua.model.Hospital;
import com.lua.service.DepartmentService;
import com.lua.service.DoctorService;
import com.lua.service.HospitalService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月5日 下午12:37:55
 * 类说明
 */
public class HospitalAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hospital hospital;
	private DoctorBaseInfo doctorBaseInfo;
	private int departmentNum;
	private int doctorNum;
	private int i;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

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

	public int getDoctorNum() {
		return doctorNum;
	}

	public void setDoctorNum(int doctorNum) {
		this.doctorNum = doctorNum;
	}

	public int getDepartmentNum() {
		return departmentNum;
	}

	public void setDepartmentNum(int departmentNum) {
		this.departmentNum = departmentNum;
	}

	public DoctorBaseInfo getDoctorBaseInfo() {
		return doctorBaseInfo;
	}

	public void setDoctorBaseInfo(DoctorBaseInfo doctorBaseInfo) {
		this.doctorBaseInfo = doctorBaseInfo;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session = request.getSession();
		DoctorBaseInfo baseInfo = (DoctorBaseInfo) session.getAttribute("doctorBaseInfo");
		String baseinfo_ID = baseInfo.getDoctorInfo_ID();
		DoctorService doctorService = new DoctorService();
		doctorBaseInfo = doctorService.findDoctorByID(baseinfo_ID);
		HospitalService hospitalService = new HospitalService();
		hospital = hospitalService.hospitalbaseinfoShow(baseinfo_ID);
		DepartmentService departmentService = new DepartmentService();
		departmentNum = departmentService.findDepartmentByHosID(baseinfo_ID);
		doctorNum = departmentService.findDoctorByHosID(hospital.getHospital_ID());
		i=i;
		return "hospitalbaseinfoShow";
	}
	
	public String modifyHospitalBefore() throws Exception{
		HospitalService hospitalService = new HospitalService();
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		if(file!=null){
			File savefile = new File(new File(realpath), fileFileName);
			if(!savefile.getParentFile().exists()) savefile.getParentFile().mkdirs();
			FileUtils.copyFile(file, savefile);
		}
		
		hospital.setHospital_photo(realpath+"\\"+fileFileName);
		hospital = hospitalService.findHospitalByID(hospital.getHospital_ID());
		return "modifyHospitalBefore";
	}
	
	public String modifyHospitalAfter() throws Exception{
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		if(file!=null){
			File savefile = new File(new File(realpath), fileFileName);
			if(!savefile.getParentFile().exists()) savefile.getParentFile().mkdirs();
			FileUtils.copyFile(file, savefile);
		}
		HospitalService hospitalService = new HospitalService();
		hospital.setHospital_photo(realpath+"\\"+fileFileName);
		i = hospitalService.modifyHospitalAfter(hospital);
		return "modifyHospitalAfter";
	}
}
