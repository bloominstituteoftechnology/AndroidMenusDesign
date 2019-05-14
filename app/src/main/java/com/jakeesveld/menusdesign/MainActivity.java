package com.jakeesveld.menusdesign;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Snackbar.make(findViewById(R.id.drawer_layout), menuItem.getTitle(), Snackbar.LENGTH_SHORT).show();
                textView.setText(menuItem.getTitle());
                switch(menuItem.getItemId()){
                    case R.id.nav_overview:
                        break;
                    case R.id.nav_current_programs:
                        break;
                    case R.id.nav_all_programs:
                        break;
                    case R.id.nav_teachers:
                        break;
                    case R.id.nav_students:
                        break;
                    case R.id.nav_current_assignments:
                        break;
                    case R.id.nav_previous_assignments:
                        break;
                    case R.id.nav_upcoming_assignments:
                        break;
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
        switch (item.getItemId()){
            case R.id.options_log_in:
                Toast.makeText(getBaseContext(), "Logged In!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.options_log_out:
                Toast.makeText(getBaseContext(), "Logged out!", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
