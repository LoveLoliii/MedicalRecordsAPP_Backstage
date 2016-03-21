package com.lua.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lua.DAOImpl.PatientDAOImpl;
import com.lua.dao.PatientDAO;
import com.lua.javautil.Pagination;
import com.lua.model.PatientBaseInfo;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午1:09:33
 * 类说明
 */
public class PatientService {
	private PatientDAO patientDAO;
	private PatientBaseInfo patientBaseInfo;
	private List<PatientBaseInfo> list;
	
	public Pagination show(String sqlString,String doctorInfo_ID,String pageNum,int i) throws Exception {
		patientDAO = new PatientDAOImpl();
		int total = patientDAO.getListNum(sqlString,doctorInfo_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = patientDAO.show(sqlString,doctorInfo_ID,pagination.getStartRow(),i);
		list = new ArrayList<PatientBaseInfo>();
		while(rs.next()){
			patientBaseInfo = new PatientBaseInfo();
			patientBaseInfo.setID(rs.getInt("ID"));
			patientBaseInfo.setPatient_ID(rs.getString("patient_ID"));
			patientBaseInfo.setPatient_pwd(rs.getString("patient_pwd"));
			patientBaseInfo.setPatient_name(rs.getString("patient_name"));
			patientBaseInfo.setPatient_sex(rs.getInt("patient_sex"));
			patientBaseInfo.setPatient_birthday(rs.getDate("patient_birthday"));
			patientBaseInfo.setPatient_address(rs.getString("patient_address"));
			patientBaseInfo.setPatient_phone(rs.getString("patient_phone"));
			patientBaseInfo.setPatient_ID_card(rs.getString("patient_ID_card"));
			list.add(patientBaseInfo);
		}
		pagination.setList(list);
		return pagination;
	}

	public Pagination showAll(String sqlString,String hospital_ID,String pageNum, int i) throws Exception{
		patientDAO = new PatientDAOImpl();
		int total = patientDAO.getAllListNum(sqlString,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = patientDAO.showAll(sqlString,hospital_ID,pagination.getStartRow(),i);
		list = new ArrayList<PatientBaseInfo>();
		while(rs.next()){
			patientBaseInfo = new PatientBaseInfo();
			patientBaseInfo.setID(rs.getInt("ID"));
			patientBaseInfo.setPatient_ID(rs.getString("patient_ID"));
			patientBaseInfo.setPatient_pwd(rs.getString("patient_pwd"));
			patientBaseInfo.setPatient_name(rs.getString("patient_name"));
			patientBaseInfo.setPatient_sex(rs.getInt("patient_sex"));
			patientBaseInfo.setPatient_birthday(rs.getDate("patient_birthday"));
			patientBaseInfo.setPatient_address(rs.getString("patient_address"));
			patientBaseInfo.setPatient_phone(rs.getString("patient_phone"));
			patientBaseInfo.setPatient_ID_card(rs.getString("patient_ID_card"));
			list.add(patientBaseInfo);
		}
		pagination.setList(list);
		return pagination;
	}

	public PatientBaseInfo findPatientByID(String patient_ID) throws Exception{
		patientDAO = new PatientDAOImpl();
		ResultSet rs = patientDAO.findPatientByID(patient_ID);
		PatientBaseInfo patientBaseInfo = new PatientBaseInfo();
		while(rs.next()){
			patientBaseInfo.setID(rs.getInt("ID"));
			patientBaseInfo.setPatient_ID(rs.getString("patient_ID"));
			patientBaseInfo.setPatient_pwd(rs.getString("patient_pwd"));
			patientBaseInfo.setPatient_name(rs.getString("patient_name"));
			patientBaseInfo.setPatient_sex(rs.getInt("patient_sex"));
			patientBaseInfo.setPatient_birthday(rs.getDate("patient_birthday"));
			patientBaseInfo.setPatient_address(rs.getString("patient_address"));
			patientBaseInfo.setPatient_phone(rs.getString("patient_phone"));
			patientBaseInfo.setPatient_ID_card(rs.getString("patient_ID_card"));
		}
		return patientBaseInfo;
	}

}
