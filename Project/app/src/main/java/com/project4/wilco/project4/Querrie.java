package com.project4.wilco.project4;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wilco on 29-6-2016.
 */
public class Querrie {
    public static List<String> fietsnummer = new ArrayList<String>();
    public static List<String> FT = new ArrayList<String>();
    public static List<String> Fietstrommel = new ArrayList<String>();
    public static List<String> straat = new ArrayList<String>();
    public static List<String> thv = new ArrayList<String>();
    public static List<String> Xcoord = new ArrayList<String>();
    public static List<String> Ycoord = new ArrayList<String>();
    public static List<String> deelgem = new ArrayList<String>();
    public static List<String> status = new ArrayList<String>();
    public static List<String> datum = new ArrayList<String>();



public Querrie(AppCompatActivity main){
    AssetManager manager = main.getAssets();
    String mCSVfile = "fietsdiefstal.csv";
    InputStream inStream = null;
    try {
        inStream = manager.open(mCSVfile);
    } catch (IOException e) {
        e.printStackTrace();
    }
    BufferedReader buffer = new BufferedReader(new InputStreamReader(inStream));

    String bufferRead = "";
    try{
        bufferRead = buffer.readLine();}
    catch (IOException e){
        e.printStackTrace();
    }
    while (bufferRead != null)
    {
        String[] values = bufferRead.split(",");



        fietsnummer.add(values[0]);
        FT.add(values[1]);
        Fietstrommel.add(values[2]);
        straat.add(values[3]);
        thv.add(values[4]);
        Xcoord.add(values[5]);
        Ycoord.add(values[6]);
        deelgem.add(values[7]);
        status.add(values[8]);
        datum.add(values[9]);
    }

}
}
