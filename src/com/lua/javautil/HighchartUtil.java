package com.lua.javautil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.lua.model.Num;

/**
 * @LUA www.guoao@foxmail.com:
 * @version 创建时间：2016年3月12日 下午10:25:53 类说明
 */
public class HighchartUtil {

	public List<Num> good(List<Num> list) {
		List<Num> listNums = new ArrayList<Num>();
		for (int i = 1; i < 13; i++) {
			Num _num = new Num(i, (float) 0);
			listNums.add(_num);
		}

		for (int i = 0; i < list.size(); i++) {
			Num num = list.get(i);
			switch (num.getMonth()) {
			case 1:
				addNum(listNums, num, num.getMonth());
				break;
			case 2:
				addNum(listNums, num, num.getMonth());
				break;
			case 3:
				addNum(listNums, num, num.getMonth());
				break;
			case 4:
				addNum(listNums, num, num.getMonth());
				break;
			case 5:
				addNum(listNums, num, num.getMonth());
				break;
			case 6:
				addNum(listNums, num, num.getMonth());
				break;
			case 7:
				addNum(listNums, num, num.getMonth());
				break;
			case 8:
				addNum(listNums, num, num.getMonth());
				break;
			case 9:
				addNum(listNums, num, num.getMonth());
				break;
			case 10:
				addNum(listNums, num, num.getMonth());
				break;
			case 11:
				addNum(listNums, num, num.getMonth());
				break;
			case 12:
				addNum(listNums, num, num.getMonth());
				break;
			default:
				break;
			}
		}
		return listNums;
	}

	private void addNum(List<Num> listNums, Num num1, int position) {
		listNums.set(position - 1, num1);
	}
	public void outJson(List list) throws IOException{
	ServletActionContext.getResponse().setContentType("text/xml;charset=utf-8");
	ServletActionContext.getResponse().setCharacterEncoding("UTF-8");  
	PrintWriter out = ServletActionContext.getResponse().getWriter();
	out.print(JSONArray.fromObject(list));  
	}
}
