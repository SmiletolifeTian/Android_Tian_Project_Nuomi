package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class TuanDetailDataBuyContent implements Serializable{
	private static final long serialVersionUID = 1687012645366885569L;
	private int content_type;
	private String buy_content;
	private int have_buy_details;

	public int getContent_type() {
		return content_type;
	}

	public void setContent_type(int content_type) {
		this.content_type = content_type;
	}

	public String getBuy_content() {
		return buy_content;
	}

	public void setBuy_content(String buy_content) {
		this.buy_content = buy_content;
	}

	public int getHave_buy_details() {
		return have_buy_details;
	}

	public void setHave_buy_details(int have_buy_details) {
		this.have_buy_details = have_buy_details;
	}

}
