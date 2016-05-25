package fr.railcommandeer.app.Adaptater;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import fr.railcommandeer.app.MainActivity;
import fr.railcommandeer.app.R;

import java.util.List;

/**
 * fr.railcommandeer.app.Adaptater
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class HomeAdaptater  extends BaseAdapter {

    private   LayoutInflater layoutInflater;
    private MainActivity context;

    public HomeAdaptater(MainActivity context) {

        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return 3;
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
        convertView= layoutInflater.inflate(R.layout.imagebuttonlist, null);

        ImageButton txt=(ImageButton)convertView.findViewById(R.id.imagebutton);
        txt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                context.GetClicked(position);
            }
        });
        if(position   == 0){
            Picasso.with(context).load((R.drawable.trainsearch)).into(txt);

        }else if(position   == 1){
         //  txt.setImageResource(R.drawable.trainrecherche);
            Picasso.with(context).load((R.drawable.trainrecherche)).into(txt);

        }else {
           // txt.setImageResource(R.drawable.tranplan);
            Picasso.with(context).load((R.drawable.tranplan)).into(txt);

        }



        return convertView;
    }

}