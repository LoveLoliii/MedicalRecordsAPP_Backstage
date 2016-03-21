package com.lua.dao;

import java.sql.ResultSet;

import com.lua.model.Hospital;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月5日 下午1:04:44
 * 类说明
 */
public interface HospitalDAO {

	ResultSet hospitalbaseinfoShow(String baseinfo_ID) throws Exception;

	ResultSet findHospitalByID(String hospital_ID) throws Exception;

	int modifyHospitalAfter(Hospital hospital) throws Exception;

}
