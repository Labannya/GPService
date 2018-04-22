package com.example.newpc.myapplication;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by NewPC on 16/03/2018.
 */

public class Availability {
    public static final String Table_name="Availability_details";
    public static final String Col_1="Available_day";
    public static final String Col_2="Available_time";
    public static final String Col_3="Doctor_name";
    public static final String Doctor_1="Dr Andy";
    public static final String Doctor_2="Dr Mark";
    public static final String Doctor_3="Dr Laura";
    public static final String Doctor_4="Dr Gemma";
    public static final String Doctor_5="Dr Nathan";





    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20)"+", "+Col_2+" varchar(20)"+", "+Col_3+" varchar(20));";

    public static final String Insert_1="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'20/04/2018' ,"+"'15:00' ,'"+Doctor_1+"');";
    public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'20/04/2018' ,"+"'16:00' ,'"+Doctor_1+"');";

    public static final String Insert_3="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'20/04/2018' ,"+"'12:00' ,'"+Doctor_5+"');";
    public static final String Insert_4="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'20/04/2018' ,"+"'10:00' ,'"+Doctor_5+"');";
    // public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'2' ,"+"'Hello' ,"+"'World' ,"+"'01.01.2002' ,"+"'Patient2' ,"+"'P102');";
    public static void createAvailabilityTable(SQLiteDatabase db){
        db.execSQL(Table_Create);
        db.execSQL(Insert_1);
        db.execSQL(Insert_2);
        db.execSQL(Insert_3);
        db.execSQL(Insert_4);

    }
}
