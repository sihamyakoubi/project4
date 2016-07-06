
import java.util.ArrayList;
import javax.swing.JComboBox;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wilco
 */
public class line_chart {
    public static ArrayList<String> strings = new ArrayList<>();
    public static ArrayList<Float> floats = new ArrayList<>();
    public static void onCreate(JComboBox jComboBox2){
        XYSeriesCollection data = new XYSeriesCollection();
        int x = -1;
        XYSeries dataset = new XYSeries("First");
        for(float f : floats){
            x = x + 1;
            dataset.add(x,f);
        }
        data.addSeries(dataset);
        
        x = -1;
        
        
        JFreeChart chart = ChartFactory.createXYLineChart("Line graph", "gemmaand", "Gestolen fietsen", data, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer renderer= null;
            CategoryPlot plot = null;
            renderer = new BarRenderer();
            ChartFrame frame = new ChartFrame("Line Graph", chart);
            frame.setVisible(true);
            frame.setSize(450,600);
    }
}
