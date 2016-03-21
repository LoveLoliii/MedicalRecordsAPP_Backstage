package com.lua.javautil;


import java.util.List;

/**
 * 通用分页类
 * @author Administrator
 *
 */
public class PaginationNew {
	//当前页号
	private int pageNumNew;
	//记录总数
	private int rowCountNew;
	//数据内容
	private List listNew;
	//页面显示记录的个数
	private int sizeNew;
	//总页数
	private int pageCountNew;
	
	//本页起始记录
	private int startRowNew;
	
	//页号导航
	private int firstNew = 1;//第一页 页号
	private int lastNew;//最后页 页号
	private int previousNew;  //上一页
	private int nextNew;  //下一页
	
	private int startNavNew;  //导航起始页号
	private int endNavNew;  //导航结束页号
	private int navCountNew = 10;//页号式导航, 最多显示页号数量
	
	public  PaginationNew(String str_pageNumNew, int rowCountNew, int sizeNew){
		this.pageNumNew = (str_pageNumNew==null)?1:(Integer.parseInt(str_pageNumNew));
		this.rowCountNew = rowCountNew;
		this.sizeNew = sizeNew;
		
		this.pageCountNew  =  (int) Math.ceil((double)this.rowCountNew/this.sizeNew);
		this.pageNumNew  = Math.min(this.pageNumNew , pageCountNew);
		this.pageNumNew  = Math.max(1, this.pageNumNew);
		
		this.startRowNew = (this.pageNumNew-1) * sizeNew ;
		
		this.lastNew = this.pageCountNew;
		
		this.previousNew = Math.max(1 , this.pageNumNew-1);
		this.nextNew = Math.min( this.pageCountNew, this.pageNumNew+1);
		
		//导航处理
		this.startNavNew = (this.pageNumNew-navCountNew/2<1)?1:this.pageNumNew-navCountNew/2;
		this.endNavNew = this.startNavNew+this.navCountNew;
		this.endNavNew = Math.min(this.endNavNew, this.pageCountNew);
		
		if(this.endNavNew-this.startNavNew  < this.navCountNew){
			this.startNavNew = Math.max(this.endNavNew-this.navCountNew, 1);
		}
	}
	
	public PaginationNew() {
	}

	public int getPageNumNew() {
		return pageNumNew;
	}

	public void setPageNumNew(int pageNumNew) {
		this.pageNumNew = pageNumNew;
	}

	public int getRowCountNew() {
		return rowCountNew;
	}

	public void setRowCountNew(int rowCountNew) {
		this.rowCountNew = rowCountNew;
	}

	public List getListNew() {
		return listNew;
	}

	public void setListNew(List listNew) {
		this.listNew = listNew;
	}

	public int getSizeNew() {
		return sizeNew;
	}

	public void setSizeNew(int sizeNew) {
		this.sizeNew = sizeNew;
	}

	public int getPageCountNew() {
		return pageCountNew;
	}

	public void setPageCountNew(int pageCountNew) {
		this.pageCountNew = pageCountNew;
	}

	public int getStartRowNew() {
		return startRowNew;
	}

	public void setStartRowNew(int startRowNew) {
		this.startRowNew = startRowNew;
	}

	public int getFirstNew() {
		return firstNew;
	}

	public void setFirstNew(int firstNew) {
		this.firstNew = firstNew;
	}

	public int getLastNew() {
		return lastNew;
	}

	public void setLastNew(int lastNew) {
		this.lastNew = lastNew;
	}

	public int getPreviousNew() {
		return previousNew;
	}

	public void setPreviousNew(int previousNew) {
		this.previousNew = previousNew;
	}

	public int getNextNew() {
		return nextNew;
	}

	public void setNextNew(int nextNew) {
		this.nextNew = nextNew;
	}

	public int getStartNavNew() {
		return startNavNew;
	}

	public void setStartNavNew(int startNavNew) {
		this.startNavNew = startNavNew;
	}

	public int getEndNavNew() {
		return endNavNew;
	}

	public void setEndNavNew(int endNavNew) {
		this.endNavNew = endNavNew;
	}

	public int getNavCountNew() {
		return navCountNew;
	}

	public void setNavCountNew(int navCountNew) {
		this.navCountNew = navCountNew;
	}
	
}
