package com.tianxinwei.project.nuomi.entity.tuan_all;

import java.io.Serializable;
import java.util.List;

public class TuanData implements Serializable {
	private static final long serialVersionUID = 3340021678765634423L;
	private List<TuanDataCategoryFilterNum> category_filter_num;
	private List<TuanDataAreaFilterNum> area_filter_num;
	private List<TuanDataTagsFilterNum> tags_filter_num;
	private int tuan_num;
	private List<TuanDataTuanList> tuan_list;
	private int poi_num;
	private List<TuanDataPoiList> poi_list;
	private String distance;
	private int nosearch_num;
	private List<TuanDataNosearchList> nosearch_list;
	private String recovery_words;
	private int recovery_type;
	private String highlights;
	private int tuan_more;
	private String recomwd_id;

	public List<TuanDataCategoryFilterNum> getCategory_filter_num() {
		return category_filter_num;
	}

	public void setCategory_filter_num(
			List<TuanDataCategoryFilterNum> category_filter_num) {
		this.category_filter_num = category_filter_num;
	}

	public List<TuanDataAreaFilterNum> getArea_filter_num() {
		return area_filter_num;
	}

	public void setArea_filter_num(List<TuanDataAreaFilterNum> area_filter_num) {
		this.area_filter_num = area_filter_num;
	}

	public List<TuanDataTagsFilterNum> getTags_filter_num() {
		return tags_filter_num;
	}

	public void setTags_filter_num(List<TuanDataTagsFilterNum> tags_filter_num) {
		this.tags_filter_num = tags_filter_num;
	}

	public int getTuan_num() {
		return tuan_num;
	}

	public void setTuan_num(int tuan_num) {
		this.tuan_num = tuan_num;
	}

	public List<TuanDataTuanList> getTuan_list() {
		return tuan_list;
	}

	public void setTuan_list(List<TuanDataTuanList> tuan_list) {
		this.tuan_list = tuan_list;
	}

	public int getPoi_num() {
		return poi_num;
	}

	public void setPoi_num(int poi_num) {
		this.poi_num = poi_num;
	}

	public List<TuanDataPoiList> getPoi_list() {
		return poi_list;
	}

	public void setPoi_list(List<TuanDataPoiList> poi_list) {
		this.poi_list = poi_list;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getNosearch_num() {
		return nosearch_num;
	}

	public void setNosearch_num(int nosearch_num) {
		this.nosearch_num = nosearch_num;
	}

	public List<TuanDataNosearchList> getNosearch_list() {
		return nosearch_list;
	}

	public void setNosearch_list(List<TuanDataNosearchList> nosearch_list) {
		this.nosearch_list = nosearch_list;
	}

	public String getRecovery_words() {
		return recovery_words;
	}

	public void setRecovery_words(String recovery_words) {
		this.recovery_words = recovery_words;
	}

	public int getRecovery_type() {
		return recovery_type;
	}

	public void setRecovery_type(int recovery_type) {
		this.recovery_type = recovery_type;
	}

	public String getHighlights() {
		return highlights;
	}

	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}

	public int getTuan_more() {
		return tuan_more;
	}

	public void setTuan_more(int tuan_more) {
		this.tuan_more = tuan_more;
	}

	public String getRecomwd_id() {
		return recomwd_id;
	}

	public void setRecomwd_id(String recomwd_id) {
		this.recomwd_id = recomwd_id;
	}
}
