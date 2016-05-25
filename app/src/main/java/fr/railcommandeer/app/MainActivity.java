package fr.railcommandeer.app;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.*;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.interfaces.ICrossfader;
import com.mikepenz.materialdrawer.model.*;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;
import com.mikepenz.crossfadedrawerlayout.view.CrossfadeDrawerLayout;
import com.mikepenz.materialize.util.UIUtils;
import fr.railcommandeer.app.Adaptater.HomeAdaptater;
import fr.railcommandeer.app.Navigation.NavigationDrawer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

      private NavigationDrawer nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView yourListView = (ListView) findViewById(R.id.listView);

        HomeAdaptater customAdapter = new HomeAdaptater(this);

        yourListView.setAdapter(customAdapter);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.drawer_item_crossfade_drawer_layout_drawer);
          nav = new NavigationDrawer(this,toolbar,savedInstanceState);


    }

    public void GetClicked(int id){
        //Toast.makeText(MainActivity.this, "rereer", Toast.LENGTH_SHORT).show();
        if(id == 0){
            Intent intent = null;
            intent = new Intent(MainActivity.this, SearchTrainActivity.class);

            if (intent != null) {
                MainActivity.this.startActivity(intent);
            }
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = nav.getResult().saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = nav.getHeaderResult().saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (nav.getResult() != null && nav.getResult().isDrawerOpen()) {
            nav.getResult().closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


}
