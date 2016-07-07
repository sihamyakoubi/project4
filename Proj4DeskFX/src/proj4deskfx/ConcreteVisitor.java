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
public class ConcreteVisitor implements IOptionVisitor{
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
