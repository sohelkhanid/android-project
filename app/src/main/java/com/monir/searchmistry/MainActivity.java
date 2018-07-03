package com.monir.searchmistry;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    private Button signIButtonId,signUpButtonId;
    private EditText userNameId,passwordId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper=new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();

        userNameId=(EditText)findViewById(R.id.userNameId);
        passwordId=(EditText)findViewById(R.id.passwordId);

        signIButtonId=(Button)findViewById(R.id.signInButtonId);
        signUpButtonId=(Button)findViewById(R.id.signUpButtonId);

        signIButtonId.setOnClickListener(new View.OnClickListener() {
            String userName=userNameId.getText().toString();
            String password=passwordId.getText().toString();
            @Override
            public void onClick(View v) {
                Boolean result=databaseHelper.findPassword(userName,password);

                if (result==true){
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"data not match",Toast.LENGTH_LONG).show();
                }

            }
        });

        signUpButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpActitvity.class);
                startActivity(intent);


                 }
        });
    }
}
