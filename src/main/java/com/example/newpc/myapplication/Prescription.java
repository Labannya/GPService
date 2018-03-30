package com.example.newpc.myapplication;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by NewPC on 16/03/2018.
 */

public class Prescription {
    public static final String Table_name="Prescription_details";
    public static final String Col_1="Username";
    public static final String Col_2="Age";
    public static final String Col_3="Attended_appointment";
    public static final String Col_4="Doctor_name";
    public static final String Col_5="Symptom";
    public static final String Col_6="Medicine";



    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20)"+", "+Col_2+" varchar(20)"+", "+Col_3+" varchar(20)"+", "+Col_4+" varchar(20)"
            +", "+Col_5+" varchar(20)"+", "+Col_6+" varchar(20));";

    public static final String Insert_1="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'World' ,"+"'22' ,"+"'01/02/2018' ,"+"'Dr. Andrew' ,"+"'Ferver' ,"+"'Paracetamol');";
    public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'World' ,"+"'22' ,"+"'02/01/2018' ,"+"'Dr. Andrew' ,"+"'Ferver' ,"+null+");";
    // public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'2' ,"+"'Hello' ,"+"'World' ,"+"'01.01.2002' ,"+"'Patient2' ,"+"'P102');";
    public static void createPatientTable(SQLiteDatabase db){
        db.execSQL(Table_Create);
        db.execSQL(Insert_1);
        db.execSQL(Insert_2);

    }
}
