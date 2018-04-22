package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAvailableTime extends AppCompatActivity {
    DatabaseHelper db;
    ArrayList<String> theList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_available_time);
        final String time= getIntent().getStringExtra("Time");
        final String uname=getIntent().getStringExtra("Username");

        ListView list_date = (ListView)findViewById(R.id.time_view);
        db= new DatabaseHelper(this);



        Cursor data = db.getListTime(time,uname);
        System.out.println("It is in view time "+time);
        //data.moveToFirst();
        System.out.println("data is "+data.getCount());

        while(data.moveToNext()){

            System.out.println("It is in view time loop");
            theList.add(data.getString(0));
            ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
            list_date.setAdapter(adapter);
            list_date.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    System.out.println("Item is "+ theList.get(position));
                    Intent i = new Intent(ViewAvailableTime.this, BookingAppointment.class);

                    i.putExtra("Time", theList.get(position));
                    i.putExtra("Date", time);
                    i.putExtra("Username",uname);

                    startActivity(i);
                }
            });
        }
    }
}
