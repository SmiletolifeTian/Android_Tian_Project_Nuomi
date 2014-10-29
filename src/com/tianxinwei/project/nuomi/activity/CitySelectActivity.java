package com.tianxinwei.project.nuomi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.tianxinwei.project.nuomi.R;

public class CitySelectActivity extends Activity {
	private TextView txTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city_select);
		
		initUI();
		initData();
	}

	private void initUI() {
		txTitle = (TextView) findViewById(R.id.tx_title);
	}

	private void initData() {
		Intent intent = getIntent();
		txTitle.setText(String.format("当前城市-%s市", intent.getStringExtra("city")));
	}
}
