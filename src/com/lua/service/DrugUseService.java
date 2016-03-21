package com.lua.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lua.DAOImpl.DrugUseDAOImpl;
import com.lua.dao.DrugUseDAO;
import com.lua.javautil.Pagination;
import com.lua.model.Druguse;
import com.lua.model.Registrationfee;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月8日 下午6:21:38
 * 类说明
 */
public class DrugUseService {

	
	private DrugUseDAO drugUseDAO;
	public Pagination showDrugUse(String sqlString,String hospital_ID, String pageNum, int i) throws Exception{
		drugUseDAO = new DrugUseDAOImpl();
		int total = drugUseDAO.getDrugUseByID(sqlString,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = drugUseDAO.showDrugUseByID(sqlString,hospital_ID,pagination.getStartRow(),i);
		List<Druguse>list = new ArrayList<Druguse>();
		Druguse druguse;
		while(rs.next()){
			druguse = new Druguse();
			druguse.setID(rs.getInt("ID"));
			druguse.setDruguse_ID(rs.getString("druguse_ID"));
			druguse.setMedical_ID(rs.getString("medical_ID"));
			druguse.setDrug_ID(rs.getString("drug_ID"));
			druguse.setDruguse_num(rs.getInt("druguse_num"));
			druguse.setDruguse_time(rs.getDate("druguse_time"));
			list.add(druguse);
		}
		pagination.setList(list);
		return pagination;
	}
	public Druguse modifyDrugUseBefore(String druguse_ID) throws Exception{
		drugUseDAO = new DrugUseDAOImpl();
		ResultSet rs = drugUseDAO.modifyDrugUseBefore(druguse_ID);
		Druguse druguse = new Druguse();
		while (rs.next()) {
			druguse.setID(rs.getInt("ID"));
			druguse.setDruguse_ID(rs.getString("druguse_ID"));
			druguse.setMedical_ID(rs.getString("medical_ID"));
			druguse.setDrug_ID(rs.getString("drug_ID"));
			druguse.setDruguse_num(rs.getInt("druguse_num"));
			druguse.setDruguse_time(rs.getDate("druguse_time"));
		}
		return druguse;
	}
	public int modifyDrugUseAfter(Druguse druguse) throws Exception{
		drugUseDAO = new DrugUseDAOImpl();
		int i = drugUseDAO.modifyDrugUseAfter(druguse);
		return i;
	}

}
