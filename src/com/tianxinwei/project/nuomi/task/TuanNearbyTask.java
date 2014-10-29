package com.tianxinwei.project.nuomi.task;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;

import com.tianxinwei.project.nuomi.adapter.TuanNearbyAdapter;
import com.tianxinwei.project.nuomi.common.CommonBitmapHelper;
import com.tianxinwei.project.nuomi.common.CommonDialog;
import com.tianxinwei.project.nuomi.common.CommonJSONHelper;
import com.tianxinwei.project.nuomi.common.CommonParser;
import com.tianxinwei.project.nuomi.entity.NearbyTuan;
import com.tianxinwei.project.nuomi.entity.tuan_all.Tuan;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataPoiList;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataTuanList;

public class TuanNearbyTask extends AsyncTask<String, Void, Void> {
	private Context context;
	private List<NearbyTuan> data;
	private List<NearbyTuan> header;
	private TuanNearbyAdapter adapter;
	private Tuan tuan;

	public TuanNearbyTask(TuanNearbyAdapter adapter,Tuan tuan) {
		this.context = adapter.getContext();
		this.data = adapter.getData();
		this.header = adapter.getHeader();
		this.adapter = adapter;
		this.tuan = tuan;
	}

	@Override
	protected void onPreExecute() {
		CommonDialog.showProgressDialog(context, "请稍候。。。");
	}

	@Override
	protected Void doInBackground(String... params) {
		try {
			String json = CommonJSONHelper.getJSON(params[0]);
			JSONObject jsonObj = new JSONObject(json);
			//解析附近团购数据
			CommonParser.parserTuan(tuan, jsonObj);
			
			//生成ListView数据
			List<TuanDataPoiList> poiList = tuan.getData().getPoi_list();
			TuanDataPoiList poi = null;
			NearbyTuan nearbyTuan = null;
			for(int i=0;i<poiList.size();i++){
				poi = poiList.get(i);
				nearbyTuan = new NearbyTuan();
				nearbyTuan.setBrand_name(poi.getPoi_name());
				nearbyTuan.setShort_title(poi.getBizarea_title());
				data.add(nearbyTuan);
				header.add(nearbyTuan);
				
				List<TuanDataTuanList> tuanList = poi.getTuan_list();
				TuanDataTuanList mytuan = null;
				for(int j=0;j<tuanList.size();j++){
					nearbyTuan = new NearbyTuan();
					mytuan = tuanList.get(j);
					nearbyTuan.setBrand_name(mytuan.getBrand_name());
					nearbyTuan.setDeal_id(mytuan.getDeal_id());
					nearbyTuan.setGroupon_price(mytuan.getGroupon_price());
					nearbyTuan.setImage(mytuan.getImage());
					nearbyTuan.setMarket_price(mytuan.getMarket_price());
					nearbyTuan.setSale_count(mytuan.getSale_count());
					nearbyTuan.setShort_title(mytuan.getShort_title());
					nearbyTuan.setBitmap(mytuan.getBitmap());
					data.add(nearbyTuan);
					
				}
				
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		CommonDialog.hideProgressDialog();
		
		adapter.notifyDataSetChanged();
	}

}
