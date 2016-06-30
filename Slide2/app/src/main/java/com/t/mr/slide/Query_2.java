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
            String connectionString = "jdbc:sqlserver://project4.database.windows.net:1433;database=project4;user=wilco@project4;password=123project!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            try {

                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                Connection DbConn = DriverManager.getConnection(connectionString);
                Statement stmt = DbConn.createStatement();
                ResultSet result = stmt.executeQuery(SQL);
                return result;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
