package com.example.newpc.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by NewPC on 16/03/2018.
 */

public class PatientDetails {
    //static SQLiteDatabase db;

    public static final String Table_name="Patient_details";
    public static final String Col_1="Foreame";
    public static final String Col_2="Surname";
    public static final String Col_3="Username";
    public static final String Col_4="DoB";
    public static final String Col_5="Contact";
    public static final String Col_6="Address";



    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20)"+", "+Col_2+" varchar(20)"+", "+Col_3+" varchar(20)"+", "+Col_4+" varchar(20)"
            +", "+Col_5+" varchar(20)"+", "+Col_6+" varchar(20));";

    public static final String Insert_1="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'1' ,"+"'Hello' ,"+"'World' ,"+"'01/01/2001' ,"+"'Patient1' ,"+"'P101');";
    public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'1' ,"+"'Hello' ,"+"'Try' ,"+"'01/01/2002' ,"+"'Patient1' ,"+"'P101');";
    // public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'2' ,"+"'Hello' ,"+"'World' ,"+"'01.01.2002' ,"+"'Patient2' ,"+"'P102');";
    public static void createPatientTable(SQLiteDatabase db){
        db.execSQL(Table_Create);
        db.execSQL(Insert_1);
        db.execSQL(Insert_2);

    }

}
