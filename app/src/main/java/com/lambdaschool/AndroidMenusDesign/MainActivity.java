package com.lambdaschool.AndroidMenusDesign;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        drawerLayout = findViewById(R.id.main_activity_drawer_layout);
        toolbar = findViewById(R.id.main_activity_toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.main_activity_navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Toast.makeText(context, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                menuItem.setChecked(!menuItem.isChecked());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (menuItem.getItemId() == R.id.nav_night_mode) {
                        UiModeManager uiModeManager = context.getSystemService(UiModeManager.class);
                        uiModeManager.setNightMode(menuItem.isChecked() ? UiModeManager.MODE_NIGHT_YES : UiModeManager.MODE_NIGHT_NO);
                    }
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.options_menu_12_hour:
                break;
            case R.id.options_menu_24_hour:
                break;
            case R.id.options_menu_fahrenheit:
                break;
            case R.id.options_menu_celsius:
                break;
            case R.id.options_menu_ounces:
                break;
            case R.id.options_menu_milliliters:
                break;
            case R.id.options_menu_reminder:
                break;
            case R.id.options_menu_images_marvel:
                break;
            case R.id.options_menu_images_dragon_ball:
                break;
            case R.id.options_menu_images_lorem_picsum:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
