package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class TuanDetailDataMoreInfo implements Serializable {
	private static final long serialVersionUID = -8670661064778608027L;

	private String catg_ids;
	private String catg_name;
	private String last_catg_id;

	public String getCatg_ids() {
		return catg_ids;
	}

	public void setCatg_ids(String catg_ids) {
		this.catg_ids = catg_ids;
	}

	public String getCatg_name() {
		return catg_name;
	}

	public void setCatg_name(String catg_name) {
		this.catg_name = catg_name;
	}

	public String getLast_catg_id() {
		return last_catg_id;
	}

	public void setLast_catg_id(String last_catg_id) {
		this.last_catg_id = last_catg_id;
	}

}
