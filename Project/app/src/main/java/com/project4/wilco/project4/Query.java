package com.project4.wilco.project4;
import android.os.AsyncTask;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.sourceforge.jtds.jdbc.*;

/**
 * Created by Wilco on 24-6-2016.
 */
public class Query  {
    public static ResultSet returnrs(String SQL) {
        Connection c = null;
        ResultSet rs = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String url = "jdbc:jtds:sqlserver://project4.database.windows.net/project4;user=wilco;password=123project!;";
            c = DriverManager.getConnection(url);
            Statement stmt = c.createStatement();
            rs = stmt.executeQuery(SQL);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return rs;
    }

    static Connection returnrs(Type String) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
