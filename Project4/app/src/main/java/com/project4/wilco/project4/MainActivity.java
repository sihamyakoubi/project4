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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        String SQL = "SELECT f.Straat FROM fietsdiefstal f WHERE f.[begin dagsoort] = DO";
        //String[] selectionargs = new String[]{"DO"};
        //ContextGet get = new ContextGet();
        //Database mDbHelper = new Database(this);
        //SQLiteDatabase db = mDbHelper.getWritableDatabase();
        //SQLiteDatabase db2 = mDbHelper.getReadableDatabase();
        //GetData data = new GetData(db,this);
        //Cursor cursor = db2.rawQuery(SQL,selectionargs);
        //String num = "";
        //if( cursor != null && cursor.moveToFirst() ){
        //    num = cursor.getString(cursor.getColumnIndex("straat"));
        //    cursor.close();
        //}
        ConnectionClass conn = new ConnectionClass();
        //Connection c = conn.CONN();

        try{
            Statement st = ConnectionClass.conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            button.setText(rs.getString(0));
        }
        catch (SQLException e){
            e.printStackTrace();
        }



    }
}
