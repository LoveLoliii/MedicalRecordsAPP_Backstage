package com.lua.DAOImpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lua.dao.DoctorDAO;
import com.lua.javautil.ImageUtil;
import com.lua.javautil.SqlUtil;
import com.lua.model.DoctorBaseInfo;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年1月21日 下午3:09:41
 * 类说明
 */
public class DoctorDAOImpl implements DoctorDAO{
	private Connection conn;
	private String sql;
	
	@Override
	public ResultSet login(String doctorInfo_ID, String doctorInfo_pwd) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from doctorinfo where doctorInfo_ID = ? and doctorInfo_pwd = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		pstmt.setString(2, doctorInfo_pwd);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int update(DoctorBaseInfo doctorBaseInfo2) throws Exception {
		conn = SqlUtil.getConnection();
		InputStream inputStream = null;
        inputStream = ImageUtil.getImageByte(doctorBaseInfo2.getDoctorInfo_photo());
		sql = "update doctorinfo set ID = ?,doctorInfo_ID=?,doctorInfo_pwd=?,doctorInfo_name=?,"
				+ "doctorInfo_sex=?,doctorInfo_birthday=?,doctorInfo_address=?,doctorInfo_record=?,"
				+ "doctorInfo_position=?,doctorInfo_phone=?,doctorInfo_email=?,doctorInfo_photo=?,"
				+ "doctorInfo_type=?,doctorInfo_disease=?,doctorInfo_Oaddress=?,state=? where doctorInfo_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, doctorBaseInfo2.getID());
		pstmt.setString(2, doctorBaseInfo2.getDoctorInfo_ID());
		pstmt.setString(3, doctorBaseInfo2.getDoctorInfo_pwd());
		pstmt.setString(4, doctorBaseInfo2.getDoctorInfo_name());
		pstmt.setInt(5, doctorBaseInfo2.getDoctorInfo_sex());
		pstmt.setDate(6, doctorBaseInfo2.getDoctorInfo_birthday());
		pstmt.setString(7, doctorBaseInfo2.getDoctorInfo_address());
		pstmt.setString(8, doctorBaseInfo2.getDoctorInfo_record());
		pstmt.setString(9, doctorBaseInfo2.getDoctorInfo_position());
		pstmt.setString(10, doctorBaseInfo2.getDoctorInfo_phone());
		pstmt.setString(11, doctorBaseInfo2.getDoctorInfo_email());
		pstmt.setBinaryStream(12, inputStream,inputStream.available());
		pstmt.setString(13, doctorBaseInfo2.getDoctorInfo_type());
		pstmt.setString(14, doctorBaseInfo2.getDoctorInfo_disease());
		pstmt.setString(15, doctorBaseInfo2.getDoctorInfo_Oaddress());
		pstmt.setString(16, doctorBaseInfo2.getState());
		pstmt.setString(17, doctorBaseInfo2.getDoctorInfo_ID());
		int i = pstmt.executeUpdate();
		return i;
	}

	@Override
	public int getListNum(String sqlString,String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from registered where doctorInfo_ID = ? ");
		sql.append(sqlString);
		/*sql = "select count(*) from registered where doctorInfo_ID = ?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showRegistered(String sqlString,String doctorInfo_ID, int startRow, int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select registered.* from registered where doctorInfo_ID = ?");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "select registered.* from registered where doctorInfo_ID = ? LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, doctorInfo_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int findById(String registered_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select registered_state from registered where registered_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, registered_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public void modifyRegistered(String registered_ID, int i) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "update registered set registered_state = ? where registered_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, i);
		pstmt.setString(2, registered_ID);
		pstmt.executeUpdate();
	}

	@Override
	public int getMedicalListNum(String sqlString,String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from medical where doctorInfo_ID = ?");
		sql.append(sqlString);
		/*sql = "select count(*) from medical where doctorInfo_ID = ?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showMedical(String sqlString,String doctorInfo_ID, int startRow, int i)
			throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select medical.* from medical where doctorInfo_ID = ?");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "select medical.* from medical where doctorInfo_ID = ? LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, doctorInfo_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	public int getAllDoctor(String sqllString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuilder sql = new StringBuilder(); 
		sql.append("SELECT count(*) FROM doctorinfo,departmentdeploy de WHERE "
				+ "doctorinfo.doctorInfo_ID = de.doctorInfo_ID AND doctorinfo.state=1 AND de.hospital_ID=?");
		sql.append(sqllString);
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	public ResultSet showAllDoctors(String sqllString,String hospital_ID,int startRow, int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuilder sql = new StringBuilder(); 
		sql.append("SELECT * FROM doctorinfo,departmentdeploy de,registrationfee re WHERE "
				+ "doctorinfo.doctorInfo_ID = de.doctorInfo_ID AND doctorinfo.state=1 AND "
				+ "de.hospital_ID=? AND doctorinfo.doctorInfo_type =re.doctorInfo_type "
				+ "AND re.hospital_ID=de.hospital_ID ");
		sql.append(sqllString);
		sql.append(" limit ?,?");
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int getAllRegisteredListNum(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM registered WHERE doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID "
				+ "FROM departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND "
				+ "departmentdeploy.hospital_ID=?) ");
		sql.append(sqlString);
 		/*sql = "SELECT count(*) FROM registered WHERE doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID "
				+ "FROM departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1 AND "
				+ "departmentdeploy.hospital_ID=?)";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showAllRegistered(String sqlString,String hospital_ID,int startRow, int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM registered WHERE doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
				+ "departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID "
				+ "AND doctorinfo.state=1 AND departmentdeploy.hospital_ID=?) ");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
	/*	sql = "SELECT * FROM registered WHERE doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
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
	public int getAllMedicalListNum(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM medical WHERE doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
				+ "departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID "
				+ "AND doctorinfo.state=1 AND departmentdeploy.hospital_ID=?)");
		sql.append(sqlString);
		/*sql = "SELECT count(*) FROM medical WHERE doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
				+ "departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID "
				+ "AND doctorinfo.state=1 AND departmentdeploy.hospital_ID=?)";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showALlMedical(String sqlString,String hospital_ID,int startRow, int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM medical WHERE doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
				+ "departmentdeploy,doctorinfo WHERE departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID "
				+ "AND doctorinfo.state=1 AND departmentdeploy.hospital_ID=?)");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT * FROM medical WHERE doctorInfo_ID IN (SELECT doctorinfo.doctorInfo_ID FROM "
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
	public int getDoctorNumByID(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select count(*) from doctorinfo where doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showDoctorsByID(String doctorInfo_ID, int startRow, int i)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from doctorinfo where doctorInfo_ID = ? LIMIT ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int getDoctorNumByName(String doctorInfo_name) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select count(*) from doctorinfo where doctorInfo_name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_name);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showDoctorsByName(String doctorInfo_name, int startRow,
			int i) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from doctorinfo where doctorInfo_name = ? LIMIT ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_name);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int getRegisteredByID(String sqlBuffer,String registered_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from registered where registered_ID = ?");
		sql.append(sqlBuffer);
		/*sql = "select count(*) from registered where registered_ID = ?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, registered_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	@Override
	public ResultSet showRegisteredByID(String sqlBuffer,String registered_ID, int startRow,
			int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from registered where registered_ID = ?");
		sql.append(sqlBuffer);
		sql.append(" LIMIT ?,?");
		/*sql = "select * from registered where registered_ID = ? LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, registered_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet findDoctorByID(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from doctorinfo where doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int insertDoctor(DoctorBaseInfo doctorBaseInfo2) throws Exception {
		conn = SqlUtil.getConnection();
		InputStream inputStream = null;
        inputStream = ImageUtil.getImageByte(doctorBaseInfo2.getDoctorInfo_photo());
		sql = "insert into doctorinfo(doctorInfo_ID,doctorInfo_pwd,"
				+ "doctorInfo_name,doctorInfo_sex,doctorInfo_birthday,doctorInfo_address,"
				+ "doctorInfo_record,doctorInfo_position,doctorInfo_phone,doctorInfo_email,"
				+ "doctorInfo_photo,doctorInfo_type,doctorInfo_disease,doctorInfo_Oaddress,state) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorBaseInfo2.getDoctorInfo_ID());
		pstmt.setString(2, doctorBaseInfo2.getDoctorInfo_pwd());
		pstmt.setString(3, doctorBaseInfo2.getDoctorInfo_name());
		pstmt.setInt(4, doctorBaseInfo2.getDoctorInfo_sex());
		pstmt.setDate(5, doctorBaseInfo2.getDoctorInfo_birthday());
		pstmt.setString(6, doctorBaseInfo2.getDoctorInfo_address());
		pstmt.setString(7, doctorBaseInfo2.getDoctorInfo_record());
		pstmt.setString(8, doctorBaseInfo2.getDoctorInfo_position());
		pstmt.setString(9, doctorBaseInfo2.getDoctorInfo_phone());
		pstmt.setString(10, doctorBaseInfo2.getDoctorInfo_email());
		pstmt.setBinaryStream(11, inputStream,inputStream.available());
		pstmt.setString(12, doctorBaseInfo2.getDoctorInfo_type());
		pstmt.setString(13, doctorBaseInfo2.getDoctorInfo_disease());
		pstmt.setString(14, doctorBaseInfo2.getDoctorInfo_Oaddress());
		pstmt.setString(15, "1");
		int i = pstmt.executeUpdate();
		return i;
	}

	@Override
	public ResultSet findDoctorByDocID(String hospital_ID,String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM doctorinfo WHERE doctorInfo_ID=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int updateBy(DoctorBaseInfo doctorBaseInfo2) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "update doctorinfo set ID = ?,doctorInfo_ID=?,doctorInfo_pwd=?,doctorInfo_name=?,"
				+ "doctorInfo_sex=?,doctorInfo_birthday=?,doctorInfo_address=?,doctorInfo_record=?,"
				+ "doctorInfo_position=?,doctorInfo_phone=?,doctorInfo_email=?,doctorInfo_photo=?,"
				+ "doctorInfo_type=?,doctorInfo_disease=?,doctorInfo_Oaddress=?,state=? where doctorInfo_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, doctorBaseInfo2.getID());
		pstmt.setString(2, doctorBaseInfo2.getDoctorInfo_ID());
		pstmt.setString(3, doctorBaseInfo2.getDoctorInfo_pwd());
		pstmt.setString(4, doctorBaseInfo2.getDoctorInfo_name());
		pstmt.setInt(5, doctorBaseInfo2.getDoctorInfo_sex());
		pstmt.setDate(6, doctorBaseInfo2.getDoctorInfo_birthday());
		pstmt.setString(7, doctorBaseInfo2.getDoctorInfo_address());
		pstmt.setString(8, doctorBaseInfo2.getDoctorInfo_record());
		pstmt.setString(9, doctorBaseInfo2.getDoctorInfo_position());
		pstmt.setString(10, doctorBaseInfo2.getDoctorInfo_phone());
		pstmt.setString(11, doctorBaseInfo2.getDoctorInfo_email());
		pstmt.setString(12, doctorBaseInfo2.getDoctorInfo_photo());
		pstmt.setString(13, doctorBaseInfo2.getDoctorInfo_type());
		pstmt.setString(14, doctorBaseInfo2.getDoctorInfo_disease());
		pstmt.setString(15, doctorBaseInfo2.getDoctorInfo_Oaddress());
		pstmt.setString(16, doctorBaseInfo2.getState());
		pstmt.setString(17, doctorBaseInfo2.getDoctorInfo_ID());
		int i = pstmt.executeUpdate();
		return i;
	}

	@Override
	public ResultSet findRegByID(String registered_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM registered WHERE registered.registered_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, registered_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public int deleteDoctorinfo(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "delete from doctorinfo where doctorInfo_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		int i = pstmt.executeUpdate();
		return i;
	}

	@Override
	public int deleteRegistered(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "DELETE FROM registered WHERE doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		int i = pstmt.executeUpdate();
		return i;
	}
	
	
	
	

}
