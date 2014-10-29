package com.tianxinwei.project.nuomi.entity.home;

import java.io.Serializable;

public class CategoryKV implements Serializable{
	private static final long serialVersionUID = 7047506780206727481L;
	private String value;
	private String key;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
