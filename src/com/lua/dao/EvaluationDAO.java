package com.lua.dao;

import java.sql.ResultSet;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月9日 下午2:42:14
 * 类说明
 */
public interface EvaluationDAO {

	public int getEvaluationByID(String sqlString,String hospital_ID) throws Exception;

	public ResultSet showEvaluationByID(String sqlString,String hospital_ID, int startRow, int i) throws Exception;

	public int getEvaluationByIDGood(String sqlString,String hospital_ID,int i)throws Exception;

	public ResultSet showEvaluationByIDGood(String sqlString,String hospital_ID, int startRow,
			int i, int j) throws Exception;

	public int deleteEvaluation(String doctorInfo_ID) throws Exception;

}
