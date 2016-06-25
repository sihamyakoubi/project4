package com.project4.wilco.project4;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Wilco on 25-6-2016.
 */
public class ContextGet extends Activity {
    public ContextGet(){
        MainActivity.context = this;
    }
}
