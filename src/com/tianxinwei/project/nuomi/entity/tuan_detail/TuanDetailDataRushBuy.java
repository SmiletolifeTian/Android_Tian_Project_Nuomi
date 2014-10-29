package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;


public class TuanDetailDataRushBuy implements Serializable{
	private static final long serialVersionUID = -5527134569079990820L;
	private long market_price;
	private long current_price;
	private int sell_status;
	private RushBuyFavourInfo favour_info;

	public long getMarket_price() {
		return market_price;
	}

	public void setMarket_price(long market_price) {
		this.market_price = market_price;
	}

	public long getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(long current_price) {
		this.current_price = current_price;
	}

	public int getSell_status() {
		return sell_status;
	}

	public void setSell_status(int sell_status) {
		this.sell_status = sell_status;
	}

	public RushBuyFavourInfo getFavour_info() {
		return favour_info;
	}

	public void setFavour_info(RushBuyFavourInfo favour_info) {
		this.favour_info = favour_info;
	}

}
