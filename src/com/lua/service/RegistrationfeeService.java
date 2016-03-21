package com.lua.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lua.DAOImpl.RegistrationfeeDAOImpl;
import com.lua.dao.RegistrationfeeDAO;
import com.lua.javautil.Pagination;
import com.lua.model.Registered;
import com.lua.model.Registrationfee;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月6日 上午10:44:22
 * 类说明
 */
public class RegistrationfeeService {

	private RegistrationfeeDAO registrationfeeDAO;
	public Pagination showRegistrationfee(String sql,String hospital_ID, String pageNum,
			int i)  throws Exception{
		registrationfeeDAO = new RegistrationfeeDAOImpl();
		int total = registrationfeeDAO.getRegistrationfeeByID(sql,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = registrationfeeDAO.showRegistrationfeeByID(sql,hospital_ID,pagination.getStartRow(),i);
		List<Registrationfee>list = new ArrayList<Registrationfee>();
		Registrationfee registrationfee;
		while(rs.next()){
			registrationfee = new Registrationfee();
			registrationfee.setID(rs.getInt("ID"));
			registrationfee.setRegistrationfee_ID(rs.getString("registrationfee_ID"));
			registrationfee.setDoctorInfo_type(rs.getInt("doctorInfo_type"));
			registrationfee.setRegistrationfee_fee(rs.getFloat("registrationfee_fee"));
			registrationfee.setHospital_ID(rs.getString("hospital_ID"));
			registrationfee.setDoctorInfo_typeName(rs.getString("doctorInfo_typeName"));
			list.add(registrationfee);
		}
		pagination.setList(list);
		return pagination;
	}
	public Registrationfee findRegistrationFeeByID(String registrationfee_ID)  throws Exception{
		registrationfeeDAO = new RegistrationfeeDAOImpl();
		ResultSet rs = registrationfeeDAO.findRegistrationFeeByID(registrationfee_ID);
		Registrationfee registrationfee = new Registrationfee();
		while (rs.next()) {
			registrationfee.setID(rs.getInt("ID"));
			registrationfee.setRegistrationfee_ID(rs.getString("registrationfee_ID"));
			registrationfee.setDoctorInfo_type(rs.getInt("doctorInfo_type"));
			registrationfee.setRegistrationfee_fee(rs.getFloat("registrationfee_fee"));
			registrationfee.setHospital_ID(rs.getString("hospital_ID"));
			registrationfee.setDoctorInfo_typeName(rs.getString("doctorInfo_typeName"));
		}
		return registrationfee;
	}
	public List<Registrationfee> getAllDoctorInfoType(String doctorInfo_ID) throws Exception{
		registrationfeeDAO = new RegistrationfeeDAOImpl();
		ResultSet rs = registrationfeeDAO.getAllDoctorInfoType(doctorInfo_ID);
		List<Registrationfee> list = new ArrayList<Registrationfee>();
		Registrationfee registrationfee;
		while(rs.next()){
			registrationfee = new Registrationfee();
			registrationfee.setID(rs.getInt("ID"));
			registrationfee.setRegistrationfee_ID(rs.getString("registrationfee_ID"));
			registrationfee.setDoctorInfo_type(rs.getInt("doctorInfo_type"));
			registrationfee.setRegistrationfee_fee(rs.getFloat("registrationfee_fee"));
			registrationfee.setHospital_ID(rs.getString("hospital_ID"));
			registrationfee.setDoctorInfo_typeName(rs.getString("doctorInfo_typeName"));
			list.add(registrationfee);
		}
		return list;
	}
	public int modifyRegistrationFeeAfter(Registrationfee registrationfee) throws Exception{
		registrationfeeDAO = new RegistrationfeeDAOImpl();
		int i = registrationfeeDAO.modifyRegistrationFeeAfter(registrationfee);
		return i;
	}
	public int insertRegistrationFeeAfter(Registrationfee registrationfee) throws Exception{
		registrationfeeDAO = new RegistrationfeeDAOImpl();
		int i = registrationfeeDAO.insertRegistrationFeeAfter(registrationfee);
		return i;
	}
	public String findHospitalByID(String doctorInfo_ID) throws Exception{
		registrationfeeDAO = new RegistrationfeeDAOImpl();
		String hospital_ID = registrationfeeDAO.findHospitalByID(doctorInfo_ID);
		return hospital_ID;
	}
	public int createType(String doctorInfo_ID) throws Exception{
		registrationfeeDAO = new RegistrationfeeDAOImpl();
		ResultSet rs = registrationfeeDAO.createType(doctorInfo_ID);
		int max = 0;
		while (rs.next()) {
			max = rs.getInt(1);
		}
		return max;
	}
	public List<Registrationfee> listRegistrationfees(String hospital_ID) throws Exception{
		registrationfeeDAO = new RegistrationfeeDAOImpl();
		ResultSet rs = registrationfeeDAO.listRegistrationfees(hospital_ID);
		List<Registrationfee> list = new ArrayList<Registrationfee>();
		Registrationfee registrationfee;
		while(rs.next()){
			registrationfee = new Registrationfee();
			registrationfee.setID(rs.getInt("ID"));
			registrationfee.setRegistrationfee_ID(rs.getString("registrationfee_ID"));
			registrationfee.setDoctorInfo_type(rs.getInt("doctorInfo_type"));
			registrationfee.setRegistrationfee_fee(rs.getFloat("registrationfee_fee"));
			registrationfee.setHospital_ID(rs.getString("hospital_ID"));
			registrationfee.setDoctorInfo_typeName(rs.getString("doctorInfo_typeName"));
			list.add(registrationfee);
		}
		return list;
	}
	public String findByDocTypename(String hospital_ID, String search_id) throws Exception{
		registrationfeeDAO = new RegistrationfeeDAOImpl();
		ResultSet rs = registrationfeeDAO.findByDocTypename(hospital_ID,search_id);
		String nameString = null ;
		while (rs.next()) {
			nameString = rs.getString("doctorInfo_type");
		}
		return nameString;
	}

}
