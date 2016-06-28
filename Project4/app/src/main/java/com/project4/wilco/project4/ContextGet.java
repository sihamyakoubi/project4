package com.project4.wilco.project4;

import android.app.Application;
import android.content.Context;


/**
 * Created by Wilco on 25-6-2016.
 */
public class ContextGet extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        ContextGet.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return ContextGet.context;
    }
}
