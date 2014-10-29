package com.tianxinwei.project.nuomi.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.common.CommonInterface;
import com.tianxinwei.project.nuomi.fragment.GrouponFragment;
import com.tianxinwei.project.nuomi.fragment.MineFragment;
import com.tianxinwei.project.nuomi.fragment.MoreFragment;
import com.tianxinwei.project.nuomi.fragment.NearbyFragment;
import com.tianxinwei.project.nuomi.task.UpdateTask;

public class MainActivity extends Activity implements OnClickListener {
	// ¿Ø¼þÏà¹Ø
	private Button btnGroupon;
	private Button btnNearby;
	private Button btnMine;
	private Button btnMore;
	private GrouponFragment fmGroupon;
	private NearbyFragment fmNearby;
	private MineFragment fmMine;
	private MoreFragment fmMore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUI();
		initData();
	}

	private void initUI() {
		btnGroupon = (Button) findViewById(R.id.btn_tuan);
		btnGroupon.setOnClickListener(this);
		btnNearby = (Button) findViewById(R.id.btn_fujin);
		btnNearby.setOnClickListener(this);
		btnMine = (Button) findViewById(R.id.btn_mine);
		btnMine.setOnClickListener(this);
		btnMore = (Button) findViewById(R.id.btn_genduo);
		btnMore.setOnClickListener(this);
	}

	private void initData() {
		btnGroupon.performClick();

		SharedPreferences sp = getSharedPreferences("isFirst", MODE_PRIVATE);
		boolean updateOrNot = sp.getBoolean("update_or_not", true);
		if (updateOrNot) {
			UpdateTask task = new UpdateTask(this);
			task.execute(CommonInterface.URI_UPDATE_LOCAL);			
		}
	}

	@Override
	public void onClick(View v) {
		Fragment fm = getFragmentManager().findFragmentById(R.id.fl_container);
		switch (v.getId()) {
		case R.id.btn_tuan:
			showGrouponFragment(fm);
			break;
		case R.id.btn_fujin:
			showNearbyFragment(fm);
			break;
		case R.id.btn_mine:
			showMineFragment(fm);
			break;
		case R.id.btn_genduo:
			showMoreFragment(fm);
			break;

		default:
			break;
		}
	}

	private void showGrouponFragment(Fragment fm) {
		if (!(fm instanceof GrouponFragment)) {
			updateBtnBG(R.id.btn_tuan);

			if (fmGroupon == null) {
				fmGroupon = new GrouponFragment();
			}

			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.fl_container, fmGroupon);
			ft.commit();
		}
	}

	private void showNearbyFragment(Fragment fm) {
		if (!(fm instanceof NearbyFragment)) {
			updateBtnBG(R.id.btn_fujin);

			if (fmNearby == null) {
				fmNearby = new NearbyFragment();
			}

			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.fl_container, fmNearby);
			ft.commit();
		}
	}

	private void showMineFragment(Fragment fm) {
		if (!(fm instanceof MineFragment)) {
			updateBtnBG(R.id.btn_mine);

			if (fmMine == null) {
				fmMine = new MineFragment();
			}

			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.fl_container, fmMine);
			ft.commit();
		}
	}

	private void showMoreFragment(Fragment fm) {
		if (!(fm instanceof MoreFragment)) {
			updateBtnBG(R.id.btn_genduo);

			if (fmMore == null) {
				fmMore = new MoreFragment();
			}

			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.fl_container, fmMore);
			ft.commit();
		}

	}

	private void updateBtnBG(int btnId) {
		Drawable drawableTop = getResources().getDrawable(
				R.drawable.tab_ic_home_normal);
		btnGroupon.setCompoundDrawablesWithIntrinsicBounds(null, drawableTop,
				null, null);
		btnGroupon.setTextColor(Color.parseColor("#8B8B8B"));

		drawableTop = getResources().getDrawable(
				R.drawable.tab_ic_nearby_normal);
		btnNearby.setCompoundDrawablesWithIntrinsicBounds(null, drawableTop,
				null, null);
		btnNearby.setTextColor(Color.parseColor("#8B8B8B"));

		drawableTop = getResources().getDrawable(R.drawable.tab_ic_mine_normal);
		btnMine.setCompoundDrawablesWithIntrinsicBounds(null, drawableTop,
				null, null);
		btnMine.setTextColor(Color.parseColor("#8B8B8B"));

		drawableTop = getResources().getDrawable(R.drawable.tab_ic_more_normal);
		btnMore.setCompoundDrawablesWithIntrinsicBounds(null, drawableTop,
				null, null);
		btnMore.setTextColor(Color.parseColor("#8B8B8B"));

		switch (btnId) {
		case R.id.btn_tuan:
			drawableTop = getResources().getDrawable(
					R.drawable.tab_ic_home_highlight);
			btnGroupon.setCompoundDrawablesWithIntrinsicBounds(null,
					drawableTop, null, null);
			btnGroupon.setTextColor(Color.parseColor("#FF4978"));
			break;
		case R.id.btn_fujin:
			drawableTop = getResources().getDrawable(
					R.drawable.tab_ic_nearby_highlight);
			btnNearby.setCompoundDrawablesWithIntrinsicBounds(null,
					drawableTop, null, null);
			btnNearby.setTextColor(Color.parseColor("#FF4978"));
			break;
		case R.id.btn_mine:
			drawableTop = getResources().getDrawable(
					R.drawable.tab_ic_mine_highlight);
			btnMine.setCompoundDrawablesWithIntrinsicBounds(null, drawableTop,
					null, null);
			btnMine.setTextColor(Color.parseColor("#FF4978"));
			break;
		case R.id.btn_genduo:
			drawableTop = getResources().getDrawable(
					R.drawable.tab_ic_more_highlight);
			btnMore.setCompoundDrawablesWithIntrinsicBounds(null, drawableTop,
					null, null);
			btnMore.setTextColor(Color.parseColor("#FF4978"));
			break;

		default:
			break;
		}
	}
}
