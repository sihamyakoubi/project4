package com.project4.wilco.project4;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    Button button;
    TextView object;
    public static int integer = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.button);
        this.object = (TextView) findViewById(R.id.textView);
        this.button.setOnClickListener(MainActivity.this);
    }

    //@Override

    public void onClick(View v) {
        String tareq = "";
        String SQL = "SELECT COUNT(*) FROM [dbo].[fietsdiefstal];";
        Query quer = new Query();
        ResultSet res = quer.getQueryResult(SQL);
        ArrayList<Integer> result = new ArrayList<Integer>();
        int cnt = 0;
        try {
            while (res.next()) {

                result.add(res.getInt(cnt));

                cnt++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        button.setText(result.get(0));

        //String SQL = "SELECT f.Straat FROM fietsdiefstal f WHERE f.[begin dagsoort] = DO";
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
        //ConnectionClass conn = new ConnectionClass();
        //Connection c = conn.CONN();

        //try{
        //  Statement st = ConnectionClass.conn.createStatement();
        //    ResultSet rs = st.executeQuery(SQL);

        //    button.setText(rs.getString(0));
        // }
        //  catch (SQLException e){
        //      e.printStackTrace();
        //  }



    }
}

