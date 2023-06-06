package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);


        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });


        CardView familyphysician = findViewById(R.id.cardFDFamilyPyhsician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Family Physicians");
                startActivity(intent);
            }
        });

        CardView dietician = findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Dietician");
                startActivity(intent);
            }
        });


        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Dentist");
                startActivity(intent);
            }
        });

        CardView surgen = findViewById(R.id.cardFDSurgeon);
        surgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Surgen");
                startActivity(intent);
            }
        });

        CardView cardiologiests = findViewById(R.id.cardFDCardiologiests);
        cardiologiests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FindDoctorActivity.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Cardiologiests");
                startActivity(intent);
            }
        });

    }
}