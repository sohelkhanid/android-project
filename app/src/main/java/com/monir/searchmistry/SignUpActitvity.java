package com.monir.searchmistry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActitvity extends AppCompatActivity {
    private EditText nameId,addressId,mailId,userTwoNameId,passwordTow;
    private Button submitButtonId;

    UserDetails userDetails;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_actitvity);

        nameId=(EditText)findViewById(R.id.nameId);
        addressId=(EditText)findViewById(R.id.addressId);
        mailId=(EditText)findViewById(R.id.mailId);
        userTwoNameId=(EditText)findViewById(R.id.userTowNameId);
        passwordTow=(EditText)findViewById(R.id.passwordTwoId);

        submitButtonId=(Button)findViewById(R.id.submitId);

        userDetails=new UserDetails();
        databaseHelper=new DatabaseHelper(this);

        submitButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameId.getText().toString();
                String address=addressId.getText().toString();
                String mail=mailId.getText().toString();
                String userName=userTwoNameId.getText().toString();
                String password=passwordTow.getText().toString();

                userDetails.setName(name);
                userDetails.setAddress(address);
                userDetails.setMail(mail);
                userDetails.setUserName(userName);
                userDetails.setPassword(password);


                long rowId=databaseHelper.inserData(userDetails);

                if(rowId>0){
                    Toast.makeText(getApplicationContext(),"data inserted",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(SignUpActitvity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext()," not inserted ",Toast.LENGTH_LONG).show();

                }



            }
        });
    }
}
