package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;

public class SeebusyListPoi implements Serializable{
	private static final long serialVersionUID = -2269155519147165646L;
	private String distance;
	private String poiid;
	private double x;
	private double y;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getPoiid() {
		return poiid;
	}

	public void setPoiid(String poiid) {
		this.poiid = poiid;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
