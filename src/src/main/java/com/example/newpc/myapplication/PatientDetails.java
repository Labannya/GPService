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
    public static final String Col_5="Password";
    public static final String Col_6="Contact_number";
    public static final String Col_7="Contact_email";
    public static final String Col_8="Contact_address";



    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20)"+", "+Col_2+" varchar(20)"+", "+Col_3+" varchar(20)"+", "+Col_4+" varchar(20)"
            +", "+Col_5+" varchar(20)"+", "+Col_6+" varchar(20)"+", "+Col_7+" varchar(20)"+", "+Col_8+" varchar(20));";

    public static final String Insert_1="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+") "+"values ("+"'Andrew' ,"+"'Smith' ,"+"'ASmith' ,"+"'01/01/2001' ,"+"'ASmith01' ,"+"'1234567890' ,"+"'andrew@email.com' ,"+"'London Road, Ls18 9pk');";
    //public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'1' ,"+"'Hello' ,"+"'Try' ,"+"'01/01/2002' ,"+"'Patient1' ,"+"'P101');";
    // public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'2' ,"+"'Hello' ,"+"'World' ,"+"'01.01.2002' ,"+"'Patient2' ,"+"'P102');";
    public static void createPatientTable(SQLiteDatabase db){
        db.execSQL(Table_Create);
        db.execSQL(Insert_1);
        //db.execSQL(Insert_2);

    }

}
