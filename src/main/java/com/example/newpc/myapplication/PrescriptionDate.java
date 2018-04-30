package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.newpc.myapplication.helper.DatabaseHelper;

import java.util.ArrayList;

public class PrescriptionDate extends AppCompatActivity {

    DatabaseHelper db;
    ArrayList<String> theList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_date);

        final String uname = getIntent().getStringExtra("Username");

        ListView list_date = (ListView) findViewById(R.id.prescriptionDate_list);
        db = new DatabaseHelper(this);

        Cursor data = db.getListPrescriptionDate(uname);

        data.moveToFirst();
        if (data.getCount() == 0) {
            Toast toastView = Toast.makeText(PrescriptionDate.this, "No prescription available", Toast.LENGTH_SHORT);
            toastView.show();
        } else if (data.getCount() == 1) {
            theList.add(data.getString(0));
            ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
            list_date.setAdapter(adapter);
            list_date.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Cursor p_date = db.getPatientPrescription(uname, theList.get(position));
                    Intent i = new Intent(PrescriptionDate.this, ViewPrescription.class);

                    i.putExtra("Date", theList.get(position));
                    i.putExtra("Username", uname);

                    startActivity(i);
                }


            });
        } else if (data.getCount() > 1) {
            while (data.moveToNext()) {
                theList.add(data.getString(0));
                ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                list_date.setAdapter(adapter);
                list_date.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Cursor p_date = db.getPatientPrescription(uname, theList.get(position));
                        System.out.println("Item is " + theList.get(position));

                          p_date.moveToFirst();
                        System.out.println("Data for medication is " + p_date.getString(5));
                        if (p_date.getString(5)==null){
                        Toast toastView = Toast.makeText(PrescriptionDate.this, "You have no prescription on this date. May be you just visited or missed the appointment", Toast.LENGTH_SHORT);
                        toastView.show();
                    }
                        //System.out.println("Item is " + theList.get(position));
                        else{
                            Intent i = new Intent(PrescriptionDate.this, ViewPrescription.class);

                            i.putExtra("Date", theList.get(position));
                            i.putExtra("Username", uname);

                            startActivity(i);
                        }
                    }
                });
            }
            //}
        }


        Button btn_bck=(Button)findViewById(R.id.bck);
        btn_bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(PrescriptionDate.this,HomeScreen.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });

    }




}

