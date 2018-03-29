package com.example.newpc.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by NewPC on 10/03/2018.
 */

public class Welcome extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        String uname= getIntent().getStringExtra("Username");
        final TextView textV= (TextView)findViewById(R.id.username);
        textV.setText(uname);


        Button button2= (Button)findViewById(R.id.start);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Welcome.this, HomeScreen.class);
                i.putExtra("Username",textV.getText());
                startActivity(i);
           }

        });


    }



}
