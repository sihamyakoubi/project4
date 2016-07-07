package com.t.mr.slide;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Wilco on 6-7-2016.
 */

//IOptionVisitor interface
public interface IOptionVisitor {
    void onSome(ResultSet rs, ArrayList<String> strings, ArrayList<Float> floats, String tag);
    void onNone();
}
