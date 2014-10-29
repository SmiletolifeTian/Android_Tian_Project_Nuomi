package com.tianxinwei.project.nuomi.task;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.tianxinwei.project.nuomi.adapter.TuanLikeAdapter;
import com.tianxinwei.project.nuomi.common.CommonImageHelper;
import com.tianxinwei.project.nuomi.common.CommonJSONHelper;
import com.tianxinwei.project.nuomi.common.CommonLoading;
import com.tianxinwei.project.nuomi.entity.tuan_all.FavourListActivityList;
import com.tianxinwei.project.nuomi.entity.tuan_all.FavourListHongBaoInfo;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanListFavourList;
import com.tianxinwei.project.nuomi.entity.tuan_like.TuanLike;
import com.tianxinwei.project.nuomi.entity.tuan_like.TuanLikeData;
import com.tianxinwei.project.nuomi.entity.tuan_like.TuanLikeDataTuanList;
import com.tianxinwei.project.nuomi.fragment.GrouponFragment.ViewHolder;

public class TuanLikeTask extends AsyncTask<String, Void, Void> {
	private Context context;
	private TuanLike tuanLike;
	private TuanLikeAdapter adapter;
	private CommonLoading commonLoading;
	private ViewHolder viewHolder;

	public TuanLikeTask(Context context, TuanLike tuanLike,
			TuanLikeAdapter adapter, ViewHolder viewHolder) {
		this.context = context;
		this.tuanLike = tuanLike;
		this.adapter = adapter;
		this.viewHolder = viewHolder;
	}

	@Override
	protected void onPreExecute() {
		viewHolder.layoutLoading.setVisibility(View.VISIBLE);
		commonLoading = new CommonLoading(viewHolder.imgLoading);
		commonLoading.startChangeImage();
	}

	@Override
	protected Void doInBackground(String... params) {
		try {
			String json = CommonJSONHelper.getJSON(params[0]);
			if (json != null && json.length() > 0) {
				JSONObject jsonObj = new JSONObject(json);
				parserTuanLike(jsonObj, tuanLike);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		if (tuanLike.getData() != null
				&& tuanLike.getData().getTuan_list().size() > 0) {
			adapter.notifyDataSetChanged();
		}
		commonLoading.stopChangeImage();
		viewHolder.layoutLoading.setVisibility(View.GONE);
		viewHolder.layoutContent.setVisibility(View.VISIBLE);
	}

	/**
	 * 解析TuanLike
	 * 
	 * @param obj
	 * @param tuanLike
	 * @throws JSONException
	 */
	private void parserTuanLike(JSONObject obj, TuanLike tuanLike)
			throws JSONException {
		tuanLike.setCached(obj.getInt("cached"));
		tuanLike.setErrmsg(obj.getString("errmsg"));
		tuanLike.setErrno(obj.getInt("errno"));
		tuanLike.setMsg(obj.getString("msg"));
		tuanLike.setServerlogid(obj.getLong("serverlogid"));
		tuanLike.setServerstatus(obj.getInt("serverstatus"));
		tuanLike.setTimestamp(obj.getLong("timestamp"));

		tuanLike.setData(parserData(obj.getJSONObject("data")));

	}

	/**
	 * 解析TuanLikeData
	 * 
	 * @param obj
	 * @return
	 * @throws JSONException
	 */
	private TuanLikeData parserData(JSONObject obj) throws JSONException {
		TuanLikeData tuanLikeData = new TuanLikeData();
		tuanLikeData.setTuan_num(obj.getInt("tuan_num"));
		tuanLikeData
				.setTuan_list(parserTuanList(obj.getJSONArray("tuan_list")));

		return tuanLikeData;
	}

	/**
	 * 解析TuanDataTuanList
	 * 
	 * @param array
	 * @return
	 * @throws JSONException
	 */
	private List<TuanLikeDataTuanList> parserTuanList(JSONArray array)
			throws JSONException {
		List<TuanLikeDataTuanList> list = new ArrayList<TuanLikeDataTuanList>();
		if (array != null && array.length() > 0) {
			JSONObject obj = null;
			TuanLikeDataTuanList tuanList = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				tuanList = new TuanLikeDataTuanList();
				tuanList.setAppoint(obj.getInt("appoint"));
				tuanList.setBought_weekly(obj.getInt("bought_weekly"));
				tuanList.setBought_weekly(obj.getInt("bought_weekly"));
				tuanList.setBrand_name(obj.getString("brand_name"));
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
				tuanList.setBitmap(CommonImageHelper.getBitmap(tuanList
						.getImage()));

				tuanList.setFavour_list(parserFavourList(obj
						.getJSONObject("favour_list")));
				list.add(tuanList);
			}
		}

		return list;
	}

	/**
	 * 解析TuanListFavourList
	 * 
	 * @param obj
	 * @return
	 * @throws JSONException
	 */
	private TuanListFavourList parserFavourList(JSONObject obj)
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
	private List<FavourListActivityList> parserActivityList(JSONArray array)
			throws JSONException {
		List<FavourListActivityList> list = new ArrayList<FavourListActivityList>();
		if (array != null && array.length() > 0) {
			JSONObject obj = null;
			FavourListActivityList activityList = null;
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
	 * @param array
	 * @return
	 * @throws JSONException
	 */
	private List<FavourListHongBaoInfo> parserHongbaoInfo(JSONArray array)
			throws JSONException {
		List<FavourListHongBaoInfo> list = new ArrayList<FavourListHongBaoInfo>();
		if (array != null && array.length() > 0) {
			JSONObject obj = null;
			FavourListHongBaoInfo hongBaoInfo = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				hongBaoInfo = new FavourListHongBaoInfo();

				list.add(hongBaoInfo);
			}
		}
		return list;
	}

}
