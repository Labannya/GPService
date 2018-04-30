package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newpc.myapplication.helper.DatabaseHelper;

public class MActivity extends AppCompatActivity {

    DatabaseHelper mydb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mydb =new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        SQLiteDatabase database = mydb.getWritableDatabase();

        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                EditText a = (EditText)findViewById(R.id.uname);
                String str= a.getText().toString();

                EditText b = (EditText)findViewById(R.id.pass);
                String strPass= b.getText().toString();
                String passwd= String.valueOf(mydb.searchCredentials(str));



                if(view.getId()==R.id.button) {

                    if(strPass.equals(passwd)) {

                        Intent i = new Intent(MActivity.this, Welcome.class);

                        i.putExtra("Username", str);

                        startActivity(i);
                    }

                    else{
                        //get notification for the invalid credentials to login
                        Toast toastView = Toast.makeText(MActivity.this,"Credentials don't match",Toast.LENGTH_SHORT);
                        toastView.show();
                    }

                }
            }
        });
    }




    public void onButtonClick(View v){

    }
}
