package com.dream.entity;

import java.util.List;

public class Page<T> {
	private int currentPage;// 当前页
	private int pageSize;// 每页显示的条数
	private int totalPage;// 总页数
	private List<T> list;// 分页的集合数据
	private String url;// 分页的跳转路径

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Page(int currentPage, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
