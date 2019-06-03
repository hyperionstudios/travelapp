package au.com.hyperionstudios.travelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import au.com.hyperionstudios.travelapp.adapters.DestinationsAdapter;
import au.com.hyperionstudios.travelapp.model.Destination;

public class HomeScreen extends AppCompatActivity {

    private static final String TAG = "AMX";
    public String destinationsAPI;

    RequestQueue requestQueue;

    List<Destination> destinations;

    DestinationsAdapter destinationsAdapter;

    RecyclerView destinationsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        setupElements();

        fetchDestinations();

    }

    private void fetchDestinations() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                destinationsAPI,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray data = response.getJSONArray( "data" );
                            for( int i = 0; i < data.length(); i++ ){
                                JSONObject jsonObject = data.getJSONObject( i );
                                Destination destination = new Destination(
                                        jsonObject.getInt( "id" ),
                                        jsonObject.getString( "title" ),
                                        jsonObject.getString( "featured_image" ),
                                        // TODO : Replace from API
                                        25
                                );
                                destinations.add( destination );
                                destinationsAdapter = new DestinationsAdapter( destinations , HomeScreen.this );
                                destinationsRecyclerView.setAdapter( destinationsAdapter );

                                destinationsAdapter.setOnClickItemListener(new DestinationsAdapter.DestinstionClickListener() {
                                    @Override
                                    public void onDestinationClickListener(int position) {
                                        Intent intent = new Intent( HomeScreen.this , DestinationPlaces.class );
                                        Destination destination = destinations.get( position );
                                        intent.putExtra( "destination_title" , destination.getTitle() );
                                        startActivity( intent );
                                    }
                                });
                            }
                        } catch (JSONException e) {
                            // TODO : Handle Errors
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle Errors
                        error.printStackTrace();
                        Log.d(TAG, "onErrorResponse: REQUEST FAILED");
                    }
                }
        );

        requestQueue.add( jsonObjectRequest );

    }

    private void setupElements() {
        destinationsAPI = getString( R.string.api_base ) + getString( R.string.destinations_endpoint );
        requestQueue = Volley.newRequestQueue( this );
        destinations = new ArrayList<Destination>();
        destinationsRecyclerView = findViewById( R.id.destinations_recyclerview );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( this );
        destinationsRecyclerView.setLayoutManager( layoutManager );
    }
}
