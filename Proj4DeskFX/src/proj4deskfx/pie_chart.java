package proj4deskfx;
import java.util.ArrayList;
import javax.swing.JComboBox;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wilco
 */
public class pie_chart implements Charts{
    public static ArrayList<String> strings = new ArrayList<>();
    public static ArrayList<Float> floats = new ArrayList<>();
    public void onCreate(){
        DefaultPieDataset pieDataset = new  DefaultPieDataset();
        int x = -1;
        for (float f : floats){
            x = x + 1;
            pieDataset.setValue(strings.get(x)+ "=" + (int) f,f);
        }
        x = -1;
        
        JFreeChart chart= ChartFactory.createPieChart("Pie Chart",pieDataset, true, true, true);
        PiePlot p = (PiePlot)chart.getPlot();
        //p.setForegroundAlpha(TOP_ALIGNMENT);
        ChartFrame frame = new ChartFrame ("Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(800,800);
   }
}
