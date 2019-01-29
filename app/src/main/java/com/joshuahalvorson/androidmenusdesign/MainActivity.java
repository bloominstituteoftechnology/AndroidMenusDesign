package com.joshuahalvorson.androidmenusdesign;

import android.net.Uri;
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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AnimalsListFragment.OnFragmentInteractionListener,
SheltersListFragment.OnFragmentInteractionListener, TaggedAnimalsFragment.OnFragmentInteractionListener{

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message = item.getTitle().toString();
        switch (item.getItemId()){
            case R.id.night_mode:
                if(item.isChecked()){
                    //change theme
                    item.setChecked(false);
                    message += " unchecked";
                }else{
                    //change theme
                    item.setChecked(true);
                    message += " checked";
                }
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_view);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
        R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //Toast.makeText(getApplicationContext(), menuItem.getTitle().toString(), Toast.LENGTH_SHORT).show();
                menuItem.setChecked(true);

                //TextView content = findViewById(R.id.content);
                //content.setText(menuItem.getTitle().toString());
                switch (menuItem.getItemId()){
                    case  R.id.nav_activity_one:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, new AnimalsListFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case  R.id.nav_activity_two:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, new SheltersListFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case  R.id.nav_activity_three:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container, new TaggedAnimalsFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                }


                drawerLayout.closeDrawers();
                return true;
            }
        });


    }


    @Override
    public void onAnimalsListFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSheltersListFragmentInteraction(Uri uri) {

    }

    @Override
    public void onTaggedAnimalsFragmentInteraction(Uri uri) {

    }
}
