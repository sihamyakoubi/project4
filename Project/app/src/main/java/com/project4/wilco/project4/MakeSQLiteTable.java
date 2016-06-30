package com.project4.wilco.project4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Wilco on 24-6-2016.
 */


public class MakeSQLiteTable {
    private static final String TEXT_TYPE = " TEXT";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TableInfo.FeedEntry.TABLE_NAME + " (" +
                    TableInfo.FeedEntry.COLUMN_NAME1 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME2 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME3 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME4 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME5 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME6 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME7 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME8 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME9 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME10 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME11 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME12 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME13 + " INTEGER," +
                    TableInfo.FeedEntry.COLUMN_NAME14 + " INTEGER," +
                    TableInfo.FeedEntry.COLUMN_NAME15 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME16 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME17 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME18 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME19 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME20 + " TEXT," +
                    TableInfo.FeedEntry.COLUMN_NAME21 + " TEXT" +
            " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS fietsdiefstal";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "project4.db";


}


