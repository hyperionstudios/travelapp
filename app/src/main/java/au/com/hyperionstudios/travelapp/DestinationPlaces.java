package au.com.hyperionstudios.travelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DestinationPlaces extends AppCompatActivity {

    TextView destinationTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_places);

        setupElements();

        parseIntentData();
    }

    private void parseIntentData() {
        String intentDestinationTitle = getIntent().getStringExtra( "destination_title" );
        destinationTitle.setText( intentDestinationTitle );
    }

    private void setupElements() {
        destinationTitle = findViewById( R.id.destination_title );
    }
}
