package com.tianxinwei.project.nuomi.common;

import android.os.Handler;
import android.widget.ImageView;

import com.tianxinwei.project.nuomi.R;

public class CommonLoading {
	private int[] imgIds = new int[]{R.drawable.tip_loading1,R.drawable.tip_loading2,R.drawable.tip_loading3};
	private Handler handler = new Handler();
	private int imgCount;
	private ImageView imgLoading;
	
	public CommonLoading(ImageView imageView){
		imgLoading = imageView;
	}
	
	public void startChangeImage(){
		handler.removeCallbacks(runnable);
		handler.postDelayed(runnable, 300);
	}

	public void stopChangeImage(){
		handler.removeCallbacks(runnable);
	}
	
	private Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			changeImageInterval();
			
		}
	};
	
	private void changeImageInterval(){
		switch (imgCount%3) {
		case 0:
			imgLoading.setImageResource(imgIds[0]);
			break;
		case 1:
			imgLoading.setImageResource(imgIds[1]);
			break;
		case 2:
			imgLoading.setImageResource(imgIds[2]);
			break;

		default:
			break;
		}
		imgCount++;
		handler.postDelayed(runnable, 300);
	}
	
	
	
}
