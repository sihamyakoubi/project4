package com.project4.wilco.project4;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * Created by Wilco on 28-6-2016.
 */
public class ConnectionClass {
    String ip = "142.24.221.226";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "project4";
    String un = "Wilco";
    String password = "";
    public static Connection conn;
    //@SuppressLint("NewApi")
    public  ConnectionClass() {

        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
        //        .permitAll().build();
        //StrictMode.setThreadPolicy(policy);

        String ConnURL = null;
        try {

            Class.forName(classs).newInstance();
            ConnURL = "jdbc:jtds:sqlserver://" + ip + "; "
                    + "databaseName=" + db + "; user=" + un + "; password="
                    + password + ";";
            this.conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        //return conn;
    }
}
