package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class TuanDetailDataConsumerTips implements Serializable{
	private static final long serialVersionUID = -3723674947389923562L;
	private int consumer_type;
	private String consumer_tips;

	public int getConsumer_type() {
		return consumer_type;
	}

	public void setConsumer_type(int consumer_type) {
		this.consumer_type = consumer_type;
	}

	public String getConsumer_tips() {
		return consumer_tips;
	}

	public void setConsumer_tips(String consumer_tips) {
		this.consumer_tips = consumer_tips;
	}

}
