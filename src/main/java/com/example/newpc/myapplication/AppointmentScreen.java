package com.example.newpc.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.newpc.myapplication.helper.DatabaseHelper;

public class AppointmentScreen extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_screen);
        final String uname= getIntent().getStringExtra("Username");
        System.out.println("AppointmentScreen "+uname);
        db= new DatabaseHelper(this);
        final Cursor data = db.getPendingAppointment(uname);
        Button button3= (Button)findViewById(R.id.booking);


            //date_view.setText(data.getString(0));
            //time_view.setText(data.getString(1));
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(db.checkExisting(data).equals("Not found")){
                        Intent i = new Intent(AppointmentScreen.this, BookingAppointment.class);
                        i.putExtra("Username", uname);
                        startActivity(i);
                    }

                    else if(db.checkExisting(data).equals("Exists")) {
                        if (data.getCount() <= 1) {
                            if (data.getString(0) == null) {
                                Intent i = new Intent(AppointmentScreen.this, BookingAppointment.class);
                                i.putExtra("Username", uname);
                                startActivity(i);
                            } else if (data.getString(0) != null) {
                                Toast toastView = Toast.makeText(AppointmentScreen.this, "You already have one pending appointment", Toast.LENGTH_SHORT);
                                toastView.show();
                            }
                        } else {
                            while (data.moveToNext()) {
                                System.out.println("Data is " + data.getString(1));
                                System.out.println("Here data is " + data.getString(0));
                                if (data.getString(0) == null) {
                                    Intent i = new Intent(AppointmentScreen.this, BookingAppointment.class);
                                    i.putExtra("Username", uname);
                                    startActivity(i);
                                } else if (data.getString(0) != null) {
                                    Toast toastView = Toast.makeText(AppointmentScreen.this, "You already have one pending appointment", Toast.LENGTH_SHORT);
                                    toastView.show();
                                }
                            }
                        }
                    }

                }
            });




//        button3.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            System.out.println("Here data is "+data);
//            if(data.getString(0) ==null) {
//                Intent i = new Intent(AppointmentScreen.this, BookingAppointment.class);
//                i.putExtra("Username", uname);
//                startActivity(i);
//            }
//
//            }
//        });


        Button btn_view=(Button)findViewById(R.id.view);
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (db.checkExisting(data).equals("Not found")) {
                    Toast toastView = Toast.makeText(AppointmentScreen.this, "You have no pending appointment to view.", Toast.LENGTH_SHORT);
                    toastView.show();
                }

                  else if(db.checkExisting(data).equals("Exists")) {
                    System.out.println("Hello Db is " + db.checkExisting(data));
                    if (data.getCount() <= 1) {
                        if (data.getString(0) == null) {
                            Toast toastView = Toast.makeText(AppointmentScreen.this, "You have no pending appointment to view.", Toast.LENGTH_SHORT);
                            toastView.show();
                        } else if (data.getString(0) != null) {
                            Intent i = new Intent(AppointmentScreen.this, ViewAppointment.class);
                            i.putExtra("Username", uname);
                            startActivity(i);
                        }
                    } else {
                        while (data.moveToNext()) {

                            if (data.getString(0) == null) {
                                Toast toastView = Toast.makeText(AppointmentScreen.this, "You have no pending appointment to view.", Toast.LENGTH_SHORT);
                                toastView.show();
                            } else if (data.getString(0) != null) {
                                Intent i = new Intent(AppointmentScreen.this, ViewAppointment.class);
                                i.putExtra("Username", uname);
                                startActivity(i);
                            }
                        }
                    }
                }
            }
        });


        Button btn_cncl=(Button)findViewById(R.id.cancel);
        btn_cncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (db.checkExisting(data).equals("Not found")) {
                    Toast toastView = Toast.makeText(AppointmentScreen.this, "You have no pending appointment to cancel", Toast.LENGTH_SHORT);
                    toastView.show();
                }

                else if(db.checkExisting(data).equals("Exists")) {
                    System.out.print(data.getCount());
                    System.out.println("Hello Db is " + db.checkExisting(data));
                    if (data.getCount() == 0) {
                        Toast toastView = Toast.makeText(AppointmentScreen.this, "You have no pending appointment to cancel", Toast.LENGTH_SHORT);
                        toastView.show();
                        } else if (data.getCount() == 1) {
                            Intent i = new Intent(AppointmentScreen.this, CancelAppointment.class);
                            i.putExtra("Username", uname);
                            startActivity(i);
                        }
                    }
            }
        });



        Button back=(Button)findViewById(R.id.bck);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(AppointmentScreen.this,HomeScreen.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });


    }



}
