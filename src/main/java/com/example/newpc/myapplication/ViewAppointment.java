package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewAppointment extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointment);
        final String uname = getIntent().getStringExtra("Username");
        TextView date_view=(TextView)findViewById(R.id.view_date);
        TextView time_view=(TextView)findViewById(R.id.view_time);
        TextView day_view=(TextView)findViewById(R.id.view_day);



        db= new DatabaseHelper(this);
        Cursor data = db.getPendingAppointment(uname);


       // while(data.moveToNext()){
        if(db.checkExisting(data).equals("Exists")) {
            System.out.println("Data is " + data.getString(0));
            try {
                //System.out.println("Day  is "+date(data.getString(0)));
                day_view.setText(db.date(data.getString(0)));
            } catch (Exception e) {
                e.printStackTrace();
            }

            date_view.setText(data.getString(0));
            time_view.setText(data.getString(1));
            // }
        }

        Button btn_chng=(Button)findViewById(R.id.chng);
        btn_chng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ViewAppointment.this,BookingAppointment.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });


        Button btn_bck=(Button)findViewById(R.id.back);
        btn_bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ViewAppointment.this,AppointmentScreen.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });

    }







}
