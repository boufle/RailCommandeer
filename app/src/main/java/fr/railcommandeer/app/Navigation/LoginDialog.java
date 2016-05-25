package fr.railcommandeer.app.Navigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.dd.CircularProgressButton;
import com.flaviofaria.kenburnsview.KenBurnsView;
import fr.railcommandeer.app.R;

/**
 * fr.railcommandeer.app.Navigation
 * Created by Theo on 25/05/2016 for RailCommandeer.
 */
public class LoginDialog extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_android_dialog);


        // Handle Toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Connexion à RailCommander");

        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
    }


    public void login(View view) {
        EditText pass = (EditText) findViewById(R.id.password);
        EditText user = (EditText) findViewById(R.id.txt_name);
        CircularProgressButton btn = (CircularProgressButton) findViewById(R.id.btn_login);
        btn.setIndeterminateProgressMode(true);
        btn.setProgress(1);
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
