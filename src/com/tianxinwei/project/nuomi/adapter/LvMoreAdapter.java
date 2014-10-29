package com.tianxinwei.project.nuomi.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.entity.Option;

public class LvMoreAdapter extends BaseAdapter{
	Context context;
	List<Option> options;

	public LvMoreAdapter(Context context,List<Option> options) {
		this.context = context;
		this.options = options;
	}
	
	@Override
	public int getCount() {
		return options.size();
	}

	@Override
	public Object getItem(int position) {
		return options.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item_gengduo, parent,false);
			
			viewHolder = new ViewHolder();
			viewHolder.txName = (TextView) convertView.findViewById(R.id.tx_name);
			viewHolder.imgOption = (ImageView) convertView.findViewById(R.id.img_option);
			
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		Option option = options.get(position);
		if(position<2){
			if(option.isChecked()){
				viewHolder.imgOption.setImageResource(R.drawable.more_check);
			}else{
				viewHolder.imgOption.setImageResource(R.drawable.more_uncheck);
			}
		}else{
			viewHolder.imgOption.setImageResource(R.drawable.icon_arrows_gray_right);
		}
		viewHolder.txName.setText(option.getName());
		
		return convertView;
	}
	
	private class ViewHolder{
		public TextView txName;
		public ImageView imgOption;
	}

}
