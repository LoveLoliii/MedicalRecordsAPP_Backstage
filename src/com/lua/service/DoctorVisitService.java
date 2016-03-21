package com.lua.service;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lua.DAOImpl.DoctorVisitDAOImpl;
import com.lua.dao.DoctorDAO;
import com.lua.dao.DoctorVisitDAO;
import com.lua.javautil.Pagination;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.DoctorVisit;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月28日 下午3:55:38
 * 类说明
 */
public class DoctorVisitService {

	private DoctorVisitDAO doctorVisitDAO;
	public Pagination showAllDoctorVisits(String sql,String hospital_ID,String pageNum, int i) throws Exception{
		doctorVisitDAO = new DoctorVisitDAOImpl();
		int total = doctorVisitDAO.getAllDoctorVisits(sql,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorVisitDAO.showAllDoctorVisits(sql,hospital_ID,pagination.getStartRow(),i);
		List<DoctorVisit> list = new ArrayList<DoctorVisit>();
		DoctorVisit doctorVisit;
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String timeString = df.format(date);
		while(rs.next()){
			doctorVisit = new DoctorVisit();
			doctorVisit.setID(rs.getInt("ID"));
			doctorVisit.setDoctorVisit_ID(rs.getString("doctorVisit_ID"));
			doctorVisit.setDoctorVisit_timeType(rs.getString("doctorVisit_timeType"));
			doctorVisit.setDoctorVisit_date(rs.getDate("doctorVisit_date"));
			doctorVisit.setDoctorVisit_regNunber(rs.getInt("doctorVisit_regNunber"));
			doctorVisit.setDoctorVisit_feedback(rs.getString("doctorVisit_feedback"));
			doctorVisit.setDoctorVisit_confirmState(rs.getInt("doctorVisit_confirmState"));
			String time = df.format(rs.getDate("doctorVisit_date"));
			if(java.sql.Date.valueOf(time).after(java.sql.Date.valueOf(timeString))){
				doctorVisit.setDoctorVisit_state(0);
			}else {
				doctorVisit.setDoctorVisit_state(1);
			}
			doctorVisit.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			doctorVisitDAO.modifyDoctorVisit(doctorVisit);
			list.add(doctorVisit);
		}
		
		pagination.setList(list);
		return pagination;
	}
	public Pagination showDoctorVisitByID(String sqlString,String doctorInfo_ID, String pageNum,
			int i) throws Exception{
		doctorVisitDAO = new DoctorVisitDAOImpl();
		int total = doctorVisitDAO.getDoctorVisitByID(sqlString,doctorInfo_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = doctorVisitDAO.showDoctorVisitByID(sqlString,doctorInfo_ID,pagination.getStartRow(),i);
		List<DoctorVisit> list = new ArrayList<DoctorVisit>();
		DoctorVisit doctorVisit;
		while(rs.next()){
			doctorVisit = new DoctorVisit();
			doctorVisit.setID(rs.getInt("ID"));
			doctorVisit.setDoctorVisit_ID(rs.getString("doctorVisit_ID"));
			doctorVisit.setDoctorVisit_timeType(rs.getString("doctorVisit_timeType"));
			doctorVisit.setDoctorVisit_date(rs.getDate("doctorVisit_date"));
			doctorVisit.setDoctorVisit_regNunber(rs.getInt("doctorVisit_regNunber"));
			doctorVisit.setDoctorVisit_feedback(rs.getString("doctorVisit_feedback"));
			doctorVisit.setDoctorVisit_confirmState(rs.getInt("doctorVisit_confirmState"));
			doctorVisit.setDoctorVisit_state(rs.getInt("doctorVisit_state"));
			doctorVisit.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			list.add(doctorVisit);
		}
		pagination.setList(list);
		return pagination;
	}
	public DoctorVisit findByID(String doctorVisit_ID) throws Exception{
		doctorVisitDAO = new DoctorVisitDAOImpl();
		ResultSet rs = doctorVisitDAO.findByID(doctorVisit_ID);
		DoctorVisit doctorVisit = new DoctorVisit();
		while (rs.next()) {
			doctorVisit.setID(rs.getInt("ID"));
			doctorVisit.setDoctorVisit_ID(rs.getString("doctorVisit_ID"));
			doctorVisit.setDoctorVisit_timeType(rs.getString("doctorVisit_timeType"));
			doctorVisit.setDoctorVisit_date(rs.getDate("doctorVisit_date"));
			doctorVisit.setDoctorVisit_regNunber(rs.getInt("doctorVisit_regNunber"));
			doctorVisit.setDoctorVisit_feedback(rs.getString("doctorVisit_feedback"));
			doctorVisit.setDoctorVisit_confirmState(rs.getInt("doctorVisit_confirmState"));
			doctorVisit.setDoctorVisit_state(rs.getInt("doctorVisit_state"));
			doctorVisit.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
		}
		return doctorVisit;
	}
	public int modifyDoctorVisit(DoctorVisit doctorVisit) throws Exception{
		doctorVisitDAO = new DoctorVisitDAOImpl();
		int i = doctorVisitDAO.modifyDoctorVisit(doctorVisit);
		return i;
	}
	public int deleteDoctVisit(String doctorInfo_ID) throws Exception{
		doctorVisitDAO = new DoctorVisitDAOImpl();
		int i = doctorVisitDAO.deleteDoctVisit(doctorInfo_ID);
		return i;
	}

}
