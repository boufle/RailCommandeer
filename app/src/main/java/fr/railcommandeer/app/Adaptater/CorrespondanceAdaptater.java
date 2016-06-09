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
        this.list = list;
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

       // Button add =(Button) convertView.findViewById(R.id.add_btn);


        return convertView;
    }

}