package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends android.app.Activity {

    Button signIn;
    EditText email,password;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn=findViewById(R.id.button_log);
        email=findViewById(R.id.email_log);
        password=findViewById(R.id.password_log);
        register=findViewById(R.id.reg_log);

       register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this,RegistrationActivity.class)));
       signIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent myIntent=new Intent(LoginActivity.this,MainActivity.class);
               startActivity(myIntent);
           }
       });

    }
}