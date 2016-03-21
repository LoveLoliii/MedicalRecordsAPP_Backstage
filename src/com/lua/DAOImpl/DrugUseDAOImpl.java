package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.DrugUseDAO;
import com.lua.javautil.SqlUtil;
import com.lua.model.Druguse;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月8日 下午6:22:12
 * 类说明
 */
public class DrugUseDAOImpl implements DrugUseDAO{

	private Connection conn;
	private String sql;
	
	@Override
	public int getDrugUseByID(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM druguse,medical,departmentdeploy "
				+ "WHERE druguse.medical_ID = medical.medical_ID AND departmentdeploy.doctorInfo_ID = "
				+ "medical.doctorInfo_ID AND departmentdeploy.hospital_ID = ?");
		sql.append(sqlString);
		/*sql = "SELECT count(*) FROM druguse,medical,departmentdeploy "
				+ "WHERE druguse.medical_ID = medical.medical_ID AND departmentdeploy.doctorInfo_ID = "
				+ "medical.doctorInfo_ID AND departmentdeploy.hospital_ID = ?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		int i=0;
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showDrugUseByID(String sqlString,String hospital_ID, int startRow, int i)
			throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT druguse.* FROM druguse,medical,departmentdeploy "
				+ "WHERE druguse.medical_ID = medical.medical_ID AND departmentdeploy.doctorInfo_ID = "
				+ "medical.doctorInfo_ID AND departmentdeploy.hospital_ID = ? ");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT druguse.* FROM druguse,medical,departmentdeploy "
				+ "WHERE druguse.medical_ID = medical.medical_ID AND departmentdeploy.doctorInfo_ID = "
				+ "medical.doctorInfo_ID AND departmentdeploy.hospital_ID = ? LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet modifyDrugUseBefore(String druguse_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from druguse where druguse_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, druguse_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int modifyDrugUseAfter(Druguse druguse) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "UPDATE druguse SET ID=?,druguse_ID=?,"
				+ "medical_ID=?,drug_ID=?,druguse_num=?,druguse_time=? WHERE druguse_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, druguse.getID());
		pstmt.setString(2, druguse.getDruguse_ID());
		pstmt.setString(3, druguse.getMedical_ID());
		pstmt.setString(4, druguse.getDrug_ID());
		pstmt.setInt(5, druguse.getDruguse_num());
		pstmt.setDate(6, druguse.getDruguse_time());
		pstmt.setString(7, druguse.getDruguse_ID());
		int i = pstmt.executeUpdate();
		return i;
	}

}
