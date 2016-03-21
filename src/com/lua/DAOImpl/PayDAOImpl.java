package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.PayDAO;
import com.lua.javautil.SqlUtil;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月9日 下午1:29:58
 * 类说明
 */
public class PayDAOImpl implements PayDAO {

	private Connection conn;
	private String sql;
	
	@Override
	public int getPayByID(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) FROM pay,druguse,drugandhospital WHERE pay.druguse_ID=druguse.druguse_ID "
				+ "AND druguse.drug_ID=drugandhospital.drug_ID AND drugandhospital.hospital_ID=?");
		sql.append(sqlString);
		/*sql = "SELECT COUNT(*) FROM pay,druguse,drugandhospital WHERE pay.druguse_ID=druguse.druguse_ID "
				+ "AND druguse.drug_ID=drugandhospital.drug_ID AND drugandhospital.hospital_ID=?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		int i= 0;
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showPayByID(String sqlString,String hospital_ID, int startRow, int i)
			throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM pay,druguse,drugandhospital WHERE pay.druguse_ID=druguse.druguse_ID "
				+ "AND druguse.drug_ID=drugandhospital.drug_ID AND drugandhospital.hospital_ID=?");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT * FROM pay,druguse,drugandhospital WHERE pay.druguse_ID=druguse.druguse_ID "
				+ "AND druguse.drug_ID=drugandhospital.drug_ID AND drugandhospital.hospital_ID=? LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

}
