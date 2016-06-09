package fr.railcommandeer.app.Adaptater;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import fr.railcommandeer.app.Utils.ClientUnirest;
import fr.railcommandeer.app.entity.Gare;

import java.util.ArrayList;

public class AutoCmopleteAdaptater extends ArrayAdapter<String> implements Filterable {

    ArrayList<String> shippers;

    public AutoCmopleteAdaptater(Context context, int textViewResourceId){
        super(context, textViewResourceId);
        shippers = new ArrayList<String>();


    }

    @Override
    public int getCount(){
        return shippers.size();
    }

    @Override
    public String getItem(int index){
        return shippers.get(index);
    }


    @Override
    public Filter getFilter(){

        Filter myFilter = new Filter(){

            @Override
            protected FilterResults performFiltering(CharSequence constraint){
                FilterResults filterResults = new FilterResults();
                if(constraint != null) {
                    // A class that queries a web API, parses the data and returns an ArrayList<Style>
//
                    try {

                        shippers = new DownloadShippers().execute(new String[]{constraint.toString()}).get();
                    }
                    catch(Exception e) {
//                        Log.e("myException", e.getMessage());
                    }
                    // Now assign the values and count to the FilterResults object
                    filterResults.values = shippers;
                    filterResults.count = shippers.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence contraint, FilterResults results) {
                if(results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }

        };

        return myFilter;

    }

    private class DownloadShippers extends AsyncTask<String, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String... constraint) {
            ClientUnirest clientUnirest = new ClientUnirest();
            ArrayList<String> gareNames = new ArrayList<String>();


            try {

                ArrayList<Gare> shippers = clientUnirest.downloadGare(constraint[0]);

                for(Gare ship: shippers){
                    gareNames.add(ship.getNom_gare());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return gareNames;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {

        }

    }



}