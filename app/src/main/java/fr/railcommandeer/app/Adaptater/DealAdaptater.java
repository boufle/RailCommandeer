package fr.railcommandeer.app.Adaptater;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;
import fr.railcommandeer.app.MainActivity;
import fr.railcommandeer.app.R;
import fr.railcommandeer.app.entity.Deal;

import java.util.List;

/**
 * fr.railcommandeer.app.Adaptater
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class DealAdaptater extends BaseAdapter {

    private   LayoutInflater layoutInflater;
    private Application context;
    private List<Deal> deals;

    public DealAdaptater(Application context, List<Deal> deals) {

        this.context = context;
        this.deals = deals;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return deals.size();
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
        convertView= layoutInflater.inflate(R.layout.imagebuttonlistdeals, null);

        KenBurnsView txt=(KenBurnsView) convertView.findViewById(R.id.imagdealse);
        TextView texteon=(TextView) convertView.findViewById(R.id.Texton);
        txt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               // context.GetClicked(position);
            }
        });
        Picasso px = Picasso.with(context);
        px.load(deals.get(position).getImage()).into(txt);
        texteon.setText(deals.get(position).getTexte());





        return convertView;
    }

}