package com.tianxinwei.project.nuomi.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;

public class GuideActivity extends Activity implements OnPageChangeListener{
	private ViewPager vpGuide;
	private TextView txExperience;
	private List<ImageView> imgs;
	private int[] ids = new int[] { R.drawable.guide_1, R.drawable.guide_2,
			R.drawable.guide_3, R.drawable.guide_4 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);

		initUI();
		initData();
	}

	private void initUI() {
		vpGuide = (ViewPager) findViewById(R.id.vp_guide);
		txExperience = (TextView) findViewById(R.id.tx_experience);
	}

	private void initData() {
		imgs = new ArrayList<ImageView>();
		ImageView img = null;
		for (int i = 0; i < ids.length; i++) {
			img = new ImageView(this);
			img.setImageResource(ids[i]);
			imgs.add(img);
		}
		ImageView imageView = imgs.get(ids.length-1);
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(GuideActivity.this,MainActivity.class));
			}
		});

		MyAdapter adapter = new MyAdapter();
		vpGuide.setAdapter(adapter);
	}

	class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {

			return imgs.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(imgs.get(position));
			return imgs.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(imgs.get(position));
		}

	}

	/* -------------------OnPageChangeListener------------------ */
	@Override
	public void onPageScrollStateChanged(int state) {
		
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		
	}

	@Override
	public void onPageSelected(int position) {
		if(position == ids.length-1){
			txExperience.setVisibility(View.VISIBLE);
		}else{
			txExperience.setVisibility(View.INVISIBLE);
		}
	}
	/* -------------------OnPageChangeListener------------------ */
}
