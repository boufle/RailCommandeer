package fr.railcommandeer.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import fr.railcommandeer.app.Adaptater.DealAdaptater;
import fr.railcommandeer.app.Adaptater.ResultatAdaptater;

import java.util.ArrayList;

/**
 * Created by Boufle on 25/05/2016.
 */
public class ResultatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_train);

        Bundle b = getIntent().getExtras();
        String trajet = b.getString("trajet");
        getSupportActionBar().setTitle(trajet);

        ListView yourListView = (ListView) findViewById(R.id.listView);

        ArrayList<String> list = new ArrayList<String>();
        list.add("15h30");
        list.add("18h30");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("19h20");
        list2.add("23h40");
        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("4h");
        list3.add("5h10");

        ResultatAdaptater customAdapter = new ResultatAdaptater(getApplication(),list,list2,list3);

        yourListView.setAdapter(customAdapter);

        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);


    }
}
