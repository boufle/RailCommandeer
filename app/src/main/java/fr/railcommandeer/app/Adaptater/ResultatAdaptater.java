package fr.railcommandeer.app.Adaptater;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;
import fr.railcommandeer.app.MainActivity;
import fr.railcommandeer.app.R;

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
    private Application context;

    public ResultatAdaptater(Application context,ArrayList<String> list,ArrayList<String> list2,ArrayList<String> list3) {
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
            }
        });

        return convertView;
    }

}