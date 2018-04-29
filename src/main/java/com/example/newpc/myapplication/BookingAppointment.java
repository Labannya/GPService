package com.example.newpc.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookingAppointment extends AppCompatActivity {

    DatabaseHelper db;
    private DatePickerDialog.OnDateSetListener dateListener;
    public Calendar cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_appointment);
        String date= getIntent().getStringExtra("Date");
        String time= getIntent().getStringExtra("Time");
        final String uname= getIntent().getStringExtra("Username");
        System.out.println("BookingAppointment "+uname);

        final TextView textV= (TextView)findViewById(R.id.date_value);
        textV.setText(date);
        final TextView textTime= (TextView)findViewById(R.id.time_value);
        textTime.setText(time);


        db= new DatabaseHelper(this);

        final Cursor chooseDate=db.chooseAvailableAppointment(textV.getText(),textTime.getText());




        Button btn_date = (Button)findViewById(R.id.date);
        Button btn_time = (Button)findViewById(R.id.time);
        Button btn_save = (Button)findViewById(R.id.edit);
        Button btn_cancel = (Button)findViewById(R.id.cancel);

        final EditText issue=(EditText)findViewById(R.id.cause);


        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textTime.setText("");
                cal= Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month= cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(BookingAppointment.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,dateListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        dateListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date;
                month=month+1;
                if(month<10){
                    if(day<10){
                        date = String.valueOf(0)+String.valueOf(day) + "/" + String.valueOf(0) + String.valueOf(month) + "/" + String.valueOf(year);
                    }
                    else {
                        date = String.valueOf(day) + "/" + String.valueOf(0) + String.valueOf(month) + "/" + String.valueOf(year);
                    }
                }
                else {
                    if(day<10) {
                        date = String.valueOf(0)+String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
                    }
                    else{
                        date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
                    }
                }
                textV.setText(date);
            }
        };


        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("date is "+textV.getText());
                  if(textV.getText().equals("")){
                    Toast toastView = Toast.makeText(BookingAppointment.this,"Please choose date first",Toast.LENGTH_SHORT);
                    toastView.show();
                }

                else {
                    int day = Integer.parseInt(db.dayCount((String) textV.getText()));
                      final Cursor chooseTime=db.getListTime(textV.getText(),uname);
                      int count =chooseTime.getCount();
                    try {
                        if (day <= 30 && day>0) {


                            if (db.date((String) textV.getText()).equalsIgnoreCase("Saturday") || db.date((String) textV.getText()).equalsIgnoreCase("Sunday")) {
                                Toast toastView = Toast.makeText(BookingAppointment.this, "You can't select a date for weekend", Toast.LENGTH_SHORT);
                                toastView.show();
                            }  else if (chooseTime.getCount() == 0) {
                                Toast toastView = Toast.makeText(BookingAppointment.this, "There is no available appointment for your resposible doctor. Please contact emergency service or choose another date.", Toast.LENGTH_SHORT);
                                toastView.show();
                            }

                            else {

                                Intent i = new Intent(BookingAppointment.this, ViewAvailableTime.class);
                                i.putExtra("Time", textV.getText());
                                i.putExtra("Username", uname);
                                startActivity(i);
                            }
                        }

                        else if (new SimpleDateFormat("dd/MM/yyyy").parse((String) textV.getText()).before(new Date())) {
                            Toast toastView = Toast.makeText(BookingAppointment.this, "You can't book an appointment on this date as it is previous date", Toast.LENGTH_SHORT);
                            toastView.show();
                        }

                        else if (day > 30) {
                            Toast toastView = Toast.makeText(BookingAppointment.this, "You can't book an appointment more than one month", Toast.LENGTH_SHORT);
                            toastView.show();

                        }




                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }


            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                final Cursor pending_data= db.getPendingAppointment(uname);
                String described_issue=issue.getText().toString();
                int day= Integer.parseInt(db.dayCount((String) textV.getText()));
                chooseDate.moveToFirst();
                pending_data.moveToFirst();

                if(day <=30){
                    if(pending_data.getCount()==0){
                        System.out.println("No data so insert");
                        db.insertPendingAppointment(uname, textV.getText(), textTime.getText(), described_issue);
                        db.deleteAvaiableAppointment(textV.getText(), textTime.getText());
                        Toast toastView = Toast.makeText(BookingAppointment.this, "Your appointment has been booked successfully", Toast.LENGTH_SHORT);
                        toastView.show();
                        Intent i= new Intent(BookingAppointment.this,AppointmentScreen.class);
                        i.putExtra("Username",uname);
                        startActivity(i);
                    }

                        else if(pending_data.getCount() ==1){
                            System.out.println("update patient data");
                            String date=pending_data.getString(0);
                            String time = pending_data.getString(1);
                            System.out.println("Date is "+date+" and Time is "+time);
                            db.restoreAvaiableAppointment(date,time,uname);
                            db.updatePendingAppointment(uname,textV.getText(),textTime.getText(),described_issue);
                            db.deleteAvaiableAppointment(textV.getText(),textTime.getText());
                            Toast toastView = Toast.makeText(BookingAppointment.this, "Your appointment has been updated successfully", Toast.LENGTH_SHORT);
                            toastView.show();
                           Intent i= new Intent(BookingAppointment.this,AppointmentScreen.class);
                           i.putExtra("Username",uname);
                           startActivity(i);

                        }
                    }



                else {
                    Toast toastView = Toast.makeText(BookingAppointment.this, "You cant select appointment after 1 month", Toast.LENGTH_SHORT);
                    toastView.show();
                }

            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BookingAppointment.this,AppointmentScreen.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });






    }


}
