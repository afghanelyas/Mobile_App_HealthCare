package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main Street", " Exp : 15 years", " Mobile No : 555-1234" , "900"},
            {"Doctor Name : Dr. Jane Doe", "Hospital Address : 456 Elm Street", " Exp : 10 years", "555-5678", "600"},
            {"Doctor Name : Dr. David Johnson", "Hospital Address : 789 Oak Street", " Exp : 20 years", "555-9012" , "800"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main Street", " Exp : 15 years", " Mobile No : 555-1234" , "900"},
            {"Doctor Name : Dr. Jane Doe", "Hospital Address : 456 Elm Street", " Exp : 10 years", "555-5678", "600"},
            {"Doctor Name : Dr. David Johnson", "Hospital Address : 789 Oak Street", " Exp : 20 years", "555-9012" , "800"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main Street", " Exp : 15 years", " Mobile No : 555-1234" , "900"},
            {"Doctor Name : Dr. Jane Doe", "Hospital Address : 456 Elm Street", " Exp : 10 years", "555-5678", "600"},
            {"Doctor Name : Dr. David Johnson", "Hospital Address : 789 Oak Street", " Exp : 20 years", "555-9012" , "800"}
    };

    private String[][] doctor_details4 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main Street", " Exp : 15 years", " Mobile No : 555-1234" , "900"},
            {"Doctor Name : Dr. Jane Doe", "Hospital Address : 456 Elm Street", " Exp : 10 years", "555-5678", "600"},
            {"Doctor Name : Dr. David Johnson", "Hospital Address : 789 Oak Street", " Exp : 20 years", "555-9012" , "800"}
    };

    private String[][] doctor_details5 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main Street", " Exp : 15 years", " Mobile No : 555-1234" , "900"},
            {"Doctor Name : Dr. Jane Doe", "Hospital Address : 456 Elm Street", " Exp : 10 years", "555-5678", "600"},
            {"Doctor Name : Dr. David Johnson", "Hospital Address : 789 Oak Street", " Exp : 20 years", "555-9012" , "800"}
    };
    TextView tv;
    Button btn;
    String[][] Doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") == 0){
            String[][] doctor_details = doctor_details1;
        }else if(title.compareTo("Dietician") == 0){
            String[][] doctor_details = doctor_details2;
        }else if(title.compareTo("Dentist") == 0){
            String[][] doctor_details = doctor_details3;
        }else if(title.compareTo("Surgen") == 0){
            String[][] doctor_details = doctor_details4;
        }else {
            String[][] doctor_details = doctor_details5;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this , FindDoctorActivity.class));
            }
        });
    list = new ArrayList();

    }
}