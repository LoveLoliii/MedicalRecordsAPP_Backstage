package com.lua.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lua.DAOImpl.HighchartDAOImpl;
import com.lua.dao.HighchartDAO;
import com.lua.model.DocCount;
import com.lua.model.Num;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月12日 下午9:27:51
 * 类说明
 */
public class HighchartService {

	private HighchartDAO highchartDAO;
	
	public List<Num> showRegistered(String hospital_ID) throws Exception{
		highchartDAO = new HighchartDAOImpl();
		ResultSet rs = highchartDAO.showRegistered(hospital_ID);
		List<Num> list = new ArrayList<Num>();
		Num num;
		while (rs.next()) {
			num = new Num(rs.getInt("monuth"),rs.getFloat("num"));
			list.add(num);
		}
		return list;
	}

	public List<Num> showRegisteredOther(String hospital_ID) throws Exception{
		highchartDAO = new HighchartDAOImpl();
		ResultSet rs = highchartDAO.showRegisteredOther(hospital_ID);
		List<Num> list = new ArrayList<Num>();
		Num num;
		while (rs.next()) {
			num = new Num(rs.getInt("monuth"),rs.getFloat("num"));
			list.add(num);
		}
		return list;
	}

	public List<DocCount> showDoctorInfo(String hospital_ID,
			String minordepartment_ID, String idTimeStart, String idTimeEnd) throws Exception{
		highchartDAO = new HighchartDAOImpl();
		ResultSet rs = highchartDAO.showDoctorInfo(hospital_ID,minordepartment_ID,idTimeStart,idTimeEnd);
		List<DocCount> list = new ArrayList<DocCount>();
		DocCount docCount;
		while (rs.next()) {
			docCount = new DocCount(rs.getString("docname"), rs.getInt("num"));
			list.add(docCount);
		}
		return list;
	}

	public List<DocCount> showDepartment(String idTimeStart, String idTimeEnd,
			String hospital_ID) throws Exception{
		highchartDAO = new HighchartDAOImpl();
		ResultSet rs = highchartDAO.showDepartment(idTimeStart,idTimeEnd,hospital_ID);
		List<DocCount> list = new ArrayList<DocCount>();
		DocCount docCount;
		while (rs.next()) {
			docCount = new DocCount(rs.getString("docname"), rs.getInt("num"));
			list.add(docCount);
		}
		return list;
	}

	public List<Num> showHospitalCost(String hospital_ID, String timeYear) throws Exception{
		highchartDAO = new HighchartDAOImpl();
		ResultSet rs = highchartDAO.showHospitalCost(hospital_ID,timeYear);
		List<Num> list = new ArrayList<Num>();
		Num num;
		while (rs.next()) {
			num = new Num(rs.getInt("month"),rs.getFloat("number"));
			list.add(num);
		}
		return list;
	}

	public List<Num> showHospitalCostBefore(String hospital_ID, String timeYear) throws Exception{
		highchartDAO = new HighchartDAOImpl();
		ResultSet rs = highchartDAO.showHospitalCostBefore(hospital_ID,Float.parseFloat(timeYear)-1);
		List<Num> list = new ArrayList<Num>();
		Num num;
		while (rs.next()) {
			num = new Num(rs.getInt("month"),rs.getFloat("number"));
			list.add(num);
		}
		return list;
	}

}
