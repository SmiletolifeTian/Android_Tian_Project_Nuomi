package com.tianxinwei.project.nuomi.entity;

import android.graphics.Bitmap;

public class DetailTuan {
	private String deal_id;
	private String business_title;
	private int current_price;
	private int market_price;
	private int sell_count;
	private String subtitle;
	private String image;
	private String min_image;
	private Bitmap bitmap;
	private Bitmap min_bitmap;

	public String getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}

	public String getBusiness_title() {
		return business_title;
	}

	public void setBusiness_title(String business_title) {
		this.business_title = business_title;
	}

	public int getCurrent_price() {
		return current_price;
	}

	public void setCurrent_price(int current_price) {
		this.current_price = current_price;
	}

	public int getMarket_price() {
		return market_price;
	}

	public void setMarket_price(int market_price) {
		this.market_price = market_price;
	}

	public int getSell_count() {
		return sell_count;
	}

	public void setSell_count(int sell_count) {
		this.sell_count = sell_count;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMin_image() {
		return min_image;
	}

	public void setMin_image(String min_image) {
		this.min_image = min_image;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public Bitmap getMin_bitmap() {
		return min_bitmap;
	}

	public void setMin_bitmap(Bitmap min_bitmap) {
		this.min_bitmap = min_bitmap;
	}

	
}
