package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.DoctorVisitDAO;
import com.lua.javautil.SqlUtil;
import com.lua.model.DoctorVisit;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月28日 下午3:56:08
 * 类说明
 */
public class DoctorVisitDAOImpl implements DoctorVisitDAO {

	
	private Connection conn;
	private String sql;
	@Override
	public int getAllDoctorVisits(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT count(*) FROM departmentdeploy,doctorvisit,doctorinfo WHERE "
				+ "doctorvisit.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND  "
				+ "departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND "
				+ "departmentdeploy.hospital_ID=?");
		sql.append(sqlString);
		/*sql = "SELECT count(*) FROM departmentdeploy,doctorvisit,doctorinfo WHERE "
				+ "doctorvisit.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND  "
				+ "departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND "
				+ "departmentdeploy.hospital_ID=?";*/
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
	public ResultSet showAllDoctorVisits(String sqlString,String hospital_ID,int startRow, int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT doctorvisit.* FROM departmentdeploy,doctorvisit,doctorinfo WHERE "
				+ "doctorvisit.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND  "
				+ "departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND "
				+ "departmentdeploy.hospital_ID=? ");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
	/*	sql = "SELECT doctorvisit.* FROM departmentdeploy,doctorvisit,doctorinfo WHERE "
				+ "doctorvisit.doctorInfo_ID=departmentdeploy.doctorInfo_ID AND  "
				+ "departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND "
				+ "departmentdeploy.hospital_ID=? LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int getDoctorVisitByID(String sqlString,String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from doctorvisit where doctorInfo_ID = ?");
		sql.append(sqlString);
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}
	@Override
	public ResultSet showDoctorVisitByID(String sqlString,String doctorInfo_ID, int startRow,
			int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from doctorvisit where doctorInfo_ID = ?");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, doctorInfo_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public ResultSet findByID(String doctorVisit_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from doctorvisit where doctorVisit_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorVisit_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int modifyDoctorVisit(DoctorVisit doctorVisit) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "update doctorvisit set ID=?,doctorVisit_ID=?,doctorVisit_timeType=?,doctorVisit_date=?,doctorVisit_regNunber=?"
				+ ",doctorVisit_feedback=?,doctorVisit_confirmState=?,doctorVisit_state=?,doctorInfo_ID=? where doctorVisit_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, doctorVisit.getID());
		pstmt.setString(2, doctorVisit.getDoctorVisit_ID());
		pstmt.setString(3, doctorVisit.getDoctorVisit_timeType());
		pstmt.setDate(4, doctorVisit.getDoctorVisit_date());
		pstmt.setInt(5, doctorVisit.getDoctorVisit_regNunber());
		pstmt.setString(6, doctorVisit.getDoctorVisit_feedback());
		pstmt.setInt(7, doctorVisit.getDoctorVisit_confirmState());
		pstmt.setInt(8, doctorVisit.getDoctorVisit_state());
		pstmt.setString(9, doctorVisit.getDoctorInfo_ID());
		pstmt.setString(10, doctorVisit.getDoctorVisit_ID());
		int i = pstmt.executeUpdate();
		return i;
	}
	@Override
	public int deleteDoctVisit(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "DELETE FROM doctorvisit WHERE doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		int i = pstmt.executeUpdate();
		return i;
	}

}
