package com.example.newpc.myapplication;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by NewPC on 23/04/2018.
 */

public class AppointmentAlarm {
    public static final String Table_name="Appointment_alarm";
    public static final String Col_1="Time";
    public static final String Col_2="Date";
    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20) ,"+Col_2+" varchar(20)"+");";
    public static void createPatientTable(SQLiteDatabase db) {
        db.execSQL(Table_Create);
    }
}
