package com.lua.dao;

import java.sql.ResultSet;

import com.lua.model.Drug;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月8日 下午1:19:12
 * 类说明
 */
public interface DrugDAO {

	public int getDrugByID(String sqlString,String hospital_ID) throws Exception;

	public ResultSet showDrugByID(String sqlString,String hospital_ID, int startRow, int i) throws Exception;

	public ResultSet modifyDrugBefore(String drug_ID) throws Exception;

	public int modifyDrugAfter(Drug drug) throws Exception;

	public int insertDrugAfter(Drug drug) throws Exception;

	public int insertHos(String drug_ID, String hospital_ID) throws Exception;

}
