package au.com.hyperionstudios.travelapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;

import au.com.hyperionstudios.travelapp.adapters.OnBoardingAdapter;
import au.com.hyperionstudios.travelapp.datasupplier.OnBoardingSupplier;
import au.com.hyperionstudios.travelapp.model.OnBoardingModel;

public class OnBoardingScreen extends AppCompatActivity {

    ViewPager viewPager;
    List<OnBoardingModel> onBoardingModels;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBarAndStatusBar();
        setContentView(R.layout.activity_on_boarding_screen);
        updateSeen();
        viewPager = findViewById( R.id.onboarding_pageview );
        onBoardingModels = OnBoardingSupplier.getOnBoardingObjects();
        pagerAdapter = new OnBoardingAdapter( onBoardingModels , this );
        viewPager.setAdapter( pagerAdapter );

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
