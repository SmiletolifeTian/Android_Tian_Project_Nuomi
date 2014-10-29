package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class TuanDetailDataMerchantPhone implements Serializable {
	private static final long serialVersionUID = 2372128279791976085L;

	private String seller_id;
	private String phone_number;

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

}
