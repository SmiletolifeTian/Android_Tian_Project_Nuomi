package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class CommentInfoExpressionLabel implements Serializable{
	private static final long serialVersionUID = 7327188756373265445L;
	private String category;
	private int num;
	private int type;
	private String desc;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
