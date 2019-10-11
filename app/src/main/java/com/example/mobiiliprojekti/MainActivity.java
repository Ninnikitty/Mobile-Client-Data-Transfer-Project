package com.example.mobiiliprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Nappi vie main2Activity:lle joka aukaisee uuden sivun randomille eläin kuvalle
        Button main2Activity = (Button) findViewById(R.id.animalButton);
        main2Activity.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                Toast.makeText(getApplicationContext(), "Button selected !", Toast.LENGTH_LONG).show();
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

        ArrayList<String> list = new ArrayList<String>();
        list.add("item1");
        list.add("item2");

        //instantiate custom adapter
        MyCustomAdapter adapter = new MyCustomAdapter(list, this);
        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.myListView);
        lView.setAdapter(adapter);







    }
}