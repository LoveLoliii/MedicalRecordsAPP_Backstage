package com.lua.dao;

import java.sql.ResultSet;

import com.lua.model.Medical;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月26日 下午1:27:05
 * 类说明
 */
public interface MedicalDAO {

	public ResultSet findById(String medical_ID) throws Exception;

	public int modifyMedical(Medical medical) throws Exception;

	public int deleteMedical(String doctorInfo_ID) throws Exception;

}
