package com.project4.wilco.project4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button) ;
        this.button = button1;
        button1.setOnClickListener(MainActivity.this);
    }




    public void onClick(View v) {
        button.setVisibility(View.INVISIBLE);
    }
}
