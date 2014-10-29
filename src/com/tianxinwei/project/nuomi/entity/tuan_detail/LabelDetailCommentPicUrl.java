package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class LabelDetailCommentPicUrl implements Serializable{
	private static final long serialVersionUID = 3312366006487892520L;
	private String tinyPicUrl;
	private String bigPicUrl;

	public String getTinyPicUrl() {
		return tinyPicUrl;
	}

	public void setTinyPicUrl(String tinyPicUrl) {
		this.tinyPicUrl = tinyPicUrl;
	}

	public String getBigPicUrl() {
		return bigPicUrl;
	}

	public void setBigPicUrl(String bigPicUrl) {
		this.bigPicUrl = bigPicUrl;
	}

}
