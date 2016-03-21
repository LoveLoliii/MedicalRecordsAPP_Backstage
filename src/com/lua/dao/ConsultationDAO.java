package com.lua.dao;

import java.sql.ResultSet;

import com.lua.model.Consultation;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月27日 下午3:30:09
 * 类说明
 */
public interface ConsultationDAO {

	public ResultSet showConsultationByID(String consultation_sendID,
			String consultation_getID)throws Exception;

	public ResultSet showAttentions(String consultation_sendID)throws Exception;

	public void insert(Consultation consultation)throws Exception;

	public int getConsultationByID(String sqlString,String hospital_ID) throws Exception;

	public ResultSet showConsultationByID(String sqlString,String hospital_ID, int startRow,
			int i)throws Exception;

	public int getConsultationElseElse(String sqlString)throws Exception;

	public ResultSet showConsultationElseElse(String sqlString, int startRow,
			int i) throws Exception;

}
