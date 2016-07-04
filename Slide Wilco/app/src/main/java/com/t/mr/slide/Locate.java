package com.t.mr.slide;
import android.app.Application;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

/**
 * Created by Wilco on 4-7-2016.
 */
public class Locate {


    private static final String TAG = "LocationAddress";
    public static String result = null;

    public static void getAddressFromLocation(final double latitude, final double longitude,
                                              final Context context) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());

                try {
                    List<Address> addressList = geocoder.getFromLocation(
                            latitude, longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                            sb.append(address.getAddressLine(i)).append("\n");
                        }

                        sb.append(address.getCountryName());
                        result = sb.toString();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Unable connect to Geocoder", e);
                } finally {

                    if (result != null) {

                        Bundle bundle = new Bundle();
                        result = "Address:\n" + result;
                        bundle.putString("address", result);

                    } else {

                        Bundle bundle = new Bundle();
                        result = "\n Unable to get address for this lat-long.";
                        bundle.putString("address", result);

                    }

                }
            }
        };
        thread.start();
    }
    public static void saveLocation(String loc){
        String youFilePath = Environment.getExternalStorageDirectory().toString()+"/location.txt";
        FileOutputStream oFile = null;

        try{
            oFile = new FileOutputStream(youFilePath, false);

        }catch(Exception e){
            e.printStackTrace();
        }

        if (oFile == null){
            File fLoc = new File(youFilePath);
            BufferedWriter bw = null;
            try{
                bw = new BufferedWriter(new FileWriter(youFilePath, true));

                bw.write(result);
                bw.newLine();
                bw.flush();
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                if (bw != null){
                    try{
                        bw.close();
                    }catch(Exception e){
                        e.printStackTrace();}}}
        }
        else{
            File fLoc = new File(youFilePath);
            fLoc.delete();
            File fLoc2 = new File(youFilePath);
            BufferedWriter bw = null;
            try{
                bw = new BufferedWriter(new FileWriter(youFilePath, true));
                bw.write(result);
                bw.newLine();
                bw.flush();
            }catch(Exception e) {
                e.printStackTrace();
            }finally {
                if (bw != null){
                    try{
                        bw.close();
                    }catch(Exception e){
                        e.printStackTrace();}}}}}
    public static void deleteLocation(){
        String youFilePath = Environment.getExternalStorageDirectory().toString()+"/location.txt";
        try{

            File file = new File(youFilePath);

            if(file.delete()){
            }else{
            }

        }catch(Exception e){
            e.printStackTrace();

        }
    }
}

