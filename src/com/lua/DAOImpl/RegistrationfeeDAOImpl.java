package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.RegistrationfeeDAO;
import com.lua.javautil.SqlUtil;
import com.lua.model.Registrationfee;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月6日 上午10:44:48
 * 类说明
 */
public class RegistrationfeeDAOImpl implements RegistrationfeeDAO {

	private Connection conn;
	private String sql ;
	
	@Override
	public int getRegistrationfeeByID(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(*) FROM registrationfee re  WHERE "
				+ "re.hospital_ID = ?");
		sql.append(sqlString);
		/*sql = "SELECT COUNT(*) FROM registrationfee  "
				+ "WHERE hospital_ID = (SELECT hospital_ID FROM departmentdeploy de "
				+ "WHERE de.doctorInfo_ID=?  LIMIT 0,1)";*/
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
	public ResultSet showRegistrationfeeByID(String sqlString,String hospital_ID,
			int startRow, int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM registrationfee re  WHERE "
				+ "re.hospital_ID = ?");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT * FROM registrationfee  WHERE hospital_ID = "
				+ "(SELECT hospital_ID FROM departmentdeploy de "
				+ "WHERE de.doctorInfo_ID=?  LIMIT 0,1)LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet findRegistrationFeeByID(String registrationfee_ID)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from registrationfee where registrationfee_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, registrationfee_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet getAllDoctorInfoType(String doctorInfo_ID)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM registrationfee  WHERE hospital_ID = (SELECT hospital_ID "
				+ "FROM departmentdeploy de WHERE de.doctorInfo_ID= ?  LIMIT 0,1)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int modifyRegistrationFeeAfter(Registrationfee registrationfee)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "update registrationfee set ID=?,registrationfee_ID=?,doctorInfo_type=?,"
				+ "registrationfee_fee=?,hospital_ID=?,doctorInfo_typeName=? where registrationfee_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, registrationfee.getID());
		pstmt.setString(2, registrationfee.getRegistrationfee_ID());
		pstmt.setInt(3, registrationfee.getDoctorInfo_type());
		pstmt.setFloat(4, registrationfee.getRegistrationfee_fee());
		pstmt.setString(5, registrationfee.getHospital_ID());
		pstmt.setString(6, registrationfee.getDoctorInfo_typeName());
		pstmt.setString(7, registrationfee.getRegistrationfee_ID());
		int i = pstmt.executeUpdate();
		return i;
	}

	@Override
	public int insertRegistrationFeeAfter(Registrationfee registrationfee)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "insert into registrationfee(registrationfee_ID,doctorInfo_type,"
				+ "registrationfee_fee,hospital_ID,doctorInfo_typeName) values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, registrationfee.getRegistrationfee_ID());
		pstmt.setInt(2, registrationfee.getDoctorInfo_type());
		pstmt.setFloat(3, registrationfee.getRegistrationfee_fee());
		pstmt.setString(4, registrationfee.getHospital_ID());
		pstmt.setString(5, registrationfee.getDoctorInfo_typeName());
		int i = pstmt.executeUpdate();
		return i;
	}

	@Override
	public String findHospitalByID(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT hospital_ID FROM departmentdeploy  WHERE doctorInfo_ID=?  LIMIT 0,1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		String hospital_ID = null ;
		while (rs.next()) {
			hospital_ID = rs.getString(1);
		}
		return hospital_ID;
	}

	@Override
	public ResultSet createType(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT MAX(doctorInfo_type) FROM registrationfee  "
				+ "WHERE hospital_ID = (SELECT hospital_ID FROM departmentdeploy "
				+ "de WHERE de.doctorInfo_ID=?  LIMIT 0,1)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet listRegistrationfees(String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT registrationfee.* FROM registrationfee WHERE registrationfee.hospital_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
		
	}

	@Override
	public ResultSet findByDocTypename(String hospital_ID, String search_id)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM registrationfee WHERE registrationfee.hospital_ID = ? "
				+ "AND registrationfee.doctorInfo_typeName = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hospital_ID);
		pstmt.setString(2, search_id);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}


}
