package com.t.mr.slide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import net.sourceforge.jtds.jdbc.*;

/**
 * Created by tareq on 30-6-2016.
 */
public class Query_2 extends AppCompatActivity {

        public ResultSet getQueryResult(String SQL){
            String connectionString = "jdbc:jtds:sqlserver://project4.database.windows.net/project4;user=wilco;password=123project!;";
            ResultSet result = null;
            try {

                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                Connection DbConn = DriverManager.getConnection(connectionString);
                Statement stmt = DbConn.createStatement();
                result = stmt.executeQuery(SQL);
                String x = "";
                ResultSet resu = result;
                return resu;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }
