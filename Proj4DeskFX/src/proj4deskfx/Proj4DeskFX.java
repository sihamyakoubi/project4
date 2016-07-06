/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj4deskfx;

import java.sql.ResultSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Wilco
 */
public class Proj4DeskFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button mainmenu = new Button("Main Menu");
        Button barchart = new Button("Bar chart");
        Button linechart = new Button("Line chart");
        Button piechart = new Button("Pie chart");
        Button piechart1 = new Button("Per Brand");
        Button piechart2 = new Button("Per Color");
        Button barchart1 = new Button("Top 5");
        Button barchart2 = new Button("Per Neighborhood");
        Button linechar1 = new Button("Per Year");
        Text barcha1 = new Text("Bikecontainers:");
        Text barcha2 = new Text("Bikecontainers and bikethefts:");
        ComboBox co1 = new ComboBox();
        ComboBox co2 = new ComboBox();
        co2.getItems().addAll("2010","2011","2012","2013");
        co2.setValue("2010");
        co1.getItems().addAll("CENTRUM","DELFSHAVEN", "FEIJENOORD", "OVERSCHIE", "PERNIS");
        co1.setValue("CENTRUM");
        
        linechar1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                line_chart.floats.clear();
        line_chart.strings.clear();
        String SQL = "SELECT  COUNT(*) as counter FROM fietsdiefstal WHERE (Begindatum > '" + co2.getValue() + "-01-01 00:00:00.000')" +
                            " AND (Begindatum < '" + co2.getValue() + "-12-31 00:00:00.000') GROUP BY DATEPART(YEAR, Begindatum), DATEPART(MONTH, Begindatum)";
                 
        ResultSet rs = Query.getQueryResult(SQL);
        try{
            while (rs.next()){
                line_chart.floats.add(rs.getFloat("counter"));
                line_chart.strings.add("");
            }    
        }   
        catch(Exception e){
        e.printStackTrace();
        }
        line_chart.onCreate(co2);
            }
        });
        
        
        barchart1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                bar_chart.floats.clear();
        bar_chart.strings.clear();
        String SQL = "SELECT TOP(5) Deelgem,COUNT(*) as counter FROM fietstrommel GROUP BY Deelgem ORDER BY COUNT(*) DESC";
        ResultSet rs = Query.getQueryResult(SQL);
        try{
            while (rs.next()){
                bar_chart.floats.add(rs.getFloat("counter"));
                bar_chart.strings.add(rs.getString("Deelgem"));
            }    
        }   
        catch(Exception e){
        e.printStackTrace();
        }
        bar_chart.onCreate();
            }
        });
        
        barchart2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                bar_chart.floats.clear();
        bar_chart.strings.clear();
        String SQL = "SELECT Deelgem,COUNT(*) as counter FROM fietstrommel WHERE Deelgem = '" + co1.getValue() + "' GROUP BY Deelgem";
        ResultSet rs = Query.getQueryResult(SQL);
        try{
            while (rs.next()){
                bar_chart.floats.add(rs.getFloat("counter"));
                bar_chart.strings.add(co1.getValue()+ " - FIETSTROMMELS ");
            }    
        }   
        catch(Exception e){
        e.printStackTrace();
        }
        String SQL2 = "SELECT Buurt,COUNT(*) as counter FROM fietsdiefstal WHERE Buurt = '" + co1.getValue() + "' GROUP BY Buurt";
        ResultSet rs2 = Query.getQueryResult(SQL2);
        try{
            while (rs2.next()){
                bar_chart.floats.add(rs2.getFloat("counter"));
                bar_chart.strings.add(co1.getValue() + " - GESTOLEN BIKES");
            }    
        }   
        catch(Exception e){
        e.printStackTrace();
        }
        bar_chart.onCreate();
            }
        });
        
        piechart2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                pie_chart.floats.clear();
                pie_chart.strings.clear();
                String SQL = "SELECT TOP (5) Kleur, COUNT(*) as counter FROM [dbo].[fietsdiefstal] GROUP BY Kleur ORDER BY COUNT(*) DESC;";
                ResultSet rs = Query.getQueryResult(SQL);
                try{
                    while (rs.next()){
                        pie_chart.floats.add(rs.getFloat("counter"));
                        pie_chart.strings.add(rs.getString("Kleur"));
                }    
                }   
                    catch(Exception e){
                    e.printStackTrace();
                }
                    pie_chart.onCreate();
            
            }
        });
        piechart1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                pie_chart.floats.clear();
        pie_chart.strings.clear();
        String SQL = "SELECT TOP (5) Merk, COUNT(*) as counter FROM [dbo].[fietsdiefstal] GROUP BY Merk ORDER BY COUNT(*) DESC;";
        ResultSet rs = Query.getQueryResult(SQL);
        try{
            while (rs.next()){
                pie_chart.floats.add(rs.getFloat("counter"));
                pie_chart.strings.add(rs.getString("Merk"));
            }    
        }   
        catch(Exception e){
        e.printStackTrace();
        }
        pie_chart.onCreate();
            }
        });
        piechart.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                piechart1.setVisible(true); piechart2.setVisible(true);
        barchart1.setVisible(false); barchart2.setVisible(false);
        barcha1.setVisible(false); barcha2.setVisible(false);co1.setVisible(false);
        linechar1.setVisible(false); co2.setVisible(false);
            }
        });
        mainmenu.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                piechart1.setVisible(false); piechart2.setVisible(false);
        barchart1.setVisible(false); barchart2.setVisible(false);
        barcha1.setVisible(false); barcha2.setVisible(false);co1.setVisible(false);
        linechar1.setVisible(false); co2.setVisible(false);
            }
        });
        barchart.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                piechart1.setVisible(false); piechart2.setVisible(false);
        barchart1.setVisible(true); barchart2.setVisible(true);
        barcha1.setVisible(true); barcha2.setVisible(true);co1.setVisible(true);
        linechar1.setVisible(false); co2.setVisible(false);
            }
        });
        linechart.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                piechart1.setVisible(false); piechart2.setVisible(false);
        barchart1.setVisible(false); barchart2.setVisible(false);
        barcha1.setVisible(false); barcha2.setVisible(false);co1.setVisible(false);
        linechar1.setVisible(true); co2.setVisible(true);
            }
        });
        
        StackPane root = new StackPane();
        mainmenu.setTranslateX(-125);
        mainmenu.setTranslateY(-145);
        barchart.setTranslateX(-125);
        barchart.setTranslateY(-105);
        linechart.setTranslateX(-125);
        linechart.setTranslateY(-65);
        piechart.setTranslateX(-125);
        piechart.setTranslateY(-25);
        piechart1.setTranslateX(25);
        piechart1.setTranslateY(-125);
        piechart2.setTranslateX(25);
        piechart2.setTranslateY(-65);
        barcha1.setTranslateX(0);
        barcha1.setTranslateY(-100);
        barcha2.setTranslateX(0);
        barcha2.setTranslateY(-25);
        barchart1.setTranslateX(0);
        barchart1.setTranslateY(-75);
        barchart2.setTranslateX(0);
        barchart2.setTranslateY(0);
        co1.setTranslateX(0);
        co1.setTranslateY(-125);
        linechar1.setTranslateX(0);
        linechar1.setTranslateY(-75);
        co2.setTranslateX(0);
        co2.setTranslateY(-125);
        
        
        piechart1.setVisible(false); piechart2.setVisible(false);
        barchart1.setVisible(false); barchart2.setVisible(false);
        barcha1.setVisible(false); barcha2.setVisible(false); co1.setVisible(false);
        linechar1.setVisible(false); co2.setVisible(false);
        root.getChildren().add(mainmenu);
        root.getChildren().add(barchart);
        root.getChildren().add(linechart);
        root.getChildren().add(piechart);
        root.getChildren().add(piechart1);
        root.getChildren().add(piechart2);
        root.getChildren().add(barchart1);
        root.getChildren().add(barchart2);
        root.getChildren().add(barcha1);
        root.getChildren().add(barcha2);
        root.getChildren().add(co1);
        root.getChildren().add(co2);
        root.getChildren().add(linechar1);
        
        
        Scene scene = new Scene(root, 350, 350);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
