package com.tianxinwei.project.nuomi.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.activity.MineFavoriteActivity;

public class MineFragment extends Fragment implements OnItemClickListener{
	private Button btnLogin;
	private TextView txRegistry;
	private GridView gvQuan;
	private ListView lvMine;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		
		View layout = inflater.inflate(R.layout.fragment_mine, container, false);
		initUI(layout);
		initData();
		
		return layout;
		
	}

	private void initUI(View layout) {
		btnLogin = (Button) layout.findViewById(R.id.btn_longin);
		txRegistry = (TextView) layout.findViewById(R.id.tx_registry);
		gvQuan = (GridView) layout.findViewById(R.id.gv_quan);
		lvMine = (ListView) layout.findViewById(R.id.lv_mine);
		lvMine.setOnItemClickListener(this);
	}

	private void initData() {
		String[] itemNames = new String[]{"糯米券","待付款"}; 
		int[] resIds = {R.drawable.icon_mine_gv_nuomiquan,R.drawable.icon_mine_gv_daifukuan};
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		Map<String,Object> map=null;
		for(int i=0;i<itemNames.length;i++){
			map = new HashMap<String,Object>();
			map.put("name", itemNames[i]);
			map.put("icon", resIds[i]);
			data.add(map);
		}
		String[] from = new String[]{"icon","name"};
		int[] to = new int[]{R.id.img_icon,R.id.tx_name};
		SimpleAdapter adapter = new SimpleAdapter(getActivity(), data, R.layout.grid_view_item_mine, from, to);
		gvQuan.setAdapter(adapter);
		
		itemNames = new String[]{"已付款","待收货","我的收藏","我的钱包","代金券"};
		resIds = new int[]{R.drawable.icon_mine_lv_yifukuan,R.drawable.icon_mine_lv_daishouhuo,R.drawable.icon_mine_lv_wode_shoucang,
				R.drawable.icon_mine_lv_wode_qianbao,R.drawable.icon_mine_lv_daijinquan};
		data = new ArrayList<Map<String,Object>>();
		for(int i=0;i<itemNames.length;i++){
			map = new HashMap<String,Object>();
			map.put("name", itemNames[i]);
			map.put("icon", resIds[i]);
			data.add(map);
		}
		adapter = new SimpleAdapter(getActivity(),data,R.layout.list_view_item_mine,from,to);
		lvMine.setAdapter(adapter);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if(parent.getId() == R.id.lv_mine){
			switch (position) {
			case 2:
				startActivity(new Intent(getActivity(),MineFavoriteActivity.class));
				break;

			default:
				break;
			}
		}
	}
}
