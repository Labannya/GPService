package com.example.newpc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        final String uname=getIntent().getStringExtra("Username");


        Button contact=(Button)findViewById(R.id.contact);
        Button back = (Button)findViewById(R.id.bck);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AboutUsActivity.this,ContactUsActivity.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AboutUsActivity.this,Welcome.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });

    }
}
