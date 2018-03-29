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
import java.util.List;

public class ViewAvailableDate extends AppCompatActivity {

    DatabaseHelper db;
    ArrayList<String> theList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_available_date);
        final String uname=getIntent().getStringExtra("Username");

        ListView list_date = (ListView)findViewById(R.id.date_view);
        db= new DatabaseHelper(this);



        Cursor data = db.getListAvailableDate();

        while(data.moveToNext()){
            theList.add(data.getString(0));
            ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
            list_date.setAdapter(adapter);
            list_date.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    System.out.println("Item is "+ theList.get(position));
                    Intent i = new Intent(ViewAvailableDate.this, BookingAppointment.class);

                    i.putExtra("Date", theList.get(position));
                    i.putExtra("Username",uname);

                    startActivity(i);
                }
            });
        }
    }
}
