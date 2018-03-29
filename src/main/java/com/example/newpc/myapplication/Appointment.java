package com.example.newpc.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by NewPC on 17/03/2018.
 */

public class Appointment{
    public static final String Table_name="Appointment_details";
    public static final String Col_1="Username";
    public static final String Col_2="Pending_appointment";
    public static final String Col_3="Time";
    public static final String Col_4="Regarding";
    public static final String Col_5="Doctor";




    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20)"+", "+Col_2+" varchar(20)"+", "+Col_3+" varchar(20)"+", "+Col_4+" varchar(20)"
            +", "+Col_5+" varchar(20));";

    public static final String Insert_1="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+") "+"values ("+"'World' ,"+"'01/04/2018' ,"+"'Unwell' ,"+"'15:00' ,"+"'Doctor1');";
    // public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'2' ,"+"'Hello' ,"+"'World' ,"+"'01.01.2002' ,"+"'Patient2' ,"+"'P102');";
    public static void createPatientTable(SQLiteDatabase db){
        db.execSQL(Table_Create);
       // db.execSQL(Insert_1);

    }



}
