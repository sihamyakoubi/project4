package com.t.mr.slide;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Wilco on 6-7-2016.
 */

//some class for visitor
public class Some implements IOption {
    public void Visit(IOptionVisitor visitor, ResultSet rs, ArrayList<String> strings, ArrayList<Float> floats, String tag){
        visitor.onSome(rs,strings,floats,tag);
    }
}
