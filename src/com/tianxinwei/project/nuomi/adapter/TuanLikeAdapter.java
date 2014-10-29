package com.tianxinwei.project.nuomi.adapter;

import java.text.DecimalFormat;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataTuanList;
import com.tianxinwei.project.nuomi.entity.tuan_like.TuanLike;
import com.tianxinwei.project.nuomi.entity.tuan_like.TuanLikeDataTuanList;

public class TuanLikeAdapter extends BaseAdapter {
	private DecimalFormat df = new DecimalFormat("#.00");
	private Context context;
	private TuanLike tuanLike;
	private ViewHolder viewHolder;
	
	public TuanLikeAdapter(Context context,TuanLike tuanLike){
		this.context = context;
		this.tuanLike = tuanLike;
	}

	@Override
	public int getCount() {
		return tuanLike.getData()!=null?tuanLike.getData().getTuan_list().size():0;
	}

	@Override
	public Object getItem(int position) {
		return tuanLike.getData()!=null?tuanLike.getData().getTuan_list().get(position):null;
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
		
		TuanLikeDataTuanList tuanList = (TuanLikeDataTuanList) getItem(position);
		viewHolder.txBrandName.setText(tuanList.getBrand_name());
		viewHolder.txShortTitle.setText(tuanList.getShort_title());
		viewHolder.txGrouponPrice.setText(df.format(tuanList.getGroupon_price()/100.0));
		viewHolder.txMarketPrice.setText(df.format(tuanList.getMarket_price()/100.0));
		viewHolder.txSaleCount.setText(String.format("“— €%s", tuanList.getSale_count()));
		viewHolder.imgIcon.setImageBitmap(tuanList.getBitmap());
		
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
