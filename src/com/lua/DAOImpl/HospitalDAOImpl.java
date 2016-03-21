package com.lua.DAOImpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.HospitalDAO;
import com.lua.javautil.ImageUtil;
import com.lua.javautil.SqlUtil;
import com.lua.model.Hospital;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月5日 下午1:05:10
 * 类说明
 */
public class HospitalDAOImpl implements HospitalDAO {

	private Connection conn;
	private String sql;
	
	@Override
	public ResultSet hospitalbaseinfoShow(String baseinfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM hospital ho,departmentdeploy de "
				+ "WHERE ho.hospital_ID = de.hospital_ID AND de.doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, baseinfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet findHospitalByID(String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from hospital where hospital_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int modifyHospitalAfter(Hospital hospital) throws Exception {
		conn = SqlUtil.getConnection();
		InputStream inputStream = null;
        inputStream = ImageUtil.getImageByte(hospital.getHospital_photo());
		sql = "update hospital set ID=?,hospital_ID=?,"
				+ "hospital_name=?,hospital_address=?,hospital_info=?,"
				+ "hospital_phone=?,hospital_webSite=?,hospital_state=?,hospital_photo=? where hospital_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, hospital.getID());
		pstmt.setString(2, hospital.getHospital_ID());
		pstmt.setString(3, hospital.getHospital_name());
		pstmt.setString(4, hospital.getHospital_address());
		pstmt.setString(5, hospital.getHospital_info());
		pstmt.setString(6, hospital.getHospital_phone());
		pstmt.setString(7, hospital.getHospital_webSite());
		pstmt.setInt(8, hospital.getHospital_state());
		pstmt.setBinaryStream(9, inputStream,inputStream.available());
		pstmt.setString(10, hospital.getHospital_ID());
		int i = pstmt.executeUpdate();
		return i;
	}

}
