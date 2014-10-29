package com.tianxinwei.project.nuomi.common;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class CommonImageHelper {
	public static Bitmap getBitmap(String uri) {
		Bitmap bitmap = null;

		HttpURLConnection urlConn = null;
		try {
			URL url = new URL(uri);
			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setConnectTimeout(CommonConfig.TIMEOUT);
			urlConn.connect();
			bitmap = BitmapFactory.decodeStream(urlConn.getInputStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			urlConn.disconnect();
		}

		return bitmap;
	}

}
