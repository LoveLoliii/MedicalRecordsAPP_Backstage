package com.lua.service;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lua.DAOImpl.DoctorDAOImpl;
import com.lua.dao.DoctorDAO;
import com.lua.javautil.ImageUtil;
import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.Medical;
import com.lua.model.Registered;
import com.lua.model.Registrationfee;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年1月21日 下午3:08:12
 * 类说明
 */
public class DoctorService {
	private DoctorDAO doctorDAO;
	private DoctorBaseInfo doctorBaseInfo;
	private List<Registered> list;
	private Registered registered;
	
	public DoctorBaseInfo login(String doctorInfo_ID, String doctorInfo_pwd)throws Exception {
		doctorDAO = new DoctorDAOImpl();
		ResultSet b= doctorDAO.login(doctorInfo_ID,doctorInfo_pwd);
		doctorBaseInfo = new DoctorBaseInfo();
		InputStream inputStream = null;
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		while(b.next()){
			doctorBaseInfo.setID(b.getInt("ID"));
			doctorBaseInfo.setDoctorInfo_ID(b.getString("doctorInfo_ID"));
			doctorBaseInfo.setDoctorInfo_pwd(b.getString("doctorInfo_pwd"));
			doctorBaseInfo.setDoctorInfo_name(b.getString("doctorInfo_name"));
			doctorBaseInfo.setDoctorInfo_sex(b.getInt("doctorInfo_sex"));
			doctorBaseInfo.setDoctorInfo_birthday(b.getDate("doctorInfo_birthday"));
			doctorBaseInfo.setDoctorInfo_address(b.getString("doctorInfo_address"));
			doctorBaseInfo.setDoctorInfo_record(b.getString("doctorInfo_record"));
			doctorBaseInfo.setDoctorInfo_position(b.getString("doctorInfo_position"));
			doctorBaseInfo.setDoctorInfo_phone(b.getString("doctorInfo_phone"));
			doctorBaseInfo.setDoctorInfo_email(b.getString("doctorInfo_email"));
			inputStream = b.getBinaryStream("doctorInfo_photo");
			ImageUtil.readBlob(inputStream, realpath+"\\photo"+b.getString("doctorInfo_ID")+".png");
			doctorBaseInfo.setDoctorInfo_photo("photo"+b.getString("doctorInfo_ID")+".png");
			doctorBaseInfo.setDoctorInfo_type(b.getString("doctorInfo_type"));
			doctorBaseInfo.setDoctorInfo_disease(b.getString("doctorInfo_disease"));
			doctorBaseInfo.setDoctorInfo_Oaddress(b.getString("doctorInfo_Oaddress"));
			doctorBaseInfo.setState(b.getString("state"));
		}
		return doctorBaseInfo;
	}

	public int update(DoctorBaseInfo doctorBaseInfo2) throws Exception {
		doctorDAO = new DoctorDAOImpl();
		int i = doctorDAO.update(doctorBaseInfo2);
		return i;
	}

	public Pagination showRegistered(String sqlString,String doctorInfo_ID, String pageNum, int i) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int total = doctorDAO.getListNum(sqlString,doctorInfo_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorDAO.showRegistered(sqlString,doctorInfo_ID,pagination.getStartRow(),i);
		list = new ArrayList<Registered>();
		while(rs.next()){
			registered = new Registered();
			registered.setID(rs.getInt("ID"));
			registered.setRegistered_ID(rs.getString("registered_ID"));
			registered.setRegistered_info(rs.getString("registered_info"));
			registered.setRegistered_state(rs.getInt("registered_state"));
			registered.setRegistered_time(rs.getDate("registered_time"));
			registered.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			registered.setPatient_ID(rs.getString("patient_ID"));
			registered.setDoctorVisit_ID(rs.getString("doctorVisit_ID"));
			list.add(registered);
		}
		pagination.setList(list);
		return pagination;
	}

	public void modifyRegistered(String registered_ID) throws Exception {
		doctorDAO = new DoctorDAOImpl();
		int i = doctorDAO.findById(registered_ID);
		if(i==1){
			doctorDAO.modifyRegistered(registered_ID,0);
		}else{
			doctorDAO.modifyRegistered(registered_ID,1);
		}
	}

	public Pagination showMedical(String sqlString,String doctorInfo_ID, String pageNum, int i) throws Exception {
		doctorDAO = new DoctorDAOImpl();
		int total = doctorDAO.getMedicalListNum(sqlString,doctorInfo_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorDAO.showMedical(sqlString,doctorInfo_ID,pagination.getStartRow(),i);
		List<Medical> list = new ArrayList<Medical>();
		Medical medical;
		while(rs.next()){
			medical = new Medical();
			medical.setID(rs.getInt("ID"));
			medical.setMedical_ID(rs.getString("medical_ID"));
			medical.setPatient_ID(rs.getString("patient_ID"));
			medical.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			medical.setRegistered_ID(rs.getString("registered_ID"));
			medical.setMedical_msg(rs.getString("medical_msg"));
			medical.setMedical_result(rs.getString("medical_result"));
			medical.setMedical_time(rs.getDate("medical_time"));
			medical.setMedical_state(rs.getInt("medical_state"));
			list.add(medical);
		}
		pagination.setList(list);
		return pagination;
	}

	public Pagination showAllDoctor(String sql,String hospital_ID, String pageNum, int i) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int total = doctorDAO.getAllDoctor(sql,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorDAO.showAllDoctors(sql,hospital_ID,pagination.getStartRow(),i);
		List<DoctorBaseInfo> list = new ArrayList<DoctorBaseInfo>();
		DoctorBaseInfo doctorBaseInfo;
		while(rs.next()){
			doctorBaseInfo = new DoctorBaseInfo();
			doctorBaseInfo.setID(rs.getInt("ID"));
			doctorBaseInfo.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			doctorBaseInfo.setDoctorInfo_pwd(rs.getString("doctorInfo_pwd"));
			doctorBaseInfo.setDoctorInfo_name(rs.getString("doctorInfo_name"));
			doctorBaseInfo.setDoctorInfo_sex(rs.getInt("doctorInfo_sex"));
			doctorBaseInfo.setDoctorInfo_birthday(rs.getDate("doctorInfo_birthday"));
			doctorBaseInfo.setDoctorInfo_address(rs.getString("doctorInfo_address"));
			doctorBaseInfo.setDoctorInfo_record(rs.getString("doctorInfo_record"));
			doctorBaseInfo.setDoctorInfo_position(rs.getString("doctorInfo_position"));
			doctorBaseInfo.setDoctorInfo_phone(rs.getString("doctorInfo_phone"));
			doctorBaseInfo.setDoctorInfo_email(rs.getString("doctorInfo_email"));
			/*inputStream = rs.getBinaryStream("doctorInfo_photo");
			ImageUtil.readBlob(inputStream, realpath+"\\photo"+rs.getString("doctorInfo_ID")+".png");*/
			doctorBaseInfo.setDoctorInfo_photo(rs.getString("doctorInfo_photo"));
			doctorBaseInfo.setDoctorInfo_type(rs.getString("doctorInfo_typeName"));
			doctorBaseInfo.setDoctorInfo_disease(rs.getString("doctorInfo_disease"));
			doctorBaseInfo.setDoctorInfo_Oaddress(rs.getString("doctorInfo_Oaddress"));
			doctorBaseInfo.setState(rs.getString("state"));
			list.add(doctorBaseInfo);
		}
		pagination.setList(list);
		return pagination;
	}

	public Pagination showAllRegistered(String sqlString,String hospital_ID,String pageNum, int i) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int total = doctorDAO.getAllRegisteredListNum(sqlString,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorDAO.showAllRegistered(sqlString,hospital_ID,pagination.getStartRow(),i);
		list = new ArrayList<Registered>();
		while(rs.next()){
			registered = new Registered();
			registered.setID(rs.getInt("ID"));
			registered.setRegistered_ID(rs.getString("registered_ID"));
			registered.setRegistered_info(rs.getString("registered_info"));
			registered.setRegistered_state(rs.getInt("registered_state"));
			registered.setRegistered_time(rs.getDate("registered_time"));
			registered.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			registered.setPatient_ID(rs.getString("patient_ID"));
			registered.setDoctorVisit_ID(rs.getString("doctorVisit_ID"));
			list.add(registered);
		}
		pagination.setList(list);
		return pagination;
	}

	public Pagination showAllMedical(String sqlString,String hospital_ID,String pageNum, int i) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int total = doctorDAO.getAllMedicalListNum(sqlString,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorDAO.showALlMedical(sqlString,hospital_ID,pagination.getStartRow(),i);
		List<Medical> list = new ArrayList<Medical>();
		Medical medical;
		while(rs.next()){
			medical = new Medical();
			medical.setID(rs.getInt("ID"));
			medical.setMedical_ID(rs.getString("medical_ID"));
			medical.setPatient_ID(rs.getString("patient_ID"));
			medical.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			medical.setRegistered_ID(rs.getString("registered_ID"));
			medical.setMedical_msg(rs.getString("medical_msg"));
			medical.setMedical_result(rs.getString("medical_result"));
			medical.setMedical_time(rs.getDate("medical_time"));
			medical.setMedical_state(rs.getInt("medical_state"));
			list.add(medical);
		}
		pagination.setList(list);
		return pagination;
	}

	public Pagination showDoctorByID(String doctorInfo_ID, String pageNum, int i) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int total = doctorDAO.getDoctorNumByID(doctorInfo_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorDAO.showDoctorsByID(doctorInfo_ID,pagination.getStartRow(),i);
		List<DoctorBaseInfo> list = new ArrayList<DoctorBaseInfo>();
		DoctorBaseInfo doctorBaseInfo;
		InputStream inputStream = null;
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		while(rs.next()){
			doctorBaseInfo = new DoctorBaseInfo();
			doctorBaseInfo.setID(rs.getInt("ID"));
			doctorBaseInfo.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			doctorBaseInfo.setDoctorInfo_pwd(rs.getString("doctorInfo_pwd"));
			doctorBaseInfo.setDoctorInfo_name(rs.getString("doctorInfo_name"));
			doctorBaseInfo.setDoctorInfo_sex(rs.getInt("doctorInfo_sex"));
			doctorBaseInfo.setDoctorInfo_birthday(rs.getDate("doctorInfo_birthday"));
			doctorBaseInfo.setDoctorInfo_address(rs.getString("doctorInfo_address"));
			doctorBaseInfo.setDoctorInfo_record(rs.getString("doctorInfo_record"));
			doctorBaseInfo.setDoctorInfo_position(rs.getString("doctorInfo_position"));
			doctorBaseInfo.setDoctorInfo_phone(rs.getString("doctorInfo_phone"));
			doctorBaseInfo.setDoctorInfo_email(rs.getString("doctorInfo_email"));
			/*inputStream = rs.getBinaryStream("doctorInfo_photo");
			ImageUtil.readBlob(inputStream, realpath+"\\photo"+rs.getString("doctorInfo_ID")+".png");*/
			doctorBaseInfo.setDoctorInfo_photo(rs.getString("doctorInfo_photo"));
			doctorBaseInfo.setDoctorInfo_type(rs.getString("doctorInfo_type"));
			doctorBaseInfo.setDoctorInfo_disease(rs.getString("doctorInfo_disease"));
			doctorBaseInfo.setDoctorInfo_Oaddress(rs.getString("doctorInfo_Oaddress"));
			doctorBaseInfo.setState(rs.getString("state"));
			list.add(doctorBaseInfo);
		}
		pagination.setList(list);
		return pagination;
	}

	public Pagination showDoctorByName(String doctorInfo_name, String pageNum,
			int i) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int total = doctorDAO.getDoctorNumByName(doctorInfo_name);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorDAO.showDoctorsByName(doctorInfo_name,pagination.getStartRow(),i);
		List<DoctorBaseInfo> list = new ArrayList<DoctorBaseInfo>();
		DoctorBaseInfo doctorBaseInfo;
		InputStream inputStream = null;
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		while(rs.next()){
			doctorBaseInfo = new DoctorBaseInfo();
			doctorBaseInfo.setID(rs.getInt("ID"));
			doctorBaseInfo.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			doctorBaseInfo.setDoctorInfo_pwd(rs.getString("doctorInfo_pwd"));
			doctorBaseInfo.setDoctorInfo_name(rs.getString("doctorInfo_name"));
			doctorBaseInfo.setDoctorInfo_sex(rs.getInt("doctorInfo_sex"));
			doctorBaseInfo.setDoctorInfo_birthday(rs.getDate("doctorInfo_birthday"));
			doctorBaseInfo.setDoctorInfo_address(rs.getString("doctorInfo_address"));
			doctorBaseInfo.setDoctorInfo_record(rs.getString("doctorInfo_record"));
			doctorBaseInfo.setDoctorInfo_position(rs.getString("doctorInfo_position"));
			doctorBaseInfo.setDoctorInfo_phone(rs.getString("doctorInfo_phone"));
			doctorBaseInfo.setDoctorInfo_email(rs.getString("doctorInfo_email"));
			/*inputStream = rs.getBinaryStream("doctorInfo_photo");
			ImageUtil.readBlob(inputStream, realpath+"\\photo"+rs.getString("doctorInfo_ID")+".png");*/
			doctorBaseInfo.setDoctorInfo_photo(rs.getString("doctorInfo_photo"));
			doctorBaseInfo.setDoctorInfo_type(rs.getString("doctorInfo_type"));
			doctorBaseInfo.setDoctorInfo_disease(rs.getString("doctorInfo_disease"));
			doctorBaseInfo.setDoctorInfo_Oaddress(rs.getString("doctorInfo_Oaddress"));
			doctorBaseInfo.setState(rs.getString("state"));
			list.add(doctorBaseInfo);
		}
		pagination.setList(list);
		return pagination;
	}

	public Pagination showRegisteredByID(String  sqlBuffer, String registered_ID, String pageNum,
			int i) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int total = doctorDAO.getRegisteredByID(sqlBuffer,registered_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorDAO.showRegisteredByID(sqlBuffer,registered_ID,pagination.getStartRow(),i);
		list = new ArrayList<Registered>();
		while(rs.next()){
			registered = new Registered();
			registered.setID(rs.getInt("ID"));
			registered.setRegistered_ID(rs.getString("registered_ID"));
			registered.setRegistered_info(rs.getString("registered_info"));
			registered.setRegistered_state(rs.getInt("registered_state"));
			registered.setRegistered_time(rs.getDate("registered_time"));
			registered.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			registered.setPatient_ID(rs.getString("patient_ID"));
			registered.setDoctorVisit_ID(rs.getString("doctorVisit_ID"));
			list.add(registered);
		}
		pagination.setList(list);
		return pagination;
	}

	public DoctorBaseInfo findDoctorByID(String doctorInfo_ID) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		ResultSet b= doctorDAO.findDoctorByID(doctorInfo_ID);
		doctorBaseInfo = new DoctorBaseInfo();
		InputStream inputStream = null;
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		while(b.next()){
			doctorBaseInfo.setID(b.getInt("ID"));
			doctorBaseInfo.setDoctorInfo_ID(b.getString("doctorInfo_ID"));
			doctorBaseInfo.setDoctorInfo_pwd(b.getString("doctorInfo_pwd"));
			doctorBaseInfo.setDoctorInfo_name(b.getString("doctorInfo_name"));
			doctorBaseInfo.setDoctorInfo_sex(b.getInt("doctorInfo_sex"));
			doctorBaseInfo.setDoctorInfo_birthday(b.getDate("doctorInfo_birthday"));
			doctorBaseInfo.setDoctorInfo_address(b.getString("doctorInfo_address"));
			doctorBaseInfo.setDoctorInfo_record(b.getString("doctorInfo_record"));
			doctorBaseInfo.setDoctorInfo_position(b.getString("doctorInfo_position"));
			doctorBaseInfo.setDoctorInfo_phone(b.getString("doctorInfo_phone"));
			doctorBaseInfo.setDoctorInfo_email(b.getString("doctorInfo_email"));
			/*inputStream = b.getBinaryStream("doctorInfo_photo");
			ImageUtil.readBlob(inputStream, realpath+"\\photo"+b.getString("doctorInfo_ID")+".png");*/
			doctorBaseInfo.setDoctorInfo_photo(b.getString("doctorInfo_photo"));
			doctorBaseInfo.setDoctorInfo_type(b.getString("doctorInfo_type"));
			doctorBaseInfo.setDoctorInfo_disease(b.getString("doctorInfo_disease"));
			doctorBaseInfo.setDoctorInfo_Oaddress(b.getString("doctorInfo_Oaddress"));
			doctorBaseInfo.setState(b.getString("state"));
		}
		return doctorBaseInfo;
	}

	public int insertDoctor(DoctorBaseInfo doctorBaseInfo2) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int i = doctorDAO.insertDoctor(doctorBaseInfo2);
		return i;
	}

	public DoctorBaseInfo findDoctorByDocID(String hospital_ID,String doctorInfo_ID) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		ResultSet b = doctorDAO.findDoctorByDocID(hospital_ID,doctorInfo_ID);
		doctorBaseInfo = new DoctorBaseInfo();
		InputStream inputStream = null;
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		while(b.next()){
			doctorBaseInfo.setID(b.getInt("ID"));
			doctorBaseInfo.setDoctorInfo_ID(b.getString("doctorInfo_ID"));
			doctorBaseInfo.setDoctorInfo_pwd(b.getString("doctorInfo_pwd"));
			doctorBaseInfo.setDoctorInfo_name(b.getString("doctorInfo_name"));
			doctorBaseInfo.setDoctorInfo_sex(b.getInt("doctorInfo_sex"));
			doctorBaseInfo.setDoctorInfo_birthday(b.getDate("doctorInfo_birthday"));
			doctorBaseInfo.setDoctorInfo_address(b.getString("doctorInfo_address"));
			doctorBaseInfo.setDoctorInfo_record(b.getString("doctorInfo_record"));
			doctorBaseInfo.setDoctorInfo_position(b.getString("doctorInfo_position"));
			doctorBaseInfo.setDoctorInfo_phone(b.getString("doctorInfo_phone"));
			doctorBaseInfo.setDoctorInfo_email(b.getString("doctorInfo_email"));
			inputStream = b.getBinaryStream("doctorInfo_photo");
			ImageUtil.readBlob(inputStream, realpath+"\\photo"+b.getString("doctorInfo_ID")+".png");
			doctorBaseInfo.setDoctorInfo_photo("photo"+b.getString("doctorInfo_ID")+".png");
			doctorBaseInfo.setDoctorInfo_type(b.getString("doctorInfo_type"));
			doctorBaseInfo.setDoctorInfo_disease(b.getString("doctorInfo_disease"));
			doctorBaseInfo.setDoctorInfo_Oaddress(b.getString("doctorInfo_Oaddress"));
			doctorBaseInfo.setState(b.getString("state"));
		}
		return doctorBaseInfo;
	}

	public int updateBy(DoctorBaseInfo doctorBaseInfo2) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int i = doctorDAO.updateBy(doctorBaseInfo2);
		return i;
	}

	public Registered findRegByID(String registered_ID) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		ResultSet rs = doctorDAO.findRegByID(registered_ID);
		Registered registered = null ; 
		while(rs.next()){
			registered = new Registered();
			registered.setID(rs.getInt("ID"));
			registered.setRegistered_ID(rs.getString("registered_ID"));
			registered.setRegistered_info(rs.getString("registered_info"));
			registered.setRegistered_state(rs.getInt("registered_state"));
			registered.setRegistered_time(rs.getDate("registered_time"));
			registered.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			registered.setPatient_ID(rs.getString("patient_ID"));
			registered.setDoctorVisit_ID(rs.getString("doctorVisit_ID"));
		}
		return registered;
	}

	public int deleteDoctorinfo(String doctorInfo_ID) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int i = doctorDAO.deleteDoctorinfo(doctorInfo_ID);
		return i;
	}

	public int deleteRegistered(String doctorInfo_ID) throws Exception{
		doctorDAO = new DoctorDAOImpl();
		int i = doctorDAO.deleteRegistered(doctorInfo_ID);
		return i;
	}


}
