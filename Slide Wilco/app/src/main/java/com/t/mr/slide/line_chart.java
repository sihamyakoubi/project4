package com.t.mr.slide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class line_chart extends AppCompatActivity implements Charts {
    //lists for strings and floats from resultsets
    private RelativeLayout drawer_layout;
    private LineChart mChart;
    public static ArrayList<Float> floats = new ArrayList<>();
    public static ArrayList<String> strings = new ArrayList<>();
    //creating the chart and a new screen to put it on
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart2);
        drawer_layout = (RelativeLayout) findViewById(R.id.drawer_layout);

        mChart = new LineChart(this);
        drawer_layout.addView(mChart);
        //Sets the size of the chart
        ViewGroup.LayoutParams params = mChart.getLayoutParams();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;

        int x = -1;

        ArrayList<Entry> entries = new ArrayList<>();
        for(float v : floats){
            x = x + 1;
            entries.add(new Entry(floats.get(x),x));
        }





        LineDataSet dataset = new LineDataSet(entries, "Stolen bicycles per month (2010/01/01 - 2013/12/31");

        int s = -1;
        ArrayList<String> labels = new ArrayList<String>();
        for (String str : strings){
            //s = s + 1;
            labels.add(str);
        }
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                                                   @Override
                                                   public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                                                       if (e == null) {
                                                           return;
                                                       } else {
                                                           Toast.makeText(line_chart.this,
                                                                   strings.get(e.getXIndex()) + " = " + ((int) e.getVal()),
                                                                   //xData[e.getXIndex()] + " = "  + e.getVal() + "%",
                                                                   Toast.LENGTH_SHORT).show();

                                                       }
                                                   }
                                                @Override
                                                public void onNothingSelected() {
                                                }
                                               });

        LineData data = new LineData(labels, dataset);

        dataset.setColor(Color.RED); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(false);
        //Animates the chart
        mChart.setData(data);
        mChart.animateX(5000);
        return;
    }
}
