package com.tianxinwei.project.nuomi.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.tianxinwei.project.nuomi.R;

public class WelcomeActivity extends Activity {
	private static final String SP_KEY_ISFIRST = "isFirst";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		
		directTo();
	}
	
	public void directTo(){
		SharedPreferences sp = getSharedPreferences("isFirst", MODE_PRIVATE);
		boolean isFirst = sp.getBoolean(SP_KEY_ISFIRST, true);
		if(isFirst){
			SharedPreferences.Editor editor = sp.edit();
			editor.putBoolean(SP_KEY_ISFIRST, false);
			editor.commit();
			
			startActivity(new Intent(this,GuideActivity.class));
			finish();
		}else{
			new CountDownTimer(3000,3000) {
				
				@Override
				public void onTick(long millisUntilFinished) {
					
				}
				
				@Override
				public void onFinish() {
					startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
					finish();
				}
			}.start();
		}
	}
}
