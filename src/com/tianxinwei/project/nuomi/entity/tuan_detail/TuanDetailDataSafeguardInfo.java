package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;


public class TuanDetailDataSafeguardInfo implements Serializable{
	private static final long serialVersionUID = -5315219383683695654L;
	private int icon_id;
	private String safeguard_name;
	private String safeguard_web;

	public int getIcon_id() {
		return icon_id;
	}

	public void setIcon_id(int icon_id) {
		this.icon_id = icon_id;
	}

	public String getSafeguard_name() {
		return safeguard_name;
	}

	public void setSafeguard_name(String safeguard_name) {
		this.safeguard_name = safeguard_name;
	}

	public String getSafeguard_web() {
		return safeguard_web;
	}

	public void setSafeguard_web(String safeguard_web) {
		this.safeguard_web = safeguard_web;
	}

}
