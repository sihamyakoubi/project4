package com.t.mr.slide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.BarChart;

public class bar_chart extends AppCompatActivity {


    protected RelativeLayout drawer_layout;
    private BarChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        drawer_layout = (RelativeLayout) findViewById(R.id.drawer_layout);

        mChart = new BarChart(this);
        drawer_layout.addView(mChart);

        mChart.setDescription("Gallo Again!");


    }
}
