package com.project4.wilco.project4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wilco on 24-6-2016.
 */
public class Database extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "project4.db";

        public Database(Context context) {
            super(context, MakeSQLiteTable.DATABASE_NAME, null, MakeSQLiteTable.DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(MakeSQLiteTable.SQL_CREATE_ENTRIES);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(MakeSQLiteTable.SQL_DELETE_ENTRIES);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }
