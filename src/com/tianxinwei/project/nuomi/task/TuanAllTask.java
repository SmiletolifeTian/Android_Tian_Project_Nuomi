package com.tianxinwei.project.nuomi.task;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;

import com.tianxinwei.project.nuomi.adapter.TuanAllAdapter;
import com.tianxinwei.project.nuomi.common.CommonDialog;
import com.tianxinwei.project.nuomi.common.CommonJSONHelper;
import com.tianxinwei.project.nuomi.common.CommonParser;
import com.tianxinwei.project.nuomi.entity.tuan_all.Tuan;

public class TuanAllTask extends AsyncTask<String, Void, Void> {
	private Context context;
	private Tuan tuan;
	private TuanAllAdapter adapter;

	public TuanAllTask(Context context, Tuan tuan, TuanAllAdapter adapter) {
		this.context = context;
		this.tuan = tuan;
		this.adapter = adapter;
	}

	@Override
	protected void onPreExecute() {
		CommonDialog.showProgressDialog(context, "«Î…‘∫Û°£°£°£ ");
	}

	@Override
	protected Void doInBackground(String... params) {

		try {
			String json = CommonJSONHelper.getJSON(params[0]);
			JSONObject tuanObject = new JSONObject(json);
			CommonParser.parserTuan(tuan, tuanObject);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		adapter.notifyDataSetChanged();

		CommonDialog.hideProgressDialog();
	}

	
}
