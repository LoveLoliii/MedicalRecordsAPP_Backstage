package com.lua.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lua.DAOImpl.DrugDAOImpl;
import com.lua.dao.DrugDAO;
import com.lua.javautil.Pagination;
import com.lua.model.Drug;
import com.lua.model.Registrationfee;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月8日 下午1:18:48
 * 类说明
 */
public class DrugService {

	private DrugDAO drugDAO;
	public Pagination drugShow(String sqlString,String hospital_ID, String pageNum, int i) throws Exception{
		drugDAO = new DrugDAOImpl();
		int total = drugDAO.getDrugByID(sqlString,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = drugDAO.showDrugByID(sqlString,hospital_ID,pagination.getStartRow(),i);
		List<Drug>list = new ArrayList<Drug>();
		Drug drug;
		while(rs.next()){
			drug = new Drug();
			drug.setID(rs.getInt("ID"));
			drug.setDrug_ID(rs.getString("drug_ID"));
			drug.setDrug_name(rs.getString("drug_name"));
			drug.setDrug_num(rs.getInt("drug_num"));
			drug.setDrug_price(rs.getFloat("drug_price"));
			drug.setDrug_time(rs.getDate("drug_time"));
			drug.setDrug_period(rs.getFloat("drug_period"));
			drug.setDrug_produce_factory(rs.getString("drug_produce_factory"));
			drug.setDrug_style(rs.getString("drug_style"));
			list.add(drug);
		}
		pagination.setList(list);
		return pagination;
	}
	public Drug modifyDrugBefore(String drug_ID) throws Exception{
		drugDAO = new DrugDAOImpl();
		ResultSet rs = drugDAO.modifyDrugBefore(drug_ID);
		Drug drug = new Drug();
		while (rs.next()) {
			drug.setID(rs.getInt("ID"));
			drug.setDrug_ID(rs.getString("drug_ID"));
			drug.setDrug_name(rs.getString("drug_name"));
			drug.setDrug_num(rs.getInt("drug_num"));
			drug.setDrug_price(rs.getFloat("drug_price"));
			drug.setDrug_time(rs.getDate("drug_time"));
			drug.setDrug_period(rs.getFloat("drug_period"));
			drug.setDrug_produce_factory(rs.getString("drug_produce_factory"));
			drug.setDrug_style(rs.getString("drug_style"));
		}
		return drug;
	}
	public int modifyDrugAfter(Drug drug) throws Exception{
		drugDAO = new DrugDAOImpl();
		int i = drugDAO.modifyDrugAfter(drug);
		return i;
	}
	
	public String insertDrugBefore(){
		return "insertDrugBefore";
	}
	public int insertDrugAfter(Drug drug) throws Exception{
		drugDAO = new DrugDAOImpl();
		int i = drugDAO.insertDrugAfter(drug);
		return i;
	}
	public int insertHos(String drug_ID, String hospital_ID) throws Exception{
		drugDAO = new DrugDAOImpl();
		int i = drugDAO.insertHos(drug_ID,hospital_ID);
		return i;
		
	}

}
