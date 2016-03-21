package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.EvaluationDAO;
import com.lua.javautil.SqlUtil;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月9日 下午2:43:06
 * 类说明
 */
public class EvaluationDAOImpl implements EvaluationDAO {

	private Connection conn;
	private String sql;
	@Override
	public int getEvaluationByID(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM evaluation,departmentdeploy WHERE "
				+ "evaluation.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND departmentdeploy.hospital_ID=?");
		sql.append(sqlString);
		/*sql = "SELECT count(*) FROM evaluation,departmentdeploy WHERE "
				+ "evaluation.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND departmentdeploy.hospital_ID=?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}
	@Override
	public ResultSet showEvaluationByID(String sqlString,String hospital_ID, int startRow, int i)
			throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM evaluation,departmentdeploy WHERE "
				+ "evaluation.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND departmentdeploy.hospital_ID=?");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT * FROM evaluation,departmentdeploy WHERE "
				+ "evaluation.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND departmentdeploy.hospital_ID=? LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int getEvaluationByIDGood(String sqlString,String hospital_ID,int j) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM evaluation,departmentdeploy WHERE "
				+ "evaluation.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND "
				+ "departmentdeploy.hospital_ID=? and evaluation.evaluation_state=? ");
		sql.append(sqlString);
		/*sql = "SELECT count(*) FROM evaluation,departmentdeploy WHERE "
				+ "evaluation.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND departmentdeploy.hospital_ID=? and evaluation.evaluation_state=?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, j);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}
	@Override
	public ResultSet showEvaluationByIDGood(String sqlString,String hospital_ID, int startRow,
			int i, int j) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM evaluation,departmentdeploy WHERE "
				+ "evaluation.doctorInfo_ID=departmentdeploy.doctorInfo_ID "
				+ "AND departmentdeploy.hospital_ID=? and evaluation.evaluation_state=? ");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT * FROM evaluation,departmentdeploy WHERE "
				+ "evaluation.doctorInfo_ID=departmentdeploy.doctorInfo_ID "
				+ "AND departmentdeploy.hospital_ID=? and evaluation.evaluation_state=? LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, j);
		pstmt.setInt(3, startRow);
		pstmt.setInt(4, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int deleteEvaluation(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "DELETE FROM evaluation WHERE doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		int i = pstmt.executeUpdate();
		return i;
	}

}
