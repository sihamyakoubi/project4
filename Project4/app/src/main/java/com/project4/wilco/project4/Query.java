package com.project4.wilco.project4;
import android.os.AsyncTask;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Wilco on 24-6-2016.
 */
public class Query  {
    public static ResultSet returnrs(String SQL, String passwd) {
        Connection c = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/user=postgres&password=1234&ssl=true";
            c = DriverManager
                    .getConnection(url);
            Statement stmt = c.createStatement();
            rs = stmt.executeQuery(SQL);
            System.out.println("hallo");

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
