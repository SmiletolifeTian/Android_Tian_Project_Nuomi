package com.tianxinwei.project.nuomi.entity.home;

import java.io.Serializable;
import java.util.List;

import com.tianxinwei.project.nuomi.entity.home.Recommend;

public class HomeData implements Serializable{
	private static final long serialVersionUID = 4084244035811572597L;
	private String hotword;
	List<Banner> banners;
	List<Category> category;
	List<Special> special;
	List<Recommend> recommend;

	public String getHotword() {
		return hotword;
	}

	public void setHotword(String hotword) {
		this.hotword = hotword;
	}

	public List<Banner> getBanners() {
		return banners;
	}

	public void setBanners(List<Banner> banners) {
		this.banners = banners;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public List<Special> getSpecial() {
		return special;
	}

	public void setSpecial(List<Special> special) {
		this.special = special;
	}

	public List<Recommend> getRecommend() {
		return recommend;
	}

	public void setRecommend(List<Recommend> recommend) {
		this.recommend = recommend;
	}

}
