package fr.railcommandeer.app.Materials;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.view.*;

import android.widget.*;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import fr.railcommandeer.app.Adaptater.AutoCmopleteAdaptater;
import fr.railcommandeer.app.R;
import fr.railcommandeer.app.ResultatActivity;
import it.gmariotti.cardslib.library.internal.CardHeader;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchTrainActivity extends AppCompatActivity {
    private static final int PROFILE_SETTING = 1;

    //save our header or result
    private AccountHeader headerResult = null;
    private Drawer result = null;
    private DatePickerDialog DepartDatePickerDialog;
    private DatePickerDialog ArriveDatePickerDialog;
    private DatePickerDialog DepartDatePickerDialog2;
    private DatePickerDialog ArriveDatePickerDialog2;
    private SimpleDateFormat dateFormatter;
    AutoCompleteTextView depart;
    AutoCompleteTextView arrive;
    EditText editText;
    Spinner dateArriver;
    EditText editText2;
    Spinner dateArriver2;
    Switch aSwitch;
    LinearLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_searchtrainactivity);
        SearchCard searchCard = new SearchCard(getApplicationContext());
        CardHeader header = new CardHeader(getApplicationContext());
        searchCard.addCardHeader(header);


        depart = (AutoCompleteTextView) findViewById(R.id.editText);
        arrive = (AutoCompleteTextView) findViewById(R.id.editText2);
        editText = (EditText) findViewById(R.id.date);
        aSwitch = (Switch) findViewById(R.id.switch1);
        relativeLayout = (LinearLayout) findViewById(R.id.trajetRetour);
        dateArriver = (Spinner) findViewById(R.id.dateArrive);
        editText2 = (EditText) findViewById(R.id.date2);
        dateArriver2 = (Spinner) findViewById(R.id.dateArrive2);

        String[] items = new String[] { "0h", "1h", "2h" , "3h" , "4h" , "5h" , "6h" , "7h" , "8h" , "9h" ,
                "10h" , "11h" , "12h" , "13h" , "14h" , "15h" , "16h", "17h", "18h", "19h", "20h", "21h", "22h", "23h" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);

        dateArriver2.setAdapter(adapter);
        dateArriver.setAdapter(adapter);




        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    onClickDepartDate(v);
                } else {
                    // Hide your calender here
                }
            }
        });
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    onClickDepartDate(v);
                } else {
                    // Hide your calender here
                }
            }
        });
/*
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
*/

        depart.setAdapter(new AutoCmopleteAdaptater(this, android.R.layout.simple_dropdown_item_1line));

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        //CardViewNative cardView = (CardViewNative) findViewById(R.id.carddemo);
        //cardView.setCard(searchCard);
        setDateTimeField();
        // Handle Toolbar
    /*    final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        getSupportActionBar().setTitle(R.string.drawer_item_compact_header);

        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
                if (isChecked){
                    relativeLayout.setVisibility(View.VISIBLE);
                }else
                {
                    relativeLayout.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
//        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
  //      outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }



    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        DepartDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                editText.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));



        DepartDatePickerDialog2 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                editText2.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));



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


    public void onClickDepartDate(View view) {
        DepartDatePickerDialog.show();
    }


    public void onClickDepartDate2(View view) {
        DepartDatePickerDialog2.show();
    }




    public void OnClicksearch(View view) {

        if(editText.getText().equals("")){

        }
        else if(editText2.getText().equals("")){

        }
        else{

        }
        Intent intent = null;
        intent = new Intent(SearchTrainActivity.this, ResultatActivity.class);
        intent.putExtra("trajet", depart.getText() + " - "+ arrive.getText() );
        SearchTrainActivity.this.startActivity(intent);
    }
}