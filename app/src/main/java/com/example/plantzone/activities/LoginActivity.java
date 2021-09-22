package com.example.plantzone.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plantzone.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity   {

    Button signIn;
    EditText email,password;
    TextView register;
    FirebaseAuth auth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar=findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        auth=FirebaseAuth.getInstance();
        signIn=findViewById(R.id.button_log);
        email=findViewById(R.id.email_log);
        password=findViewById(R.id.password_log);
        register=findViewById(R.id.reg_log);

        register.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegistrationActivity.class)));
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUser();
                progressBar.setVisibility(View.VISIBLE);
            }
        });

    }
            private void loginUser(){

                String userEmail=email.getText().toString();
                String userPassword=password.getText().toString();

                if(TextUtils.isEmpty(userEmail)){
                    Toast.makeText(this, "Email is Empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(userPassword)){
                    Toast.makeText(this, "Password is Empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(userPassword.length()<6){
                    Toast.makeText(this, "Password Length Must Be Greater Than 6 Letters", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(userEmail,userPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                Intent myIntent=new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(myIntent);
                            }
                             else{
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(LoginActivity.this,"Error"+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                            }
                        });
            }
}

