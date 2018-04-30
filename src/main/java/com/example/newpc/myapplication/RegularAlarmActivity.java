package com.example.newpc.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.newpc.myapplication.helper.AlarmReceiver;
import com.example.newpc.myapplication.helper.DatabaseHelper;
import com.example.newpc.myapplication.helper.TimePickerFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RegularAlarmActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

//    private  TextView text_snooze;
    private TextView textTime;
    DatabaseHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String uname= getIntent().getStringExtra("Username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular_alarm);


        db= new DatabaseHelper(this);





        Button btn_timeset=(Button)findViewById(R.id.setbutton);
        Button btn_timecancel=(Button)findViewById(R.id.cancel);
        final EditText text_snooze=(EditText) findViewById(R.id.remindmin);
        final EditText text_medicine=(EditText) findViewById(R.id.medicine);
        textTime=(TextView)findViewById(R.id.alarmset);



        btn_timeset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.deleteRegularAlarmTable(uname);

                if(text_snooze.getText().length()==0 || text_medicine.getText().length()==0){
                    Toast toastView = Toast.makeText(RegularAlarmActivity.this, "Please choose reminder time", Toast.LENGTH_SHORT);
                    toastView.show();
                }

                else{

                    String snooze_text=""+text_snooze.getText();
                    int size=snooze_text.length();
                    int snooze_time=Integer.parseInt(snooze_text);
                    System.out.println("Time and length is "+snooze_time+" "+size);
                   db.insertRegularAlarmTable(""+text_snooze.getText(),""+text_medicine.getText(),uname);
                    android.support.v4.app.DialogFragment pick = new TimePickerFragment();
                    pick.show(getSupportFragmentManager(),"time picker");
                }
            }
        });


        btn_timecancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
                db.deleteRegularAlarmTable(uname);
            }
        });


        Button btn_bck=(Button)findViewById(R.id.bck);
        btn_bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(RegularAlarmActivity.this,HomeScreen.class);
                i.putExtra("Username",uname);
                startActivity(i);
            }
        });
    }

    public void startAlarm(Calendar c){

        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent i= new Intent(this,AlarmReceiver.class);
        Bundle b=new Bundle();
        Cursor data=db.getSnooze();
        data.moveToFirst();
        b.putString("snoozeTime",data.getString(0));
        b.putString("medicine",data.getString(1));
        i.putExtras(b);
//        startActivity(i);
        PendingIntent pending=PendingIntent.getBroadcast(this,1,i,0);

        manager.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pending);
    }

    public  void cancelAlarm(){
        TextView textTime=(TextView)findViewById(R.id.alarmset);
        EditText text_snooze=(EditText) findViewById(R.id.remindmin);
        EditText text_medicine=(EditText) findViewById(R.id.medicine);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent i= new Intent(this,AlarmReceiver.class);
        PendingIntent pending=PendingIntent.getBroadcast(this,1,i,0);

        manager.cancel(pending);

        textTime.setText("");
        text_snooze.setText("");
        text_medicine.setText("");

    }


    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Date today = new Date();
        String s = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(today);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,i);
        c.set(Calendar.MINUTE,i1);
        c.set(Calendar.SECOND,0);

        updateTime(c);
//        int time= Integer.parseInt((String) text_snooze.getText());
        Cursor data=db.getSnooze();
        data.moveToFirst();
        reminderNote(c,i,i1,Integer.parseInt(data.getString(0)));


    }


    public void updateTime(Calendar c){
       // TextView textTime=(TextView)findViewById(R.id.time);
        String text="";
        text = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        textTime.setText(text);



    }


    public void reminderNote(Calendar cal,int hour, int minute, int time){
        cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,hour);
        cal.set(Calendar.MINUTE,minute-time);
        cal.set(Calendar.SECOND,0);
        startAlarm(cal);

    }
}
