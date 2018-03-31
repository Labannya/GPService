package com.example.newpc.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by NewPC on 04/03/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    static SQLiteDatabase db;
    public static final int DATABASE_VERSION = 2;
    public static  final String Database_name="Patient.db";
    public static final String Table_name="Patient_table";
    public static final String Col_1="ID";
    public static final String Col_2="Foreame";
    public static final String Col_3="Surname";
    public static final String Col_4="DoB";
    public static final String Col_5="Username";
    public static final String Col_6="Password";
    public  final Context context;


    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" INTEGER PRIMARY KEY AUTOINCREMENT"+", "+Col_2+" varchar(20)"+", "+Col_3+" varchar(20)"+", "+Col_4+" varchar(20)"
            +", "+Col_5+" varchar(20)"+", "+Col_6+" varchar(20));";

    public static final String Insert_1="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'1' ,"+"'Hello' ,"+"'World' ,"+"'01.01.2001' ,"+"'Patient1' ,"+"'P101');";
   // public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'2' ,"+"'Hello' ,"+"'World' ,"+"'01.01.2002' ,"+"'Patient2' ,"+"'P102');";
   public static final String Insert_2="insert into "+Table_name+" ("+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'Hello' ,"+"'World' ,"+"'01.01.2002' ,"+"'Patient2' ,"+"'P102');";
    public static final String Insert_3="insert into "+Table_name+" ("+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'Hello' ,"+"'World' ,"+"'01.01.2003' ,"+"'Patient3' ,"+"'P103');";
    public static final String Insert_4="insert into "+Table_name+" ("+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'Hello' ,"+"'World' ,"+"'01.01.2004' ,"+"'Patient4' ,"+"'P104');";


    public DatabaseHelper(Context context) {
        super(context, Database_name, null, DATABASE_VERSION);
        this.context=context;
//        SQLiteDatabase db=this.getWritableDatabase();
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL("DROP TABLE IF EXISTS "+Table_name+";");//
//        db=this.getWritableDatabase();//
//        db.execSQL(Table_Create);
//        db.execSQL(Insert_1);
//        db.execSQL(Insert_2);
//        db.execSQL(Insert_3);
//        db.execSQL(Insert_4);
        //db.close();//
        //db.execSQL(PatientDetails.Table_Create);
        PatientDetails.createPatientTable(db);
        Availability.createAvailabilityTable(db);
        Prescription.createPatientTable(db);
        Appointment.createPatientTable(db);

    }




    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        System.out.println("Its in Upgrade");
        try {
           // if (newVersion > oldVersion) {
                System.out.println("Its in Upgrade and in if");
                db.execSQL("DROP TABLE IF EXISTS " + PatientDetails.Table_name);
                db.execSQL("DROP TABLE IF EXISTS " + Availability.Table_name);
                db.execSQL("DROP TABLE IF EXISTS " + Prescription.Table_name);
                db.execSQL("DROP TABLE IF EXISTS " + Appointment.Table_name);
                System.out.println("Its in Upgrade and done the drop");
                onCreate(db);
           // }
        }catch(Exception e){
            System.out.println("Its in Upgrade and didn't work for try");
            Toast.makeText(null,"due to "+e,Toast.LENGTH_LONG).show();
        }
    }

    public String searchCredentials(String uname){
        SQLiteDatabase db;
        db=this.getReadableDatabase();
        String query="Select Username, DoB from "+PatientDetails.Table_name;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst()){
            do{
               a=cursor.getString(0);
                if (a.equals(uname)) {
                    b=cursor.getString(1);
                    break;
                }

            }while(cursor.moveToNext());
        }
        return b;
    }


  public Cursor getListAvailableDate(){
      SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Select Available_day from "+Availability.Table_name,null);
        return data;
  }

    public Cursor getListPrescriptionDate(String uname){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Select Attended_appointment from "+Prescription.Table_name+ " where Username='"+uname+"'",null);
        return data;
    }


    public Cursor getListTime(String date){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Select Available_time from "+Availability.Table_name+" where Available_day='"+date+"'",null);
        return data;
    }

    public Cursor getPatientPrescription(String uname,String date){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Select "+PatientDetails.Table_name+"."+PatientDetails.Col_1+", "+PatientDetails.Table_name+"."+PatientDetails.Col_2+", "+PatientDetails.Table_name+"."+PatientDetails.Col_4+", "+Prescription.Table_name+"."+Prescription.Col_2+", "+Prescription.Table_name+"."+Prescription.Col_5+", "+Prescription.Table_name+"."+Prescription.Col_6+", "+Prescription.Table_name+"."+Prescription.Col_4+" from "+Prescription.Table_name+" inner join "+PatientDetails.Table_name+" on "+PatientDetails.Table_name+"."+PatientDetails.Col_3+"="+Prescription.Table_name+"."+Prescription.Col_1+" and "+Prescription.Table_name+"."+Prescription.Col_3+"="+"'"+date+"' and "+Prescription.Table_name+"."+Prescription.Col_1+"= '"+uname+"'",null);
        return data;
    }


    public Cursor insertAppointment(String username, CharSequence date, CharSequence time, String cause){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Insert into "+Appointment.Table_name+" Values ("+"'"+username+"'"+","+"'"+date+"'"+","+"'"+time+"'"+","+"'"+cause+"'"+","+null+")",null);

        return data;
    }


    public void insertPendingAppointment(String username, CharSequence date, CharSequence time, String cause){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Insert into "+Appointment.Table_name+" Values ("+"'"+username+"'"+","+"'"+date+"'"+","+"'"+time+"'"+","+"'"+cause+"'"+","+null+")",null);
        db.execSQL("Insert into "+Appointment.Table_name+" Values ("+"'"+username+"'"+","+"'"+date+"'"+","+"'"+time+"'"+","+"'"+cause+"'"+","+null+")");

    }

    public void deleteAvaiableAppointment(String date,String time){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Delete from "+Availability.Table_name+" Where Available_day='"+date+"' and Available_time='"+time+"'",null);
        db.execSQL("Delete from "+Availability.Table_name+" Where Available_day='"+date+"' and Available_time='"+time+"'");
        //return data;
    }


    public void deletePendingAppointment(String uname){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Delete from "+Appointment.Table_name+" Where Username='"+uname+"'",null);
        db.execSQL("Delete from "+Appointment.Table_name+" Where Username='"+uname+"'");
        //return data;
    }


    public void restoreAvaiableAppointment(String date,String time){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Insert into "+Availability.Table_name+" Values('"+date+"'"+", '"+time+"'"+")",null);
        db.execSQL("Insert into "+Availability.Table_name+" Values('"+date+"'"+", '"+time+"'"+")");
        //return data;
    }

    public void updatePendingAppointment(String uname, CharSequence date, CharSequence time, String issue){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Update "+Appointment.Table_name+" Set Pending_appointment='"+date+"', Time='"+time+"',Regarding='"+issue+"'"+" where Username='"+uname+"'",null);
        db.execSQL("Update "+Appointment.Table_name+" Set Pending_appointment='"+date+"', Time='"+time+"',Regarding='"+issue+"'"+" where Username='"+uname+"'");
        //return data;
    }

    public Cursor getPendingAppointment(String username){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Select Pending_appointment, Time from "+Appointment.Table_name+" Where Username='"+username+"'",null);
        return data;
    }

    public Cursor chooseAvailableAppointment(CharSequence date, CharSequence time){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Select Pending_appointment, Time from "+Appointment.Table_name+" Where Pending_appointment='"+date+"' and Time='"+time+"'",null);
        return data;
    }

    //Select Foreame from Patient_details where Surname='Hello' and not Username='Try'

    public Cursor matchPendingAppointment(String username,String time){
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor data=db.rawQuery("Select Pending_appointment from Appointment_details where Time='"+time+"' and not Username='"+username+"'",null);
        return data;
    }

    public String checkExisting(Cursor data){
        String str= null;
        if(data.moveToFirst()){
            str="Exists";
        }

        else{
            str="Not found";
        }

        return str;
    }


    public String date(String data) throws Exception{
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("dd/MM/yyyy"); // the day of the week spelled out completely
        Date dt1=simpleDateformat.parse(data);
        DateFormat format2=new SimpleDateFormat("EEEE");


        return format2.format(dt1);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String yearCount(String dob){
        String today = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
         DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy",Locale.US);
         String yearDifference= String.valueOf(ChronoUnit.YEARS.between(LocalDate.parse(dob,formatter),LocalDate.parse(today,formatter)));
         return yearDifference;

    }



    public String dayCount(String selectedDay){
        String[] parts=selectedDay.split("/");
        int year=Integer.parseInt(parts[2]);
        int month=Integer.parseInt(parts[1]);
        month=month-1;
        int day=Integer.parseInt(parts[0]);
        Date today = new Date();
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");

        Calendar myCalender = Calendar.getInstance();
        myCalender.set(year,month,day);

        Date futureDate=myCalender.getTime();

        String currentDate=format.format(today);
        String nextDate=format.format(futureDate);

        long days=(futureDate.getTime()-today.getTime())/86400000;

        String daysCount=String.valueOf(days);

        return daysCount;


    }

    public int getHour(String time){
        String[] parts = time.split(":");
        String hour = parts[0];
        int hour_digit=Integer.parseInt(hour);
        return hour_digit;
    }


    public int getMinute(String time){
        String[] parts = time.split(":");
        String second_part = parts[1];
        String[] minute_parts=second_part.split(" ");
        String minute=minute_parts[0];

        int minute_digit=Integer.parseInt(minute);
        return minute_digit;
    }
}
