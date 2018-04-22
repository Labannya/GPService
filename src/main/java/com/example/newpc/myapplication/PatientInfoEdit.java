package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientInfoEdit extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info_edit);
        final String uname= getIntent().getStringExtra("Username");

        Button btn_save = (Button) findViewById(R.id.save);
        TextView name_text=(TextView)findViewById(R.id.nmTxt);
        TextView dob_text=(TextView)findViewById(R.id.dobTxt);
        TextView age_text=(TextView)findViewById(R.id.ageTxt);
        final TextView number_text=(TextView)findViewById(R.id.numTxt);
        final TextView email_text=(TextView)findViewById(R.id.emailTxt);
        final TextView address_text=(TextView)findViewById(R.id.adrsTxt);
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


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.updatePatientDetails(uname,number_text.getText(),email_text.getText(),address_text.getText());
                Toast toastView = Toast.makeText(PatientInfoEdit.this, "Your details has been updated successfully", Toast.LENGTH_SHORT);
                toastView.show();

                Intent i=new Intent(PatientInfoEdit.this,PatientInfo.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });
    }
}
