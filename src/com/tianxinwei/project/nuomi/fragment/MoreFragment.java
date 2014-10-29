package com.tianxinwei.project.nuomi.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.adapter.LvMoreAdapter;
import com.tianxinwei.project.nuomi.entity.Option;

public class MoreFragment extends Fragment implements OnItemClickListener {
	private ListView lvMore;
	private Button btnCacheClean;
	private List<Option> options;
	private LvMoreAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}

		View layout = inflater.inflate(R.layout.fragment_gengduo, container,
				false);
		initUI(layout);
		initData();

		return layout;
	}

	@Override
	public void onResume() {
		super.onResume();
		
		SharedPreferences sp = getActivity().getSharedPreferences("options", 0);
		boolean txOption = sp.getBoolean("tx", true);
		boolean wifiOption = sp.getBoolean("wifi", false);
		options.get(0).setChecked(txOption);
		options.get(1).setChecked(wifiOption);
		
		adapter.notifyDataSetChanged();
	}
	
	private void initUI(View layout) {
		lvMore = (ListView) layout.findViewById(R.id.lv_more);
		lvMore.setOnItemClickListener(this);
		btnCacheClean = (Button) layout.findViewById(R.id.btn_cache_clean);
	}

	private void initData() {
		String[] names = new String[] { "团购评价提醒", "仅Wi-Fi下显示图片", "分享设置",
				"关于我们", "邀请好友", "意见反馈", "精品应用" };

		options = new ArrayList<Option>();
		Option option = null;
		for (int i = 0; i < names.length; i++) {
			option = new Option();
			option.setName(names[i]);
			options.add(option);
		}
		options.get(0).setChecked(true);

		adapter = new LvMoreAdapter(getActivity(), options);
		lvMore.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if (position < 2) {
			boolean checked = !(options.get(position).isChecked());
			options.get(position).setChecked(checked);

			SharedPreferences sp = getActivity().getSharedPreferences("options", 0);
			Editor editor = sp.edit();
			if (position == 0) {
				editor.putBoolean("tx", checked);
			} else {
				editor.putBoolean("wifi", checked);
			}
			editor.commit();
		}
		adapter.notifyDataSetChanged();

	}

}
