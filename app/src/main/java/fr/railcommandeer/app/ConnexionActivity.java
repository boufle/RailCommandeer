package fr.railcommandeer.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.dd.CircularProgressButton;
import com.flaviofaria.kenburnsview.KenBurnsView;
import fr.railcommandeer.app.MainActivity;
import fr.railcommandeer.app.Materials.SearchTrainActivity;
import fr.railcommandeer.app.R;
import fr.railcommandeer.app.Utils.ClientUnirest;

/**
 * fr.railcommandeer.app.Navigation
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class ConnexionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inscription);


        // Handle Toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Inscription à RailCommander");

        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
    }


    public void login(View view) {
        final EditText nom = (EditText) findViewById(R.id.nom);
        final EditText prenom = (EditText) findViewById(R.id.prenom);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText mdp = (EditText) findViewById(R.id.mdp);
        final EditText adresse = (EditText) findViewById(R.id.adresse);

        final CircularProgressButton btn = (CircularProgressButton) findViewById(R.id.btn_login);
        btn.setIndeterminateProgressMode(true);
        btn.setProgress(1);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ClientUnirest clientUnirest = new ClientUnirest();
                if (clientUnirest.isInscriptionCheck(nom.getText().toString(), prenom.getText().toString(), email.getText().toString(), mdp.getText().toString(), adresse.getText().toString()))
                {

                    MainActivity.isConnected = true;
                    Intent intent = null;
                    intent = new Intent(ConnexionActivity.this, MainActivity.class);

                    if (intent != null) {
                        ConnexionActivity.this.startActivity(intent);
                    }
                }
                else {

                    ConnexionActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AlertDialog alertDialog = new AlertDialog.Builder(ConnexionActivity.this).create();
                            alertDialog.setTitle("Erreur");
                            alertDialog.setMessage("L'utilisateur existe deja");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            btn.setProgress(0);
                                        }
                                    });
                            alertDialog.show();
                        }
                    });


                }

            }
        });
        thread.start();

        //  user.getTextString();
    }

    public void cancel(View view) {
        KenBurnsView img = (KenBurnsView) findViewById(R.id.image);
        if (img != null) {
            img.pause();
        }
        super.onBackPressed();
    }
}
