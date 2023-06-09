package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

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
    String[][] doctor_details = {};
    HashMap<String , String> item;
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
            doctor_details = doctor_details1;
        }else if(title.compareTo("Dietician") == 0){
            doctor_details = doctor_details2;
        }else if(title.compareTo("Dentist") == 0){
            doctor_details = doctor_details3;
        }else if(title.compareTo("Surgen") == 0){
            doctor_details = doctor_details4;
        }else {
            doctor_details = doctor_details5;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this , FindDoctorActivity.class));
            }
        });
    list = new ArrayList();
    for (int i = 0 ; i < doctor_details.length; i++){
        item = new HashMap<String , String>();
        item.put("line1" , doctor_details[i][0]);
        item.put("line2" , doctor_details[i][1]);
        item.put("line3" , doctor_details[i][2]);
        item.put("line4" , doctor_details[i][3]);
        item.put("line5" , "Cons Fees:"+ doctor_details[i][4]+"$");
        list.add(item);
    }

//    simple adapter object
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1" , "line2" , "line3" , "line4" , "line5"},
                new int[]{R.id.line_a, R.id.line_b , R.id.line_c , R.id.line_d , R.id.line_e}
                );
        ListView lst = findViewById(R.id.listviewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                intent.putExtra("text1" , title);
                intent.putExtra("text2" , doctor_details[i][0]);
                intent.putExtra("text3" ,  doctor_details[i][1]);
                intent.putExtra("text4" ,  doctor_details[i][3]);
                intent.putExtra("text5" ,  doctor_details[i][4]);
                startActivity(intent);
            }
        });
    }
}