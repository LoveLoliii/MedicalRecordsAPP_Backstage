package com.lua.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lua.DAOImpl.PayDAOImpl;
import com.lua.dao.PayDAO;
import com.lua.javautil.Pagination;
import com.lua.model.Druguse;
import com.lua.model.Pay;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月9日 下午1:27:21
 * 类说明
 */
public class PayService {

	private PayDAO payDAO;
	public Pagination showPay(String sqlString,String hospital_ID, String pageNum, int i) throws Exception{
		payDAO = new PayDAOImpl();
		int total = payDAO.getPayByID(sqlString,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = payDAO.showPayByID(sqlString,hospital_ID,pagination.getStartRow(),i);
		List<Pay>list = new ArrayList<Pay>();
		Pay pay;
		while(rs.next()){
			pay = new Pay();
			pay.setID(rs.getInt("ID"));
			pay.setPay_ID(rs.getString("pay_ID"));
			pay.setDruguse_ID(rs.getString("druguse_ID"));
			pay.setPay_cost(rs.getInt("pay_cost"));
			pay.setPay_time(rs.getDate("pay_time"));
			pay.setPay_state(rs.getInt("pay_state"));
			list.add(pay);
		}
		pagination.setList(list);
		return pagination;
	}

}
