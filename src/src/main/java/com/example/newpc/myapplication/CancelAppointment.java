package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CancelAppointment extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_appointment);
        final String uname = getIntent().getStringExtra("Username");
        final TextView date_view = (TextView) findViewById(R.id.dateView);
        final TextView time_view = (TextView) findViewById(R.id.timeView);
        TextView day_view = (TextView) findViewById(R.id.dayView);
        db = new DatabaseHelper(this);
        final Cursor pending_data = db.getPendingAppointment(uname);

        db = new DatabaseHelper(this);
        Cursor data = db.getPendingAppointment(uname);


        // while(data.moveToNext()){
        if (db.checkExisting(data).equals("Exists")) {
            System.out.println("Data is " + data.getString(0));
            try {
                //System.out.println("Day  is "+date(data.getString(0)));
                day_view.setText(db.date(data.getString(0)));
            } catch (Exception e) {
                e.printStackTrace();
            }

            date_view.setText(data.getString(0));
            time_view.setText(data.getString(1));
        }


        Button btn_cncl = (Button) findViewById(R.id.cancel);
        btn_cncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pending_data.moveToFirst();
                System.out.println("date and time is respectively " + pending_data.getString(0) + pending_data.getString(1));
                db.restoreAvaiableAppointment(pending_data.getString(0), pending_data.getString(1));
                System.out.println("Restored date and time respectively " + pending_data.getString(0) + " " + pending_data.getString(1));

                db.deletePendingAppointment(uname);
                Toast.makeText(CancelAppointment.this, "You cancelled you appointment successfully", Toast.LENGTH_SHORT).show();

            }
        });

        Button btn_bck = (Button) findViewById(R.id.back);
        btn_bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(CancelAppointment.this,AppointmentScreen.class);
                i.putExtra("Username",uname);
                startActivity(i);

            }
            // }
        });
    }
}
