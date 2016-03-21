package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.DepartmentDAO;
import com.lua.javautil.SqlUtil;
import com.lua.model.DepartmentDeploy;
import com.lua.model.MainDepartment;
import com.lua.model.MinorDepartment;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月29日 下午8:08:27
 * 类说明
 */
public class DepartmentDAOImpl implements DepartmentDAO {

	
	private Connection conn;
	private String sql;
	@Override
	public ResultSet showMaindepartment(String sqlString,String hospital_ID,int start,int i) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT main.* FROM minordepartment mino,maindepartment main WHERE main.maindepartment_ID = "
				+ "mino.maindepartment_ID AND mino.minordepartment_ID IN (SELECT de.minordepartment_ID FROM "
				+ "departmentdeploy de,doctorinfo WHERE hospital_ID = ? AND de.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1)");
		sql.append(sqlString);
		sql.append(" LIMIT ?,?");
		/*sql = "SELECT DISTINCT main.* FROM minordepartment mino,maindepartment main WHERE main.maindepartment_ID = "
				+ "mino.maindepartment_ID AND mino.minordepartment_ID IN (SELECT de.minordepartment_ID FROM "
				+ "departmentdeploy de,doctorinfo WHERE hospital_ID = ? AND de.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1) LIMIT ?,?";*/
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, hospital_ID);
		pstmt.setInt(2, start);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int getAllMaindepartment(String sqlString,String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT COUNT(DISTINCT main.maindepartment_ID) FROM minordepartment mino,maindepartment main WHERE main.maindepartment_ID = "
				+ "mino.maindepartment_ID AND mino.minordepartment_ID IN (SELECT de.minordepartment_ID FROM "
				+ "departmentdeploy de,doctorinfo WHERE hospital_ID = ? AND de.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1)");
		sql.append(sqlString);
		/*sql = "SELECT COUNT(DISTINCT main.maindepartment_ID) FROM minordepartment mino,maindepartment main WHERE main.maindepartment_ID = "
				+ "mino.maindepartment_ID AND mino.minordepartment_ID IN (SELECT de.minordepartment_ID FROM "
				+ "departmentdeploy de,doctorinfo WHERE hospital_ID = ? AND de.doctorInfo_ID = "
				+ "doctorinfo.doctorInfo_ID AND doctorinfo.state=1)";*/
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
	public ResultSet findByID(String maindepartment_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from maindepartment where maindepartment_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, maindepartment_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int modifyMainDepartmentAfter(MainDepartment maindepartment)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "update maindepartment set ID = ?,maindepartment_ID=?,maindepartment_name=? where maindepartment_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, maindepartment.getID());
		pstmt.setString(2, maindepartment.getMaindepartment_ID());
		pstmt.setString(3, maindepartment.getMaindepartment_name());
		pstmt.setString(4, maindepartment.getMaindepartment_ID());
		int i = pstmt.executeUpdate();
		return i;
	}
	@Override
	public int insertMainDepartmentAfter(MainDepartment maindepartment)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "insert into maindepartment(maindepartment_ID,maindepartment_name) values(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, maindepartment.getMaindepartment_ID());
		pstmt.setString(2, maindepartment.getMaindepartment_name());
		int i = pstmt.executeUpdate();
		return i;
	}
	@Override
	public int getAllMinordepartment() throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select count(*) from minordepartment";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}
	@Override
	public ResultSet showMinordepartment(int startRowNew, int i)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM minordepartment,maindepartment WHERE (minordepartment.maindepartment_ID = maindepartment.maindepartment_ID) LIMIT ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startRowNew);
		pstmt.setInt(2, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int getAllMinordepartmentByID(String doctorInfo_ID,String maindepartment_ID)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT count(*) FROM minordepartment WHERE maindepartment_ID = ? AND "
				+ "minordepartment_ID IN (SELECT minordepartment_ID FROM departmentdeploy WHERE "
				+ "doctorInfo_ID = ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, maindepartment_ID);
		pstmt.setString(2, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}
	@Override
	public ResultSet showMinordepartmentByID(String doctorInfo_ID,String maindepartment_ID,
			int startRowNew, int i) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM minordepartment WHERE maindepartment_ID = ? "
				+ "AND minordepartment_ID IN (SELECT minordepartment_ID FROM departmentdeploy "
				+ "WHERE doctorInfo_ID = ?) LIMIT ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, maindepartment_ID);
		pstmt.setString(2, doctorInfo_ID);
		pstmt.setInt(3, startRowNew);
		pstmt.setInt(4, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public ResultSet showMaindepartmentByID(String maindepartment_ID)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from maindepartment where maindepartment_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, maindepartment_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public ResultSet findMinordepartmentByID(String minordepartment_ID)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from minordepartment where minordepartment_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, minordepartment_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public ResultSet showMaindepartment() throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from maindepartment";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int modifyMinorDepartmentAfter(MinorDepartment minordepartment)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "update minordepartment set ID=?,minordepartment_ID=?,minordepartment_name=?,maindepartment_ID=? where minordepartment_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, minordepartment.getID());
		pstmt.setString(2, minordepartment.getMinordepartment_ID());
		pstmt.setString(3, minordepartment.getMinordepartment_name());
		pstmt.setString(4, minordepartment.getMaindepartment_ID());
		pstmt.setString(5, minordepartment.getMinordepartment_ID());
		int i = pstmt.executeUpdate();
		return i;
	}
	@Override
	public int inserMinordepartment(MinorDepartment minordepartment)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "insert into minordepartment(minordepartment_ID,minordepartment_name,maindepartment_ID) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, minordepartment.getMinordepartment_ID());
		pstmt.setString(2, minordepartment.getMinordepartment_name());
		pstmt.setString(3, minordepartment.getMaindepartment_ID());
		int i = pstmt.executeUpdate();
		return i;
	}
	@Override
	public int getAllDepartmentandDoc(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select count(*) from departmentdeploy where doctorInfo_ID=?";
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
	public ResultSet showDepartmentandDoc(String doctorInfo_ID, int startRow,
			int i) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from departmentdeploy de,minordepartment min where de.minordepartment_ID = min.minordepartment_ID and doctorInfo_ID=? LIMIT ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int getDoctorBy(String hospital_ID,String minordepartment_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT COUNT(*) FROM departmentdeploy,doctorinfo "
				+ "WHERE departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID "
				+ "AND departmentdeploy.minordepartment_ID = ? "
				+ "AND doctorinfo.state=1 and departmentdeploy.hospital_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, minordepartment_ID);
		pstmt.setString(2, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}
	@Override
	public ResultSet showDoctorByID(String hospital_ID,String minordepartment_ID, int startRowNew,
			int i) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM departmentdeploy,doctorinfo,registrationfee WHERE "
				+ "departmentdeploy.doctorInfo_ID = doctorinfo.doctorInfo_ID AND "
				+ "departmentdeploy.minordepartment_ID = ? AND doctorinfo.state=1 "
				+ "AND departmentdeploy.hospital_ID=? AND registrationfee.doctorInfo_type "
				+ "= doctorinfo.doctorInfo_type AND registrationfee.hospital_ID = "
				+ "departmentdeploy.hospital_ID  LIMIT ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, minordepartment_ID);
		pstmt.setString(2, hospital_ID);
		pstmt.setInt(3, startRowNew);
		pstmt.setInt(4, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public ResultSet getAllMinordepartmentByDocID(String doctorInfo_ID)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select min.* from departmentdeploy de,minordepartment min "
				+ "where de.minordepartment_ID = min.minordepartment_ID "
				+ "and de.doctorInfo_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public ResultSet findByDocID(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from departmentdeploy where doctorInfo_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int update(DepartmentDeploy departmentDeploy) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "update departmentdeploy set minordepartment_ID=?,doctorInfo_ID=?,hospital_ID=? where doctorInfo_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, departmentDeploy.getMinordepartment_ID());
		pstmt.setString(2, departmentDeploy.getDoctorInfo_ID());
		pstmt.setString(3, departmentDeploy.getHospital_ID());
		pstmt.setString(4, departmentDeploy.getDoctorInfo_ID());
		int i = pstmt.executeUpdate();
		return i;
	}
	@Override
	public ResultSet findMinorByID(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "select * from departmentdeploy where doctorInfo_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int insertDepartmentDeploy(DepartmentDeploy departmentDeploy)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "insert into departmentdeploy(minordepartment_ID,doctorInfo_ID,hospital_ID) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, departmentDeploy.getMinordepartment_ID());
		pstmt.setString(2, departmentDeploy.getDoctorInfo_ID());
		pstmt.setString(3, departmentDeploy.getHospital_ID());
		int i = pstmt.executeUpdate();
		return i;
	}
	@Override
	public ResultSet findDepartmentByHosID(String baseinfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT count(*) FROM departmentdeploy WHERE doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, baseinfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public ResultSet findDoctorByHosID(String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT count(*) FROM doctorinfo,departmentdeploy de "
				+ "WHERE doctorinfo.doctorInfo_ID = de.doctorInfo_ID "
				+ "AND doctorinfo.state=1 AND de.hospital_ID =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int showALlMaindepartment() throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT count(*) FROM maindepartment";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int i =0;
		while (rs.next()) {
			i = rs.getInt(1);
		}
		return i;
	}
	@Override
	public ResultSet showALlMaindepartments(int startRow, int i)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT * FROM maindepartment limit ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, i);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public ResultSet list(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT DISTINCT (de.minordepartment_ID),mino.minordepartment_name FROM "
				+ "departmentdeploy de,doctorinfo doc,minordepartment mino WHERE de.doctorInfo_ID "
				+ "= ?  AND mino.minordepartment_ID = de.minordepartment_ID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	@Override
	public int deleteDepartment(String doctorInfo_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "DELETE FROM departmentdeploy  WHERE doctorInfo_ID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, doctorInfo_ID);
		int i =  pstmt.executeUpdate();
		return i;
	}

}
