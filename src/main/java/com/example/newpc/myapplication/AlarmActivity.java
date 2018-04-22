package com.example.newpc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Button btn_regremin= (Button)findViewById(R.id.regremin);
        btn_regremin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlarmActivity.this,RegularAlarmActivity.class);
                startActivity(i);
            }
        });

        Button btn_appremin= (Button)findViewById(R.id.appRemin);
        btn_appremin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlarmActivity.this,AppointmentAlarmActivity.class);
                startActivity(i);
            }
        });

    }
}
