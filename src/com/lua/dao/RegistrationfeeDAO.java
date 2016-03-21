package com.lua.dao;

import java.sql.ResultSet;

import com.lua.model.Registrationfee;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月6日 上午10:44:31
 * 类说明
 */
public interface RegistrationfeeDAO {

	public int getRegistrationfeeByID(String sqlString,String hospital_ID) throws Exception;

	public ResultSet showRegistrationfeeByID(String sqlString,String hospital_ID,
			int startRow, int i) throws Exception;

	public ResultSet findRegistrationFeeByID(String registrationfee_ID) throws Exception;

	public ResultSet getAllDoctorInfoType(String doctorInfo_ID) throws Exception;

	public int modifyRegistrationFeeAfter(Registrationfee registrationfee) throws Exception;

	public int insertRegistrationFeeAfter(Registrationfee registrationfee) throws Exception;

	public String findHospitalByID(String doctorInfo_ID) throws Exception;

	public ResultSet createType(String doctorInfo_ID) throws Exception;

	public ResultSet listRegistrationfees(String hospital_ID)throws Exception;

	public ResultSet findByDocTypename(String hospital_ID, String search_id)throws Exception;


}
