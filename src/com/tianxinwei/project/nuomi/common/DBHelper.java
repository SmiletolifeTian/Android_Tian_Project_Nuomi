package com.tianxinwei.project.nuomi.common;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "database.db";
	private static final int VERSION = 1;
	private SQLiteDatabase db;

	public DBHelper(Context context) {
		super(context, DB_NAME, null, VERSION);

		db = getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String drop = "DROP TABLE IF EXISTS table_tuan";
		db.execSQL(drop);
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("CREATE TABLE IF NOT EXISTS table_tuan(		          	  ");
		stringBuffer.append("       _id INTEGER PRIMARY KEY AUTOINCREMENT,			  ");
		stringBuffer.append("       deal_id TEXT,                         			  ");
		stringBuffer.append("       business_title TEXT,                      		  ");
		stringBuffer.append("       subtitle TEXT,                     				  ");
		stringBuffer.append("       min_image TEXT,                       			  ");
		stringBuffer.append("       sell_count INTEGER,                   			  ");
		stringBuffer.append("       current_price INTEGER,                			  ");
		stringBuffer.append("       market_price INTEGER                 			  ");
		stringBuffer.append(")                                           			  ");
		String sql = stringBuffer.toString();
		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(newVersion>oldVersion){
			onCreate(db);
		}
	}
	
	public void exeSQL(String sql,Object...bindArgs){
		db.execSQL(sql, bindArgs);
	}
	
	public Cursor exeQurey(String sql,String... selectionArgs){
		return db.rawQuery(sql, selectionArgs);
	}

}
