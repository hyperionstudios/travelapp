package au.com.hyperionstudios.travelapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import au.com.hyperionstudios.travelapp.adapters.OnBoardingAdapter;
import au.com.hyperionstudios.travelapp.datasupplier.OnBoardingSupplier;
import au.com.hyperionstudios.travelapp.model.OnBoardingModel;

public class OnBoardingScreen extends AppCompatActivity {

    ViewPager viewPager;
    List<OnBoardingModel> onBoardingModels;
    PagerAdapter pagerAdapter;
    LinearLayout indicatorsContainer;
    TextView[] dots;
    ViewPager.OnPageChangeListener listener;
    Button getStarted;
    private static final String HOME_TAG = "au.com.hyperionstudios.HOME_SCREEN" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBarAndStatusBar();
        setContentView(R.layout.activity_on_boarding_screen);
        viewPager = findViewById( R.id.onboarding_pageview );
        onBoardingModels = OnBoardingSupplier.getOnBoardingObjects();
        pagerAdapter = new OnBoardingAdapter( onBoardingModels , this );
        indicatorsContainer = findViewById( R.id.dots_container );
        viewPager.setAdapter( pagerAdapter );
        addGetStartedButton();
        addPageIndicators(0);
        addOnPagerChangeListener();
        viewPager.addOnPageChangeListener( listener );
    }

    private void addGetStartedButton() {
        getStarted = findViewById( R.id.button );
        final Intent intent = new Intent( this ,  HomeScreen.class );
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSeen();
                startActivity( intent );
            }
        });
    }


    private void addOnPagerChangeListener(){
        listener =  new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                addPageIndicators( i );
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        };
    }

    private void addPageIndicators( int position ) {
        indicatorsContainer.removeAllViews();
        dots = new TextView[ onBoardingModels.size() ];

        for( int i = 0; i < dots.length; i++ ){

            dots[i] = new TextView( this );
            dots[i].setText( Html.fromHtml( "&#8226;" ) );
            dots[i].setTextSize( 48 );
            dots[i].setTextColor( getResources().getColor( R.color.brandGrey ) );
            indicatorsContainer.addView( dots[i] );
        }

        dots[position].setTextColor( getResources().getColor( R.color.colorPrimary ) );
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
