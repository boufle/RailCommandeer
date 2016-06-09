package fr.railcommandeer.app.Materials;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import com.google.gson.Gson;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import fr.railcommandeer.app.Adaptater.DealAdaptater;
import fr.railcommandeer.app.R;
import fr.railcommandeer.app.ReponseRest.DealReponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * fr.railcommandeer.app.Navigation
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class DealItent extends AppCompatActivity {

    private AccountHeader headerResult = null;
    private Drawer result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /*    requestWindowFeature(Window.FEATURE_ACTION_BAR);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.deallistview);
        ListView yourListView = (ListView) findViewById(R.id.listView);
        Sess sess = new Sess();
        sess.yourListView = yourListView;
        sess.execute();




        getSupportActionBar().setTitle("Les Deals du moment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        // Handle Toolbar
   /*     final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);*/
    }

    class Sess extends AsyncTask<Void, Integer, Long> {
        public ListView yourListView;
        private DealAdaptater customAdapter;

        protected Long doInBackground(Void... arg0) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://10.29.18.39:8080/rest/dealrest/listdeal")
                    .build();

            try {
                Response response = client.newCall(request).execute();

                Gson gson = new Gson();
                DealReponse deal =  gson.fromJson(response.body().string(), DealReponse.class);
                if(deal.getSuccess().getSuccess()){
                      customAdapter = new DealAdaptater(getApplication(),deal.getDealList());


                }


            } catch (Exception e) {
           /* DealAdaptater customAdapter = new DealAdaptater(getApplication(),deal.getdealList());

            yourListView.setAdapter(customAdapter);*/
            }
            return null;
        }

        protected void onPostExecute(Long result) {
            yourListView.setAdapter(customAdapter);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle the click on the back arrow click
        switch (item.getItemId()) {
            case android.R.id.home:

                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
