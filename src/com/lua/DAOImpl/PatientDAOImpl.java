package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lua.dao.PatientDAO;
import com.lua.javautil.SqlUtil;
import com.lua.model.PatientBaseInfo;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月24日 下午1:13:15
 * 类说明
 */
public class PatientDAOImpl implements PatientDAO{

	private Connection conn;
	private String sql;
	
	@Override
	public ResultSet show(String sqlString,String doctorInfo_ID,int startRow,int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT patient.* FROM patient,registered WHERE (patient.patient_ID = registered.patient_ID "
				+ "AND registered.doctorInfo_ID=?)");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT patient.* FROM patient,registered WHERE (patient.patient_ID = registered.patient_ID "
				+ "AND registered.doctorInfo_ID=?) LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, doctorInfo_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
		
	}

	@Override
	public int getListNum(String sqlString,String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) FROM patient,registered WHERE (patient.patient_ID = registered.patient_ID "
				+ "AND registered.doctorInfo_ID=?) ");
		sql.append(sqlString);
		/*sql = "SELECT COUNT(*) FROM patient,registered WHERE (patient.patient_ID = registered.patient_ID "
				+ "AND registered.doctorInfo_ID=?)";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0 ;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public int getAllListNum(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM registered,patient WHERE patient.patient_ID = registered.patient_ID "
				+ "AND registered.doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
				+ "departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND "
				+ "departmentdeploy.hospital_ID=?) ");
		sql.append(sqlString);
		/*sql = "SELECT count(*) FROM registered,patient WHERE patient.patient_ID = registered.patient_ID "
				+ "AND registered.doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
				+ "departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND "
				+ "departmentdeploy.hospital_ID=?)";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0 ;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showAll(String sqlString,String hospital_ID,int startRow, int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT patient.* FROM registered,patient WHERE patient.patient_ID = registered.patient_ID"
				+ " AND registered.doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
				+ "departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID "
				+ "AND doctorinfo.state=1 AND departmentdeploy.hospital_ID=?)");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT patient.* FROM registered,patient WHERE patient.patient_ID = registered.patient_ID"
				+ " AND registered.doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
				+ "departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID "
				+ "AND doctorinfo.state=1 AND departmentdeploy.hospital_ID=?) LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet findPatientByID(String patient_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM patient WHERE patient.patient_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, patient_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

}
