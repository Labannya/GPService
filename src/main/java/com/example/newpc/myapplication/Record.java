package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Record extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        final String uname= getIntent().getStringExtra("Username");
        Button button_details= (Button)findViewById(R.id.details);
        Button button_history= (Button)findViewById(R.id.history);
        db = new DatabaseHelper(this);
        final Cursor data = db.getListHistoryDate(uname);

        button_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Record.this, PatientInfo.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });


        button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.moveToFirst();
                if(data.getCount()==0){
                    Toast toastView = Toast.makeText(Record.this, "No history available", Toast.LENGTH_SHORT);
                    toastView.show();
                }
                else {
                    Intent i = new Intent(Record.this, HistoryDate.class);
                    i.putExtra("Username", uname);
                    startActivity(i);
                }
            }
        });


        Button back=(Button)findViewById(R.id.bck);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Record.this,Welcome.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });
    }
}
