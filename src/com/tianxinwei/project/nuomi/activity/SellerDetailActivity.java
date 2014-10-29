package com.tianxinwei.project.nuomi.activity;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.fragment.SellerDetailFragment;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

public class SellerDetailActivity extends Activity{
	private SellerDetailFragment sellerDetailFragment; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seller_detail);
		
		initData();
		initActionBar();
	}

	private void initData() {
		if(sellerDetailFragment == null){
			Bundle bundle = new Bundle();
			bundle.putSerializable("tuandetail", getIntent().getSerializableExtra("tuandetail"));
			sellerDetailFragment = new SellerDetailFragment();
			sellerDetailFragment.setArguments(bundle);
		}
		
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.fl_seller_detail_container, sellerDetailFragment);
		transaction.commit();
	}

	private void initActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setTitle("…Ãº“œÍ«È");
		actionBar.setIcon(R.drawable.ic_launcher);
		actionBar.setDisplayHomeAsUpEnabled(true);
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
	
}
