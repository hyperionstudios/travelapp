package au.com.hyperionstudios.travelapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class DeciderActivity extends AppCompatActivity {

    Intent intent;
    public static String MyPREFERENCES = "au.com.hyperionstudios.SHARED_PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decider);
        // TODO Decide which activity to launch
        prepareProperties();
    }

    private void prepareProperties() {
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        boolean seen = sharedpreferences.getBoolean( "seen" , false );
        if( seen ){
            intent = new Intent( this, HomeScreen.class );
        }else{
            intent = new Intent( this, OnBoardingScreen.class );
        }
        startActivity( intent );

    }
}
