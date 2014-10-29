package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;
import java.util.List;

import android.R.integer;

public class TuanDetailData implements Serializable {
	private static final long serialVersionUID = -1082252149409174300L;
	private String deal_id;
	private int deal_type;
	private TuanDetailDataRushBuy rush_buy;
	private TuanDetailDataTitleAbout title_about;
	private List<TuanDetailDataSafeguardInfo> safeguard_info;
	private TuanDetailDataNotice notice;
	private TuanDetailDataBuyContent buy_content;
	private TuanDetailDataConsumerTips consumer_tips;
	private TuanDetailDataMoreInfo more_info;
	private TuanDetailDataSeebuy seebuy;
	private int have_store;
	private TuanDetailDataCommentInfo comment_info;
	private TuanDetailDataMerchantBaseinfo merchant_baseinfo;
	private TuanDetailDataMerchantPhone merchant_phone;
	private TuanDetailDataHotRecommend hot_recommend;

	public String getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(String deal_id) {
		this.deal_id = deal_id;
	}

	public int getDeal_type() {
		return deal_type;
	}

	public void setDeal_type(int deal_type) {
		this.deal_type = deal_type;
	}

	public TuanDetailDataRushBuy getRush_buy() {
		return rush_buy;
	}

	public void setRush_buy(TuanDetailDataRushBuy rush_buy) {
		this.rush_buy = rush_buy;
	}

	public TuanDetailDataTitleAbout getTitle_about() {
		return title_about;
	}

	public void setTitle_about(TuanDetailDataTitleAbout title_about) {
		this.title_about = title_about;
	}

	public List<TuanDetailDataSafeguardInfo> getSafeguard_info() {
		return safeguard_info;
	}

	public void setSafeguard_info(
			List<TuanDetailDataSafeguardInfo> safeguard_info) {
		this.safeguard_info = safeguard_info;
	}

	public TuanDetailDataNotice getNotice() {
		return notice;
	}

	public void setNotice(TuanDetailDataNotice notice) {
		this.notice = notice;
	}

	public TuanDetailDataBuyContent getBuy_content() {
		return buy_content;
	}

	public void setBuy_content(TuanDetailDataBuyContent buy_content) {
		this.buy_content = buy_content;
	}

	public TuanDetailDataConsumerTips getConsumer_tips() {
		return consumer_tips;
	}

	public void setConsumer_tips(TuanDetailDataConsumerTips consumer_tips) {
		this.consumer_tips = consumer_tips;
	}

	public TuanDetailDataMoreInfo getMore_info() {
		return more_info;
	}

	public void setMore_info(TuanDetailDataMoreInfo more_info) {
		this.more_info = more_info;
	}

	public TuanDetailDataSeebuy getSeebuy() {
		return seebuy;
	}

	public void setSeebuy(TuanDetailDataSeebuy seebuy) {
		this.seebuy = seebuy;
	}

	public int getHave_store() {
		return have_store;
	}

	public void setHave_store(int have_store) {
		this.have_store = have_store;
	}

	public TuanDetailDataCommentInfo getComment_info() {
		return comment_info;
	}

	public void setComment_info(TuanDetailDataCommentInfo comment_info) {
		this.comment_info = comment_info;
	}

	public TuanDetailDataMerchantBaseinfo getMerchant_baseinfo() {
		return merchant_baseinfo;
	}

	public void setMerchant_baseinfo(
			TuanDetailDataMerchantBaseinfo merchant_baseinfo) {
		this.merchant_baseinfo = merchant_baseinfo;
	}

	public TuanDetailDataMerchantPhone getMerchant_phone() {
		return merchant_phone;
	}

	public void setMerchant_phone(TuanDetailDataMerchantPhone merchant_phone) {
		this.merchant_phone = merchant_phone;
	}

	public TuanDetailDataHotRecommend getHot_recommend() {
		return hot_recommend;
	}

	public void setHot_recommend(TuanDetailDataHotRecommend hot_recommend) {
		this.hot_recommend = hot_recommend;
	}

}
