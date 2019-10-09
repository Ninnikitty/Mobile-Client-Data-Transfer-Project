package com.example.mobiiliprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button main2Activity = (Button) findViewById(R.id.animalButton);
        main2Activity.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                Toast.makeText(getApplicationContext(), "Button selected !", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }});
        Button addSiteActivity = (Button) findViewById(R.id.addSiteButton);
        addSiteActivity.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                Toast.makeText(getApplicationContext(), "Add site view showing", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), AddSiteActivity.class);
                startActivity(intent);
            }});
    }
}