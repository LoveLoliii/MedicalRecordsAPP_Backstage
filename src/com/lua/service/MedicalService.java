package com.lua.service;

import java.sql.ResultSet;

import com.lua.DAOImpl.MedicalDAOImpl;
import com.lua.dao.MedicalDAO;
import com.lua.model.Medical;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月26日 下午1:26:53
 * 类说明
 */
public class MedicalService {

	private MedicalDAO medicalDAO;
	
	public Medical findById(String medical_ID) throws Exception{
		medicalDAO = new MedicalDAOImpl();
		ResultSet rs = medicalDAO.findById(medical_ID);
		Medical medical = new Medical();
		while(rs.next()){
			medical.setID(rs.getInt("ID"));
			medical.setMedical_ID(rs.getString("medical_ID"));
			medical.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			medical.setPatient_ID(rs.getString("patient_ID"));
			medical.setRegistered_ID(rs.getString("registered_ID"));
			medical.setMedical_msg(rs.getString("medical_msg"));
			medical.setMedical_result(rs.getString("medical_result"));
			medical.setMedical_time(rs.getDate("medical_time"));
			medical.setMedical_state(rs.getInt("medical_state"));
		}
		return medical;
		
		
	}

	public int modifyMedical(Medical medical) throws Exception {
		medicalDAO = new MedicalDAOImpl();
		int i = medicalDAO.modifyMedical(medical);
		return i ;
	}

	public int deleteMedical(String doctorInfo_ID) throws Exception{
		medicalDAO = new MedicalDAOImpl();
		int i =  medicalDAO.deleteMedical(doctorInfo_ID);
		return i;
	}

}
