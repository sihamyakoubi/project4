package com.project4.wilco.project4;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button button;
    TextView object;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.button) ;
        this.object = (TextView) findViewById(R.id.textView);
        this.button.setOnClickListener(MainActivity.this);
    }

    @Override

    public void onClick(View v) {
        String SQL = "SELECT f.staat FROM fietstrommel f WHERE f.inventarisatienr = 'FT10'; ";
        ResultSet test = Query.returnrs(SQL,"1234");
        object.setText((CharSequence) test);
    }
}
