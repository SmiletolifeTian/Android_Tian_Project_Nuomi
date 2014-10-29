package com.tianxinwei.project.nuomi.entity.tuan_all;

import java.io.Serializable;
import java.util.List;

public class TuanDataPoiList implements Serializable {
	private static final long serialVersionUID = 6141137435332980515L;
	private String poi_name;
	private String poi_distance;
	private long lat;
	private long lng;
	private String bizarea_title;
	private int tuan_more;
	private List<TuanDataTuanList> tuan_list;
	private int tuan_num;

	public String getPoi_name() {
		return poi_name;
	}

	public void setPoi_name(String poi_name) {
		this.poi_name = poi_name;
	}

	public String getPoi_distance() {
		return poi_distance;
	}

	public void setPoi_distance(String poi_distance) {
		this.poi_distance = poi_distance;
	}

	public long getLat() {
		return lat;
	}

	public void setLat(long lat) {
		this.lat = lat;
	}

	public long getLng() {
		return lng;
	}

	public void setLng(long lng) {
		this.lng = lng;
	}

	public String getBizarea_title() {
		return bizarea_title;
	}

	public void setBizarea_title(String bizarea_title) {
		this.bizarea_title = bizarea_title;
	}

	public int getTuan_more() {
		return tuan_more;
	}

	public void setTuan_more(int tuan_more) {
		this.tuan_more = tuan_more;
	}

	public List<TuanDataTuanList> getTuan_list() {
		return tuan_list;
	}

	public void setTuan_list(List<TuanDataTuanList> tuan_list) {
		this.tuan_list = tuan_list;
	}

	public int getTuan_num() {
		return tuan_num;
	}

	public void setTuan_num(int tuan_num) {
		this.tuan_num = tuan_num;
	}

}
