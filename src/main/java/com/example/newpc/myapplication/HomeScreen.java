package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        final String uname= getIntent().getStringExtra("Username");
        System.out.println("HomeScreen "+uname);

        db= new DatabaseHelper(this);

        final Cursor data = db.getListPrescriptionDate(uname);

        Button btn_rmndr= (Button)findViewById(R.id.rmndr);

        btn_rmndr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeScreen.this, AlarmActivity.class);

                i.putExtra("Username",uname);
                startActivity(i);
            }

        });



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
                data.moveToFirst();
                if(data.getCount()==0){
                    Toast toastView = Toast.makeText(HomeScreen.this, "You have no pending appointment to view.", Toast.LENGTH_SHORT);
                    toastView.show();
                }
                else {
                    Intent i = new Intent(HomeScreen.this, PrescriptionDate.class);
                    i.putExtra("Username", uname);
                    startActivity(i);
                }

            }
        });
    }


    }


