package com.tianxinwei.project.nuomi.entity.tuan_all;

import java.io.Serializable;
import java.util.List;

public class TuanDataAreaFilterNum implements Serializable {
	private static final long serialVersionUID = -4219420375629255880L;
	private String key;
	private List<Count> count;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Count> getCount() {
		return count;
	}

	public void setCount(List<Count> count) {
		this.count = count;
	}
}
