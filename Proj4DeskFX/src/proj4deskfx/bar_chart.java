package proj4deskfx;
import java.awt.Color;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wilco
 */
public class bar_chart {
    public static ArrayList<String> strings = new ArrayList<>();
    public static ArrayList<Float> floats = new ArrayList<>();
    public static void onCreate(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int x = -1;
        for(float f : floats){
            x = x + 1;
            dataset.setValue(f, strings.get(x) , strings.get(x));
        }
        x = -1;
        //dataset.setValue(value4,"Marks", "Fietstrommel");
        
        
        JFreeChart chart = ChartFactory.createBarChart("Vergelijking", "", "Hoeveelheid gestolen fietsen", dataset, PlotOrientation.VERTICAL,false,true,false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);   
        ChartFrame frame = new ChartFrame ("Bar Chart for students", chart);
        frame.setVisible(true);
        frame.setSize(800,800);
            
    }
}
