package com.tianxinwei.project.nuomi.entity.tuan_all;

import java.io.Serializable;

public class TuanDataCategoryFilterNum implements Serializable {
	private static final long serialVersionUID = -8695057299678049238L;
	private String filter_id;
	private int count;

	public String getFilter_id() {
		return filter_id;
	}

	public void setFilter_id(String filter_id) {
		this.filter_id = filter_id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
