package au.com.hyperionstudios.travelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class HomeScreen extends AppCompatActivity {

    private static final String TAG = "AMX";
    public String destinationsAPI;

    RequestQueue requestQueue;

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
                        Log.d(TAG, "onResponse: SUCCESS");
                        try {
                            JSONArray data = response.getJSONArray( "data" );
                            for( int i = 0; i < data.length(); i++ ){
                                JSONObject jsonObject = data.getJSONObject( i );
                                Log.d(TAG, "onResponse: " + jsonObject.getString( "title" ));
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
    }
}
