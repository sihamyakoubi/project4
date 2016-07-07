package com.t.mr.slide;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Wilco on 5-7-2016.
 */

//iterator
public class ConcreteIterator implements Iterator {


    public ConcreteIterator(){

    }
    public void GetCurrent(){

    }
    public boolean HasNext(){
        return true;
    }
    public void MoveNext(ArrayList<String> strings, ArrayList<Float> floats, String str, Float fl){
        strings.add(str);
        floats.add(fl);
    }
}

