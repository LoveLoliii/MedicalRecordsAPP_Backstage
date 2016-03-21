package com.lua.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lua.DAOImpl.EvaluationDAOImpl;
import com.lua.dao.EvaluationDAO;
import com.lua.javautil.Pagination;
import com.lua.model.Evaluation;
import com.lua.model.Pay;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月9日 下午2:41:00
 * 类说明
 */
public class EvaluationService {

	
	private EvaluationDAO evaluationDAO;
	public Pagination showEvaluation(String sqlString,String hospital_ID, String pageNum, int i) throws Exception{
		evaluationDAO = new EvaluationDAOImpl();
		int total = evaluationDAO.getEvaluationByID(sqlString,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = evaluationDAO.showEvaluationByID(sqlString,hospital_ID,pagination.getStartRow(),i);
		List<Evaluation>list = new ArrayList<Evaluation>();
		Evaluation evaluation;
		while(rs.next()){
			evaluation = new Evaluation();
			evaluation.setID(rs.getInt("ID"));
			evaluation.setEvaluation_ID(rs.getString("evaluation_ID"));
			evaluation.setPatient_ID(rs.getString("patient_ID"));
			evaluation.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			evaluation.setEvaluation_msg(rs.getString("evaluation_msg"));
			evaluation.setEvaluation_time(rs.getDate("evaluation_time"));
			evaluation.setEvaluation_state(rs.getInt("evaluation_state"));
			list.add(evaluation);
		}
		pagination.setList(list);
		return pagination;
	}
	public Pagination showEvaluationGood(String sqlString,String hospital_ID, String pageNum,
			int i, int j) throws Exception{
		evaluationDAO = new EvaluationDAOImpl();
		int total = evaluationDAO.getEvaluationByIDGood(sqlString,hospital_ID,j);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = evaluationDAO.showEvaluationByIDGood(sqlString,hospital_ID,pagination.getStartRow(),i,j);
		List<Evaluation>list = new ArrayList<Evaluation>();
		Evaluation evaluation;
		while(rs.next()){
			evaluation = new Evaluation();
			evaluation.setID(rs.getInt("ID"));
			evaluation.setEvaluation_ID(rs.getString("evaluation_ID"));
			evaluation.setPatient_ID(rs.getString("patient_ID"));
			evaluation.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			evaluation.setEvaluation_msg(rs.getString("evaluation_msg"));
			evaluation.setEvaluation_time(rs.getDate("evaluation_time"));
			evaluation.setEvaluation_state(rs.getInt("evaluation_state"));
			list.add(evaluation);
		}
		pagination.setList(list);
		return pagination;
	}
	public int deleteEvaluation(String doctorInfo_ID) throws Exception{
		evaluationDAO = new EvaluationDAOImpl();
		int i = evaluationDAO.deleteEvaluation(doctorInfo_ID);
		return i;
	}

}
