package com.example.israel.androidmenusdesign;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.activitiy_main_nav);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        // close the drawer instead of back press
        DrawerLayout drawer = findViewById(R.id.activity_main_drawer_root);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id) {
            case R.id.nav_menu_map: {
                Toast toast = Toast.makeText(this, "Opens map", Toast.LENGTH_LONG);
                toast.show();
            } break;
            case R.id.nav_menu_travels: {
                Toast toast = Toast.makeText(this, "Opens travel list", Toast.LENGTH_LONG);
                toast.show();
            } break;
            case R.id.nav_menu_logout: {
                Toast toast = Toast.makeText(this, "Logs user out", Toast.LENGTH_LONG);
                toast.show();
            } break;
        }

        return true;
    }
}
