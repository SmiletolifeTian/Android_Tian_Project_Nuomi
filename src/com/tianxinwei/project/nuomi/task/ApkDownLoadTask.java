package com.tianxinwei.project.nuomi.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;

public class ApkDownLoadTask extends AsyncTask<String, Integer, File> {
	private Context context;
	private ProgressDialog progressDialog;
	
	public ApkDownLoadTask(Context context){
		this.context = context;
	}

	@Override
	protected void onPreExecute() {
		progressDialog = new ProgressDialog(context);
		progressDialog.setMax(100);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.show();
	}

	@Override
	protected File doInBackground(String... params) {
		File downloadFile = null;
		FileOutputStream fos = null;
		InputStream is =  null; 
		try {
			HttpClient httpClient = new DefaultHttpClient();
			HttpParams httpParams = httpClient.getParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
			HttpGet httpGet = new HttpGet(params[0]);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if (httpResponse != null
					&& httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity httpEntity = httpResponse.getEntity();
				if (httpEntity != null) {
					long length = httpEntity.getContentLength();
					is = httpEntity.getContent();

					String path = Environment.getExternalStorageDirectory()
							+ "/nuomi/";
					String name = "nuomi_update.apk";

					File pathFile = new File(path);
					if (!pathFile.exists()) {
						pathFile.mkdir();
					}

					downloadFile = new File(path + name);
					fos = new FileOutputStream(downloadFile);

					byte[] buf = new byte[1024];
					int len = -1, count = 0;
					while ((len = is.read(buf)) != -1) {
						fos.write(buf, 0, len);
						fos.flush();
						count += len;
						publishProgress((int) (count * 100 / length));
					}
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return downloadFile;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		progressDialog.setProgress(values[0]);
	}

	@Override
	protected void onPostExecute(File result) {
		progressDialog.dismiss();
		
		Intent apkIntent = new Intent(Intent.ACTION_VIEW);
		apkIntent.setDataAndType(
		Uri.parse("file://" + result.toString()),
		"application/vnd.android.package-archive");
		context.startActivity(apkIntent); 
	}

}
