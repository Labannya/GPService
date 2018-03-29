package com.example.newpc.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewPrescription extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_prescription);

        String date=getIntent().getStringExtra("Date");
        String uname=getIntent().getStringExtra("Username");

        TextView name_view=(TextView)findViewById(R.id.name);
        TextView dob_view=(TextView)findViewById(R.id.dob);
        TextView age_view=(TextView)findViewById(R.id.age);

        TextView symptom_view=(TextView)findViewById(R.id.symptom);
        TextView medication_view=(TextView)findViewById(R.id.medication);
        TextView doctor_view=(TextView)findViewById(R.id.doctor);

        TextView date_view=(TextView)findViewById(R.id.date);

        db= new DatabaseHelper(this);
        Cursor data = db.getPatientPrescription(uname,date);

        if(db.checkExisting(data).equals("Exists")){
            System.out.println("Count is a"+data.getCount());

            System.out.println("date is a"+date);
            if(data.getCount() ==1){
               name_view.setText(data.getString(0)+" "+data.getString(1));
               dob_view.setText(data.getString(2));
               age_view.setText(data.getString(3));
               symptom_view.setText(data.getString(4));
               medication_view.setText(data.getString(5));
               doctor_view.setText(data.getString(6));
               date_view.setText(date);
            }
        }




    }
}
