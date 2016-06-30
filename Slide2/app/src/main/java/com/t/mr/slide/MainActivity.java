package com.t.mr.slide;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.sourceforge.jtds.jdbc.*;

import org.w3c.dom.Text;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static Button button;
    public static Button button2;
    public static TextView textView;
    TextView object;
    public void enableStrictMode()
    {        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enableStrictMode();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.button = (Button) findViewById(R.id.button);
        this.button2 = (Button) findViewById(R.id.button2);
        this.textView = (TextView) findViewById(R.id.textView2);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SQL = "SELECT TOP (5) Merk, COUNT(*) as counter FROM [dbo].[fietsdiefstal] GROUP BY Merk;";
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

        switch (menuItem.getItemId()) {


            // Handle navigation view item clicks here.
            case R.id.nav_pie_chart:

                menuItem.setChecked(true);
                textView1.setText(menuItem.getTitle());
                button.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                //String SQL = "SELECT TOP (5) Merk, COUNT(*) as counter FROM [dbo].[fietsdiefstal] GROUP BY Merk;";
                //Query_2 quer = new Query_2();
                //ResultSet res = quer.getQueryResult(SQL);
                //try {
                //    while(res.next()) {
                //        button.setText(res.getString("counter"));
                //        pie_chart.xData1.add(res.getString("Merk"));
                //        pie_chart.yData1.add(res.getFloat("counter"));
                //    }
                //}catch(Exception e){
                //    e.printStackTrace();
                //
                //  }
                //Intent intent = new Intent(MainActivity.this, pie_chart.class);
                //startActivity(intent);
                return true;
            case R.id.nav_line_chart:
                menuItem.setChecked(true);
                textView1.setText(menuItem.getTitle());
                Intent intent2 = new Intent(MainActivity.this, line_chart.class);
                startActivity(intent2);
                return true;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}