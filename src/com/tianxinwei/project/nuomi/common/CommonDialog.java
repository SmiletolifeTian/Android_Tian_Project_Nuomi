package com.tianxinwei.project.nuomi.common;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;

public class CommonDialog {
	private static ProgressDialog progressDialg;

	public static void showProgressDialog(Context context, String message) {
		progressDialg = new ProgressDialog(context);
		progressDialg.setMessage(message);
		progressDialg.setCancelable(false);
		progressDialg.show();
	}

	public static void hideProgressDialog() {
		progressDialg.dismiss();
	}

	public static void hint(Context context, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(message);
		builder.setPositiveButton("È·¶¨", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		builder.create().show();
	}

	public static void confirm(Context context, String title, String message,
			String positiveText, DialogInterface.OnClickListener... listener) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton(positiveText, listener[0]);
		if (listener.length > 1) {
			builder.setNegativeButton("ºöÂÔ", listener[1]);
		} else {
			builder.setNegativeButton("ºöÂÔ",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
		}

		AlertDialog alertDialog = builder.show();
		TextView txMessage = (TextView) alertDialog
				.findViewById(android.R.id.message);
		txMessage.setTextSize(16);

	}
}
