package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class TuanDetailDataMerchantBaseinfo implements Serializable{
	private static final long serialVersionUID = -6896975939645171999L;
	private int flag_shop;
	private String deal_id;
	private String city_id;
	private int shop_num;
	private MerchantBaseinfoSellerList seller_list;
	private String seller_id;
	private int have_content;

	public int getFlag_shop() {
		return flag_shop;
	}

	public void setFlag_shop(int flag_shop) {
		this.flag_shop = flag_shop;
	}

	public String getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public int getShop_num() {
		return shop_num;
	}

	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}

	public MerchantBaseinfoSellerList getSeller_list() {
		return seller_list;
	}

	public void setSeller_list(MerchantBaseinfoSellerList seller_list) {
		this.seller_list = seller_list;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public int getHave_content() {
		return have_content;
	}

	public void setHave_content(int have_content) {
		this.have_content = have_content;
	}

}
