package com.tianxinwei.project.nuomi.common;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tianxinwei.project.nuomi.entity.tuan_all.Count;
import com.tianxinwei.project.nuomi.entity.tuan_all.FavourListActivityList;
import com.tianxinwei.project.nuomi.entity.tuan_all.FavourListHongBaoInfo;
import com.tianxinwei.project.nuomi.entity.tuan_all.Tuan;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanData;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataAreaFilterNum;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataCategoryFilterNum;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataNosearchList;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataPoiList;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataTagsFilterNum;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataTuanList;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanListFavourList;

public class CommonParser {
	
	/**
	 * 解析Tuan
	 * 
	 * @param tuan
	 * @param tuanObject
	 * @throws JSONException
	 */
	public static void parserTuan(Tuan tuan, JSONObject tuanObject)
			throws JSONException {
		tuan.setCached(tuanObject.getInt("cached"));
		tuan.setErrmsg(tuanObject.getString("errmsg"));
		tuan.setErrno(tuanObject.getInt("errno"));
		tuan.setMsg(tuanObject.getString("msg"));
		tuan.setServerlogid(tuanObject.getLong("serverlogid"));
		tuan.setServerstatus(tuanObject.getInt("serverstatus"));
		tuan.setTimestamp(tuanObject.getLong("timestamp"));

		// 解析TuanData
		tuan.setData(parserTuanData(tuanObject.getJSONObject("data")));
	}

	/**
	 * 解析TuanData
	 * 
	 * @param jsonObject
	 * @return
	 * @throws JSONException
	 */
	private static TuanData parserTuanData(JSONObject dataObject) throws JSONException {
		TuanData data = new TuanData();

		data.setDistance(dataObject.getString("distance"));
		data.setHighlights(dataObject.getString("highlights"));
		data.setNosearch_num(dataObject.getInt("nosearch_num"));
		data.setPoi_num(dataObject.getInt("poi_num"));
		data.setRecomwd_id(dataObject.getString("recomwd_id"));
		data.setRecovery_type(dataObject.getInt("recovery_type"));
		data.setRecovery_words(dataObject.getString("recovery_words"));
		data.setTuan_more(dataObject.getInt("tuan_more"));
		data.setTuan_num(dataObject.getInt("tuan_num"));

		// 解析AreaFilterNum
		data.setArea_filter_num(parserAreaFilterNum(dataObject
				.getJSONArray("area_filter_num")));
		data.setCategory_filter_num(parserCategoryFilterNum(dataObject
				.getJSONArray("category_filter_num")));
		data.setNosearch_list(parserNosearchList(dataObject
				.getJSONArray("nosearch_list")));
		data.setPoi_list(parserPoiList(dataObject.getJSONArray("poi_list")));
		data.setTags_filter_num(parserTagsFilterNum(dataObject
				.getJSONArray("tags_filter_num")));
		data.setTuan_list(parserTuanList(dataObject.getJSONArray("tuan_list")));

		return data;
	}

	/* -------------------- AreaFilterNum -------------------- */

	/**
	 * 解析AreaFilterNum
	 * 
	 * @param jsonArray
	 * @return
	 * @throws JSONException
	 */
	private static List<TuanDataAreaFilterNum> parserAreaFilterNum(JSONArray array)
			throws JSONException {
		List<TuanDataAreaFilterNum> list = new ArrayList<TuanDataAreaFilterNum>();

		if (array != null && array.length() > 0) {
			TuanDataAreaFilterNum filterNum = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				filterNum = new TuanDataAreaFilterNum();
				filterNum.setKey(obj.getString("key"));
				// 解析Count
				filterNum.setCount(parserCount(obj.getJSONArray("count")));
				list.add(filterNum);
			}
		}

		return list;
	}

	/**
	 * 解析Count
	 * 
	 * @param array
	 * @return
	 * @throws JSONException
	 */
	private static List<Count> parserCount(JSONArray array) throws JSONException {
		List<Count> list = new ArrayList<Count>();

		if (array != null && array.length() > 0) {
			Count count = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				count = new Count();
				count.setCount(obj.getInt("count"));
				count.setFilter_id(obj.getString("filter_id"));
				list.add(count);
			}
		}

		return list;
	}

	/* -------------------- AreaFilterNum -------------------- */

	/* -------------------- CategoryFilterNum -------------------- */

	/**
	 * 解析CategoryFilterNum
	 * 
	 * @param array
	 * @return
	 * @throws JSONException
	 */
	private static List<TuanDataCategoryFilterNum> parserCategoryFilterNum(
			JSONArray array) throws JSONException {
		List<TuanDataCategoryFilterNum> list = new ArrayList<TuanDataCategoryFilterNum>();

		if (array != null && array.length() > 0) {
			TuanDataCategoryFilterNum filterNum = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				filterNum = new TuanDataCategoryFilterNum();
				filterNum.setCount(obj.getInt("count"));
				filterNum.setFilter_id(obj.getString("filter_id"));
				list.add(filterNum);
			}
		}

		return list;
	}

	/* -------------------- CategoryFilterNum -------------------- */

	/* -------------------- NosearchList -------------------- */

	/**
	 * NosearchList
	 * 
	 * @param jsonArray
	 * @return
	 * @throws JSONException
	 */
	private static List<TuanDataNosearchList> parserNosearchList(JSONArray array)
			throws JSONException {
		List<TuanDataNosearchList> list = new ArrayList<TuanDataNosearchList>();

		if (array != null && array.length() > 0) {
			TuanDataNosearchList nosearchList = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				nosearchList = new TuanDataNosearchList();
				list.add(nosearchList);
			}
		}

		return list;
	}

	/* -------------------- NosearchList -------------------- */

	/* -------------------- PoiList -------------------- */

	/**
	 * 解析PoiList
	 * 
	 * @param jsonArray
	 * @return
	 * @throws JSONException
	 */
	private static List<TuanDataPoiList> parserPoiList(JSONArray array)
			throws JSONException {
		List<TuanDataPoiList> list = new ArrayList<TuanDataPoiList>();

		if (array != null && array.length() > 0) {
			TuanDataPoiList poiList = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				poiList = new TuanDataPoiList();
				poiList.setBizarea_title(obj.getString("bizarea_title"));
				poiList.setLat(obj.getLong("lat"));
				poiList.setLng(obj.getLong("lng"));
				poiList.setPoi_distance(obj.getString("poi_distance"));
				poiList.setPoi_name(obj.getString("poi_name"));
				poiList.setTuan_more(obj.getInt("tuan_more"));
				poiList.setTuan_num(obj.getInt("tuan_num"));
				
				poiList.setTuan_list(parserTuanList(obj.getJSONArray("tuan_list")));
				
				list.add(poiList);
			}
		}

		return list;
	}

	/* -------------------- PoiList -------------------- */

	/* -------------------- TagsFilterNum -------------------- */

	/**
	 * 解析TagsFilterNum
	 * 
	 * @param jsonArray
	 * @return
	 * @throws JSONException
	 */
	private static List<TuanDataTagsFilterNum> parserTagsFilterNum(JSONArray array)
			throws JSONException {
		List<TuanDataTagsFilterNum> list = new ArrayList<TuanDataTagsFilterNum>();

		if (array != null && array.length() > 0) {
			TuanDataTagsFilterNum filterNum = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				filterNum = new TuanDataTagsFilterNum();
				filterNum.setCount(obj.getInt("count"));
				filterNum.setFilter_id(obj.getString("filter_id"));
				list.add(filterNum);
			}
		}

		return list;
	}

	/* -------------------- TagsFilterNum -------------------- */

	/* -------------------- TuanList -------------------- */

	/**
	 * 解析TuanList
	 * 
	 * @param jsonArray
	 * @return
	 * @throws JSONException
	 */
	private static List<TuanDataTuanList> parserTuanList(JSONArray array)
			throws JSONException {
		List<TuanDataTuanList> list = new ArrayList<TuanDataTuanList>();

		if (array != null && array.length() > 0) {
			TuanDataTuanList tuanList = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				tuanList = new TuanDataTuanList();
				tuanList.setAppoint(obj.getInt("appoint"));
				tuanList.setBrand_name(obj.getString("brand_name"));
				tuanList.setBizarea(obj.getString("bizarea"));
				tuanList.setBought_weekly(obj.getInt("bought_weekly"));
				tuanList.setComment_num(obj.getInt("comment_num"));
				tuanList.setDeal_id(obj.getString("deal_id"));
				tuanList.setDistance(obj.getString("distance"));
				tuanList.setGroupon_price(obj.getLong("groupon_price"));
				tuanList.setGroupon_type(obj.getInt("groupon_type"));
				tuanList.setIfvirtual(obj.getInt("ifvirtual"));
				tuanList.setImage(obj.getString("image"));
				tuanList.setIs_flash(obj.getInt("is_flash"));
				tuanList.setIs_latest(obj.getInt("is_latest"));
				tuanList.setMarket_price(obj.getLong("market_price"));
				tuanList.setNew_groupon(obj.getInt("new_groupon"));
				tuanList.setPay_end_time(obj.getLong("pay_end_time"));
				tuanList.setPay_start_time(obj.getLong("pay_start_time"));
				tuanList.setReason(obj.getString("reason"));
				tuanList.setS(obj.getString("s"));
				tuanList.setSale_count(obj.getLong("sale_count"));
				tuanList.setSale_out(obj.getInt("sale_out"));
				tuanList.setScore(obj.getDouble("score"));
				tuanList.setShort_title(obj.getString("short_title"));
				tuanList.setVirtual_redirect_url(obj
						.getString("virtual_redirect_url"));
				tuanList.setBitmap(CommonBitmapHelper.getBitmap(tuanList.getImage()));

				tuanList.setFavour_list(parserFavourList(obj
						.getJSONObject("favour_list")));
				list.add(tuanList);
				
			}
		}

		return list;
	}

	/**
	 * 解析FavourList
	 * 
	 * @param jsonObject
	 * @return
	 * @throws JSONException
	 */
	private static TuanListFavourList parserFavourList(JSONObject obj)
			throws JSONException {
		TuanListFavourList favourList = new TuanListFavourList();

		favourList.setDeal_id(obj.getString("deal_id"));
		favourList.setList_text(obj.getString("list_text"));
		favourList.setPrice(obj.getLong("price"));
		favourList.setPrice_tag_id(obj.getString("price_tag_id"));
		favourList.setReductionAmount(obj.getInt("reductionAmount"));

		favourList.setActivityList(parserActivityList(obj
				.getJSONArray("activityList")));
		favourList.setHongbao_info(parserHongbaoInfo(obj
				.getJSONArray("hongbao_info")));

		return favourList;
	}

	/**
	 * 解析FavourListActivityList
	 * 
	 * @param jsonArray
	 * @return
	 * @throws JSONException
	 */
	private static List<FavourListActivityList> parserActivityList(JSONArray array)
			throws JSONException {
		List<FavourListActivityList> list = new ArrayList<FavourListActivityList>();

		if (array != null && array.length() > 0) {
			FavourListActivityList activityList = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				activityList = new FavourListActivityList();
				activityList.setFavour_id(obj.getString("favour_id"));
				activityList.setHeight(obj.getInt("height"));
				activityList.setIcon(obj.getString("icon"));
				activityList.setName(obj.getString("name"));
				activityList.setText(obj.getString("text"));
				activityList.setType(obj.getInt("type"));
				activityList.setWidth(obj.getInt("width"));
				list.add(activityList);
			}
		}

		return list;
	}

	/**
	 * 解析FavourListHongBaoInfo
	 * 
	 * @param jsonArray
	 * @return
	 * @throws JSONException
	 */
	private static List<FavourListHongBaoInfo> parserHongbaoInfo(JSONArray array)
			throws JSONException {
		List<FavourListHongBaoInfo> list = new ArrayList<FavourListHongBaoInfo>();

		if (array != null && array.length() > 0) {
			FavourListHongBaoInfo info = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				info = new FavourListHongBaoInfo();
				list.add(info);
			}
		}

		return list;
	}

	/* -------------------- TuanList -------------------- */

}
