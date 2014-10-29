package com.tianxinwei.project.nuomi.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tianxinwei.project.nuomi.R;
import com.tianxinwei.project.nuomi.common.CommonInterface;
import com.tianxinwei.project.nuomi.common.DBHelper;
import com.tianxinwei.project.nuomi.entity.DetailTuan;
import com.tianxinwei.project.nuomi.entity.tuan_detail.TuanDetail;
import com.tianxinwei.project.nuomi.task.TuanDetailTask;
import com.tianxinwei.project.nuomi.task.TuanDetailTask.GetTuanDetailCallback;

public class TuanDetailActivity extends Activity implements OnClickListener{
	private ViewHolder viewHolder;
	private DBHelper db;
	private TuanDetail detailTuan;
	private DetailTuan detailData;
	private boolean isFavorite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tuan_detail);

		initUI();
		initData();
	}

	private void initUI() {
		viewHolder = new ViewHolder();

		viewHolder.imgTuPian = (ImageView) findViewById(R.id.img_tupian);
		viewHolder.txGrouponPrice = (TextView) findViewById(R.id.tx_groupon_price);
		viewHolder.txMarketPrice = (TextView) findViewById(R.id.tx_market_price);
		viewHolder.txMarketPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		viewHolder.btnQiangGou = (Button) findViewById(R.id.btn_qianggou);
		viewHolder.txFavourInfo = (TextView) findViewById(R.id.tx_favour_info);
		viewHolder.txBusinessTitle = (TextView) findViewById(R.id.tx_business_title);
		viewHolder.txSubtitle = (TextView) findViewById(R.id.tx_subtitle);
		viewHolder.txSellCount = (TextView) findViewById(R.id.tx_sell_count);
		viewHolder.txRemainTime = (TextView) findViewById(R.id.tx_remain_time);
		viewHolder.txSafeguardName = (TextView) findViewById(R.id.tx_safeguard_name);
		viewHolder.txShopNum = (TextView) findViewById(R.id.tx_shop_num);
		viewHolder.txSellerName = (TextView) findViewById(R.id.tx_seller_name);
		viewHolder.txSellerAddress = (TextView) findViewById(R.id.tx_seller_address);
		viewHolder.llSellerInfo = (ViewGroup) findViewById(R.id.ll_seller_info);
		viewHolder.llSellerInfo.setOnClickListener(this);
	}

	private void initData() {
		db = new DBHelper(this);
		detailData = new DetailTuan();

		Intent intent = getIntent();
		String dealId = intent.getStringExtra("deal_id");
		TuanDetailTask task = new TuanDetailTask(this,detailData, viewHolder,new GetTuanDetailCallback() {
			@Override
			public void getTuanDetail(TuanDetail tuanDetail) {
				detailTuan = tuanDetail;
			}
		});
		String uri = String.format(CommonInterface.URI_PRODUCT_DEAL, dealId);
		task.execute(uri);

	}

	private void doFavorite(MenuItem item) {
		if (isFavorite) {
			String sql = "DELETE FROM table_tuan WHERE deal_id = " + detailData.getDeal_id();
			db.exeSQL(sql);

			item.setIcon(R.drawable.icon_nav_weishoucang_normal);
			Toast.makeText(this, "已取消收藏", Toast.LENGTH_LONG).show();
			
			isFavorite = !isFavorite;
		} else {
			String sql = "INSERT INTO table_tuan(deal_id,business_title,subtitle,min_image,sell_count,current_price,market_price) VALUES(?,?,?,?,?,?,?)";
			Object[] bindArgs = new Object[] { detailData.getDeal_id(),
					detailData.getBusiness_title(), detailData.getSubtitle(),
					detailData.getMin_image(), detailData.getSell_count(),
					detailData.getCurrent_price(), detailData.getMarket_price() };
			db.exeSQL(sql, bindArgs);

			item.setIcon(R.drawable.icon_nav_yishoucang_normal);
			Toast.makeText(this, "已收藏", Toast.LENGTH_LONG).show();
			
			isFavorite = !isFavorite;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.action_tuan_detail, menu);
		
		ActionBar actionBar = getActionBar();
		actionBar.setTitle("团购详情");
		actionBar.setIcon(R.drawable.ic_launcher);
		actionBar.setDisplayHomeAsUpEnabled(true);

		Intent intent = getIntent();
		String dealId = intent.getStringExtra("deal_id");
		String sql = "SELECT * FROM table_tuan WHERE deal_id = " + dealId;
		Cursor cursor = db.exeQurey(sql);
		
		MenuItem item = menu.findItem(R.id.action_favorite);
		if (cursor != null && cursor.getCount() > 0) {
			isFavorite = true;
			item.setIcon(R.drawable.icon_nav_yishoucang_normal);
		} else {
			isFavorite = false;
			item.setIcon(R.drawable.icon_nav_weishoucang_normal);
		}

		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_favorite:
			doFavorite(item);
			break;
		case android.R.id.home:
			finish();
			break;
		default:
			break;
		}
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_seller_info:
			Intent intent = new Intent(this,SellerDetailActivity.class);
			intent.putExtra("tuandetail", detailTuan);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	public class ViewHolder {

		public ImageView imgTuPian;
		public TextView txGrouponPrice;
		public TextView txMarketPrice;
		public Button btnQiangGou;
		public TextView txFavourInfo;
		public TextView txBusinessTitle;
		public TextView txSubtitle;
		public TextView txSellCount;
		public TextView txRemainTime;
		public TextView txSafeguardName;
		public TextView txShopNum;
		public TextView txSellerName;
		public TextView txSellerAddress;
		public ViewGroup llSellerInfo;
	}
}