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

import java.util.Calendar;

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


        //final String time= getIntent().getStringExtra("Time");
        final TextView textTime= (TextView)findViewById(R.id.time_value);
        textTime.setText(time);


        db= new DatabaseHelper(this);
        final Cursor pending_data= db.getPendingAppointment(uname);
        final Cursor chooseDate=db.chooseAvailableAppointment(textV.getText(),textTime.getText());



        String timeText= (String) textTime.getText();
        String dateText= (String) textV.getText();

        Button btn_date = (Button)findViewById(R.id.date);
        Button btn_time = (Button)findViewById(R.id.time);
        Button btn_save = (Button)findViewById(R.id.edit);
        Button btn_cancel = (Button)findViewById(R.id.cancel);

        final EditText issue=(EditText)findViewById(R.id.cause);


        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i= new Intent(BookingAppointment.this,ViewAvailableDate.class);
//                i.putExtra("Username",uname);
//                startActivity(i);
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
                    date = String.valueOf(day) + "/" + String.valueOf(0)+String.valueOf(month) + "/" + String.valueOf(year);
                }
                else {
                     date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
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

                else{
                    System.out.println("date is in else");
                    Intent i= new Intent(BookingAppointment.this,ViewAvailableTime.class);
                    i.putExtra("Time", textV.getText());
                    i.putExtra("Username",uname);
                    startActivity(i);
                }
//
//                cal= Calendar.getInstance();
//                int hour= cal.get(Calendar.HOUR_OF_DAY);
//                int minute= cal.get(Calendar.MINUTE);
//
//
//                TimePickerDialog time_dialog=new TimePickerDialog(BookingAppointment.this, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
//                        textTime.setText(hour+":"+minute+" "+selectedTimeFormat(hour));
//                    }
//                },hour,minute,true);
//
//                time_dialog.show();



            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
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
//                    else if(chooseDate.getCount()==1){
//                        System.out.println("No data so insert");
//                        if(pending_data.getCount()==0){
//                            System.out.println("patient has no data");
//                            Toast toastView = Toast.makeText(BookingAppointment.this, "You can't book this slot.This is already booked", Toast.LENGTH_SHORT);
//                            toastView.show();
//                        }

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


                            // && chooseDate.getString(0).equals(textV.getText()) && db.getHour(chooseDate.getString(1)).equals(db.getHour((String) textTime.getText()))
                        }
                    }



                else {
                    Toast toastView = Toast.makeText(BookingAppointment.this, "You cant select appointment after 1 month", Toast.LENGTH_SHORT);
                    toastView.show();
                }















//
//
//
//
//
//
//
//                if(chooseDate.getCount()==0){
//                    if(day <=30){
////                        if(chooseDate.getString(0).equals(textV.getText()) && db.getHour(chooseDate.getString(1)).equals(db.getHour((String) textTime.getText()))){
////                            Toast toastView = Toast.makeText(BookingAppointment.this, "Slot is already booked", Toast.LENGTH_SHORT);
////                            toastView.show();
////                        }
//
//                      //  else {
//                        System.out.println("Hour is "+db.getHour((String) textTime.getText()));
//                        if(db.getHour((String) textTime.getText())<8 || db.getHour((String) textTime.getText())>19) {
//
//                            Toast toastView = Toast.makeText(BookingAppointment.this, "You have to select slot between 8AM to 7PM", Toast.LENGTH_SHORT);
//                            toastView.show();
//
//                        }
//
//                        else{
//                            if(db.getMinute((String) textTime.getText())>0){
//                                Toast toastView = Toast.makeText(BookingAppointment.this, "Please select absolute time. For example, 12:00 pm", Toast.LENGTH_SHORT);
//                                toastView.show();
//                            }
//                            else if(db.getMinute((String) textTime.getText())==0) {
//                                if(chooseDate.getCount()==0) {
//                                    db.insertPendingAppointment(uname, textV.getText(), textTime.getText(), described_issue);
//                                    db.deleteAvaiableAppointment(textV.getText(), textTime.getText());
//                                    Toast toastView = Toast.makeText(BookingAppointment.this, "Your appointment has been booked successfully", Toast.LENGTH_SHORT);
//                                    toastView.show();
//                                }
//                                else if(chooseDate.getCount()==1){
//                                    if(pending_data.getCount()==0){
//                                        Toast toastView = Toast.makeText(BookingAppointment.this, "You can't book this slot.This is already booked", Toast.LENGTH_SHORT);
//                                        toastView.show();
//                                    }
//
//                                    else if(pending_data.getCount() ==1){
//                                        db.updatePendingAppointment(uname,textV.getText(),textTime.getText(),described_issue);
//
//                                        // && chooseDate.getString(0).equals(textV.getText()) && db.getHour(chooseDate.getString(1)).equals(db.getHour((String) textTime.getText()))
//                                    }
//                                }
//                            }
//                        }
//                       // }
//                    }
//
//                    else {
//                        Toast toastView = Toast.makeText(BookingAppointment.this, "You cant select appointment after 1 month", Toast.LENGTH_SHORT);
//                        toastView.show();
//                    }
//                }




            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BookingAppointment.this,AppointmentScreen.class);
                //putExtraData("Username",uname);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });


    }

    public String selectedTimeFormat(int hour){
        String format;
        if(hour==0){
            hour +=12;
            format="AM";
        }

        else if(hour==12){
            //hour =0;
            format="PM";
        }

        else if(hour>12){
            hour -=12;
            format="PM";
        }
        else{
            format="AM";
        }

        return format;
    }
}
