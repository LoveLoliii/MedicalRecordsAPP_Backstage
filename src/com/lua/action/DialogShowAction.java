package com.lua.action;

import java.util.ArrayList;
import java.util.List;

import com.lua.javautil.HighchartUtil;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.DoctorVisit;
import com.lua.model.Drug;
import com.lua.model.Druguse;
import com.lua.model.Medical;
import com.lua.model.PatientBaseInfo;
import com.lua.model.Registered;
import com.lua.service.DoctorService;
import com.lua.service.DoctorVisitService;
import com.lua.service.DrugService;
import com.lua.service.DrugUseService;
import com.lua.service.MedicalService;
import com.lua.service.PatientService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月15日 下午8:05:37
 * 类说明
 */
public class DialogShowAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DoctorBaseInfo doctorBaseInfo;
	private PatientBaseInfo patientBaseInfo;
	private DoctorVisit doctorVisit;
	private Registered registered;
	private Medical medical;
	private Drug drug;
	private Druguse druguse;
	public Druguse getDruguse() {
		return druguse;
	}
	public void setDruguse(Druguse druguse) {
		this.druguse = druguse;
	}
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	public Medical getMedical() {
		return medical;
	}
	public void setMedical(Medical medical) {
		this.medical = medical;
	}
	public Registered getRegistered() {
		return registered;
	}
	public void setRegistered(Registered registered) {
		this.registered = registered;
	}
	public DoctorVisit getDoctorVisit() {
		return doctorVisit;
	}
	public void setDoctorVisit(DoctorVisit doctorVisit) {
		this.doctorVisit = doctorVisit;
	}
	public PatientBaseInfo getPatientBaseInfo() {
		return patientBaseInfo;
	}
	public void setPatientBaseInfo(PatientBaseInfo patientBaseInfo) {
		this.patientBaseInfo = patientBaseInfo;
	}
	public DoctorBaseInfo getDoctorBaseInfo() {
		return doctorBaseInfo;
	}
	public void setDoctorBaseInfo(DoctorBaseInfo doctorBaseInfo) {
		this.doctorBaseInfo = doctorBaseInfo;
	}
	
	public String showDocByID() throws Exception{
		DoctorService doctorService = new DoctorService();
		doctorBaseInfo = doctorService.findDoctorByID(doctorBaseInfo.getDoctorInfo_ID());
		/*List<DoctorBaseInfo> list = new ArrayList<DoctorBaseInfo>();
		list.add(doctorBaseInfo);
		HighchartUtil highchartUtil =  new HighchartUtil();
		highchartUtil.outJson(list);*/
		return "showDocByID";
	}
	
	public String showPatByID() throws Exception{
		PatientService patientService = new PatientService();
		patientBaseInfo = patientService.findPatientByID(patientBaseInfo.getPatient_ID());
		return "showPatByID";
	}
	
	public String showVisByID() throws Exception{
		DoctorVisitService doctorVisitService = new DoctorVisitService();
		doctorVisit = doctorVisitService.findByID(doctorVisit.getDoctorVisit_ID());
		return "showVisByID";
	}
	
	public String showRegByID() throws Exception{
		DoctorService doctorService = new DoctorService();
		registered = doctorService.findRegByID(registered.getRegistered_ID());
		return "showRegByID";
	}
	
	public String showMedByID() throws Exception{
		MedicalService medicalService = new MedicalService();
		medical = medicalService.findById(medical.getMedical_ID());
		return "showMedByID";
	}
	
	public String showDrugByID() throws Exception{
		DrugService drugService = new DrugService();
		drug = drugService.modifyDrugBefore(drug.getDrug_ID());
		return "showDrugByID";
	}
	
	public String showDrugUseByID() throws Exception{
		DrugUseService drugUseService = new DrugUseService();
		druguse = drugUseService.modifyDrugUseBefore(druguse.getDruguse_ID());
		return "showDrugUseByID";
	}
}
