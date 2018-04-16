package com.zheng.cpw.dao.model;

import java.util.List;

public class PageOnterModle {

	private int pageNum;// 当前页数
    private int pages;// 总页数
	private long total;// 总记录
	private List dataList;
	private boolean dataFla=false;

	public boolean isDataFla() {
		return dataFla;
	}

	public void setDataFla(boolean dataFla) {
		this.dataFla = dataFla;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}



	public static PageOnterModle getInstence(int pageNum, long total, int pageSize, List dataList){

		PageOnterModle modle = new PageOnterModle();
		modle.setPageNum(pageNum);
		modle.setDataList(dataList);
		if(null!=dataList&&dataList.size()>0){
			modle.setDataFla(true);
		}else{
			modle.setDataFla(false);
		}
		modle.setPages((int)(total/pageSize)+1);
		return modle;
	}


}