package com.project4.wilco.project4;

import android.app.Activity;
import android.content.ContentValues;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Wilco on 25-6-2016.
 */
public class GetData extends Activity {
    ArrayList<String> voorvalnummer = new ArrayList<String>();
    ArrayList<String> district = new ArrayList<String>();
    ArrayList<String> werkgebied = new ArrayList<String>();
    ArrayList<String> plaats = new ArrayList<String>();
    ArrayList<String> buurt = new ArrayList<String>();
    ArrayList<String> straat = new ArrayList<String>();
    ArrayList<String> begin_dagsoort = new ArrayList<String>();
    ArrayList<String> begindatum = new ArrayList<String>();
    ArrayList<String> begintijd = new ArrayList<String>();
    ArrayList<String> eind_dagsoort = new ArrayList<String>();
    ArrayList<String> einddatum = new ArrayList<String>();
    ArrayList<String> eindtijd = new ArrayList<String>();
    ArrayList<String> gemjaar = new ArrayList<String>();
    ArrayList<String> gemmaand = new ArrayList<String>();
    ArrayList<String> gemdag = new ArrayList<String>();
    ArrayList<String> gemdagdeel = new ArrayList<String>();
    ArrayList<String> trefwoord = new ArrayList<String>();
    ArrayList<String> voertuig = new ArrayList<String>();
    ArrayList<String> merk = new ArrayList<String>();
    ArrayList<String> type = new ArrayList<String>();
    ArrayList<String> kleur = new ArrayList<String>();

    public GetData(SQLiteDatabase db, AppCompatActivity main){

        AssetManager manager = main.getAssets();
        String mCSVfile = "fietsdiefstal.csv";
        InputStream inStream = null;
        try {
            inStream = manager.open(mCSVfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inStream));



        String tableName ="fietsdiefstal";
        String columns = "voorvalnummer, district, werkgebied, plaats, buurt, straat, begin_dagsoort, begindatum, begintijd, eind_dagsoort, einddatum, eindtijd, gemjaar, gemmaand, gemdag, gemdagdeel, trefwoord, voertuig, merk, type, kleur";
        String str1 = "INSERT INTO fietsdiefstal" + "(" + columns + ") values(";
        String str2 = ");";

        String line = "";
        db.beginTransaction();
        //try {
            for(int x = 0; x <= 500; x = x + 1) {
                try{
                    Thread.sleep(10);}
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                try{
                    line = buffer.readLine();}
                catch (IOException e){
                    e.printStackTrace();
                }
                String[] colums = line.split(",");
                ContentValues cv = new ContentValues(21);
                cv.put("voorvalnummer", colums[0].trim() + "");
                cv.put("district", colums[1].trim() + "");
                cv.put("werkgebied", colums[2].trim() + "");
                cv.put("plaats", colums[3].trim() + "");
                cv.put("buurt", colums[4].trim() + "");
                cv.put("straat", colums[5].trim() + "");
                cv.put("begin_dagsoort", colums[6].trim() + "");
                cv.put("begindatum", colums[7].trim() + "");
                cv.put("begintijd", colums[8].trim() + "");
                cv.put("eind_dagsoort", colums[9].trim() + "");
                cv.put("einddatum", colums[10].trim() + "");
                cv.put("eindtijd", colums[11].trim() + "");
                cv.put("gemjaar", colums[12].trim() + "");
                cv.put("gemmaand", colums[13].trim() + "");
                cv.put("gemdag", colums[14].trim() + "");
                cv.put("gemdagdeel", colums[15].trim() + "");
                cv.put("trefwoord", colums[16].trim() + "");
                cv.put("voertuig", colums[17].trim() + "");
                cv.put("merk", colums[18].trim() + "");
                cv.put("type", colums[19].trim() + "");
                cv.put("kleur", colums[20].trim() + "");
                db.insert("fietsdiefstal", null, cv);
                colums = null;
            }
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        db.setTransactionSuccessful();
        db.endTransaction();

    }
}
