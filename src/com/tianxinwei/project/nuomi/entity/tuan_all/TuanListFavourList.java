package com.tianxinwei.project.nuomi.entity.tuan_all;

import java.io.Serializable;
import java.util.List;

public class TuanListFavourList implements Serializable {
	private static final long serialVersionUID = -1066986716448115374L;
	private String deal_id;
	private int reductionAmount;
	private long price;
	private List<FavourListActivityList> activityList;
	private String list_text;
	private List<FavourListHongBaoInfo> hongbao_info;
	private String price_tag_id;

	public String getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}

	public int getReductionAmount() {
		return reductionAmount;
	}

	public void setReductionAmount(int reductionAmount) {
		this.reductionAmount = reductionAmount;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public List<FavourListActivityList> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<FavourListActivityList> activityList) {
		this.activityList = activityList;
	}

	public String getList_text() {
		return list_text;
	}

	public void setList_text(String list_text) {
		this.list_text = list_text;
	}

	public List<FavourListHongBaoInfo> getHongbao_info() {
		return hongbao_info;
	}

	public void setHongbao_info(List<FavourListHongBaoInfo> hongbao_info) {
		this.hongbao_info = hongbao_info;
	}

	public String getPrice_tag_id() {
		return price_tag_id;
	}

	public void setPrice_tag_id(String price_tag_id) {
		this.price_tag_id = price_tag_id;
	}
}
