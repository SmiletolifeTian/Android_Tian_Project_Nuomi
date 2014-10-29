package com.tianxinwei.project.nuomi.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.activity.TuanDetailActivity;
import com.tianxinwei.project.nuomi.adapter.TuanNearbyAdapter;
import com.tianxinwei.project.nuomi.common.CommonInterface;
import com.tianxinwei.project.nuomi.entity.NearbyTuan;
import com.tianxinwei.project.nuomi.entity.tuan_all.Tuan;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataTuanList;
import com.tianxinwei.project.nuomi.task.TuanNearbyTask;

public class NearbyFragment extends Fragment implements OnItemClickListener {
	// 控件相关
	private ListView lvNearbyTuan;
	private TextView txAllCategory;
	private TextView tx3km;
	private TextView txNear;
	private TextView txFilter;

	// 数据相关
	Tuan tuan = new Tuan();
	TuanNearbyAdapter adapter;
	private List<NearbyTuan> data;
	private List<NearbyTuan> header;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		data = new ArrayList<NearbyTuan>();
		header = new ArrayList<NearbyTuan>();
		adapter = new TuanNearbyAdapter(getActivity(), data,header);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		View layout = inflater.inflate(R.layout.fragment_nearby, container,
				false);

		initUI(layout);
		initData();

		return layout;
	}

	private void initUI(View layout) {
		lvNearbyTuan = (ListView) layout.findViewById(R.id.lv_nearby_tuan);
		txAllCategory = (TextView) layout.findViewById(R.id.tx_all_category);
		tx3km = (TextView) layout.findViewById(R.id.tx_3km);
		txNear = (TextView) layout.findViewById(R.id.tx_near);
		txFilter = (TextView) layout.findViewById(R.id.tx_filter);

		lvNearbyTuan.setAdapter(adapter);
		lvNearbyTuan.setOnItemClickListener(this);
	}

	private void initData() {
		if (tuan.getData() == null) {
			TuanNearbyTask task = new TuanNearbyTask(adapter,tuan);
			task.execute(CommonInterface.URI_TUAN_NEARBY);
		} else {
			lvNearbyTuan.setAdapter(adapter);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		NearbyTuan tuanList = (NearbyTuan) parent
				.getItemAtPosition(position);
		Intent intent = new Intent(getActivity(), TuanDetailActivity.class);
		intent.putExtra("deal_id", tuanList.getDeal_id());
		startActivity(intent);
	}
}
