package com.monir.searchmistry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Location extends AppCompatActivity {
    private Button mirpurButtonId,mohammadpurButtonId,dhanmondiButtonId,bonaniButtonId,golshanButtonId,uttoranButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mirpurButtonId=(Button)findViewById(R.id.mirpurButtonId);
        mohammadpurButtonId=(Button)findViewById(R.id.mohammadpurButtonId);
        dhanmondiButtonId=(Button)findViewById(R.id.dhanmondiButtonId);
        bonaniButtonId=(Button)findViewById(R.id.bonaniButtonId);
        golshanButtonId=(Button)findViewById(R.id.golshanButtonId);
        uttoranButtonId=(Button)findViewById(R.id.uttoraButton);

        mirpurButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Location.this,Mirpur.class);
                startActivity(intent);
            }
        });

        mohammadpurButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Location.this,Mohammadpur.class);
                startActivity(intent);

            }
        });

        dhanmondiButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Location.this,Dhanmondi.class);
                startActivity(intent);

            }
        });

        bonaniButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Location.this,Bonani.class);
                startActivity(intent);

            }
        });

        golshanButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Location.this,Mirpur.class);
                startActivity(intent);

            }
        });

        uttoranButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Location.this,Uttoran.class);
                startActivity(intent);
            }
        });

    }
}
