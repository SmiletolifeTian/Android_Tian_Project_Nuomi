package com.tianxinwei.project.nuomi.activity;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.common.CommonInterface;
import com.tianxinwei.project.nuomi.task.UpdateTask;

public class MoreAboutusActivity extends Activity implements OnClickListener{
	private Button btnUpdateCheck;
	private TextView txVersion;
	private ImageView imgIcon;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gengduo_aboutus);
		
		initUI();
		initData();
	}

	private void initUI() {
		btnUpdateCheck =  (Button) findViewById(R.id.btn_update_check);
		btnUpdateCheck.setOnClickListener(this);
		imgIcon =  (ImageView) findViewById(R.id.img_icon);
		imgIcon.setOnClickListener(this);
		
		txVersion = (TextView) findViewById(R.id.tx_version);
	}

	private void initData() {
		try {
			String versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
			txVersion.setText(String.format("µ±Ç°°æ±¾£º%s", versionName));
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_update_check:
			UpdateTask task = new UpdateTask(this);
			task.execute(CommonInterface.URI_UPDATE_LOCAL);
			break;
		case R.id.img_icon:
			finish();
			break;
		default:
			break;
		}
	}
}
