package com.project4.wilco.project4;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button button;
    TextView object;
    public static Context context;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.button) ;
        this.object = (TextView) findViewById(R.id.textView);
        this.button.setOnClickListener(MainActivity.this);
    }

    @Override

    public void onClick(View v) {
        String SQL = "SELECT COUNT(*) FROM fietsdiefstal;";
        ResultSet rs = Query.returnrs(SQL);
        try{
            //String x =
            button.setText(rs.getString(0));
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        //String[] selectionargs = new String[]{"BADWEG"};
        //Database mDbHelper = new Database(this);
        //SQLiteDatabase db = mDbHelper.getWritableDatabase();
        //SQLiteDatabase db2 = mDbHelper.getReadableDatabase();
        //GetData data = new GetData(db,this);
        //db.beginTransaction();
        //Cursor cursor = db2.rawQuery(SQL,selectionargs);
        //db.endTransaction();
        //String answer = "";
        //if(cursor!=null && cursor.getCount()>0){
        //    cursor.moveToFirst();
        //    answer = cursor.getString(0);
        //    button.setText(answer);
        //}



    }




    }

