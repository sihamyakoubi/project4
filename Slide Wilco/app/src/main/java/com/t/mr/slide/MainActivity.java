package com.t.mr.slide;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import net.sourceforge.jtds.jdbc.*;
import org.w3c.dom.Text;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{
    public static Button button;
    public static Button button2;
    public static TextView textView;
    public static TextView textViewLine2;
    public static NumberPicker np2;
    public static Button buttonLine;
    public static Button buttonBar1;
    public static Button buttonBar2;
    public static TextView textBar1;
    public static TextView textBar2;
    public static TextView textLine1;
    public static Spinner spinner;
    public static Button buttonLocation1;
    public static Button buttonLocation2;
    private Location mLastLocation;
    com.google.android.gms.common.api.GoogleApiClient mGoogleApiClient;
    public LocationManager mLocationManager;
    public static WebView webView;
    public static ImageButton imageButton;
    public static ArrayList<Integer> intList = new ArrayList<Integer>();
    public static ArrayList<Integer> intListRec = new ArrayList<Integer>();
    public void enableStrictMode()
    {        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enableStrictMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url ="http://rotterdamopendata.nl/dataset";
        WebView view=(WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
        this.webView = (WebView) findViewById(R.id.webView);
        this.button = (Button) findViewById(R.id.button);
        this.button2 = (Button) findViewById(R.id.button2);
        this.textView = (TextView) findViewById(R.id.textView2);
        this.textViewLine2 = (TextView) findViewById(R.id.textView4);
        this.np2 = (NumberPicker) findViewById(R.id.numberPicker2);
        this.buttonLine = (Button) findViewById(R.id.button3);
        this.buttonBar1 = (Button) findViewById(R.id.button4);
        this.buttonBar2 = (Button) findViewById(R.id.button5);
        this.textBar1 = (TextView) findViewById(R.id.textView3);
        this.textBar2 = (TextView) findViewById(R.id.textView5);
        this.textLine1 = (TextView) findViewById(R.id.textView6);
        this.spinner = (Spinner) findViewById(R.id.spinner);
        this.buttonLocation1 = (Button) findViewById(R.id.button6);
        this.buttonLocation2 = (Button) findViewById(R.id.button7);
        this.imageButton = (ImageButton) findViewById(R.id.imageButton);
        np2.setMaxValue(2013); np2.setMinValue(2010); np2.setValue(2010);
        String SQL = "Select DISTINCT fietsdiefstal.Buurt, fietstrommel.Deelgem as buur FROM fietstrommel, fietsdiefstal WHERE fietstrommel.Deelgem = fietsdiefstal.Buurt";
        Query_2 querry = new Query_2();
        ResultSet res = querry.getQueryResult(SQL);
        ArrayList<String> buurt = new ArrayList<>();
        buurt.add("CENTRUM"); buurt.add("DELFSHAVEN"); buurt.add("FEIJENOORD"); buurt.add("OVERSCHIE"); buurt.add("PERNIS");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, buurt);
        spinner.setAdapter(adapter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        int LOCATION_REFRESH_TIME = 1000;
        int LOCATION_REFRESH_DISTANCE = 5;
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return  ;
        }
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME, LOCATION_REFRESH_DISTANCE, mLocationListener);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SQL = "SELECT TOP (5) Merk, COUNT(*) as counter FROM [dbo].[fietsdiefstal] GROUP BY Merk ORDER BY COUNT(*) DESC;";
                Query_2 quer = new Query_2();
                ResultSet res = quer.getQueryResult(SQL);
                try {
                    while(res.next()) {
                        pie_chart.xData1.add(res.getString("Merk"));
                        pie_chart.yData1.add(res.getFloat("counter"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, pie_chart.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SQL = "SELECT TOP (5) Kleur, COUNT(*) as counter FROM [dbo].[fietsdiefstal] GROUP BY Kleur ORDER BY COUNT(*) DESC;";
                Query_2 quer = new Query_2();
                ResultSet res = quer.getQueryResult(SQL);
                try {
                    while(res.next()) {
                        pie_chart.xData1.add(res.getString("Kleur"));
                        pie_chart.yData1.add(res.getFloat("counter"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, pie_chart.class);
                startActivity(intent);
            }

        });
        buttonLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String SQL = "SELECT  COUNT(*) as counter FROM fietsdiefstal WHERE (Begindatum > '" + np2.getValue() + "-01-01 00:00:00.000')" +
                            " AND (Begindatum < '" + np2.getValue() + "-12-31 00:00:00.000') GROUP BY DATEPART(YEAR, Begindatum), DATEPART(MONTH, Begindatum)";
                    Query_2 quer = new Query_2();
                    ResultSet res = quer.getQueryResult(SQL);
                        try {
                        while(res.next()) {
                            line_chart.floats.add((float)res.getInt("counter"));
                            line_chart.strings.add("");
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                Intent intent = new Intent(MainActivity.this, line_chart.class);
                startActivity(intent);
            }
        });
        buttonBar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SQL = "SELECT TOP(5) Deelgem,COUNT(*) as counter FROM fietstrommel GROUP BY Deelgem ORDER BY COUNT(*) DESC" ;
                Query_2 quer = new Query_2();
                ResultSet res = quer.getQueryResult(SQL);
                try {
                    while(res.next()) {
                        bar_chart.floats.add((float)res.getInt("counter"));
                        bar_chart.strings.add(res.getString("Deelgem"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, bar_chart.class);
                startActivity(intent);
            }
        });
        buttonBar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SQL = "SELECT Deelgem,COUNT(*) as counter FROM fietstrommel WHERE Deelgem = '" + spinner.getSelectedItem() + "' GROUP BY Deelgem";
                Query_2 quer = new Query_2();
                ResultSet res = quer.getQueryResult(SQL);
                String SQL2 = "SELECT Buurt,COUNT(*) as counter FROM fietsdiefstal WHERE Buurt = '" + spinner.getSelectedItem() + "' GROUP BY Buurt";
                ResultSet res2 = quer.getQueryResult(SQL2);
                try {while(res.next()) {
                        bar_chart.floats.add((float)res.getInt("counter"));
                        bar_chart.strings.add("Trommels");}
                }catch(Exception e){
                    e.printStackTrace();}
                try {
                    while (res2.next()){
                        bar_chart.floats.add((float)res2.getInt("counter"));
                        bar_chart.strings.add("Diefstallen");
                    }}catch(Exception e){
                    e.printStackTrace();}
                Intent intent = new Intent(MainActivity.this, bar_chart.class);
                startActivity(intent);
            }
        });
        buttonLocation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                        mGoogleApiClient);
                if (mLastLocation != null) {
                }
                Locate.getAddressFromLocation(mLastLocation.getLatitude(),mLastLocation.getLongitude(),MainActivity.this);
                try{
                    Thread.sleep(500);
                }catch(Exception e){
                    e.printStackTrace();
                }
                Locate.saveLocation(Locate.result);
            }
        });
        buttonLocation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locate.deleteLocation();
            }
        });
    }
    public void onAddEventClicked(View view){
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");
        Calendar cal = Calendar.getInstance();
        long startTime = cal.getTimeInMillis();
        long endTime = cal.getTimeInMillis()  + 60 * 60 * 1000;
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
        intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
        intent.putExtra(CalendarContract.Events.TITLE, "Gestolen fiets");
        intent.putExtra(CalendarContract.Events.DESCRIPTION,  "Description");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My location");
        intent.putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");
        startActivity(intent);
    }
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }
    @Override
    public void onConnected(Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
        }
    }
    @Override
    public void onConnectionSuspended(int i) {

    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        TextView textView1 = (TextView) findViewById(R.id.textView);
        DrawerLayout nav_view = (DrawerLayout) findViewById(R.id.drawer_layout);
        switch (menuItem.getItemId()) {
            // Handle navigation view item clicks here.
            case R.id.nav_bar_main:
                webView.setVisibility(View.VISIBLE);
                buttonLocation1.setVisibility(View.VISIBLE);
                buttonLocation2.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textViewLine2.setVisibility(View.INVISIBLE);
                np2.setVisibility(View.INVISIBLE);
                buttonLine.setVisibility(View.INVISIBLE);
                textBar1.setVisibility(View.INVISIBLE);
                textBar2.setVisibility(View.INVISIBLE);
                buttonBar1.setVisibility(View.INVISIBLE);
                buttonBar2.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                nav_view.closeDrawers();
                return true;
            case R.id.nav_pie_chart:
                button.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textViewLine2.setVisibility(View.INVISIBLE);
                np2.setVisibility(View.INVISIBLE);
                buttonLine.setVisibility(View.INVISIBLE);
                textLine1.setVisibility(View.INVISIBLE);
                textBar1.setVisibility(View.INVISIBLE);
                textBar2.setVisibility(View.INVISIBLE);
                buttonBar1.setVisibility(View.INVISIBLE);
                buttonBar2.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                buttonLocation1.setVisibility(View.INVISIBLE);
                buttonLocation2.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.INVISIBLE);
                nav_view.closeDrawers();
                pie_chart.xData1 = new ArrayList<String>();
                pie_chart.yData1 = new ArrayList<Float>();
                return true;
            case R.id.nav_line_chart:
                menuItem.setChecked(true);
                textViewLine2.setVisibility(View.VISIBLE);
                np2.setVisibility(View.VISIBLE);
                buttonLine.setVisibility(View.VISIBLE);
                textLine1.setVisibility(View.VISIBLE);

                textBar1.setVisibility(View.INVISIBLE);
                textBar2.setVisibility(View.INVISIBLE);
                buttonBar1.setVisibility(View.INVISIBLE);
                buttonBar2.setVisibility(View.INVISIBLE);
                button.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.INVISIBLE);
                buttonLocation1.setVisibility(View.INVISIBLE);
                buttonLocation2.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.INVISIBLE);
                nav_view.closeDrawers();
                line_chart.strings = new ArrayList<String>();
                line_chart.floats = new ArrayList<Float>();
                return true;
            case R.id.nav_bar_chart:
                textBar1.setVisibility(View.VISIBLE);
                textBar2.setVisibility(View.VISIBLE);
                buttonBar1.setVisibility(View.VISIBLE);
                buttonBar2.setVisibility(View.VISIBLE);
                spinner.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                textViewLine2.setVisibility(View.INVISIBLE);
                np2.setVisibility(View.INVISIBLE);
                buttonLine.setVisibility(View.INVISIBLE);
                buttonLocation1.setVisibility(View.INVISIBLE);
                buttonLocation2.setVisibility(View.INVISIBLE);
                textLine1.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.INVISIBLE);
                nav_view.closeDrawers();
                bar_chart.strings = new ArrayList<String>();
                bar_chart.floats = new ArrayList<Float>();
                return true;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private final android.location.LocationListener mLocationListener = new android.location.LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            //code
            System.out.println("onLocationChanged");
            mLastLocation = location;
            // mainLabel.setText("Latitude:" + String.valueOf(location.getLatitude()) + "\n" + "Longitude:" + String.valueOf(location.getLongitude()));
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            System.out.println("onStatusChanged");
        }
        @Override
        public void onProviderEnabled(String provider) {
            System.out.println("onProviderEnabled");
        }
        @Override
        public void onProviderDisabled(String provider) {
            System.out.println("onProviderDisabled");
            //turns off gps services
        }
    };
}