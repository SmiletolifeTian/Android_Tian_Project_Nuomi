package com.tianxinwei.project.nuomi.entity.tuan_like;

import java.util.List;

import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataTuanList;

public class TuanLikeData {
	private int tuan_num;
	private List<TuanLikeDataTuanList> tuan_list;

	public int getTuan_num() {
		return tuan_num;
	}

	public void setTuan_num(int tuan_num) {
		this.tuan_num = tuan_num;
	}

	public List<TuanLikeDataTuanList> getTuan_list() {
		return tuan_list;
	}

	public void setTuan_list(List<TuanLikeDataTuanList> tuan_list) {
		this.tuan_list = tuan_list;
	}

}
