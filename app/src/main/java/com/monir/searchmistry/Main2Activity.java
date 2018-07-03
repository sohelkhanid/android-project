package com.monir.searchmistry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {
    private ListView listViewId;
    private int[] mistryType={R.drawable.electrician,R.drawable.doormistry,R.drawable.rajmistry,R.drawable.plumber,
            R.drawable.rong,R.drawable.shatar,R.drawable.electrician,R.drawable.doormistry,R.drawable.rajmistry,R.drawable.plumber,
            R.drawable.rong,R.drawable.shatar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listViewId=(ListView)findViewById(R.id.listViewId);

        final String[] mistry=getResources().getStringArray(R.array.mistryType);

        CustomAddapter customAddapter=new CustomAddapter(this,mistry,mistryType);
        listViewId.setAdapter(customAddapter);


        listViewId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Main2Activity.this,Location.class);
                startActivity(intent);


            }
        });
    }
}
