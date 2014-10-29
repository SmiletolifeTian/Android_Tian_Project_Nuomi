package com.tianxinwei.project.nuomi.adapter;

import java.text.DecimalFormat;
import java.util.List;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.entity.NearbyTuan;

public class TuanNearbyAdapter extends BaseAdapter {
	private DecimalFormat df = new DecimalFormat("#.00");
	private Context context;
	private List<NearbyTuan> data;
	private List<NearbyTuan> header;

	public TuanNearbyAdapter(Context context, List<NearbyTuan> data, List<NearbyTuan> header) {
		this.context = context;
		this.data = data;
		this.header = header;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public List<NearbyTuan> getData() {
		return data;
	}

	public void setData(List<NearbyTuan> data) {
		this.data = data;
	}

	public List<NearbyTuan> getHeader() {
		return header;
	}

	public void setHeader(List<NearbyTuan> header) {
		this.header = header;
	}

	@Override
	public int getCount() {
		return data!=null?data.size():0;
	}

	@Override
	public Object getItem(int position) {
		return data!=null?data.get(position):null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public boolean isEnabled(int position) {
		return !header.contains(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		NearbyTuan tuan = (NearbyTuan) getItem(position);

		if (header.contains(getItem(position))) {
			// 加载标题项
			ViewHolderHeader holder = null;
			if (convertView == null || !(convertView.getTag() instanceof ViewHolderHeader)) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.list_view_item_tag_nearby, parent, false);
				holder = new ViewHolderHeader();
				holder.txName = (TextView) convertView
						.findViewById(R.id.tx_poi_name);
				holder.txTitle = (TextView) convertView
						.findViewById(R.id.tx_bizarea_title);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolderHeader) convertView.getTag();
			}

			holder.txName.setText(tuan.getBrand_name());
			holder.txTitle.setText(tuan.getShort_title());

		} else {
			// 加载内容项
			ViewHolder viewHolder = null;

			if (convertView == null || !(convertView.getTag() instanceof ViewHolder)) {
				convertView = LayoutInflater.from(context).inflate(
						R.layout.list_view_item_tuan, parent, false);

				viewHolder = new ViewHolder();
				viewHolder.imgIcon = (ImageView) convertView
						.findViewById(R.id.img_icon);
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

				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}

			viewHolder.imgIcon.setImageBitmap(tuan.getBitmap());
			viewHolder.txShortTitle.setText(tuan.getShort_title());
			viewHolder.txGrouponPrice
					.setText(df.format(tuan.getGroupon_price() / 100.0));
			viewHolder.txMarketPrice
					.setText(df.format(tuan.getMarket_price() / 100.0));
			viewHolder.txSaleCount.setText(String.format("已售%s",
					tuan.getSale_count()));

		}

		return convertView;
	}

	class ViewHolderHeader {
		public TextView txName;
		public TextView txTitle;
	}

	class ViewHolder {
		public ImageView imgIcon;
		public TextView txShortTitle;
		public TextView txGrouponPrice;
		public TextView txMarketPrice;
		public TextView txSaleCount;
	}

}
