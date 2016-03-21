package com.lua.dao;

import java.sql.ResultSet;

import com.lua.model.Druguse;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月8日 下午6:21:48
 * 类说明
 */
public interface DrugUseDAO {

	public int getDrugUseByID(String sqlString,String hospital_ID) throws Exception;

	public ResultSet showDrugUseByID(String sqlString,String hospital_ID, int startRow, int i) throws Exception;

	public ResultSet modifyDrugUseBefore(String druguse_ID) throws Exception;

	public int modifyDrugUseAfter(Druguse druguse) throws Exception;

}
