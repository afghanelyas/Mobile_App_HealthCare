package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText  edUsername , edEmail, edPassword , edConfirm;
    Button btn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editEmailAddress);
        edEmail = findViewById(R.id.editReEmailAddress2);
        edPassword = findViewById(R.id.editRePassword);
        edConfirm = findViewById(R.id.editConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistingUser);

//        connect to the database
        Database db = new Database(getApplicationContext(),"healthcare" , null , 1);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this , LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();

                if(username.length() == 0 || email.length() == 0  || password.length()==0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all Details", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.compareTo(confirm) == 0){
                        if(validatePassword(password)){

                            db.register(username, email , password);
                            Toast.makeText(getApplicationContext(),"Record Inserted" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this , LoginActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters" , Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Password and confirm password  didn't much" , Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });


    }

    private boolean validatePassword(String password) {
        // Check if password is not empty
        if (TextUtils.isEmpty(password)) {
            // Password is empty
            return false;
        }

        // Check if password meets the required criteria
        // You can customize the criteria as per your needs
        int minLength = 8;  // Minimum length of the password

        if (password.length() < minLength) {
            // Password length is less than the required minimum length
            return false;
        }

        // You can add more validation rules here such as requiring at least one uppercase letter,
        // one lowercase letter, one digit, and one special character.

        return true; // Password is valid
    }

}