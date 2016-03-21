package com.lua.dao;

import java.sql.ResultSet;

import com.lua.model.DoctorBaseInfo;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年1月21日 下午3:09:04
 * 类说明
 */
public interface DoctorDAO {

	public ResultSet login(String doctorInfo_ID, String doctorInfo_pwd)throws Exception;

	public int update(DoctorBaseInfo doctorBaseInfo2) throws Exception ;

	public int getListNum(String sqlString,String doctorInfo_ID) throws Exception;

	public ResultSet showRegistered(String sqlString,String doctorInfo_ID, int startRow, int i) throws Exception;

	public int findById(String registered_ID) throws Exception;

	public void modifyRegistered(String registered_ID, int i) throws Exception;

	public int getMedicalListNum(String sqlString,String doctorInfo_ID) throws Exception;

	public ResultSet showMedical(String sqlString,String doctorInfo_ID, int startRow, int i) throws Exception;

	public int getAllDoctor(String sql,String hospital_ID)throws Exception;

	public ResultSet showAllDoctors(String sql,String hospital_ID, int startRow, int i)throws Exception;

	public int getAllRegisteredListNum(String sqlString,String hospital_ID)throws Exception;

	public ResultSet showAllRegistered(String sqlString,String hospital_ID, int startRow, int i)throws Exception;

	public int getAllMedicalListNum(String sqlString,String hospital_ID)throws Exception;

	public ResultSet showALlMedical(String sqlString,String hospital_ID, int startRow, int i)throws Exception;

	public int getDoctorNumByID(String doctorInfo_ID)throws Exception;

	public ResultSet showDoctorsByID(String doctorInfo_ID, int startRow, int i) throws Exception;

	public int getDoctorNumByName(String doctorInfo_name)throws Exception;

	public ResultSet showDoctorsByName(String doctorInfo_name, int startRow,
			int i) throws Exception;

	public int getRegisteredByID(String sqlBuffer,String registered_ID)throws Exception;

	public ResultSet showRegisteredByID(String sqlBuffer,String registered_ID, int startRow,
			int i) throws Exception;

	public ResultSet findDoctorByID(String doctorInfo_ID) throws Exception;

	public int insertDoctor(DoctorBaseInfo doctorBaseInfo2) throws Exception;

	public ResultSet findDoctorByDocID(String hospital_ID,String doctorInfo_ID) throws Exception;

	public int updateBy(DoctorBaseInfo doctorBaseInfo2) throws Exception;

	public ResultSet findRegByID(String registered_ID) throws Exception;

	public int deleteDoctorinfo(String doctorInfo_ID) throws Exception;

	public int deleteRegistered(String doctorInfo_ID) throws Exception;

}
