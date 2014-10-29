package com.tianxinwei.project.nuomi.entity.tuan_like;

import java.io.Serializable;

import android.graphics.Bitmap;

import com.tianxinwei.project.nuomi.entity.tuan_all.TuanListFavourList;

public class TuanLikeDataTuanList implements Serializable {
	private static final long serialVersionUID = -8217267766797592425L;
	private String deal_id;
	private String image;
	private String brand_name;
	private String short_title;
	private long sale_count;
	private long groupon_price;
	private long market_price;
	private long pay_start_time;
	private long pay_end_time;
	private int new_groupon;
	private int sale_out;
	private int groupon_type;
	private double score;
	private int comment_num;
	private int bought_weekly;
	private String reason;
	private TuanListFavourList favour_list;
	private String distance;
	private int appoint;
	private int is_flash;
	private String s;
	private int ifvirtual;
	private String virtual_redirect_url;
	private int is_latest;

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

	public long getPay_start_time() {
		return pay_start_time;
	}

	public void setPay_start_time(long pay_start_time) {
		this.pay_start_time = pay_start_time;
	}

	public long getPay_end_time() {
		return pay_end_time;
	}

	public void setPay_end_time(long pay_end_time) {
		this.pay_end_time = pay_end_time;
	}

	public int getNew_groupon() {
		return new_groupon;
	}

	public void setNew_groupon(int new_groupon) {
		this.new_groupon = new_groupon;
	}

	public int getSale_out() {
		return sale_out;
	}

	public void setSale_out(int sale_out) {
		this.sale_out = sale_out;
	}

	public int getGroupon_type() {
		return groupon_type;
	}

	public void setGroupon_type(int groupon_type) {
		this.groupon_type = groupon_type;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public int getBought_weekly() {
		return bought_weekly;
	}

	public void setBought_weekly(int bought_weekly) {
		this.bought_weekly = bought_weekly;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public TuanListFavourList getFavour_list() {
		return favour_list;
	}

	public void setFavour_list(TuanListFavourList favour_list) {
		this.favour_list = favour_list;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getAppoint() {
		return appoint;
	}

	public void setAppoint(int appoint) {
		this.appoint = appoint;
	}

	public int getIs_flash() {
		return is_flash;
	}

	public void setIs_flash(int is_flash) {
		this.is_flash = is_flash;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getIfvirtual() {
		return ifvirtual;
	}

	public void setIfvirtual(int ifvirtual) {
		this.ifvirtual = ifvirtual;
	}

	public String getVirtual_redirect_url() {
		return virtual_redirect_url;
	}

	public void setVirtual_redirect_url(String virtual_redirect_url) {
		this.virtual_redirect_url = virtual_redirect_url;
	}

	public int getIs_latest() {
		return is_latest;
	}

	public void setIs_latest(int is_latest) {
		this.is_latest = is_latest;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

}
