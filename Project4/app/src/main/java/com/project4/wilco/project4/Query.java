package com.project4.wilco.project4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import net.sourceforge.jdbc.jtds.*;
import java.sql.Statement;



/**
 * Created by Wilco on 24-6-2016.
 */
public class Query{

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
