package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class SeebusyList implements Serializable{
	private static final long serialVersionUID = -1898627957580827075L;
	private String deal_id;
	private long current_price;
	private long market_price;
	private String min_title;
	private String mid_image;
	private SeebusyListPoi poi;
	private String tuan_s;

	public String getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}

	public long getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(long current_price) {
		this.current_price = current_price;
	}

	public long getMarket_price() {
		return market_price;
	}

	public void setMarket_price(long market_price) {
		this.market_price = market_price;
	}

	public String getMin_title() {
		return min_title;
	}

	public void setMin_title(String min_title) {
		this.min_title = min_title;
	}

	public String getMid_image() {
		return mid_image;
	}

	public void setMid_image(String mid_image) {
		this.mid_image = mid_image;
	}

	public SeebusyListPoi getPoi() {
		return poi;
	}

	public void setPoi(SeebusyListPoi poi) {
		this.poi = poi;
	}

	public String getTuan_s() {
		return tuan_s;
	}

	public void setTuan_s(String tuan_s) {
		this.tuan_s = tuan_s;
	}

}
