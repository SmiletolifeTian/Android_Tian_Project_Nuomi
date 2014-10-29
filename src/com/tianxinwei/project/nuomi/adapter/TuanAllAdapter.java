package com.tianxinwei.project.nuomi.adapter;

import java.text.DecimalFormat;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.entity.tuan_all.Tuan;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataTuanList;

public class TuanAllAdapter extends BaseAdapter {
	private DecimalFormat df = new DecimalFormat("#.00");
	private ViewHolder viewHolder;
	private Context context;
	private Tuan tuan;

	public TuanAllAdapter(Context context, Tuan tuan) {
		this.context = context;
		this.tuan = tuan;
	}

	@Override
	public int getCount() {
		return tuan.getData() != null ? tuan.getData().getTuan_list().size()
				: 0;
	}

	@Override
	public Object getItem(int position) {
		return tuan.getData() != null ? tuan.getData().getTuan_list()
				.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.list_view_item_tuan, parent, false);

			viewHolder = new ViewHolder();
			viewHolder.txBrandName = (TextView) convertView
					.findViewById(R.id.tx_brand_name);
			viewHolder.txShortTitle = (TextView) convertView
					.findViewById(R.id.tx_short_title);
			viewHolder.txGrouponPrice = (TextView) convertView
					.findViewById(R.id.tx_groupon_price);
			viewHolder.txMarketPrice = (TextView) convertView
					.findViewById(R.id.tx_market_price);
			viewHolder.txMarketPrice.getPaint().setFlags(
					Paint.STRIKE_THRU_TEXT_FLAG);
			viewHolder.txSaleCount = (TextView) convertView
					.findViewById(R.id.tx_sale_count);
			viewHolder.imgIcon = (ImageView) convertView
					.findViewById(R.id.img_icon);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		TuanDataTuanList tuanList = (TuanDataTuanList) getItem(position);

		viewHolder.txBrandName.setText(tuanList.getBrand_name());
		viewHolder.txShortTitle.setText(tuanList.getShort_title());
		viewHolder.txGrouponPrice
				.setText(df.format(tuanList.getGroupon_price() / 100.0));
		viewHolder.txMarketPrice
				.setText(df.format(tuanList.getMarket_price() / 100.0));
		viewHolder.txSaleCount.setText(String.format("“— €%s",
				tuanList.getSale_count()));
		viewHolder.imgIcon.setImageBitmap(tuanList.getBitmap());

		return convertView;
	}

	class ViewHolder {

		public TextView txBrandName;
		public TextView txShortTitle;
		public TextView txGrouponPrice;
		public TextView txMarketPrice;
		public TextView txSaleCount;
		public ImageView imgIcon;
	}

}
