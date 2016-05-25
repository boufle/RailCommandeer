package fr.railcommandeer.app.Materials;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import fr.railcommandeer.app.Adaptater.DealAdaptater;
import fr.railcommandeer.app.R;

/**
 * fr.railcommandeer.app.Navigation
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class DealItent extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /*    requestWindowFeature(Window.FEATURE_ACTION_BAR);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.deallistview);
        ListView yourListView = (ListView) findViewById(R.id.listView);

        DealAdaptater customAdapter = new DealAdaptater(getApplication());

        yourListView.setAdapter(customAdapter);

        getSupportActionBar().setTitle("Les Deals du moment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        // Handle Toolbar
   /*     final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);*/
    }



}
