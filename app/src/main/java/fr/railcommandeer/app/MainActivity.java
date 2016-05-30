package fr.railcommandeer.app;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.support.v7.widget.Toolbar;
import fr.railcommandeer.app.Adaptater.HomeAdaptater;
import fr.railcommandeer.app.Materials.DealItent;
import fr.railcommandeer.app.Materials.SearchTrainActivity;
import fr.railcommandeer.app.Navigation.LoginDialog;
import fr.railcommandeer.app.Navigation.NavigationDrawer;

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
        }else if( id == 10 ){
            Intent intent = null;
            intent = new Intent(MainActivity.this, LoginDialog.class);

            if (intent != null) {
                MainActivity.this.startActivity(intent);
            }
        }
        else if( id == 2 ){
            Intent intent = null;
            intent = new Intent(MainActivity.this, DealItent.class);

            if (intent != null) {
                MainActivity.this.startActivity(intent);
            }
        }
       /* else if( id == -1 ){
            ListView yourListView = (ListView) findViewById(R.id.listView);

            HomeAdaptater customAdapter = new HomeAdaptater(this);

            yourListView.setAdapter(customAdapter);
        }*/





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
