package com.tianxinwei.project.nuomi.fragment;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.entity.tuan_detail.TuanDetail;

import android.R.integer;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SellerDetailFragment extends Fragment {
	// 地图相关
	private MapView mMapView;
	private BaiduMap mBaiduMap;

	// 控件相关
	private TextView txSellerName;
	private TextView txSellerAddress;
	private ViewGroup rlLookWay;
	private ViewGroup rlSellerPhone;
	private TextView txSellerPhone;
	private ViewGroup rlSellerHuanjing;

	// 详情数据
	TuanDetail detailTuan;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		View layout = inflater.inflate(R.layout.fragment_seller_detail,
				container, false);

		initUI(layout);
		initMap(layout);
		initData();

		return layout;
	}

	private void initUI(View layout) {
		detailTuan = (TuanDetail) getArguments().getSerializable("tuandetail");

		txSellerName = (TextView) layout.findViewById(R.id.tx_seller_name);
		txSellerAddress = (TextView) layout
				.findViewById(R.id.tx_seller_address);
		rlLookWay = (ViewGroup) layout.findViewById(R.id.rl_look_way);
		rlSellerPhone = (ViewGroup) layout.findViewById(R.id.rl_seller_phone);
		txSellerPhone = (TextView) layout.findViewById(R.id.tx_seller_phone);
		rlSellerHuanjing = (ViewGroup) layout
				.findViewById(R.id.rl_seller_huanjing);

	}

	private void initMap(View layout) {
		mMapView = (MapView) layout.findViewById(R.id.mapview_seller_detail);
		mBaiduMap = mMapView.getMap();
		// 定义Maker坐标点
		double lat = detailTuan.getData().getMerchant_baseinfo().getSeller_list().getLat();
		double lng = detailTuan.getData().getMerchant_baseinfo().getSeller_list().getLng();
		LatLng point = new LatLng(lat, lng);
		// 构建Marker图标
		BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding);
		// 构建MarkerOption，用于在地图上添加Marker
		OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);
		// 在地图上添加Marker，并显示
		mBaiduMap.addOverlay(option);

		MapStatusUpdate mapCenter = MapStatusUpdateFactory.newLatLng(point);
		mBaiduMap.setMapStatus(mapCenter);

		MapStatusUpdate mapLevel = MapStatusUpdateFactory.zoomTo(14.0f);
		mBaiduMap.setMapStatus(mapLevel);
	}

	private void initData() {
		txSellerName.setText(detailTuan.getData().getMerchant_baseinfo()
				.getSeller_list().getSeller_name());
		txSellerAddress.setText(detailTuan.getData().getMerchant_baseinfo()
				.getSeller_list().getSeller_address());
		txSellerPhone.setText(detailTuan.getData().getMerchant_baseinfo()
				.getSeller_list().getSeller_phone());
	}

	@Override
	public void onResume() {
		super.onResume();
		mMapView.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		mMapView.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mMapView.onDestroy();
	}
}
