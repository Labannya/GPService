package com.example.newpc.myapplication.table;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by NewPC on 22/04/2018.
 */

public class RegularAlarm {
    public static final String Table_name="Regular_alarm";
    public static final String Col_1="Time";
    public static final String Col_2="Medicine";
    public static final String Col_3="Username";
    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20) ,"+Col_2+" varchar(20) ,"+Col_3+" varchar(20)"+");";
    public static void createPatientTable(SQLiteDatabase db) {
        db.execSQL(Table_Create);
    }
}
