package com.lua.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lua.DAOImpl.ConsultationDAOImpl;
import com.lua.dao.ConsultationDAO;
import com.lua.javautil.Pagination;
import com.lua.model.Consultation;
import com.lua.model.DoctorVisit;
import com.lua.model.attention;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月27日 下午3:29:55
 * 类说明
 */
public class ConsultationService {

	
	private ConsultationDAO consultationDAO;
	public List<Consultation> showConsultationByID(String consultation_sendID,
			String consultation_getID) throws Exception{
		consultationDAO = new ConsultationDAOImpl();
		ResultSet rs = consultationDAO.showConsultationByID(consultation_sendID,consultation_getID);
		List<Consultation> list = new ArrayList<Consultation>();
		Consultation consultation ;
		while (rs.next()) {
			consultation = new Consultation();
			consultation.setID(rs.getInt("ID"));
			consultation.setConsultation_ID(rs.getString("consultation_ID"));
			consultation.setConsultation_sendID(rs.getString("consultation_sendID"));
			consultation.setConsultation_getID(rs.getString("consultation_getID"));
			consultation.setConsultation_msg(rs.getString("consultation_msg"));
			consultation.setConsultation_time(rs.getTimestamp("consultation_time"));
			list.add(consultation);
		}
		return list;
	}
	public List<attention> showAttentions(
			String consultation_sendID) throws Exception{
		consultationDAO = new ConsultationDAOImpl();
		ResultSet rs = consultationDAO.showAttentions(consultation_sendID);
		List<attention> list = new ArrayList<attention>();
		attention attention ;
		while (rs.next()) {
			attention = new attention();
			attention.setID(rs.getInt("ID"));
			attention.setPatient_ID(rs.getString("patient_ID"));
			attention.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			attention.setDoctorInfo_time(rs.getDate("doctorInfo_time"));
			list.add(attention);
		}
		return list;
	}
	public void insert(Consultation consultation) throws Exception{
		consultationDAO = new ConsultationDAOImpl();
		consultationDAO.insert(consultation);
	}
	public Pagination showConsultationElse(String sqlString,String hospital_ID, String pageNum,
			int i) throws Exception{
		consultationDAO = new ConsultationDAOImpl();
		int total = consultationDAO.getConsultationByID(sqlString,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = consultationDAO.showConsultationByID(sqlString,hospital_ID,pagination.getStartRow(),i);
		List<Consultation> list = new ArrayList<Consultation>();
		Consultation consultation;
		while(rs.next()){
			consultation = new Consultation();
			consultation.setID(rs.getInt("ID"));
			consultation.setConsultation_ID(rs.getString("consultation_ID"));
			consultation.setConsultation_sendID(rs.getString("consultation_sendID"));
			consultation.setConsultation_getID(rs.getString("consultation_getID"));
			consultation.setConsultation_msg(rs.getString("consultation_msg"));
			consultation.setConsultation_time(rs.getTimestamp("consultation_time"));
			list.add(consultation);
		}
		pagination.setList(list);
		return pagination;
	}
	public Pagination showConsultationElseElse(String sqlString, String pageNum,
			int i) throws Exception{
		consultationDAO = new ConsultationDAOImpl();
		int total = consultationDAO.getConsultationElseElse(sqlString);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = consultationDAO.showConsultationElseElse(sqlString,pagination.getStartRow(),i);
		List<Consultation> list = new ArrayList<Consultation>();
		Consultation consultation;
		while(rs.next()){
			consultation = new Consultation();
			consultation.setID(rs.getInt("ID"));
			consultation.setConsultation_ID(rs.getString("consultation_ID"));
			consultation.setConsultation_sendID(rs.getString("consultation_sendID"));
			consultation.setConsultation_getID(rs.getString("consultation_getID"));
			consultation.setConsultation_msg(rs.getString("consultation_msg"));
			consultation.setConsultation_time(rs.getTimestamp("consultation_time"));
			list.add(consultation);
		}
		pagination.setList(list);
		return pagination;
	}

}
