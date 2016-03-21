package com.lua.dao;

import java.sql.ResultSet;

import com.lua.model.DoctorVisit;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月28日 下午3:55:50
 * 类说明
 */
public interface DoctorVisitDAO {

	public int getAllDoctorVisits(String sql,String hospital_ID)throws Exception;

	public ResultSet showAllDoctorVisits(String sql,String hospital_ID, int startRow, int i)throws Exception;

	public int getDoctorVisitByID(String sqlString,String doctorInfo_ID) throws Exception;

	public ResultSet showDoctorVisitByID(String sqlString,String doctorInfo_ID, int startRow,
			int i) throws Exception;

	public ResultSet findByID(String doctorVisit_ID)throws Exception;

	public int modifyDoctorVisit(DoctorVisit doctorVisit) throws Exception;

	public int deleteDoctVisit(String doctorInfo_ID) throws Exception;

}
