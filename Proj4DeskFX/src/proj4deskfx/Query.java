package proj4deskfx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wilco
 */
public class Query {
    public static ResultSet getQueryResult(String SQL){
            String connectionString = "jdbc:jtds:sqlserver://project4.database.windows.net/project4;user=wilco;password=123project!;";
            ResultSet result = null;
            try {

                Class.forName("net.sourceforge.jtds.jdbc.Driver");
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
