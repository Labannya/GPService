package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.newpc.myapplication.helper.DatabaseHelper;

public class ViewHIstory extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        String date=getIntent().getStringExtra("Date");
        final String uname=getIntent().getStringExtra("Username");

        TextView name_view=(TextView)findViewById(R.id.name);
        TextView dob_view=(TextView)findViewById(R.id.dob);
        TextView age_view=(TextView)findViewById(R.id.age);

        TextView symptom_view=(TextView)findViewById(R.id.symptom);
        TextView medication_view=(TextView)findViewById(R.id.medication);
        TextView doctor_view=(TextView)findViewById(R.id.doctor);
        TextView doctor_note=(TextView)findViewById(R.id.note);

        TextView date_view=(TextView)findViewById(R.id.date);

        db= new DatabaseHelper(this);
        Cursor data = db.getPatientHistory(uname,date);

        if(db.checkExisting(data).equals("Exists")){
            System.out.println("Count is a"+data.getCount());

            System.out.println("date is a"+date);
            if(data.getCount() ==1){

                name_view.setText(data.getString(0) + " " + data.getString(1));
                dob_view.setText(data.getString(2));
                age_view.setText(data.getString(3));
                symptom_view.setText(data.getString(4));
                medication_view.setText(data.getString(5));
                doctor_view.setText(data.getString(6));
                doctor_note.setText(data.getString(7));
                date_view.setText(date);
            }
            if(data.getCount() >1){
                while(data.moveToNext()) {
                    name_view.setText(data.getString(0) + " " + data.getString(1));
                    dob_view.setText(data.getString(2));
                    age_view.setText(data.getString(3));
                    symptom_view.setText(data.getString(4));
                    medication_view.setText(data.getString(5));
                    doctor_view.setText(data.getString(6));
                    doctor_note.setText(data.getString(7));
                    date_view.setText(date);
                }
            }

        }

        Button go_back=(Button)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ViewHIstory.this,HistoryDate.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });





    }
}
