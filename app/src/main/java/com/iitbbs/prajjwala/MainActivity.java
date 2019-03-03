package com.iitbbs.prajjwala;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username, email, link_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(MainActivity.this);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences mPrefs = getSharedPreferences("MyPreferences",0);
        username = mPrefs.getString("Retailer_name", "");
        Log.d("huhu",username);

        email = mPrefs.getString("Retailer_email","");
        Log.d("huhu",email);

        link_uri = mPrefs.getString("Profile_pic","");
        Log.d("huhu",link_uri);

        Uri imageUri = Uri.parse(link_uri);

        Log.d("huhu", imageUri.toString());


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment, new BlankFragment());
        ft.addToBackStack(null);
        ft.commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View hView =  navigationView.getHeaderView(0);

        TextView nav_name = (TextView) hView.findViewById(R.id.name_user);
        nav_name.setText(username);

        TextView nav_email = (TextView) hView.findViewById(R.id.textView);
        nav_email.setText(email);

        SimpleDraweeView draweeView = (SimpleDraweeView) hView.findViewById(R.id.sdvImage);
        draweeView.setImageURI(imageUri);

        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment());
            ft.addToBackStack(null);
            ft.commit();
        } else if (id == R.id.nav_profile) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment2());
            ft.addToBackStack(null);
            ft.commit();
        } else if (id == R.id.nav_gas) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment3());
            ft.addToBackStack(null);
            ft.commit();
        }else if (id == R.id.nav_subs) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment4());
            ft.addToBackStack(null);
            ft.commit();
        }  else if (id == R.id.nav_tamper) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment5());
            ft.addToBackStack(null);
            ft.commit();
        } else if (id == R.id.nav_dealer) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment6());
            ft.addToBackStack(null);
            ft.commit();
        } else if (id == R.id.nav_customercare) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment7());
            ft.addToBackStack(null);
            ft.commit();
        } else if (id == R.id.nav_maps) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment8());
            ft.addToBackStack(null);
            ft.commit();
        } else if(id == R.id.nav_log_out){
            Intent intent = new Intent(this, Main3Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
            startActivity(intent);
        } else if(id == R.id.nav_register_customer) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.fragment, new BlankFragment9());
            ft.addToBackStack(null);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
