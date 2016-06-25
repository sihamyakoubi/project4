package com.t.mr.charts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RelativeLayout mainLayout;
    private PieChart mChart;

    private float[] yData = { 20, 20, 20, 20, 20 };
    private String[] xData = { "Ik", "wil", "naar", "huis", "lol" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        mChart = new PieChart(this);

        mainLayout.addView(mChart);
        mainLayout.setBackgroundColor(Color.LTGRAY);

        mChart.setUsePercentValues(true);
        mChart.setDescription("u suck again!");

        mChart.setDrawHoleEnabled(true);
        //mChart.setHoleColorTransparent(true);
        mChart.setHoleRadius(7);
        mChart.setTransparentCircleRadius(10);

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);


        ViewGroup.LayoutParams params = mChart.getLayoutParams();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                if (e == null)
                    return;
                Toast.makeText(MainActivity.this,
                        xData[e.getXIndex()] + " = " + e.getVal() + "%",
                        Toast.LENGTH_SHORT) .show();
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

        for (int i = 0; i < yData.length; i++)
            yValsl.add(new Entry(yData[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xData.length; i++)
            xVals.add(xData[i]);

        PieDataSet dataSet = new PieDataSet(yValsl, "u suck");
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
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.GRAY);

        mChart.setData(data);

        mChart.highlightValue(null);

        mChart.invalidate();


    }
}
