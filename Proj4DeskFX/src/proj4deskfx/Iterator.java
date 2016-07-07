/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj4deskfx;
import java.util.ArrayList;
/**
 *
 * @author Wilco
 */
public interface Iterator {
    void GetCurrent();
    boolean HasNext();
    void MoveNext(ArrayList<String> strings, ArrayList<Float> floats, String str, Float fl);
}
