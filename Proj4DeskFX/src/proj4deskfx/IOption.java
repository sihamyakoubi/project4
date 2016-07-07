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
public interface IOption {
    void Visit(IOptionVisitor visitor, ResultSet rs, ArrayList<String> strings, ArrayList<Float> floats, String tag);
}

