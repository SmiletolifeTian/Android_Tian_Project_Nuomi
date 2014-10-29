package com.tianxinwei.project.nuomi.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.entity.DetailTuan;
import com.tianxinwei.project.nuomi.entity.NearbyTuan;
import com.tianxinwei.project.nuomi.task.MineFavoriteTask;

public class MineFavoriteActivity extends Activity implements OnItemClickListener{
	private ListView lvMineFavorite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mine_favorite);

		initUI();
		initData();
	}

	private void initUI() {
		lvMineFavorite = (ListView) findViewById(R.id.lv_mine_favorite);
		lvMineFavorite.setOnItemClickListener(this);

		ActionBar actionBar = getActionBar();
		actionBar.setTitle("Œ“µƒ ’≤ÿ");
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	private void initData() {
		MineFavoriteTask task = new MineFavoriteTask(this, lvMineFavorite);
		task.execute();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;

		default:
			break;
		}
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		DetailTuan detailTuan = (DetailTuan) parent.getItemAtPosition(position);
		Intent intent = new Intent(this, TuanDetailActivity.class);
		intent.putExtra("deal_id", detailTuan.getDeal_id());
		startActivity(intent);
	}

}
