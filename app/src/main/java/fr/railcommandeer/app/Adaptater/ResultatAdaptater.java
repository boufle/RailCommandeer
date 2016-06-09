package fr.railcommandeer.app.Adaptater;

import android.app.Application;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import fr.railcommandeer.app.MainActivity;
import fr.railcommandeer.app.PossibilityActivity;
import fr.railcommandeer.app.R;
import fr.railcommandeer.app.ReponseRest.DealReponse;
import fr.railcommandeer.app.ReponseRest.PossibilityReponse;
import fr.railcommandeer.app.ResultatActivity;

import java.util.ArrayList;

/**
 * fr.railcommandeer.app.Adaptater
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class ResultatAdaptater extends BaseAdapter {
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> list2 = new ArrayList<String>();
    private ArrayList<String> list3 = new ArrayList<String>();

    private   LayoutInflater layoutInflater;
    private ResultatActivity context;

    public ResultatAdaptater(ResultatActivity context, ArrayList<String> list, ArrayList<String> list2, ArrayList<String> list3) {
        this.list = list;
        this.list2 = list2;
        this.list3 = list3;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView= layoutInflater.inflate(R.layout.research_card, null);

        Button add =(Button) convertView.findViewById(R.id.add_btn);
        TextView heureD =(TextView) convertView.findViewById(R.id.heureDeDepart);
        TextView heureA =(TextView) convertView.findViewById(R.id.heureDarrivee);
        TextView duree =(TextView) convertView.findViewById(R.id.duree);

        if (position < list.size()){
            heureD.setText(list.get(position));
            heureA.setText(list2.get(position));
            duree.setText(list3.get(position));
        }


        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // context.GetClicked(position);

                Gson gson = new Gson();
                PossibilityReponse deal =  gson.fromJson("{\n" +
                        "        \"correspondanceReponses\": [\n" +
                        "          {\n" +
                        "            \"heureD\": \"Nov 5, 2016 4:27:27 AM\",\n" +
                        "            \"heureA\": \"Nov 5, 2016 7:26:12 AM\",\n" +
                        "            \"gareD\": {\n" +
                        "              \"id\": 10,\n" +
                        "              \"nom_gare\": \"Gare Saint-Charles\",\n" +
                        "              \"gps\": {\n" +
                        "                \"x\": 43,\n" +
                        "                \"y\": 5\n" +
                        "              },\n" +
                        "              \"code_postal\": 13000,\n" +
                        "              \"ville\": \"Marseille\"\n" +
                        "            },\n" +
                        "            \"gareA\": {\n" +
                        "              \"id\": 8,\n" +
                        "              \"nom_gare\": \"Gare Pare-Dieu\",\n" +
                        "              \"gps\": {\n" +
                        "                \"x\": 46,\n" +
                        "                \"y\": 5\n" +
                        "              },\n" +
                        "              \"code_postal\": 69000,\n" +
                        "              \"ville\": \"Lyon\"\n" +
                        "            },\n" +
                        "            \"duree\": 10725,\n" +
                        "            \"km\": 325,\n" +
                        "            \"ligne\": \"F\",\n" +
                        "            \"train\": {\n" +
                        "              \"id\": 45210,\n" +
                        "              \"surplus\": 0,\n" +
                        "              \"Date_depart\": \"Nov 4, 2016 10:36:00 PM\",\n" +
                        "              \"nbr_place\": 100,\n" +
                        "              \"ligne\": {\n" +
                        "                \"id\": 6,\n" +
                        "                \"nomLigne\": \"F\"\n" +
                        "              }\n" +
                        "            }\n" +
                        "          },\n" +
                        "          {\n" +
                        "            \"heureD\": \"Nov 5, 2016 7:59:27 AM\",\n" +
                        "            \"heureA\": \"Nov 5, 2016 11:15:15 AM\",\n" +
                        "            \"gareD\": {\n" +
                        "              \"id\": 8,\n" +
                        "              \"nom_gare\": \"Gare Pare-Dieu\",\n" +
                        "              \"gps\": {\n" +
                        "                \"x\": 46,\n" +
                        "                \"y\": 5\n" +
                        "              },\n" +
                        "              \"code_postal\": 69000,\n" +
                        "              \"ville\": \"Lyon\"\n" +
                        "            },\n" +
                        "            \"gareA\": {\n" +
                        "              \"id\": 3,\n" +
                        "              \"nom_gare\": \"Gare de Lyon\",\n" +
                        "              \"gps\": {\n" +
                        "                \"x\": 48,\n" +
                        "                \"y\": 2\n" +
                        "              },\n" +
                        "              \"code_postal\": 75000,\n" +
                        "              \"ville\": \"Paris\"\n" +
                        "            },\n" +
                        "            \"duree\": 11748,\n" +
                        "            \"km\": 356,\n" +
                        "            \"ligne\": \"B\",\n" +
                        "            \"train\": {\n" +
                        "              \"id\": 45212,\n" +
                        "              \"surplus\": 0,\n" +
                        "              \"Date_depart\": \"Nov 4, 2016 11:01:00 PM\",\n" +
                        "              \"nbr_place\": 100,\n" +
                        "              \"ligne\": {\n" +
                        "                \"id\": 2,\n" +
                        "                \"nomLigne\": \"B\"\n" +
                        "              }\n" +
                        "            }\n" +
                        "          },\n" +
                        "          {\n" +
                        "            \"heureD\": \"Nov 5, 2016 12:00:18 PM\",\n" +
                        "            \"heureA\": \"Nov 5, 2016 7:40:39 PM\",\n" +
                        "            \"gareD\": {\n" +
                        "              \"id\": 3,\n" +
                        "              \"nom_gare\": \"Gare de Lyon\",\n" +
                        "              \"gps\": {\n" +
                        "                \"x\": 48,\n" +
                        "                \"y\": 2\n" +
                        "              },\n" +
                        "              \"code_postal\": 75000,\n" +
                        "              \"ville\": \"Paris\"\n" +
                        "            },\n" +
                        "            \"gareA\": {\n" +
                        "              \"id\": 6,\n" +
                        "              \"nom_gare\": \"Gare Matabiau\",\n" +
                        "              \"gps\": {\n" +
                        "                \"x\": 44,\n" +
                        "                \"y\": 2\n" +
                        "              },\n" +
                        "              \"code_postal\": 31000,\n" +
                        "              \"ville\": \"Toulouse\"\n" +
                        "            },\n" +
                        "            \"duree\": 27621,\n" +
                        "            \"km\": 837,\n" +
                        "            \"ligne\": \"D\",\n" +
                        "            \"train\": {\n" +
                        "              \"id\": 45274,\n" +
                        "              \"surplus\": 0,\n" +
                        "              \"Date_depart\": \"Nov 5, 2016 9:56:00 AM\",\n" +
                        "              \"nbr_place\": 100,\n" +
                        "              \"ligne\": {\n" +
                        "                \"id\": 4,\n" +
                        "                \"nomLigne\": \"D\"\n" +
                        "              }\n" +
                        "            }\n" +
                        "          }\n" +
                        "        ],\n" +
                        "        \"pos\": 0,\n" +
                        "        \"distancetotale\": 1518,\n" +
                        "        \"Depart\": \"Nov 5, 2016 4:27:27 AM\",\n" +
                        "        \"ArrDate\": \"Nov 5, 2016 7:40:39 PM\",\n" +
                        "        \"prix\": 303.6\n" +
                        "      }", PossibilityReponse.class);

                context.gointent(deal);

            }
        });

        return convertView;
    }

}