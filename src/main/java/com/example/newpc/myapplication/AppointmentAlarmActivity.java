package com.example.newpc.myapplication;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.newpc.myapplication.helper.AppointmentAlarmReceiver;
import com.example.newpc.myapplication.helper.DatabaseHelper;
import com.example.newpc.myapplication.helper.TimePickerFragment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AppointmentAlarmActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    Calendar cal;
    private DatePickerDialog.OnDateSetListener dateListener;
    EditText text_alarm;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_alarm);
        final String uname= getIntent().getStringExtra("Username");
        db= new DatabaseHelper(this);

        Button btn_timeset=(Button)findViewById(R.id.set);
        Button btn_timecancel=(Button)findViewById(R.id.cncl);
        Button btn_date=(Button)findViewById(R.id.choosedate);
        final EditText text_date=(EditText)findViewById(R.id.date);
        text_alarm=(EditText)findViewById(R.id.alarm);
        final EditText text_remind=(EditText)findViewById(R.id.rmnd);

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal= Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month= cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(AppointmentAlarmActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,dateListener,year,month,day);
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
                text_date.setText(date);
            }
        };

        btn_timecancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
                db.deleteAppointmentAlarmTable(uname);
            }
        });


        Button btn_bck=(Button)findViewById(R.id.bck);
        btn_bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(AppointmentAlarmActivity.this,HomeScreen.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });

        btn_timeset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteAppointmentAlarmTable(uname);
                if(text_remind.getText().length()==0 && text_date.getText().length()!=0){
                    Toast toastView = Toast.makeText(AppointmentAlarmActivity.this, "Please remind time first", Toast.LENGTH_SHORT);
                    toastView.show();
                }

                else if(text_date.getText().length()==0 && text_remind.getText().length()!=0){
                    Toast toastView = Toast.makeText(AppointmentAlarmActivity.this, "Please choose date first", Toast.LENGTH_SHORT);
                    toastView.show();
                }

                else if(text_date.getText().length()==0 && text_remind.getText().length()==0){
                    Toast toastView = Toast.makeText(AppointmentAlarmActivity.this, "Please fill the required field", Toast.LENGTH_SHORT);
                    toastView.show();
                }

                else{
                    try {
                        String s1=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                        String s2=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(text_date.getText())));
                        if(new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(text_date.getText())).before(new Date()) && !s1.equals(s2)){
                            Toast toastView = Toast.makeText(AppointmentAlarmActivity.this, "You can't set alarm for previous date", Toast.LENGTH_SHORT);
                            toastView.show();
                            System.out.println("today data "+new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()));

                            //convert string to date  new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(text_date.getText())

                            System.out.println("Got data "+new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(text_date.getText()))));
                        }
                        else{
                            String snooze_text=""+text_remind.getText();
                            int size=snooze_text.length();
                            int snooze_time=Integer.parseInt(snooze_text);
                            System.out.println("Time and length is "+snooze_time+" "+size);
                            db.insertAppointmentAlarmTable(""+text_remind.getText(),""+text_date.getText(),uname);
                            android.support.v4.app.DialogFragment pick = new TimePickerFragment();
                            pick.show(getSupportFragmentManager(),"time picker");
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
    }



    public  void cancelAlarm(){
        //TextView textTime=(TextView)findViewById(R.id.alarmset);
        EditText text_date=(EditText)findViewById(R.id.date);
        EditText text_alarm=(EditText)findViewById(R.id.alarm);
        EditText text_reminder=(EditText)findViewById(R.id.rmnd);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent i= new Intent(this,AppointmentAlarmReceiver.class);
        PendingIntent pending=PendingIntent.getBroadcast(this,1,i,0);

        manager.cancel(pending);

        text_date.setText("");
        text_alarm.setText("");
        text_reminder.setText("");

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Cursor data=db.getAppointmentSnooze();
        data.moveToFirst();
        Date today = new Date();
        //convert date to string
        String s = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(today);

        System.out.println("Today is "+s);
        System.out.println("Got date is"+data.getString(1));

            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, i);
            c.set(Calendar.MINUTE, i1);
            c.set(Calendar.SECOND, 0);

            updateTime(c);
//        int time= Integer.parseInt((String) text_snooze.getText());
        System.out.println("It is equal "+data.getString(1)+" and reminder time is "+data.getString(0));
        System.out.println("Respectively 0 and 1 is "+data.getString(0).length()+" and "+data.getString(1).length());
        System.out.println("Respectively s and 1 is "+s.length()+" and "+data.getString(1).length());
        if(s.equals(data.getString(1)) && s.length()==data.getString(1).length()) {
            System.out.println("These are equal");
            reminderNote(c, i, i1, Integer.parseInt(data.getString(0)));
        }
    }


    public void reminderNote(Calendar cal,int hour, int minute, int time){
        cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,hour);
        cal.set(Calendar.MINUTE,minute-time);
        cal.set(Calendar.SECOND,0);
        startAlarm(cal);

    }

    public void updateTime(Calendar c){
        // TextView textTime=(TextView)findViewById(R.id.time);
        String text="";
        text = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        text_alarm.setText(text);



    }


    public void startAlarm(Calendar c){

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent i= new Intent(this,AppointmentAlarmReceiver.class);
        Bundle b=new Bundle();
        Cursor data=db.getAppointmentSnooze();
        data.moveToFirst();
        b.putString("snoozeTime",data.getString(0));
        b.putString("date",data.getString(1));
        i.putExtras(b);
//        startActivity(i);
        PendingIntent pending=PendingIntent.getBroadcast(this,1,i,0);

        manager.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pending);
    }


}
