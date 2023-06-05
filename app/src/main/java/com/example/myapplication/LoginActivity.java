package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername , edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editEmailAddress);
        edPassword = findViewById(R.id.editPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check the username and password empty

                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();

                if(username.length() == 0 || password.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please fill all details" , Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(getApplicationContext() , "Login Success" , Toast.LENGTH_SHORT).show();

                }

            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this , RegisterActivity.class));
            }
        });
    }
}