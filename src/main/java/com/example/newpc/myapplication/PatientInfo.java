package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.newpc.myapplication.helper.DatabaseHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientInfo extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        final String uname= getIntent().getStringExtra("Username");
        Button btn_edit = (Button) findViewById(R.id.edit);
        TextView name_text=(TextView)findViewById(R.id.name_text);
        TextView dob_text=(TextView)findViewById(R.id.dob_txt);
        TextView age_text=(TextView)findViewById(R.id.age_txt);
        TextView number_text=(TextView)findViewById(R.id.num_txt);
        TextView email_text=(TextView)findViewById(R.id.email_txt);
        TextView address_text=(TextView)findViewById(R.id.adrs_txt);
        Date today=new Date();
        db= new DatabaseHelper(this);
        Cursor data= db.getPatientDetails(uname);
        data.moveToFirst();
        name_text.setText(data.getString(0)+" "+data.getString(1));
        dob_text.setText(data.getString(2));
        try {
            age_text.setText(db.getDiffYears(new SimpleDateFormat("dd/MM/yyyy").parse((String) dob_text.getText()),today));//Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dob_text.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        number_text.setText(data.getString(3));
        email_text.setText(data.getString(4));
        address_text.setText(data.getString(5));


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(PatientInfo.this,PatientInfoEdit.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });


        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(PatientInfo.this,Record.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });
    }
}
