package fr.railcommandeer.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import fr.railcommandeer.app.Adaptater.CorrespondanceAdaptater;
import fr.railcommandeer.app.Adaptater.ResultatAdaptater;
import fr.railcommandeer.app.ReponseRest.PossibilityReponse;

import java.util.ArrayList;

/**
 * Created by Boufle on 25/05/2016.
 */
public class PossibilityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.possibility_layout);

        Bundle b = getIntent().getExtras();
        PossibilityReponse trajet = (PossibilityReponse) b.get("rep");
      //getSupportActionBar().setTitle(trajet.get);

        TextView yourListView = (TextView) findViewById(R.id.km_temps);
        TextView gareD = (TextView) findViewById(R.id.gareD);
        TextView gareA = (TextView) findViewById(R.id.gareA);
        Button prix = (Button) findViewById(R.id.prixbtn);

        yourListView.setText(trajet.getDistancetotale()+"km");
        gareD.setText(trajet.getDepart().getDay() +"/"+trajet.getDepart().getMonth() +" "+ trajet.getDepart().getHours() +":"+trajet.getDepart().getMinutes());
        gareA.setText(trajet.getArrDate().getDay() +"/"+trajet.getArrDate().getMonth() +" "+ trajet.getArrDate().getHours() +":"+trajet.getArrDate().getMinutes());


        prix.setText(String.valueOf(trajet.getPrix()));
        ListView liste = (ListView) findViewById(R.id.listView2);


        CorrespondanceAdaptater customAdapter = new CorrespondanceAdaptater(getApplication(),trajet.getCorrespondanceReponses());

        liste.setAdapter(customAdapter);

        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);


    }
}
