package fr.railcommandeer.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import fr.railcommandeer.app.Adaptater.DealAdaptater;
import fr.railcommandeer.app.Adaptater.ResultatAdaptater;

/**
 * Created by Boufle on 25/05/2016.
 */
public class ResultatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_train);

        getSupportActionBar().setTitle("Bordeaux - Orléans");

        ListView yourListView = (ListView) findViewById(R.id.listView);

        ResultatAdaptater customAdapter = new ResultatAdaptater(getApplication());

        yourListView.setAdapter(customAdapter);

        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);


    }
}
