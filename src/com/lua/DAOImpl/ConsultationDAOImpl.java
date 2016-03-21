package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.ConsultationDAO;
import com.lua.javautil.SqlUtil;
import com.lua.model.Consultation;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月27日 下午3:30:38
 * 类说明
 */
public class ConsultationDAOImpl implements ConsultationDAO {
	private Connection conn;
	private String sql; 
	@Override
	public ResultSet showConsultationByID(String consultation_sendID,
			String consultation_getID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM consultation "
				+ "WHERE (consultation_sendID = ? AND consultation_getID = ?)"
				+ "OR(consultation_sendID = ? AND consultation_getID = ?) "
				+ "ORDER BY consultation_time ASC ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, consultation_sendID);
		pstmt.setString(2, consultation_getID);
		pstmt.setString(3, consultation_getID);
		pstmt.setString(4, consultation_sendID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public ResultSet showAttentions(String consultation_sendID)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM attention where doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, consultation_sendID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public void insert(Consultation consultation) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "insert into consultation (consultation_ID,consultation_sendID,"
				+ "consultation_getID,consultation_msg,consultation_time) values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, consultation.getConsultation_ID());
		pstmt.setString(2, consultation.getConsultation_sendID());
		pstmt.setString(3, consultation.getConsultation_getID());
		pstmt.setString(4, consultation.getConsultation_msg());
		pstmt.setTimestamp(5, consultation.getConsultation_time());
		pstmt.executeUpdate();
	}
	@Override
	public int getConsultationByID(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM consultation con WHERE ");
		sql.append(sqlString);
		sql.append(" con.consultation_sendID IN "
				+ "(SELECT doctorinfo.doctorInfo_ID FROM departmentdeploy,doctorinfo WHERE "
				+ "departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 "
				+ "AND departmentdeploy.hospital_ID=?) OR con.consultation_getID IN "
				+ "(SELECT doctorinfo.doctorInfo_ID FROM departmentdeploy,doctorinfo WHERE "
				+ "departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 "
				+ "AND departmentdeploy.hospital_ID=?)");
		/*sql = "SELECT count(*) FROM consultation con WHERE con.consultation_sendID IN "
				+ "(SELECT doctorinfo.doctorInfo_ID FROM departmentdeploy,doctorinfo WHERE "
				+ "departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 "
				+ "AND departmentdeploy.hospital_ID=?) OR con.consultation_getID IN "
				+ "(SELECT doctorinfo.doctorInfo_ID FROM departmentdeploy,doctorinfo WHERE "
				+ "departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 "
				+ "AND departmentdeploy.hospital_ID=?)";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setString(2, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}
	@Override
	public ResultSet showConsultationByID(String sqlString,String hospital_ID, int startRow,
			int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM consultation con WHERE ");
		sql.append(sqlString);
		sql.append(" con.consultation_sendID IN (SELECT doctorinfo.doctorInfo_ID "
				+ "FROM departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND departmentdeploy.hospital_ID=?) "
				+ "OR con.consultation_getID IN (SELECT doctorinfo.doctorInfo_ID FROM departmentdeploy,doctorinfo "
				+ "WHERE departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 "
				+ "AND departmentdeploy.hospital_ID=?) ");
		sql.append(" limit ?,?");
		/*sql = "SELECT * FROM consultation con WHERE con.consultation_sendID IN (SELECT doctorinfo.doctorInfo_ID "
				+ "FROM departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND departmentdeploy.hospital_ID=?) "
				+ "OR con.consultation_getID IN (SELECT doctorinfo.doctorInfo_ID FROM departmentdeploy,doctorinfo "
				+ "WHERE departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND doctorinfo.state=1 "
				+ "AND departmentdeploy.hospital_ID=?) limit ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setString(2, hospital_ID);
		pstmt.setInt(3, startRow);
		pstmt.setInt(4, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int getConsultationElseElse(String sqlString) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) FROM consultation con WHERE ");
		sql.append(sqlString);
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}
	@Override
	public ResultSet showConsultationElseElse(String sqlString, int startRow,
			int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM consultation con WHERE ");
		sql.append(sqlString);
		sql.append(" limit ?,?");
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

}
