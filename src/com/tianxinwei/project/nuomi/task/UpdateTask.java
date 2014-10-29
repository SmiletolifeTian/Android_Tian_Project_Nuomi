package com.tianxinwei.project.nuomi.task;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;

import com.tianxinwei.project.nuomi.common.CommonDialog;
import com.tianxinwei.project.nuomi.common.CommonInterface;
import com.tianxinwei.project.nuomi.entity.Update;

public class UpdateTask extends AsyncTask<String, Void, Void> {
	private Context context;
	private Update update;

	public UpdateTask(Context context) {
		this.context = context;
	}

	@Override
	protected Void doInBackground(String... params) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			UpdateHandler handler = new UpdateHandler();
			parser.parse(params[0], handler);
			update = handler.getUpdate();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		try {
			int versionCode = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0).versionCode;
			if (update.getVersion() > versionCode) {
				CommonDialog.confirm(context, update.getName(), update
						.getMessage().replace("-", "\r\n"), "升级",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								ApkDownLoadTask task = new ApkDownLoadTask(
										context);
								task.execute(CommonInterface.URI_APK);
							}
						}, new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								SharedPreferences sp = context
										.getSharedPreferences("isFirst",
												Context.MODE_PRIVATE);
								SharedPreferences.Editor editor = sp.edit();
								editor.putBoolean("update_or_not", false);
								editor.commit();
							}
						});
			} else {
				String versionName = context.getPackageManager()
						.getPackageInfo(context.getPackageName(), 0).versionName;

				CommonDialog.hint(context,
						String.format("你当前已经是最新版本 %s", versionName));
			}

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}

	class UpdateHandler extends DefaultHandler {
		private static final int NAME = 1;
		private static final int MESSAGE = 2;
		private static final int VERSION = 3;
		private static final int VERSION_NAME = 4;
		private int currentIndex = 0;
		private Update update;

		public Update getUpdate() {
			return update;
		}

		@Override
		public void startDocument() throws SAXException {
			update = new Update();
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			if ("name".equals(qName)) {
				currentIndex = NAME;
			} else if ("message".equals(qName)) {
				currentIndex = MESSAGE;
			} else if ("version".equals(qName)) {
				currentIndex = VERSION;
			} else if ("version_name".equals(qName)) {
				currentIndex = VERSION_NAME;
			}

		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			String value = new String(ch, start, length);
			switch (currentIndex) {
			case NAME:
				update.setName(value);
				break;
			case MESSAGE:
				update.setMessage(value);
				break;
			case VERSION:
				update.setVersion(Integer.parseInt(value));
				break;
			case VERSION_NAME:
				update.setVersionName(value);
				break;

			default:
				break;
			}
			currentIndex = 0;
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
		}

		@Override
		public void endDocument() throws SAXException {
		}

	}

}
