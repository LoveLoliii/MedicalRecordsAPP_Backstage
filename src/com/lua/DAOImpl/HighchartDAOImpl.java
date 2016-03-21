package com.lua.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lua.dao.HighchartDAO;
import com.lua.javautil.SqlUtil;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月12日 下午9:36:48
 * 类说明
 */
public class HighchartDAOImpl implements HighchartDAO {
	
	private Connection conn;
	private String sql;

	@Override
	public ResultSet showRegistered(String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT MONTH(rg.registered_time)  AS monuth,COUNT(registered_time)  AS num FROM registered rg "
				+ "WHERE rg.registered_state =1 AND rg.doctorInfo_ID IN (SELECT de.doctorInfo_ID "
				+ "FROM departmentdeploy de,doctorinfo doc WHERE de.hospital_ID = ? AND "
				+ "doc.doctorInfo_ID = de.doctorInfo_ID AND doc.state=1)GROUP BY MONTH(rg.registered_time)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet showRegisteredOther(String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT MONTH(rg.registered_time)  AS monuth,COUNT(registered_time)  AS num FROM registered rg "
				+ "WHERE rg.registered_state =0 AND rg.doctorInfo_ID IN (SELECT de.doctorInfo_ID "
				+ "FROM departmentdeploy de,doctorinfo doc WHERE de.hospital_ID = ? AND "
				+ "doc.doctorInfo_ID = de.doctorInfo_ID AND doc.state=1)GROUP BY MONTH(rg.registered_time)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet showDoctorInfo(String hospital_ID,
			String minordepartment_ID,String timeStart,String timeEnd) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT doc.doctorInfo_name AS docname,COUNT(me.doctorInfo_ID) AS num FROM departmentdeploy "
				+ "de LEFT JOIN medical me ON de.doctorInfo_ID=me.doctorInfo_ID   ,doctorinfo doc WHERE "
				+ "me.medical_time BETWEEN ? AND ? AND doc.doctorInfo_ID = de.doctorInfo_ID "
				+ "AND doc.state=1 AND de.hospital_ID=? AND de.minordepartment_ID=? "
				+ "GROUP BY de.doctorInfo_ID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, timeStart);
		pstmt.setString(2, timeEnd);
		pstmt.setString(3, hospital_ID);
		pstmt.setString(4, minordepartment_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet showDepartment(String idTimeStart, String idTimeEnd,
			String hospital_ID) throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT mino.minordepartment_name AS docname,COUNT(de.minordepartment_ID) AS num FROM "
				+ "departmentdeploy de LEFT JOIN medical me ON de.doctorInfo_ID=me.doctorInfo_ID   ,"
				+ "doctorinfo doc,minordepartment mino WHERE me.medical_time BETWEEN ? AND"
				+ " ? AND doc.doctorInfo_ID = de.doctorInfo_ID AND mino.minordepartment_ID = "
				+ "de.minordepartment_ID  AND doc.state=1 AND de.hospital_ID=?  GROUP BY "
				+ "de.minordepartment_ID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, idTimeStart);
		pstmt.setString(2, idTimeEnd);
		pstmt.setString(3, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet showHospitalCost(String hospital_ID, String timeYear)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT MONTH(pay.pay_time) AS MONTH,SUM(pay.pay_cost) AS number FROM pay,druguse,"
				+ "drugandhospital WHERE pay.pay_state = 1 AND YEAR(pay.pay_time) = ? AND "
				+ "pay.druguse_ID=druguse.druguse_ID AND druguse.drug_ID=drugandhospital.drug_ID AND "
				+ "drugandhospital.hospital_ID=? GROUP BY MONTH(pay.pay_time)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, timeYear);
		pstmt.setString(2, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	@Override
	public ResultSet showHospitalCostBefore(String hospital_ID, float f)
			throws Exception {
		conn = SqlUtil.getConnection();
		sql = "SELECT MONTH(pay.pay_time) AS MONTH,SUM(pay.pay_cost) AS number FROM pay,druguse,"
				+ "drugandhospital WHERE pay.pay_state = 1 AND YEAR(pay.pay_time) = ? AND "
				+ "pay.druguse_ID=druguse.druguse_ID AND druguse.drug_ID=drugandhospital.drug_ID AND "
				+ "drugandhospital.hospital_ID=? GROUP BY MONTH(pay.pay_time)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, String.valueOf(f));
		pstmt.setString(2, hospital_ID);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

}
