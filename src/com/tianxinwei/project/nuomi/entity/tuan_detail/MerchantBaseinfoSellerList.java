package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class MerchantBaseinfoSellerList implements Serializable{
	private static final long serialVersionUID = 8802792660548265019L;
	private String seller_id;
	private String seller_name;
	private String seller_phone;
	private String seller_address;
	private String subway_distance;
	private String location_distance;
	private double lng;
	private double lat;

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public String getSeller_phone() {
		return seller_phone;
	}

	public void setSeller_phone(String seller_phone) {
		this.seller_phone = seller_phone;
	}

	public String getSeller_address() {
		return seller_address;
	}

	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
	}

	public String getSubway_distance() {
		return subway_distance;
	}

	public void setSubway_distance(String subway_distance) {
		this.subway_distance = subway_distance;
	}

	public String getLocation_distance() {
		return location_distance;
	}

	public void setLocation_distance(String location_distance) {
		this.location_distance = location_distance;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

}
