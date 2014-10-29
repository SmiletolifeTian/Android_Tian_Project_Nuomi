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
import com.tianxinwei.project.nuomi.entity.DetailTuan;

public class MineFavoriteAdapter extends BaseAdapter {
	private Context context;
	private List<DetailTuan> list;
	private ViewHolder viewHolder;
	private DecimalFormat df = new DecimalFormat("#.00");
	
	public MineFavoriteAdapter(Context context,List<DetailTuan> list){
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView ==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item_tuan, parent, false);
			
			viewHolder = new ViewHolder();
			viewHolder.imgIcon = (ImageView) convertView.findViewById(R.id.img_icon);
			viewHolder.txBrandName = (TextView) convertView.findViewById(R.id.tx_brand_name);
			viewHolder.txShortTitle = (TextView) convertView.findViewById(R.id.tx_short_title);
			viewHolder.txGrouponPrice = (TextView) convertView.findViewById(R.id.tx_groupon_price);
			viewHolder.txMarketPrice = (TextView) convertView.findViewById(R.id.tx_market_price);
			viewHolder.txMarketPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
			viewHolder.txSaleCount = (TextView) convertView.findViewById(R.id.tx_sale_count);
			
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		DetailTuan detailTuan = list.get(position);
		viewHolder.imgIcon.setImageBitmap(detailTuan.getMin_bitmap());
		viewHolder.txBrandName.setText(detailTuan.getBusiness_title());
		viewHolder.txShortTitle.setText(detailTuan.getSubtitle());
		viewHolder.txGrouponPrice.setText(df.format(detailTuan.getCurrent_price()/100.0));
		viewHolder.txMarketPrice.setText(df.format(detailTuan.getMarket_price()/100.0));
		viewHolder.txSaleCount.setText(String.format("“— €%s", detailTuan.getSell_count()));
		
		
		return convertView;
	}
	
	class ViewHolder{
		public ImageView imgIcon;
		public TextView txBrandName;
		public TextView txShortTitle;
		public TextView txGrouponPrice;
		public TextView txMarketPrice;
		public TextView txSaleCount;
	}

}
