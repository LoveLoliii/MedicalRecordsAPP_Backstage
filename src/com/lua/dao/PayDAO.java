package com.lua.dao;

import java.sql.ResultSet;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月9日 下午1:29:11
 * 类说明
 */
public interface PayDAO {

	public int getPayByID(String sqlString,String hospital_ID) throws Exception;

	public ResultSet showPayByID(String sqlString,String hospital_ID, int startRow, int i) throws Exception;

}
