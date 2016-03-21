package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.DrugDAO;
import com.lua.javautil.SqlUtil;
import com.lua.model.Drug;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月8日 下午1:19:32
 * 类说明
 */
public class DrugDAOImpl implements DrugDAO {

	private Connection conn;
	private String sql;
	
	@Override
	public int getDrugByID(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) FROM drug,drugandhospital druga "
				+ "WHERE drug.drug_ID = druga.drug_ID AND druga.hospital_ID = ?");
		sql.append(sqlString);
		/*sql = "SELECT COUNT(*) FROM drug,drugandhospital druga "
				+ "WHERE drug.drug_ID = druga.drug_ID AND druga.hospital_ID = ?";*/
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
	public ResultSet showDrugByID(String sqlString,String hospital_ID, int startRow, int i)
			throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM drug,drugandhospital druga "
				+ "WHERE drug.drug_ID = druga.drug_ID AND druga.hospital_ID = ?");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT * FROM drug,drugandhospital druga "
				+ "WHERE drug.drug_ID = druga.drug_ID AND druga.hospital_ID = ? LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet modifyDrugBefore(String drug_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from drug where drug_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, drug_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int modifyDrugAfter(Drug drug) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "update drug set ID=?,drug_ID=?,drug_name=?,drug_num=?,"
				+ "drug_price=?,drug_time=?,drug_period=?,drug_produce_factory=?,drug_style=? where drug_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, drug.getID());
		pstmt.setString(2, drug.getDrug_ID());
		pstmt.setString(3, drug.getDrug_name());
		pstmt.setInt(4, drug.getDrug_num());
		pstmt.setFloat(5, drug.getDrug_price());
		pstmt.setDate(6, drug.getDrug_time());
		pstmt.setFloat(7, drug.getDrug_period());
		pstmt.setString(8, drug.getDrug_produce_factory());
		pstmt.setString(9, drug.getDrug_style());
		pstmt.setString(10, drug.getDrug_ID());
		int i = pstmt.executeUpdate();
		return i;
	}

	@Override
	public int insertDrugAfter(Drug drug) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "insert into drug(drug_ID,drug_name,drug_num,drug_price,drug_time,drug_period,drug_produce_factory,drug_style) values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, drug.getDrug_ID());
		pstmt.setString(2, drug.getDrug_name());
		pstmt.setInt(3, drug.getDrug_num());
		pstmt.setFloat(4, drug.getDrug_price());
		pstmt.setDate(5, drug.getDrug_time());
		pstmt.setFloat(6, drug.getDrug_period());
		pstmt.setString(7, drug.getDrug_produce_factory());
		pstmt.setString(8, drug.getDrug_style());
		int i =  pstmt.executeUpdate();
		return i;
	}

	@Override
	public int insertHos(String drug_ID, String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "insert into drugandhospital(drug_ID,hospital_ID) values(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, drug_ID);
		pstmt.setString(2, hospital_ID);
		int i = pstmt.executeUpdate();
		return i;
	}

}
