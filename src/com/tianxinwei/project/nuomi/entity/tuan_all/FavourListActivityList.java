package com.tianxinwei.project.nuomi.entity.tuan_all;

import java.io.Serializable;

public class FavourListActivityList implements Serializable {
	private static final long serialVersionUID = -1751419854895988480L;
	private String favour_id;
	private int type;
	private String name;
	private String icon;
	private String text;
	private int height;
	private int width;

	public String getFavour_id() {
		return favour_id;
	}

	public void setFavour_id(String favour_id) {
		this.favour_id = favour_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
