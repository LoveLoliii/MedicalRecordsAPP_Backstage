package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.MedicalDAO;
import com.lua.javautil.SqlUtil;
import com.lua.model.Medical;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月26日 下午1:27:20
 * 类说明
 */
public class MedicalDAOImpl implements MedicalDAO{

	private Connection conn;
	private String sql;
	@Override
	public ResultSet findById(String medical_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from medical where medical_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, medical_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int modifyMedical(Medical medical) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "update medical set ID = ?,medical_ID=?,patient_ID=?,doctorInfo_ID=?,registered_ID=?,medical_msg=?,medical_result=?,medical_time=?,medical_state=? where medical_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, medical.getID());
		pstmt.setString(2, medical.getMedical_ID());
		pstmt.setString(3, medical.getPatient_ID());
		pstmt.setString(4, medical.getDoctorInfo_ID());
		pstmt.setString(5, medical.getRegistered_ID());
		pstmt.setString(6, medical.getMedical_msg());
		pstmt.setString(7, medical.getMedical_result());
		pstmt.setDate(8, medical.getMedical_time());
		pstmt.setInt(9, medical.getMedical_state());
		pstmt.setString(10, medical.getMedical_ID());
		int i = pstmt.executeUpdate();
		return i;
	}
	@Override
	public int deleteMedical(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "DELETE FROM medical WHERE doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		int i = pstmt.executeUpdate();
		return i;
	}

}
