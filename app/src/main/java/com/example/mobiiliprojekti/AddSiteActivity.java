package com.example.mobiiliprojekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddSiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_site);

        final EditText siteTextField = findViewById(R.id.siteTextField);

        final Button addSiteToList = findViewById(R.id.addSiteToList);
        addSiteToList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent addSiteIntent = new Intent(AddSiteActivity.this, MainActivity.class);
                addSiteIntent.putExtra("Address", siteTextField.getText().toString());
                startActivity(addSiteIntent);

            }
        });
    }
}
