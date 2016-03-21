package com.lua.dao;

import java.sql.ResultSet;

import com.lua.model.DepartmentDeploy;
import com.lua.model.MainDepartment;
import com.lua.model.MinorDepartment;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月29日 下午8:08:08
 * 类说明
 */
public interface DepartmentDAO {

	public ResultSet showMaindepartment(String sqlString,String hospital_ID, int start,int i) throws Exception;

	public int getAllMaindepartment(String sqlString,String hospital_ID) throws Exception;

	public ResultSet findByID(String maindepartment_ID) throws Exception;

	public int modifyMainDepartmentAfter(MainDepartment maindepartment) throws Exception;

	public int insertMainDepartmentAfter(MainDepartment maindepartment)throws Exception;

	public int getAllMinordepartment()throws Exception;

	public ResultSet showMinordepartment(int startRowNew, int i)throws Exception;

	public int getAllMinordepartmentByID(String doctorInfo_ID,String maindepartment_ID)throws Exception;

	public ResultSet showMinordepartmentByID(String doctorInfo_ID,String maindepartment_ID,
			int startRowNew, int i)throws Exception;

	public ResultSet showMaindepartmentByID(String maindepartment_ID) throws Exception;

	public ResultSet findMinordepartmentByID(String minordepartment_ID)throws Exception;

	public ResultSet showMaindepartment() throws Exception;

	public int modifyMinorDepartmentAfter(MinorDepartment minordepartment)throws Exception;

	public int inserMinordepartment(MinorDepartment minordepartment) throws Exception;

	public int getAllDepartmentandDoc(String doctorInfo_ID) throws Exception;

	public ResultSet showDepartmentandDoc(String doctorInfo_ID, int startRow,
			int i) throws Exception;

	public int getDoctorBy(String hospital_ID,String minordepartment_ID)throws Exception;

	public ResultSet showDoctorByID(String hospital_ID,String minordepartment_ID, int startRowNew,
			int i) throws Exception;

	public ResultSet getAllMinordepartmentByDocID(String doctorInfo_ID)throws Exception;

	public ResultSet findByDocID(String doctorInfo_ID) throws Exception;

	public int update(DepartmentDeploy departmentDeploy) throws Exception;

	public ResultSet findMinorByID(String doctorInfo_ID) throws Exception;

	public int insertDepartmentDeploy(DepartmentDeploy departmentDeploy) throws Exception;

	public ResultSet findDepartmentByHosID(String hospital_ID) throws Exception;

	public ResultSet findDoctorByHosID(String hospital_ID) throws Exception;

	public int showALlMaindepartment() throws Exception;

	public ResultSet showALlMaindepartments(int startRow, int i) throws Exception;

	public ResultSet list(String doctorInfo_ID) throws Exception;

	public int deleteDepartment(String doctorInfo_ID) throws Exception;

}
