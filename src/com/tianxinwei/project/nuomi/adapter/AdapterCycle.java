package com.tianxinwei.project.nuomi.adapter;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tianxinwei.project.nuomi.R;

public class AdapterCycle extends PagerAdapter implements
		ViewPager.OnPageChangeListener {

	private LinkedList<View> mViews; // 用于显示的View
	private List<ImageView> mList; // 数据源
	private ViewPager mViewPager; // 页面
	private ImageView[] tips; // 图片上标记点

	public AdapterCycle(Context context, ViewPager viewPager,
			List<ImageView> list, ImageView[] tips) {
		mViewPager = viewPager;
		mList = list;
		this.tips = tips;

		ImageView imgData = null;
		ImageView imgView = null;
		if (list != null) {
			// 无论是否多于1个，都要初始化第一个（index:0）
			mViews = new LinkedList<View>();
			imgData = mList.get(mList.size() - 1);
			imgView = new ImageView(context);
			imgView.setImageDrawable(imgData.getDrawable());
			mViews.add(imgView);
			// 注意，如果不只1个，mViews比mList多两个（头尾各多一个）
			// 假设：mList为mList[0~N-1], mViews为mViews[0~N+1]
			// mViews[0]放mList[N-1], mViews[i]放mList[i-1],
			// mViews[N+1]放mList[0]
			// mViews[1~N]用于循环；首位之前的mViews[0]和末尾之后的mViews[N+1]用于跳转
			// 首位之前的mViews[0]，跳转到末尾（N）；末位之后的mViews[N+1]，跳转到首位（1）
			if (list.size() > 1) { // 多于1个要循环
				for (ImageView img : mList) { // 中间的N个（index:1~N）
					mViews.add(img);
				}
				// 最后一个（index:N+1）

				imgData = mList.get(0);
				imgView = new ImageView(context);
				imgView.setImageDrawable(imgData.getDrawable());
				mViews.add(imgView);
			}
		}
	}

	@Override
	public int getCount() {
		return mViews.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mViews.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = mViews.get(position);
		container.addView(view);
		return view;
	}

	// 实现ViewPager.OnPageChangeListener接口
	@Override
	public void onPageSelected(int position) {
		if (mViews.size() > 1) { // 多于1，才会循环跳转
			if (position < 1) { // 首位之前，跳转到末尾（N）
				position = mList.size(); // 注意这里是mList，而不是mViews
				mViewPager.setCurrentItem(position, false);
			} else if (position > mList.size()) { // 末位之后，跳转到首位（1）
				mViewPager.setCurrentItem(1, false); // false:不显示跳转过程的动画
				position = 1;
			}

			setImageBackground(position);
		}

	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
	}

	@Override
	public void onPageScrollStateChanged(int state) {
	}

	/**
	 * 设置选中的tip的背景
	 * 
	 * @param selectItems
	 */
	private void setImageBackground(int selectItems) {
		if (selectItems >= 1 && selectItems <= mList.size()) {
			selectItems = selectItems - 1;
			for (int i = 0; i < tips.length; i++) {
				if (i == selectItems) {
					tips[i].setBackgroundResource(R.drawable.page_indicator_focused);
				} else {
					tips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
				}
			}
		}
	}
}