package com.t.mr.slide;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

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
        ViewGroup.LayoutParams params = mChart.getLayoutParams();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));

        BarDataSet dataset = new BarDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");




        BarData data = new BarData(labels, dataset);
        mChart.setData(data);

        mChart.setDescription("# of times Alice called Bob");

//        ColorTemplate.LIBERTY_COLORS
//        ColorTemplate.COLORFUL_COLORS
//        ColorTemplate.JOYFUL_COLORS
//        ColorTemplate.PASTEL_COLORS
//        ColorTemplate.VORDIPLOM_COLORS

        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        mChart.animateY(5000);


    }
}