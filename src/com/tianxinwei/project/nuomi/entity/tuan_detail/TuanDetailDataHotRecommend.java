package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;
import java.util.List;

public class TuanDetailDataHotRecommend implements Serializable{
	private static final long serialVersionUID = 7432136205557215148L;
	private int total;
	private List<HotRecommendList> list;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<HotRecommendList> getList() {
		return list;
	}

	public void setList(List<HotRecommendList> list) {
		this.list = list;
	}

}
