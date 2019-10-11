package com.example.mobiiliprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    private ImageView imgView;
    private String catUrl;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        queue = Volley.newRequestQueue(this);

        imgView = findViewById(R.id.imageView);
        imgView.setImageResource(android.R.color.transparent);

        demoGET();
        getImgString();
    }

    //Function for getting the url of the cat picture
    public void getImgString(){
        catUrl = "";
        final String url ="https://api.thecatapi.com/v1/images/search";

        Log.d("KISU", "Aloitetaan kisun etsintää osoitteesta: " + url);
        // Request cat JSON from the random cat API
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray rndCatArray = new JSONArray(response);
                            String parseTemp = rndCatArray.getString(0);
                            JSONObject rndCatJSON = new JSONObject(parseTemp);
                            catUrl = rndCatJSON.getString("url");

                            Log.d("KISU","Kisun sijainti tiedossa!" + catUrl + "Haetaan kisua...!");
                            setKitty(catUrl);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("KISU","JSON Parsinta on rikki! " + e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("KISU","Kissan sijainnin haku epäonnistui");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        Log.d("KISU","Kisu on nyt jonossa!");
    }
    private void setKitty(String url){
        Picasso.with(this.getApplicationContext()).load(url).into(imgView);
        Log.d("KISU", "Kisu asetettu!");
    }
    private void demoGET(){
        String url ="http://www.google.com";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("KISU","Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
