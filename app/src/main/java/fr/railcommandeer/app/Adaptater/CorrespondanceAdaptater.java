package fr.railcommandeer.app.Adaptater;

import android.app.Application;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;
import fr.railcommandeer.app.R;
import fr.railcommandeer.app.ReponseRest.CorrespondanceReponse;
import fr.railcommandeer.app.ReponseRest.PossibilityReponse;
import fr.railcommandeer.app.ResultatActivity;

import java.util.ArrayList;

/**
 * fr.railcommandeer.app.Adaptater
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class CorrespondanceAdaptater extends BaseAdapter {
    private ArrayList<CorrespondanceReponse> list = new ArrayList<CorrespondanceReponse>();


    private   LayoutInflater layoutInflater;
    private Application context;

    public CorrespondanceAdaptater(Application context, ArrayList<CorrespondanceReponse> list) {

        ArrayList<CorrespondanceReponse> list2 = new ArrayList<>();
        for (CorrespondanceReponse correspondanceReponse : list) {
            list2.add(correspondanceReponse);
            list2.add(correspondanceReponse);
        }
        list2.add(list2.get(list2.size()-1));
        this.list = list2;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    String arr = "";
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        String arr = "";
        String dep = "";
        if (position % 2 == 0 ){
            //route
            System.out.println(position);
            if(position ==0 ){ //dep
                convertView= layoutInflater.inflate(R.layout.coresp_card1, null);
            }else   if(position == list.size()-1 ){ //last gare
                convertView= layoutInflater.inflate(R.layout.coresp_card2, null);
            }else { //corespondance
                convertView= layoutInflater.inflate(R.layout.coresp_card3, null);
            }

            TextView add =(TextView) convertView.findViewById(R.id.heure);
            TextView gare =(TextView) convertView.findViewById(R.id.gare);
            TextView garenew =(TextView) convertView.findViewById(R.id.garenew);

            if(position != list.size()-1 ) {
                garenew.setText(list.get(position).getGareD().getNom_gare());
            }else {
                garenew.setText(list.get(position).getGareA().getNom_gare());
            }

            if(position !=0 ){
                arr = "Arrivé : " + list.get(position-2).getHeureA().getDay() +"/"+list.get(position-2).getHeureA().getMonth() +" "+ list.get(position-2).getHeureA().getHours() +":"+list.get(position-2).getHeureA().getMinutes();
            }
            if(position != list.size()-1 ) {
                dep = "Depart : " + list.get(position).getHeureD().getDay() + "/" + list.get(position).getHeureD().getMonth() + " " + list.get(position).getHeureD().getHours() + ":" + list.get(position).getHeureD().getMinutes();
            }
            gare.setText(arr);
            add.setText( dep);


        }else {
            //corres
            convertView= layoutInflater.inflate(R.layout.coresp_card, null);
            TextView add =(TextView) convertView.findViewById(R.id.heure);
            TextView gare =(TextView) convertView.findViewById(R.id.gare);
           int totalsecondes = list.get(position).getDuree();

            int secondes = totalsecondes % 60;
            int minutes = (totalsecondes / 60) % 60;
            int heures = (totalsecondes / (60 * 60));
            gare.setText(heures+"h"+minutes);
            add.setText(list.get(position).getKm()+"km " );
        }


        return convertView;
    }

}