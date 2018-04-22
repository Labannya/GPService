package com.example.newpc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        final String uname= getIntent().getStringExtra("Username");
        Button button_details= (Button)findViewById(R.id.details);
        Button button_history= (Button)findViewById(R.id.history);

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
                Intent i = new Intent(Record.this, HistoryDate.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });
    }
}
