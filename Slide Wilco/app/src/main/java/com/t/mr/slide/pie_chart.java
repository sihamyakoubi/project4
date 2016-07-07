package com.t.mr.slide;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.sql.Array;
import java.util.ArrayList;

public class pie_chart extends AppCompatActivity implements Charts {
    //lists for strings and floats from resultsets
    private RelativeLayout drawer_layout;
    private PieChart mChart;
    public static ArrayList<Float> yData1 = new ArrayList<>();
    public static ArrayList<String> xData1 = new ArrayList<>();
    //creating the chart and a new screen to put it on
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        drawer_layout = (RelativeLayout) findViewById(R.id.drawer_layout);
        mChart = new PieChart(this);
        drawer_layout.addView(mChart);
        drawer_layout.setBackgroundColor(Color.LTGRAY);
        mChart.setUsePercentValues(true);
        mChart.setDescription("Rotterdam Open Data");
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleRadius(7);
        mChart.setRotationEnabled(true);
        //Sets the size of the chart
        ViewGroup.LayoutParams params = mChart.getLayoutParams();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                if (e == null){
                    return;
                }
                   else{
                    Toast.makeText(pie_chart.this,
                            xData1.get(e.getXIndex()) + " = " + ((int) e.getVal()),
                            //xData[e.getXIndex()] + " = "  + e.getVal() + "%",
                            Toast.LENGTH_SHORT) .show();
                }
            }
            @Override
            public void onNothingSelected() {
            }
        });
        addData();
        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);
    }
    private void addData() {
        ArrayList<Entry> yValsl = new ArrayList<Entry>();
        for (int i = 0; i < xData1.size(); i++)
            yValsl.add(new Entry(yData1.get(i) , i));
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < yData1.size(); i++)
            xVals.add(xData1.get(i));
        //Creates the legend for this chart
        PieDataSet dataSet = new PieDataSet(yValsl, "Rotterdam Open Data");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.GRAY);

        mChart.setData(data);
        mChart.highlightValue(null);
        mChart.invalidate();
    }
}
