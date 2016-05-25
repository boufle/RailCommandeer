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

/**
 * fr.railcommandeer.app.Adaptater
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class DealAdaptater extends BaseAdapter {

    private   LayoutInflater layoutInflater;
    private Application context;

    public DealAdaptater(Application context) {

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
        //px.setIndicatorsEnabled(true);
        if(position   == 0){
            px.load("https://www.raileurope.ca/cms-images/810/496/eurostar-train-lg-index,1.jpg").into(txt);

        }else if(position   == 1){
            //  txt.setImageResource(R.drawable.trainrecherche);
            px.load("http://www.indianrailwaynews.com/wp-content/uploads/2016/03/Train-1.jpg").into(txt);

        }else if(position   == 2){
            //  txt.setImageResource(R.drawable.trainrecherche);
            px.load("http://static.dnaindia.com/sites/default/files/styles/half/public/2016/03/20/439541-railways.jpg").into(txt);

        }else if(position   == 3){
            //  txt.setImageResource(R.drawable.trainrecherche);
            px.load("https://www.crosscountrytrains.co.uk/media/23127/hst2012.jpg").into(txt);

        }else if(position   == 4){
            //  txt.setImageResource(R.drawable.trainrecherche);
            px.load("http://referentiel.nouvelobs.com/file/6480450-saone-et-loire-une-rixe-dans-un-train-fait-1-blesse-grave.jpg").into(txt);

        }else if(position   == 5){
            //  txt.setImageResource(R.drawable.trainrecherche);
            px.load("http://ichef-1.bbci.co.uk/news/660/cpsprodpb/17FAC/production/_88502289_968.jpg").into(txt);

        }else if(position   == 6){
            //  txt.setImageResource(R.drawable.trainrecherche);
            px.load("http://www.tourisme-gravelines.fr/files/9514/3401/9062/train_touristique2.jpg").into(txt);

         }else if(position   == 7){
           // txt.setImageResource(R.drawable.tranplan);
            px.load("https://www.raileurope.ca/cms-images/6/234/tgv-train-lg-index,1.jpg").into(txt);
        }





        return convertView;
    }

}