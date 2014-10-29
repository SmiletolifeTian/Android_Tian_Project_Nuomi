package com.tianxinwei.project.nuomi.entity;

import android.graphics.Bitmap;

public class NearbyTuan {
	private String deal_id;
	private String image;
	private String brand_name;
	private String short_title;
	private long sale_count;
	private long groupon_price;
	private long market_price;
	private Bitmap bitmap;

	public String getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getShort_title() {
		return short_title;
	}

	public void setShort_title(String short_title) {
		this.short_title = short_title;
	}

	public long getSale_count() {
		return sale_count;
	}

	public void setSale_count(long sale_count) {
		this.sale_count = sale_count;
	}

	public long getGroupon_price() {
		return groupon_price;
	}

	public void setGroupon_price(long groupon_price) {
		this.groupon_price = groupon_price;
	}

	public long getMarket_price() {
		return market_price;
	}

	public void setMarket_price(long market_price) {
		this.market_price = market_price;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

}
