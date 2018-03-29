package com.example.newpc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        final String uname= getIntent().getStringExtra("Username");
        System.out.println("HomeScreen "+uname);

        Button button3= (Button)findViewById(R.id.apntmnt);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this, AppointmentScreen.class);

                i.putExtra("Username",uname);
                startActivity(i);
            }

        });

        Button btn_date = (Button)findViewById(R.id.prscrptn);

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeScreen.this,PrescriptionDate.class);
                i.putExtra("Username",uname);
                startActivity(i);

            }
        });
    }


    }


