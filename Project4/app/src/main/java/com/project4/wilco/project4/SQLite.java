package com.project4.wilco.project4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wilco on 24-6-2016.
 */
public class SQLite extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "project4.db";

        public SQLite(Context context) {
            super(context, TestSQLite.DATABASE_NAME, null, TestSQLite.DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(TestSQLite.SQL_CREATE_ENTRIES);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(TestSQLite.SQL_DELETE_ENTRIES);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }
