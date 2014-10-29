package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;
import java.util.List;

import com.tianxinwei.project.nuomi.entity.tuan_all.FavourListHongBaoInfo;

import android.R.integer;

public class RushBuyFavourInfo implements Serializable {
	private static final long serialVersionUID = -80224064088888737L;
	private long favour_price;
	private List<String> text;
	private String type;
	private String favour_id;
	private String favour_icon;
	private List<FavourListHongBaoInfo> hongbao_info;

	public long getFavour_price() {
		return favour_price;
	}

	public void setFavour_price(long favour_price) {
		this.favour_price = favour_price;
	}

	public List<String> getText() {
		return text;
	}

	public void setText(List<String> text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFavour_id() {
		return favour_id;
	}

	public void setFavour_id(String favour_id) {
		this.favour_id = favour_id;
	}

	public String getFavour_icon() {
		return favour_icon;
	}

	public void setFavour_icon(String favour_icon) {
		this.favour_icon = favour_icon;
	}

	public List<FavourListHongBaoInfo> getHongbao_info() {
		return hongbao_info;
	}

	public void setHongbao_info(List<FavourListHongBaoInfo> hongbao_info) {
		this.hongbao_info = hongbao_info;
	}

}
