package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class HotRecommendList implements Serializable{
	private static final long serialVersionUID = 5575985766114653325L;
	private String deal_id;
	private long current_price;
	private long market_price;
	private String min_title;
	private String group_s;

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

	public String getGroup_s() {
		return group_s;
	}

	public void setGroup_s(String group_s) {
		this.group_s = group_s;
	}

}
