package com.tianxinwei.project.nuomi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.adapter.TuanAllAdapter;
import com.tianxinwei.project.nuomi.common.CommonInterface;
import com.tianxinwei.project.nuomi.entity.tuan_all.Tuan;
import com.tianxinwei.project.nuomi.entity.tuan_all.TuanDataTuanList;
import com.tianxinwei.project.nuomi.task.TuanAllTask;

public class TuanAllActivity extends Activity implements OnItemClickListener{
	private ListView lvTuan;
	private int pageId;
	private boolean isLastItem = false;
	private Tuan tuan = new Tuan();
	private TuanAllAdapter adapter = new TuanAllAdapter(this, tuan);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tuan_all);

		initUI();
		initData();
	}

	private void initUI() {
		lvTuan = (ListView) findViewById(R.id.lv_tuan);
		lvTuan.setAdapter(adapter);
		lvTuan.setOnItemClickListener(this);
		lvTuan.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if (scrollState == SCROLL_STATE_IDLE && isLastItem) {
					pageId++;

					TuanAllTask task = new TuanAllTask(TuanAllActivity.this,tuan,adapter);
					task.execute(String.format(CommonInterface.URI_TUAN_ALL,pageId));

					isLastItem = false;
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				if (firstVisibleItem + visibleItemCount == totalItemCount) {
					isLastItem = true;
				}
			}
		});
	}

	private void initData() {
		TuanAllTask task = new TuanAllTask(this, tuan, adapter);
		task.execute(String.format(CommonInterface.URI_TUAN_ALL, pageId));
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		TuanDataTuanList data = (TuanDataTuanList) parent.getItemAtPosition(position);
		Intent intent = new Intent(this,TuanDetailActivity.class);
		intent.putExtra("deal_id", data.getDeal_id());
		startActivity(intent);
	}

}
