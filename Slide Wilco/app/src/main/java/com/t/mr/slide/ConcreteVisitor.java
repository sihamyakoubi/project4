package com.t.mr.slide;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Wilco on 6-7-2016.
 */

//visitor
public class ConcreteVisitor implements IOptionVisitor {
    public void onSome(ResultSet rs, ArrayList<String> strings, ArrayList<Float> floats, String tag){
        try{
            while (rs.next()) {
                strings.add("");
                floats.add(rs.getFloat("counter"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void onNone(){
    }
}
