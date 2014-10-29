package com.tianxinwei.project.nuomi.fragment;

import com.baidu.mapapi.map.MapView;
import com.tianxinwei.project.nuomi.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SellerMapFragment extends Fragment {
	private MapView mMapView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(container == null){
			return null;
		}
		
		View layout = inflater.inflate(R.layout.fragment_seller_map, container,false);
		initUI(layout);
		
		
		return layout;
	}

	private void initUI(View layout) {
		mMapView = (MapView) layout.findViewById(R.id.mapview_seller_map);
	}

}
