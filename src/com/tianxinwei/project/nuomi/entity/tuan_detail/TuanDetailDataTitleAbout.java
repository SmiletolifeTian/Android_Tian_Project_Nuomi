package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;
import java.util.List;

public class TuanDetailDataTitleAbout implements Serializable{
	private static final long serialVersionUID = 7562545125926665070L;
	private List<String> image;
	private String min_image;
	private String business_title;
	private String subtitle;
	private long remain_time;
	private long sell_count;
	private int special_mark;
	private String tinyurl;

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String getMin_image() {
		return min_image;
	}

	public void setMin_image(String min_image) {
		this.min_image = min_image;
	}

	public String getBusiness_title() {
		return business_title;
	}

	public void setBusiness_title(String business_title) {
		this.business_title = business_title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public long getRemain_time() {
		return remain_time;
	}

	public void setRemain_time(long remain_time) {
		this.remain_time = remain_time;
	}

	public long getSell_count() {
		return sell_count;
	}

	public void setSell_count(long sell_count) {
		this.sell_count = sell_count;
	}

	public int getSpecial_mark() {
		return special_mark;
	}

	public void setSpecial_mark(int special_mark) {
		this.special_mark = special_mark;
	}

	public String getTinyurl() {
		return tinyurl;
	}

	public void setTinyurl(String tinyurl) {
		this.tinyurl = tinyurl;
	}

}
