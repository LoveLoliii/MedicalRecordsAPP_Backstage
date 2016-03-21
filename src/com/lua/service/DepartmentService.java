package com.lua.service;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.lua.DAOImpl.DepartmentDAOImpl;
import com.lua.dao.DepartmentDAO;
import com.lua.javautil.ImageUtil;
import com.lua.javautil.Pagination;
import com.lua.javautil.PaginationNew;
import com.lua.model.DepartmentDeploy;
import com.lua.model.DoctorBaseInfo;
import com.lua.model.MainDepartment;
import com.lua.model.MinorDepartment;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年2月29日 下午8:07:50
 * 类说明
 */
public class DepartmentService {

	private DepartmentDAO departmentDAO;
	
	public Pagination showMaindepartment(String sqlString,String hospital_ID,String pageNum,int i) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int total = departmentDAO.getAllMaindepartment(sqlString,hospital_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = departmentDAO.showMaindepartment(sqlString,hospital_ID,pagination.getStartRow(),i);
		List<MainDepartment> list = new ArrayList<MainDepartment>();
		MainDepartment mainDepartment;
		while(rs.next()){
			mainDepartment = new MainDepartment();
			mainDepartment.setID(rs.getInt("ID"));
			mainDepartment.setMaindepartment_ID(rs.getString("maindepartment_ID"));
			mainDepartment.setMaindepartment_name(rs.getString("maindepartment_name"));
			list.add(mainDepartment);
		}
		pagination.setList(list);
		return pagination;
	}

	public MainDepartment modifyMainDepartmentBefore(String maindepartment_ID) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.findByID(maindepartment_ID);
		MainDepartment mainDepartment  = new MainDepartment();
		while (rs.next()) {
			mainDepartment.setID(rs.getInt("ID"));
			mainDepartment.setMaindepartment_ID(rs.getString("maindepartment_ID"));
			mainDepartment.setMaindepartment_name(rs.getString("maindepartment_name"));
		}
		return mainDepartment;
	}

	public int modifyMainDepartmentAfter(MainDepartment maindepartment) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int i = departmentDAO.modifyMainDepartmentAfter(maindepartment);
		return i;
	}

	public int insertMainDepartmentAfter(MainDepartment maindepartment) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int i = departmentDAO.insertMainDepartmentAfter(maindepartment);
		return i;
	}

	public PaginationNew showMinordepartment(String pageNumNew, int i) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int total = departmentDAO.getAllMinordepartment();
		PaginationNew paginationNew = new PaginationNew(pageNumNew,total,i);
		ResultSet rs = departmentDAO.showMinordepartment(paginationNew.getStartRowNew(),i);
		List<MinorDepartment> list = new ArrayList<MinorDepartment>();
		MinorDepartment minordepartment;
		while(rs.next()){
			minordepartment = new MinorDepartment();
			minordepartment.setID(rs.getInt("ID"));
			minordepartment.setMinordepartment_ID(rs.getString("minordepartment_ID"));
			minordepartment.setMinordepartment_name(rs.getString("minordepartment_name"));
			minordepartment.setMaindepartment_ID(rs.getString("maindepartment_name"));
			list.add(minordepartment);
		}
		paginationNew.setListNew(list);
		return paginationNew;
	}

	public PaginationNew showMinordepartmentByID(String doctorInfo_ID,String maindepartment_ID,
			String pageNumNew, int i) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int total = departmentDAO.getAllMinordepartmentByID(doctorInfo_ID,maindepartment_ID);
		PaginationNew paginationNew = new PaginationNew(pageNumNew,total,i);
		ResultSet rs = departmentDAO.showMinordepartmentByID(doctorInfo_ID,maindepartment_ID,paginationNew.getStartRowNew(),i);
		List<MinorDepartment> list = new ArrayList<MinorDepartment>();
		MinorDepartment minordepartment;
		while(rs.next()){
			minordepartment = new MinorDepartment();
			minordepartment.setID(rs.getInt("ID"));
			minordepartment.setMinordepartment_ID(rs.getString("minordepartment_ID"));
			minordepartment.setMinordepartment_name(rs.getString("minordepartment_name"));
			minordepartment.setMaindepartment_ID(rs.getString("maindepartment_ID"));
			list.add(minordepartment);
		}
		paginationNew.setListNew(list);
		return paginationNew;
	}

	public MainDepartment showMaindepartmentByID(String maindepartment_ID) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.showMaindepartmentByID(maindepartment_ID);
		MainDepartment maindepartment = new MainDepartment();
		while (rs.next()) {
			maindepartment.setID(rs.getInt("ID"));
			maindepartment.setMaindepartment_ID(rs.getString("maindepartment_ID"));
			maindepartment.setMaindepartment_name(rs.getString("maindepartment_name"));
		}
		return maindepartment;
	}

	public MinorDepartment findMinordepartmentByID(String minordepartment_ID) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.findMinordepartmentByID(minordepartment_ID);
		MinorDepartment minordepartment = new MinorDepartment();
		while (rs.next()) {
			minordepartment.setID(rs.getInt("ID"));
			minordepartment.setMinordepartment_ID(rs.getString("minordepartment_ID"));
			minordepartment.setMinordepartment_name(rs.getString("minordepartment_name"));
			minordepartment.setMaindepartment_ID(rs.getString("maindepartment_ID"));
		}
		return minordepartment;
	}

	public List<MainDepartment> showMaindepartment() throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.showMaindepartment();
		List<MainDepartment> list = new ArrayList<MainDepartment>();
		MainDepartment maindepartment;
		while (rs.next()) {
			maindepartment = new MainDepartment();
			maindepartment.setID(rs.getInt("ID"));
			maindepartment.setMaindepartment_ID(rs.getString("maindepartment_ID"));
			maindepartment.setMaindepartment_name(rs.getString("maindepartment_name"));
			list.add(maindepartment);
		}
		return list;
	}

	public int modifyMinorDepartmentAfter(MinorDepartment minordepartment) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int i = departmentDAO.modifyMinorDepartmentAfter(minordepartment);
		return i;
	}

	public int inserMinordepartment(MinorDepartment minordepartment) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int i = departmentDAO.inserMinordepartment(minordepartment);
		return i;
	}

	public Pagination showDepartmentandDoc(String doctorInfo_ID, String pageNum, int i) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int total = departmentDAO.getAllDepartmentandDoc(doctorInfo_ID);
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = departmentDAO.showDepartmentandDoc(doctorInfo_ID,pagination.getStartRow(),i);
		List<MinorDepartment> list = new ArrayList<MinorDepartment>();
		MinorDepartment minordepartment;
		while(rs.next()){
			minordepartment = new MinorDepartment();
			minordepartment.setID(rs.getInt("ID"));
			minordepartment.setMinordepartment_ID(rs.getString("minordepartment_ID"));
			minordepartment.setMinordepartment_name(rs.getString("minordepartment_name"));
			minordepartment.setMaindepartment_ID(rs.getString("maindepartment_ID"));
			list.add(minordepartment);
		}
		pagination.setList(list);
		return pagination;
	}

	public PaginationNew showDoctor(String hospital_ID,String minordepartment_ID,
			String pageNumNew, int i) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int total = departmentDAO.getDoctorBy(hospital_ID,minordepartment_ID);
		PaginationNew paginationNew = new PaginationNew(pageNumNew,total,i);
		ResultSet rs = departmentDAO.showDoctorByID(hospital_ID,minordepartment_ID,paginationNew.getStartRowNew(),i);
		List<DoctorBaseInfo> list = new ArrayList<DoctorBaseInfo>();
		DoctorBaseInfo doctorBaseInfo;
		InputStream inputStream = null;
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		while(rs.next()){
			doctorBaseInfo = new DoctorBaseInfo();
			doctorBaseInfo.setID(rs.getInt("ID"));
			doctorBaseInfo.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			doctorBaseInfo.setDoctorInfo_pwd(rs.getString("doctorInfo_pwd"));
			doctorBaseInfo.setDoctorInfo_name(rs.getString("doctorInfo_name"));
			doctorBaseInfo.setDoctorInfo_sex(rs.getInt("doctorInfo_sex"));
			doctorBaseInfo.setDoctorInfo_birthday(rs.getDate("doctorInfo_birthday"));
			doctorBaseInfo.setDoctorInfo_address(rs.getString("doctorInfo_address"));
			doctorBaseInfo.setDoctorInfo_record(rs.getString("doctorInfo_record"));
			doctorBaseInfo.setDoctorInfo_position(rs.getString("doctorInfo_position"));
			doctorBaseInfo.setDoctorInfo_phone(rs.getString("doctorInfo_phone"));
			doctorBaseInfo.setDoctorInfo_email(rs.getString("doctorInfo_email"));
			/*inputStream = rs.getBinaryStream("doctorInfo_photo");
			ImageUtil.readBlob(inputStream, realpath+"\\photo"+rs.getInt("ID")+".png");*/
			doctorBaseInfo.setDoctorInfo_photo(rs.getString("doctorInfo_photo"));
			doctorBaseInfo.setDoctorInfo_type(rs.getString("doctorInfo_typeName"));
			doctorBaseInfo.setDoctorInfo_disease(rs.getString("doctorInfo_disease"));
			doctorBaseInfo.setDoctorInfo_Oaddress(rs.getString("doctorInfo_Oaddress"));
			doctorBaseInfo.setState(rs.getString("state"));
			list.add(doctorBaseInfo);
		}
		paginationNew.setListNew(list);
		return paginationNew;
	}

	public List<MinorDepartment> findAllMinorByID(String doctorInfo_ID) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.getAllMinordepartmentByDocID(doctorInfo_ID);
		List<MinorDepartment> list = new ArrayList<MinorDepartment>();
		MinorDepartment minordepartment;
		while (rs.next()) {
			minordepartment = new MinorDepartment();
			minordepartment.setID(rs.getInt("ID"));
			minordepartment.setMinordepartment_ID(rs.getString("minordepartment_ID"));
			minordepartment.setMinordepartment_name(rs.getString("minordepartment_name"));
			minordepartment.setMaindepartment_ID(rs.getString("maindepartment_ID"));
			list.add(minordepartment);
		}
		return list;
	}

	public DepartmentDeploy findByDocID(String doctorInfo_ID) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.findByDocID(doctorInfo_ID);
		DepartmentDeploy departmentDeploy = new DepartmentDeploy();
		while (rs.next()) {
			departmentDeploy.setID(rs.getInt("ID"));
			departmentDeploy.setMinordepartment_ID(rs.getString("minordepartment_ID"));
			departmentDeploy.setDoctorInfo_ID(rs.getString("doctorInfo_ID"));
			departmentDeploy.setHospital_ID(rs.getString("hospital_ID"));
		}
		return departmentDeploy;
	}

	public int update(DepartmentDeploy departmentDeploy) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int i = departmentDAO.update(departmentDeploy);
		return i;
	}

	public MinorDepartment findMinorByID(String doctorInfo_ID) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.findMinorByID(doctorInfo_ID);
		MinorDepartment minordepartment = new MinorDepartment();
		while (rs.next()) {
			minordepartment.setMinordepartment_ID(rs.getString("minordepartment_ID"));
		}
		return minordepartment;
	}

	public int insertDepartmentDeploy(DepartmentDeploy departmentDeploy) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int i = departmentDAO.insertDepartmentDeploy(departmentDeploy);
		return i;
	}

	public int findDepartmentByHosID(String hospital_ID) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.findDepartmentByHosID(hospital_ID);
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	public int findDoctorByHosID(String hospital_ID) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.findDoctorByHosID(hospital_ID);
		int i = 0;
		while(rs.next()){
			i = rs.getInt(1);
		}
		return i;
	}

	public Pagination showALlMaindepartment(String pageNum, int i) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int total = departmentDAO.showALlMaindepartment();
		Pagination pagination = new Pagination(pageNum,total,i);
		ResultSet rs = departmentDAO.showALlMaindepartments(pagination.getStartRow(),i);
		List<MainDepartment> list = new ArrayList<MainDepartment>();
		MainDepartment mainDepartment;
		while(rs.next()){
			mainDepartment = new MainDepartment();
			mainDepartment.setID(rs.getInt("ID"));
			mainDepartment.setMaindepartment_ID(rs.getString("maindepartment_ID"));
			mainDepartment.setMaindepartment_name(rs.getString("maindepartment_name"));
			list.add(mainDepartment);
		}
		pagination.setList(list);
		return pagination;
	}

	public List<MinorDepartment> list(String doctorInfo_ID)  throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		ResultSet rs = departmentDAO.list(doctorInfo_ID);
		MinorDepartment minorDepartment;
		List<MinorDepartment> list = new ArrayList<MinorDepartment>();
		while (rs.next()) {
			minorDepartment = new MinorDepartment();
			minorDepartment.setMinordepartment_ID(rs.getString("minordepartment_ID"));
			minorDepartment.setMinordepartment_name(rs.getString("minordepartment_name"));
			list.add(minorDepartment);
		}
		return list;
	}

	public int deleteDepartment(String doctorInfo_ID) throws Exception{
		departmentDAO = new DepartmentDAOImpl();
		int i = departmentDAO.deleteDepartment(doctorInfo_ID);
		return i;
	}

}
