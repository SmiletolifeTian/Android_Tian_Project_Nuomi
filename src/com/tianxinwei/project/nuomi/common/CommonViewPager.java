package com.tianxinwei.project.nuomi.common;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.adapter.AdapterCycle;
import com.tianxinwei.project.nuomi.entity.home.Home;
import com.tianxinwei.project.nuomi.fragment.GrouponFragment.ViewHolder;

public class CommonViewPager {
	private Context context;
	private Home home;
	private ViewHolder viewHolder;

	private List<ImageView> imageViews;
	private Handler handler = new Handler();
	private AdapterCycle adapter;

	public CommonViewPager(Context context, Home home, ViewHolder viewHolder) {
		this.context = context;
		this.home = home;
		this.viewHolder = viewHolder;
	}

	public void start() {

		imageViews = new ArrayList<ImageView>();
		ImageView imageView = null;
		// List<Banner> banners = home.getData().getBanners();
		// for (int i = 0; i < banners.size(); i++) {
		// imageView = new ImageView(context);
		// imageView.setImageBitmap(banners.get(i).getBitmap());
		// imageViews.add(imageView);
		// }
		int[] ids = new int[] { R.drawable.banner1, R.drawable.banner2 };
		for (int i = 0; i < ids.length; i++) {
			imageView = new ImageView(context);
			imageView.setImageResource(ids[i]);
			imageViews.add(imageView);
		}

		// 将点点加入到ViewGroup中
		ImageView[] tips = new ImageView[ids.length];
		for (int i = 0; i < tips.length; i++) {
			ImageView dotView = new ImageView(context);
			LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(10, 10);
			params.setMargins(0, 0, 5, 0);
			dotView.setLayoutParams(params);
			tips[i] = dotView;
			if (i == 0) {
				tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}

			viewHolder.dotContainer.addView(dotView);
		}

		adapter = new AdapterCycle(context, viewHolder.vpBanner,imageViews, tips);
		viewHolder.vpBanner.setAdapter(adapter);
		// 设置监听，主要是设置边界图片的切换和点点的背景
		viewHolder.vpBanner.setOnPageChangeListener(adapter);
		// 将viewPager初始位置设置为1
		if (adapter.getCount() > 1) {
			viewHolder.vpBanner.setCurrentItem(1);
		}

		handler.removeCallbacks(changeImgAuto);
		handler.postDelayed(changeImgAuto, 5000);
	}
	

	
	private Runnable changeImgAuto = new Runnable() {

		@Override
		public void run() {
			int currentIndex = viewHolder.vpBanner.getCurrentItem();
			viewHolder.vpBanner.setCurrentItem((currentIndex+1)%imageViews.size());
			handler.postDelayed(changeImgAuto, 5000);

		}
	};

	
}
