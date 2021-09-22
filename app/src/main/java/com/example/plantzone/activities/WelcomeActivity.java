package com.example.plantzone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plantzone.R;
import com.google.firebase.auth.FirebaseAuth;

public class WelcomeActivity extends AppCompatActivity {


    TextView LogIn, Register;
    ProgressBar progressBar;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        auth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
        LogIn=findViewById(R.id.LogIn_wel);
        Register=findViewById(R.id.Register_wel);
//        if(auth.getCurrentUser()!=null){
//           progressBar.setVisibility(View.VISIBLE);
//          startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
//           Toast.makeText(this, "Please Wait You Are Already Logged In", Toast.LENGTH_SHORT).show();
//          finish();
//       }


        LogIn.setOnClickListener(view -> {
            Intent myIntent=new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(myIntent);
        });
        Register.setOnClickListener(v -> {
            Intent myIntent=new Intent(WelcomeActivity.this, RegistrationActivity.class);
            startActivity(myIntent);
        });
    }

}