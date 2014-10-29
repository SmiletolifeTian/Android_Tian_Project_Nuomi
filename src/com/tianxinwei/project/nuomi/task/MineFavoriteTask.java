package com.tianxinwei.project.nuomi.task;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.ListView;

import com.tianxinwei.project.nuomi.adapter.MineFavoriteAdapter;
import com.tianxinwei.project.nuomi.common.CommonBitmapHelper;
import com.tianxinwei.project.nuomi.common.CommonDialog;
import com.tianxinwei.project.nuomi.common.DBHelper;
import com.tianxinwei.project.nuomi.entity.DetailTuan;

public class MineFavoriteTask extends AsyncTask<Void, Void, List<DetailTuan>> {
	private Context context;
	private DBHelper db;
	private ListView lvMineFavorite;

	public MineFavoriteTask(Context context, ListView lvMineFavorite) {
		this.context = context;
		this.lvMineFavorite = lvMineFavorite;
	}

	@Override
	protected void onPreExecute() {
		db = new DBHelper(context);
		CommonDialog.showProgressDialog(context, "«Î…‘∫Û°£°£°£");
	}

	@Override
	protected List<DetailTuan> doInBackground(Void... params) {
		List<DetailTuan> list = new ArrayList<DetailTuan>();

		String sql = "SELECT * FROM table_tuan";
		Cursor cursor = db.exeQurey(sql);
		if (cursor != null && cursor.getCount() > 0) {
			DetailTuan detailTuan = null;
			while (cursor.moveToNext()) {
				detailTuan = new DetailTuan();
				detailTuan.setBusiness_title(cursor.getString(cursor
						.getColumnIndex("business_title")));
				detailTuan.setSubtitle(cursor.getString(cursor
						.getColumnIndex("subtitle")));
				detailTuan.setCurrent_price(cursor.getInt(cursor
						.getColumnIndex("current_price")));
				detailTuan.setDeal_id(cursor.getString(cursor
						.getColumnIndex("deal_id")));
				detailTuan.setMarket_price(cursor.getInt(cursor
						.getColumnIndex("market_price")));
				detailTuan.setMin_image(cursor.getString(cursor
						.getColumnIndex("min_image")));
				detailTuan.setSell_count(cursor.getInt(cursor
						.getColumnIndex("sell_count")));
				detailTuan.setMin_bitmap(CommonBitmapHelper
						.getBitmap(detailTuan.getMin_image()));
				list.add(detailTuan);
			}
		}

		return list;
	}

	@Override
	protected void onPostExecute(List<DetailTuan> result) {
		CommonDialog.hideProgressDialog();

		MineFavoriteAdapter adapter = new MineFavoriteAdapter(context, result);
		lvMineFavorite.setAdapter(adapter);
	}

}
