package com.t.mr.slide;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class bar_chart extends AppCompatActivity {


    protected RelativeLayout drawer_layout;
    private BarChart mChart;

    public static ArrayList<Float> floats = new ArrayList<>();
    public static ArrayList<String> strings = new ArrayList<>();

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
        int x = -1;
        ArrayList<BarEntry> entries = new ArrayList<>();
        for(Float o : floats){
            x = x + 1;
            entries.add(new BarEntry(o, x));
        }

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                if (e == null) {
                    return;
                } else {
                    Toast.makeText(bar_chart.this,
                            strings.get(e.getXIndex()) + " = " + ((int) e.getVal()),
                            //xData[e.getXIndex()] + " = "  + e.getVal() + "%",
                            Toast.LENGTH_SHORT).show();

                }
            }
            @Override
            public void onNothingSelected() {
            }
        });

        BarDataSet dataset = new BarDataSet(entries, "Bar Chart");

        ArrayList<String> labels = new ArrayList<>();
        for(String o : strings){
            labels.add(o);
        }

        BarData data = new BarData(labels, dataset);
        mChart.setData(data);
        mChart.setDescription("Bar Chart");
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        dataset.setColors(colors);


        mChart.animateY(5000);


    }
}