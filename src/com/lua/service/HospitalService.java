package com.lua.service;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lua.DAOImpl.HospitalDAOImpl;
import com.lua.dao.HospitalDAO;
import com.lua.javautil.ImageUtil;
import com.lua.model.Hospital;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月5日 下午1:04:24
 * 类说明
 */
public class HospitalService {

	private HospitalDAO hospitalDAO;
	public Hospital hospitalbaseinfoShow(String baseinfo_ID) throws Exception{
		hospitalDAO = new HospitalDAOImpl();
		ResultSet rs = hospitalDAO.hospitalbaseinfoShow(baseinfo_ID);
		Hospital hospital = null;
	    InputStream inputStream = null;
	    String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		while (rs.next()) {
			hospital = new Hospital();
			hospital.setID(rs.getInt("ID"));
			hospital.setHospital_ID(rs.getString("hospital_ID"));
			hospital.setHospital_name(rs.getString("hospital_name"));
			hospital.setHospital_address(rs.getString("hospital_address"));
			hospital.setHospital_info(rs.getString("hospital_info"));
			hospital.setHospital_phone(rs.getString("hospital_phone"));
			hospital.setHospital_webSite(rs.getString("hospital_webSite"));
			hospital.setHospital_state(rs.getInt("hospital_state"));
			inputStream = rs.getBinaryStream("hospital_photo");
			ImageUtil.readBlob(inputStream, realpath+"\\photo"+rs.getInt("ID")+".png");
			hospital.setHospital_photo("photo"+rs.getInt("ID")+".png");
		}
		return hospital;
	}
	public Hospital findHospitalByID(String hospital_ID) throws Exception{
		hospitalDAO = new HospitalDAOImpl();
		ResultSet rs = hospitalDAO.findHospitalByID(hospital_ID);
		Hospital hospital = new Hospital();
		InputStream inputStream = null;
	    String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		while (rs.next()) {
			hospital.setID(rs.getInt("ID"));
			hospital.setHospital_ID(rs.getString("hospital_ID"));
			hospital.setHospital_name(rs.getString("hospital_name"));
			hospital.setHospital_address(rs.getString("hospital_address"));
			hospital.setHospital_info(rs.getString("hospital_info"));
			hospital.setHospital_phone(rs.getString("hospital_phone"));
			hospital.setHospital_webSite(rs.getString("hospital_webSite"));
			hospital.setHospital_state(rs.getInt("hospital_state"));
			inputStream = rs.getBinaryStream("hospital_photo");
			ImageUtil.readBlob(inputStream, realpath+"\\photo"+rs.getInt("ID")+".png");
			hospital.setHospital_photo("photo"+rs.getInt("ID")+".png");
		}
		return hospital;
	}
	public int modifyHospitalAfter(Hospital hospital) throws Exception{
		hospitalDAO = new HospitalDAOImpl();
		int i = hospitalDAO.modifyHospitalAfter(hospital);
		return i;
	}

}
