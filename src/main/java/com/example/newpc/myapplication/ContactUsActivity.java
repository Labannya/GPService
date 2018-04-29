package com.example.newpc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        final String uname=getIntent().getStringExtra("Username");
        Button back=(Button)findViewById(R.id.bck);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ContactUsActivity.this,Welcome.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });
    }
}
