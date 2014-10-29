package com.tianxinwei.project.nuomi.task;

import java.text.DecimalFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.google.gson.Gson;
import com.tianxinwei.project.nuomi.activity.TuanDetailActivity.ViewHolder;
import com.tianxinwei.project.nuomi.common.CommonBitmapHelper;
import com.tianxinwei.project.nuomi.common.CommonDialog;
import com.tianxinwei.project.nuomi.common.CommonJSONHelper;
import com.tianxinwei.project.nuomi.entity.DetailTuan;
import com.tianxinwei.project.nuomi.entity.tuan_detail.FavourInfoText;
import com.tianxinwei.project.nuomi.entity.tuan_detail.TuanDetail;

public class TuanDetailTask extends AsyncTask<String, Void, Void> {
	private DecimalFormat df = new DecimalFormat("#.00");
	private Context context;
	private TuanDetail detailTuan;
	private DetailTuan detailData;
	private ViewHolder viewHolder;
	private GetTuanDetailCallback getTuanDetailCallback;

	public TuanDetailTask(Context context,
			DetailTuan detailData, ViewHolder viewHolder,GetTuanDetailCallback getTuanDetailCallback) {
		this.context = context;
		this.viewHolder = viewHolder;
		this.detailData = detailData;
		this.getTuanDetailCallback = getTuanDetailCallback;
	}

	@Override
	protected void onPreExecute() {
		CommonDialog.showProgressDialog(context, "请稍候。。。");
	}

	@Override
	protected Void doInBackground(String... params) {
		try {

			String json = CommonJSONHelper.getJSON(params[0]);
			Gson gson = new Gson();
			detailTuan = gson.fromJson(json, TuanDetail.class);

			JSONObject jsonObj = new JSONObject(json);
			JSONObject jsonData = jsonObj.getJSONObject("data");
			detailData.setDeal_id(jsonData.getString("deal_id"));

			JSONObject jsonRushBuy = jsonData.getJSONObject("rush_buy");
			detailData.setCurrent_price(jsonRushBuy.getInt("current_price"));
			detailData.setMarket_price(jsonRushBuy.getInt("market_price"));

			JSONObject jsonTitleAbout = jsonData.getJSONObject("title_about");
			JSONArray arrayImg = jsonTitleAbout.getJSONArray("image");

			detailData.setImage(arrayImg.getString(0));
			detailData.setMin_image(jsonTitleAbout.getString("min_image"));
			detailData.setBusiness_title(jsonTitleAbout
					.getString("business_title"));
			detailData.setSubtitle(jsonTitleAbout.getString("subtitle"));
			detailData.setSell_count(jsonTitleAbout.getInt("sell_count"));
			detailData.setBitmap(CommonBitmapHelper.getBitmap(detailData
					.getImage()));

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		viewHolder.imgTuPian.setImageBitmap(detailData.getBitmap());
		viewHolder.txGrouponPrice.setText(df.format(detailData
				.getCurrent_price() / 100.0));
		viewHolder.txMarketPrice
				.setText(df.format(detailData.getMarket_price() / 100.0));

		viewHolder.txBusinessTitle.setText(detailTuan.getData()
				.getTitle_about().getBusiness_title());
		if (detailTuan.getData().getRush_buy().getFavour_info().getText() != null
				&& detailTuan.getData().getRush_buy().getFavour_info()
						.getText().size() > 0) {
			viewHolder.txFavourInfo.setVisibility(View.VISIBLE);

			StringBuffer sb = new StringBuffer();
			for (String infoText : detailTuan.getData().getRush_buy().getFavour_info().getText()) {
				sb.append(infoText);
			}
			viewHolder.txFavourInfo.setText(sb.toString());
		}
		viewHolder.txRemainTime.setText(getRemainTimeString(detailTuan.getData().getTitle_about().getRemain_time()));
		viewHolder.txSellCount.setText(String.format("已售%d", detailTuan.getData().getTitle_about().getSell_count()));
		viewHolder.txSellerAddress.setText(detailTuan.getData().getMerchant_baseinfo().getSeller_list().getSeller_address());
		viewHolder.txSellerName.setText(detailTuan.getData().getMerchant_baseinfo().getSeller_list().getSeller_name());
		viewHolder.txShopNum.setText(String.format("%d家分店", detailTuan.getData().getMerchant_baseinfo().getShop_num()));
		viewHolder.txSubtitle.setText(detailTuan.getData().getTitle_about().getSubtitle());
		
		getTuanDetailCallback.getTuanDetail(detailTuan);
		CommonDialog.hideProgressDialog();
	}

	private String getRemainTimeString(long time) {
		int day = 0;
		int hour = 0;
		int min = 0;
		if (time >= 86400) {
			day = (int) (time / 86400);
			time = (int) (time % 86400);

		}

		if (time >= 3600) {
			hour = (int) (time / 3600);
			time %= 3600;
		}

		if (time >= 60) {
			min = (int) (time / 60);
			time %= 60;
		}
		return String.format("剩余%d天%d小时%d分", day, hour, min);
	}
	
	public interface GetTuanDetailCallback{
		void getTuanDetail(TuanDetail tuanDetail);
	}
}
