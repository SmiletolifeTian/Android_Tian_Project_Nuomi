package com.tianxinwei.project.nuomi.task;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.R.string;
import android.content.Context;
import android.os.AsyncTask;

import com.tianxinwei.project.nuomi.adapter.CategoryAdapter;
import com.tianxinwei.project.nuomi.common.CommonBitmapHelper;
import com.tianxinwei.project.nuomi.common.CommonDialog;
import com.tianxinwei.project.nuomi.common.CommonImageHelper;
import com.tianxinwei.project.nuomi.common.CommonJSONHelper;
import com.tianxinwei.project.nuomi.common.CommonViewPager;
import com.tianxinwei.project.nuomi.entity.home.Banner;
import com.tianxinwei.project.nuomi.entity.home.Category;
import com.tianxinwei.project.nuomi.entity.home.CategoryKV;
import com.tianxinwei.project.nuomi.entity.home.Home;
import com.tianxinwei.project.nuomi.entity.home.HomeData;
import com.tianxinwei.project.nuomi.entity.home.Recommend;
import com.tianxinwei.project.nuomi.entity.home.Special;
import com.tianxinwei.project.nuomi.fragment.GrouponFragment.ViewHolder;

public class HomeTask extends AsyncTask<String, Void, Void> {
	private Context context;
	private Home home;
	private ViewHolder viewHolder;
	private CategoryAdapter adapter;
	private CommonViewPager commonViewPager;

	public HomeTask(Context context, Home home, CategoryAdapter adapter,
			ViewHolder viewHolder,CommonViewPager commonViewPager) {
		this.context = context;
		this.home = home;
		this.viewHolder = viewHolder;
		this.adapter = adapter;
		this.commonViewPager = commonViewPager;
	}

	@Override
	protected void onPreExecute() {
		CommonDialog.showProgressDialog(context, "加载中。。。");
	}

	@Override
	protected Void doInBackground(String... params) {

		try {
			String json = CommonJSONHelper.getJSON(params[0]);
			JSONObject homeObject = new JSONObject(json);
			parserHome(homeObject, home);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		if (home.getData().getBanners() != null&& home.getData().getBanners().size() > 0) {
			commonViewPager.start();
		}
		if (home.getData().getCategory() != null&& home.getData().getCategory().size() > 0) {
			viewHolder.gridCategory.setAdapter(adapter);
		}
		if (home.getData().getSpecial() != null&& home.getData().getSpecial().size() > 0) {
			viewHolder.imgSpec1.setImageBitmap(home.getData().getSpecial().get(0).getBitmap());
			viewHolder.imgSpec2.setImageBitmap(home.getData().getSpecial().get(1).getBitmap());
		}

		CommonDialog.hideProgressDialog();
	}

	/**
	 * 解析Home
	 * 
	 * @param obj
	 * @param home
	 * @throws JSONException
	 */
	private void parserHome(JSONObject obj, Home home) throws JSONException {
		home.setCached(obj.getInt("cached"));
		home.setErrmsg(obj.getString("errmsg"));
		home.setErrno(obj.getInt("errno"));
		home.setMsg(obj.getString("msg"));
		home.setServerlogid(obj.getLong("serverlogid"));
		home.setServerstatus(obj.getInt("serverstatus"));
		home.setTimestamp(obj.getLong("timestamp"));

		home.setData(paserHomeData(obj.getJSONObject("data")));
	}

	/**
	 * 解析HomeData
	 * 
	 * @param jsonObject
	 * @return
	 * @throws JSONException
	 */
	private HomeData paserHomeData(JSONObject obj) throws JSONException {
		HomeData homeData = new HomeData();

		homeData.setHotword(obj.getString("hotword"));
		
		homeData.setBanners(parserBanners(obj.getJSONArray("banners")));
		homeData.setCategory(parserCategory(obj.getJSONArray("category")));
		homeData.setRecommend(parserRecommend(obj.getJSONArray("recommend")));
		homeData.setSpecial(parserSpecial(obj.getJSONArray("special")));
		
		return homeData;
	}

	/**
	 * 解析Banners
	 * 
	 * @param array
	 * @return
	 * @throws JSONException
	 */
	private List<Banner> parserBanners(JSONArray array) throws JSONException {
		List<Banner> list = new ArrayList<Banner>();

		if (array != null && array.length() > 0) {
			Banner banner = null;
			JSONObject obj = null;
			for (int i = 0; i < array.length(); i++) {
				obj = array.getJSONObject(i);
				banner = new Banner();
				banner.setBanner_id(obj.getInt("banner_id"));
				banner.setCont(obj.getString("cont"));
				banner.setGoto_type(obj.getInt("goto_type"));
				banner.setPicture_url(obj.getString("picture_url"));
				banner.setBitmap(CommonBitmapHelper.getBitmap(banner.getPicture_url()));
				
				list.add(banner);
			}
		}
		return list;
	}


	/**
	 * 解析Category
	 * @param array
	 * @return
	 * @throws JSONException 
	 */
	private List<Category> parserCategory(JSONArray array) throws JSONException {
		List<Category> list = new ArrayList<Category>();
		if(array!=null&&array.length()>0){
			JSONObject obj = null;
			Category category = null;
			for(int i =0;i<array.length();i++){
				obj = array.getJSONObject(i);
				category = new Category();
				category.setCategory_id(obj.getString("category_id"));
				category.setCategory_name(obj.getString("category_name"));
				category.setCategory_picurl(obj.getString("category_picurl"));
				category.setHas_icon(obj.getInt("has_icon"));
				category.setIcon_url(obj.getString("icon_url"));
				category.setTiny_name(obj.getString("tiny_name"));
				category.setBitmap(CommonBitmapHelper.getBitmap(category.getCategory_picurl()));
				
				category.setCategory(parserCategoryKV(obj.getJSONArray("category")));
				list.add(category);
			}
		}
		return list;
	}

	/**
	 * 解析CategoryKV
	 * @param array
	 * @return
	 * @throws JSONException 
	 */
	private List<CategoryKV> parserCategoryKV(JSONArray array) throws JSONException {
		List<CategoryKV> list = new ArrayList<CategoryKV>();
		if(array!=null&&array.length()>0){
			JSONObject obj = null;
			CategoryKV categoryKV = null;
			for(int i = 0;i<array.length();i++){
				obj = array.getJSONObject(i);
				categoryKV = new CategoryKV();
				categoryKV.setKey(obj.getString("key"));
				categoryKV.setValue(obj.getString("value"));
				list.add(categoryKV);
			}
		}
		
		return list;
	}

	/**
	 * 解析Recommend
	 * @param array
	 * @return
	 * @throws JSONException 
	 */
	private List<Recommend> parserRecommend(JSONArray array) throws JSONException {
		List<Recommend> list = new ArrayList<Recommend>();
		if(array!=null && array.length()>0){
			JSONObject obj = null;
			Recommend recommend = null;
			for(int i = 0;i<array.length();i++){
				obj = array.getJSONObject(i);
				recommend = new Recommend();
				
				list.add(recommend);
			}
		}
		return list;
	}

	/**
	 * 解析Special
	 * @param array
	 * @return
	 * @throws JSONException 
	 */
	private List<Special> parserSpecial(JSONArray array) throws JSONException {
		List<Special> list = new ArrayList<Special>();
		if(array!=null&&array.length()>0){
			JSONObject obj = null;
			Special special = null;
			for(int i=0;i<array.length();i++){
				obj = array.getJSONObject(i);
				special = new Special();
				special.setCont(obj.getString("cont"));
				special.setGoto_type(obj.getInt("goto_type"));
				special.setPicture_url(obj.getString("picture_url"));
				special.setSpecial_id(obj.getInt("special_id"));
				special.setBitmap(CommonBitmapHelper.getBitmap(special.getPicture_url()));
				list.add(special);
			}
		}
		return list;
	}
}
