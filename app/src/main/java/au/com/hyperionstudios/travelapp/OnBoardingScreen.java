package au.com.hyperionstudios.travelapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class OnBoardingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBarAndStatusBar();
        setContentView(R.layout.activity_on_boarding_screen);
        updateSeen();
    }

    private void hideActionBarAndStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void updateSeen() {
        SharedPreferences sharedpreferences = getSharedPreferences(DeciderActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean( "seen" , true );
        editor.apply();
    }
}
