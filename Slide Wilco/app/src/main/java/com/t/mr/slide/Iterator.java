package com.t.mr.slide;

import java.util.ArrayList;

/**
 * Created by Wilco on 5-7-2016.
 */
public interface Iterator {

    void GetCurrent();
    boolean HasNext();
    void MoveNext(ArrayList<String> strings, ArrayList<Float> floats, String str, Float fl);
}
