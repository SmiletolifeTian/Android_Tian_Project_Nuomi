package com.tianxinwei.project.nuomi.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.activity.CitySelectActivity;
import com.tianxinwei.project.nuomi.activity.TuanAllActivity;
import com.tianxinwei.project.nuomi.activity.TuanDetailActivity;
import com.tianxinwei.project.nuomi.adapter.CategoryAdapter;
import com.tianxinwei.project.nuomi.adapter.TuanLikeAdapter;
import com.tianxinwei.project.nuomi.common.CommonInterface;
import com.tianxinwei.project.nuomi.common.CommonViewPager;
import com.tianxinwei.project.nuomi.common.ScrollBottomScrollView;
import com.tianxinwei.project.nuomi.common.ScrollBottomScrollView.OnScrollBottomListener;
import com.tianxinwei.project.nuomi.entity.home.Home;
import com.tianxinwei.project.nuomi.entity.tuan_like.TuanLike;
import com.tianxinwei.project.nuomi.entity.tuan_like.TuanLikeDataTuanList;
import com.tianxinwei.project.nuomi.task.HomeTask;
import com.tianxinwei.project.nuomi.task.TuanLikeTask;

public class GrouponFragment extends Fragment implements OnClickListener,OnItemClickListener {
	private static final String TAG = "GrouponFragment";
	private ViewHolder viewHolder;
	private Home home = new Home();
	private CategoryAdapter adapter;
	private TuanLike tuanLike;
	private TuanLikeAdapter adapterLike;
	private boolean isFirstLoading = true;
	private CommonViewPager commonViewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		adapter = new CategoryAdapter(getActivity(), home);
		tuanLike = new TuanLike();
		adapterLike = new TuanLikeAdapter(getActivity(), tuanLike);
		viewHolder = new ViewHolder();
		commonViewPager = new CommonViewPager(getActivity(), home, viewHolder);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		View layout = inflater.inflate(R.layout.fragment_groupon, container,
				false);

		initUI(layout);
		initData();

		return layout;
	}

	private void initUI(View layout) {
		viewHolder.gridCategory = (GridView) layout.findViewById(R.id.gv_category);
		viewHolder.gridCategory.setOnItemClickListener(this);
		viewHolder.vpBanner = (ViewPager) layout.findViewById(R.id.vp_banner);
		viewHolder.dotContainer = (ViewGroup) layout.findViewById(R.id.ll_container);
		viewHolder.imgSpec1 = (ImageView) layout.findViewById(R.id.img_spec1);
		viewHolder.imgSpec2 = (ImageView) layout.findViewById(R.id.img_spec2);
		viewHolder.lvLike = (ListView) layout.findViewById(R.id.lv_like);
		viewHolder.lvLike.setOnItemClickListener(this);
		viewHolder.layoutLoading = layout.findViewById(R.id.ll_loading);
		viewHolder.layoutContent = layout.findViewById(R.id.ll_guess_like);
		viewHolder.svContent = (ScrollBottomScrollView) layout.findViewById(R.id.sv_content);
		viewHolder.imgLoading = (ImageView) layout.findViewById(R.id.img_loading);
		viewHolder.svContent.setOnScrollBottomListener(new OnScrollBottomListener() {

					@Override
					public void scrollBottom() {
						if (isFirstLoading) {
							TuanLikeTask task = new TuanLikeTask(getActivity(),tuanLike, adapterLike,viewHolder);
							task.execute(CommonInterface.URI_TUAN_LIKE);
							isFirstLoading = false;
						}
					}
				});

		viewHolder.btnAllGroupon = (Button) layout.findViewById(R.id.btn_all_groupon);
		viewHolder.btnAllGroupon.setOnClickListener(this);

		viewHolder.btnFooterAllGroupon = (Button) layout.findViewById(R.id.btn_footer_all_groupon);
		viewHolder.btnFooterAllGroupon.setOnClickListener(this);

		viewHolder.btnCity = (Button) layout.findViewById(R.id.btn_city);
		viewHolder.btnCity.setOnClickListener(this);

	}

	private void initData() {
		if (home.getData() == null) {
			HomeTask task = new HomeTask(getActivity(), home, adapter,
					viewHolder,commonViewPager);
			task.execute(CommonInterface.URI_CATEGORY);
		} else {
			if (home.getData().getBanners() != null
					&& home.getData().getBanners().size() > 0) {
				commonViewPager.start();
			}
			if (home.getData().getCategory() != null
					&& home.getData().getCategory().size() > 0) {
				viewHolder.gridCategory.setAdapter(adapter);
			}
			if (home.getData().getSpecial() != null
					&& home.getData().getSpecial().size() > 0) {
				viewHolder.imgSpec1.setImageBitmap(home.getData().getSpecial()
						.get(0).getBitmap());
				viewHolder.imgSpec2.setImageBitmap(home.getData().getSpecial()
						.get(1).getBitmap());
			}
		}
		
		if(!isFirstLoading){
			viewHolder.layoutContent.setVisibility(View.VISIBLE);
		}
		viewHolder.lvLike.setAdapter(adapterLike);
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_all_groupon:
		case R.id.btn_footer_all_groupon:
			startActivity(new Intent(getActivity(), TuanAllActivity.class));
			break;
		case R.id.btn_city:
			Intent intent = new Intent(getActivity(), CitySelectActivity.class);
			intent.putExtra("city", viewHolder.btnCity.getText());
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	public class ViewHolder {
		public GridView gridCategory;
		public ViewPager vpBanner;
		public ViewGroup dotContainer;  //µãµÄÈÝÆ÷
		public ImageView imgSpec1;
		public ImageView imgSpec2;
		public ListView lvLike;
		public ScrollBottomScrollView svContent;
		public Button btnAllGroupon;
		public Button btnFooterAllGroupon;
		public Button btnCity;
		public View layoutLoading;
		public View layoutContent;
		public ImageView imgLoading;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		switch (parent.getId()) {
		case R.id.lv_like:
			TuanLikeDataTuanList data = (TuanLikeDataTuanList) parent.getItemAtPosition(position);
			Intent intent = new Intent(getActivity(),TuanDetailActivity.class);
			intent.putExtra("deal_id", data.getDeal_id());
			Log.i(TAG,  data.getDeal_id());
			startActivity(intent);
			break;
		case R.id.gv_category:
			
			break;

		default:
			break;
		}
	}
	
}
