package com.tianxinwei.project.nuomi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.entity.home.Category;
import com.tianxinwei.project.nuomi.entity.home.Home;

public class CategoryAdapter extends BaseAdapter {
	private Context context;
	private Home home;
	private ViewHolder viewHolder;

	public CategoryAdapter(Context context, Home home) {
		this.home = home;
		this.context = context;
	}

	@Override
	public int getCount() {
		return home.getData() != null ? home.getData().getCategory().size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return home.getData() != null ? home.getData().getCategory().get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.grid_view_item_category, parent, false);

			viewHolder = new ViewHolder();
			viewHolder.imgIcon = (ImageView) convertView
					.findViewById(R.id.img_category_pic);
			viewHolder.txName = (TextView) convertView
					.findViewById(R.id.tx_category_name);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Category category = (Category) getItem(position);
		viewHolder.imgIcon.setImageBitmap(category.getBitmap());
		viewHolder.txName.setText(category.getCategory_name());

		return convertView;
	}

	class ViewHolder {
		public ImageView imgIcon;
		public TextView txName;
	}
}
