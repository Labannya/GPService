package com.example.newpc.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BookingAppointment extends AppCompatActivity {

    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_appointment);
        String date= getIntent().getStringExtra("Date");
        final String uname= getIntent().getStringExtra("Username");
        System.out.println("BookingAppointment "+uname);


        db= new DatabaseHelper(this);
        final Cursor pending_data= db.getPendingAppointment(uname);

        final TextView textV= (TextView)findViewById(R.id.date_value);
        textV.setText(date);


        String time= getIntent().getStringExtra("Time");
        final TextView textTime= (TextView)findViewById(R.id.time_value);
        textTime.setText(time);

        Button btn_date = (Button)findViewById(R.id.date);
        Button btn_time = (Button)findViewById(R.id.time);
        Button btn_save = (Button)findViewById(R.id.save);
        Button btn_cancel = (Button)findViewById(R.id.cancel);

        final EditText issue=(EditText)findViewById(R.id.cause);


        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(BookingAppointment.this,ViewAvailableDate.class);
                i.putExtra("Username",uname);
                startActivity(i);

            }
        });


        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("date is "+textV.getText());
                if(textV.getText().equals("")){
                    Toast toastView = Toast.makeText(BookingAppointment.this,"Please choose date first",Toast.LENGTH_SHORT);
                    toastView.show();
                }

                else{
                    Intent i= new Intent(BookingAppointment.this,ViewAvailableTime.class);
                    i.putExtra("Time", textV.getText());
                    i.putExtra("Username",uname);
                    startActivity(i);
                }


            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String described_issue=issue.getText().toString();
                //update Appointment_detail when pending appointis !=0
                     //restore available appointment
                     //delete newly input appointment
                if(db.checkExisting(pending_data).equals("Not found")){
//                    Cursor data = db.insertAppointment(uname, textV.getText(), textTime.getText(), described_issue);
//
//                    while (data.moveToNext()) {
//                    }
//
//                    Cursor data1 = db.deleteAvaiableAppointment(textV.getText().toString(), textTime.getText().toString());
//                    while (data1.moveToNext()) {
//                    }
                    db.insertPendingAppointment(uname, textV.getText(), textTime.getText(), described_issue);
                    db.deleteAvaiableAppointment(textV.getText().toString(), textTime.getText().toString());
                    Toast toastView = Toast.makeText(BookingAppointment.this, "Appointment has been booked successfully", Toast.LENGTH_SHORT);
                    toastView.show();

                }

                else if(db.checkExisting(pending_data).equals("Exists")){
                    if(pending_data.getCount()==0){
                        db.insertPendingAppointment(uname, textV.getText(), textTime.getText(), described_issue);
                        db.deleteAvaiableAppointment(textV.getText().toString(), textTime.getText().toString());
                        Toast toastView = Toast.makeText(BookingAppointment.this, "Appointment has been booked successfully", Toast.LENGTH_SHORT);
                        toastView.show();
                    }

                    else if(pending_data.getCount()==1){
                        db.restoreAvaiableAppointment(pending_data.getString(0), pending_data.getString(1));
                        System.out.println("Restored date and time respectively "+pending_data.getString(0)+" "+pending_data.getString(1));

                        db.deleteAvaiableAppointment(textV.getText().toString(), textTime.getText().toString());
                        System.out.println("Deleted date and time respectively "+textV.getText().toString()+" "+textTime.getText().toString());

                        db.updatePendingAppointment(uname, textV.getText(), textTime.getText(), described_issue);

                        Toast toastView = Toast.makeText(BookingAppointment.this, "Appointment has been updated successfully", Toast.LENGTH_SHORT);
                        toastView.show();
                    }
                }

//
//                //insert Appointment_detail when pending appointis =0
//                else if(db.checkExisting(pending_data).equals("Exists")){
//                if(pending_data.getCount()<=1){
//                    if(pending_data.getString(0) == null) {
//                        db.insertPendingAppointment(uname, textV.getText(), textTime.getText(), described_issue);
//                        db.deleteAvaiableAppointment(textV.getText().toString(), textTime.getText().toString());
//                        System.out.println("Deleted date and time respectively "+textV.getText().toString()+" "+textTime.getText().toString());
//
//                        Toast toastView = Toast.makeText(BookingAppointment.this, "Appointment has been booked successfully", Toast.LENGTH_SHORT);
//                        toastView.show();
//                    }
//                    else{
//                        db.restoreAvaiableAppointment(pending_data.getString(0), pending_data.getString(1));
//                        System.out.println("Restored date and time respectively "+pending_data.getString(0)+" "+pending_data.getString(1));
//
//                        db.deleteAvaiableAppointment(textV.getText().toString(), textTime.getText().toString());
//                        System.out.println("Deleted date and time respectively "+textV.getText().toString()+" "+textTime.getText().toString());
//
//                        db.updatePendingAppointment(uname, textV.getText(), textTime.getText(), described_issue);
//
//
//
//
//
//                        Toast toastView = Toast.makeText(BookingAppointment.this, "Appointment has been updated successfully", Toast.LENGTH_SHORT);
//                        toastView.show();
//                    }
//                }
//
//                else {
//
//                    while (pending_data.moveToNext()) {
//                        if (pending_data.getString(0) == null) {
//                            db.insertPendingAppointment(uname, textV.getText(), textTime.getText(), described_issue);
//
//
//
//
//                            Toast toastView = Toast.makeText(BookingAppointment.this, "Appointment has been booked successfully", Toast.LENGTH_SHORT);
//                            toastView.show();
//                        } else {
//                            db.restoreAvaiableAppointment(pending_data.getString(0), pending_data.getString(1));
//
//
//                            db.updatePendingAppointment(uname, textV.getText(), textTime.getText(), described_issue);
//
//
//                            db.deleteAvaiableAppointment(textV.getText().toString(), textTime.getText().toString());
//
//
//                            Toast toastView = Toast.makeText(BookingAppointment.this, "Appointment has been updated successfully", Toast.LENGTH_SHORT);
//                            toastView.show();
//                        }
//                    }
//
//                }
//
//                }
            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BookingAppointment.this,AppointmentScreen.class);
                //putExtraData("Username",uname);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });


    }
}
