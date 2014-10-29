package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;
import java.util.List;

import android.R.integer;

public class TuanDetailDataSeebuy implements Serializable{
	private static final long serialVersionUID = -4824886058209642937L;
	private List<SeebusyList> list;
	private int total;
	private int number;
	private String tuan_s;

	public List<SeebusyList> getList() {
		return list;
	}

	public void setList(List<SeebusyList> list) {
		this.list = list;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTuan_s() {
		return tuan_s;
	}

	public void setTuan_s(String tuan_s) {
		this.tuan_s = tuan_s;
	}

}
