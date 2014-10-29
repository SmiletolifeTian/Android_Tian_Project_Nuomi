package com.tianxinwei.project.nuomi.entity.home;

import java.io.Serializable;
import java.util.List;

import com.tianxinwei.project.nuomi.entity.home.CategoryKV;

import android.graphics.Bitmap;

public class Category implements Serializable{
	private static final long serialVersionUID = -1050518038487646348L;
	private String category_id;
	private String category_picurl;
	private String category_name;
	private String tiny_name;
	private int has_icon;
	private String icon_url;
	private List<CategoryKV> category;

	private Bitmap bitmap;

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_picurl() {
		return category_picurl;
	}

	public void setCategory_picurl(String category_picurl) {
		this.category_picurl = category_picurl;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getTiny_name() {
		return tiny_name;
	}

	public void setTiny_name(String tiny_name) {
		this.tiny_name = tiny_name;
	}

	public int getHas_icon() {
		return has_icon;
	}

	public void setHas_icon(int has_icon) {
		this.has_icon = has_icon;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	public List<CategoryKV> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryKV> category) {
		this.category = category;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

}
