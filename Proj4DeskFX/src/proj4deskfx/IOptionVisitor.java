/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj4deskfx;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Wilco
 */

//IOptionVisitor interface
public interface IOptionVisitor {
    void onSome(ResultSet rs, ArrayList<String> strings, ArrayList<Float> floats, String tag);
    void onNone();
}
