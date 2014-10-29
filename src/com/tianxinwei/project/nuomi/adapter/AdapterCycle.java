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

	private LinkedList<View> mViews; // ������ʾ��View
	private List<ImageView> mList; // ����Դ
	private ViewPager mViewPager; // ҳ��
	private ImageView[] tips; // ͼƬ�ϱ�ǵ�

	public AdapterCycle(Context context, ViewPager viewPager,
			List<ImageView> list, ImageView[] tips) {
		mViewPager = viewPager;
		mList = list;
		this.tips = tips;

		ImageView imgData = null;
		ImageView imgView = null;
		if (list != null) {
			// �����Ƿ����1������Ҫ��ʼ����һ����index:0��
			mViews = new LinkedList<View>();
			imgData = mList.get(mList.size() - 1);
			imgView = new ImageView(context);
			imgView.setImageDrawable(imgData.getDrawable());
			mViews.add(imgView);
			// ע�⣬�����ֻ1����mViews��mList��������ͷβ����һ����
			// ���裺mListΪmList[0~N-1], mViewsΪmViews[0~N+1]
			// mViews[0]��mList[N-1], mViews[i]��mList[i-1],
			// mViews[N+1]��mList[0]
			// mViews[1~N]����ѭ������λ֮ǰ��mViews[0]��ĩβ֮���mViews[N+1]������ת
			// ��λ֮ǰ��mViews[0]����ת��ĩβ��N����ĩλ֮���mViews[N+1]����ת����λ��1��
			if (list.size() > 1) { // ����1��Ҫѭ��
				for (ImageView img : mList) { // �м��N����index:1~N��
					mViews.add(img);
				}
				// ���һ����index:N+1��

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

	// ʵ��ViewPager.OnPageChangeListener�ӿ�
	@Override
	public void onPageSelected(int position) {
		if (mViews.size() > 1) { // ����1���Ż�ѭ����ת
			if (position < 1) { // ��λ֮ǰ����ת��ĩβ��N��
				position = mList.size(); // ע��������mList��������mViews
				mViewPager.setCurrentItem(position, false);
			} else if (position > mList.size()) { // ĩλ֮����ת����λ��1��
				mViewPager.setCurrentItem(1, false); // false:����ʾ��ת���̵Ķ���
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
	 * ����ѡ�е�tip�ı���
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