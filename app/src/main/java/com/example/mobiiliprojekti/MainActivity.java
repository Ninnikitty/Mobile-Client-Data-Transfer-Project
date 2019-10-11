package com.example.mobiiliprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView myListView = (ListView)findViewById(R.id.myListView);

        // Nappi vie main2Activity:lle joka aukaisee uuden sivun randomille eläin kuvalle

        Button main2Activity = (Button) findViewById(R.id.animalButton);
        main2Activity.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                Toast.makeText(getApplicationContext(), "Etsitään kissaa internetin syöväreistä...      ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }});

        // Nappi vie näkymään, jossa voidaan lisätä sivu menuun
        Button addSiteActivity = (Button) findViewById(R.id.addSiteButton);
        addSiteActivity.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                Toast.makeText(getApplicationContext(), "Add site view showing", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), AddSiteActivity.class);
                startActivity(intent);
            }});

        // Nappi joka vie suoraan googleen käyttäjän
        Button googleButton = (Button) findViewById(R.id.googleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent googleLinkki = new Intent(android.content.Intent.ACTION_VIEW);
                googleLinkki.setData(Uri.parse("http://www.google.com"));
                startActivity(googleLinkki);
            }
        });

        DataMan man = DataMan.getInstance();
        list = man.getPeople();

        MyCustomAdapter adapter = new MyCustomAdapter(list, this); //instantiate custom adapter
        ListView listView = findViewById(R.id.myListView);
        listView.setAdapter(adapter); //handle listview and assign adapter
        
        Intent i = getIntent();
        String text = i.getStringExtra("Address");





        if(list.isEmpty()){
            // Defaulttina
            Log.d("MAIN","Lista ennen: "+ list);
            list.add("google.com");
            list.add("facebook.com");
        }
        if(text != null){
            list.add(text);
        }

        Log.d("MAIN","Lista: "+ list);
        adapter.notifyDataSetChanged();
        man.setPeople(list);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("siteList", list);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        list = savedInstanceState.getStringArrayList("siteList");
    }
}

class DataMan {

    private ArrayList<String> people = new ArrayList<String>();
    private static DataMan instance;
    private DataMan() {}

    static DataMan getInstance() {
        if( instance == null ) {
            instance = new DataMan();
        }
        return instance;
    }

    public ArrayList<String> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<String> people) {
        this.people = people;
    }
}