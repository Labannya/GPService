package com.example.newpc.myapplication.table;

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
    public static final String Col_9="Doctor_name";



    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20)"+", "+Col_2+" varchar(20)"+", "+Col_3+" varchar(20)"+", "+Col_4+" varchar(20)"
            +", "+Col_5+" varchar(20)"+", "+Col_6+" varchar(20)"+", "+Col_7+" varchar(20)"+", "+Col_8+" varchar(20)"+", "+Col_9+" varchar(20));";

    public static final String Insert_1="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'Andrew' ,"+"'Smith' ,"+"'ASmith' ,"+"'01/01/2001' ,"+"'ASmith01' ,"+"'1234567890' ,"+"'andrew@email.com' ,"+"'London Road, Ls18 9pk' ,"+"'Dr Andy');";
    public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'John' ,"+"'Brien' ,"+"'BJohn' ,"+"'01/01/2002' ,"+"'BJohn02' ,"+"'1234567890' ,"+"'john@email.com' ,"+"'London Road, Ls18 9pk' ,"+"'Dr Andy');";
    public static final String Insert_3="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'Smith' ,"+"'Gordon' ,"+"'SGordon' ,"+"'01/01/2001' ,"+"'SGordon01' ,"+"'1234567890' ,"+"'smith@email.com' ,"+"'London Road, Ls18 9pk' ,"+"'Dr Nathan');";
    public static final String Insert_4="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'Sendra' ,"+"'Mike' ,"+"'SMike' ,"+"'01/01/2002' ,"+"'SMike02' ,"+"'1234567890' ,"+"'mike@email.com' ,"+"'London Road, Ls18 9pk' ,"+"'Dr Nathan');";

    public static final String Insert_5="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'Rachel' ,"+"'Hill' ,"+"'RHill' ,"+"'01/01/1991' ,"+"'RHill91' ,"+"'1234567890' ,"+"'rach@email.com' ,"+"'London Road, Ls190 8LK' ,"+"'Dr Andy');";
    public static final String Insert_6="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'Johnny' ,"+"'Perkin' ,"+"'JPerkin' ,"+"'01/01/1992' ,"+"'JPerkin92' ,"+"'1234567890' ,"+"'johnny@email.com' ,"+"'London Road, LS18 8QG' ,"+"'Dr Andy');";
    public static final String Insert_7="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'Jelena' ,"+"'Anderson' ,"+"'JAnderson' ,"+"'01/01/1991' ,"+"'JAnderson91' ,"+"'1234567890' ,"+"'jelena@email.com' ,"+"'London Road, MP70 0PI' ,"+"'Dr Nathan');";
    public static final String Insert_8="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'Lina' ,"+"'Richard' ,"+"'LRichard' ,"+"'01/01/1982' ,"+"'LRichard82' ,"+"'1234567890' ,"+"'lina@email.com' ,"+"'London Road, Ls88 4RT' ,"+"'Dr Nathan');";

    public static final String Insert_9="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'Adam' ,"+"'George' ,"+"'AGeorge' ,"+"'01/01/1991' ,"+"'AGeorge91' ,"+"'1234567890' ,"+"'adam@email.com' ,"+"'London Road, MP70 0PI' ,"+"'Dr Gemma');";
    public static final String Insert_10="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+", "+Col_8+", "+Col_9+") "+"values ("+"'Mary' ,"+"'Richardsom' ,"+"'MRichardson' ,"+"'01/01/1982' ,"+"'MRichardson82' ,"+"'1234567890' ,"+"'mary@email.com' ,"+"'London Road, Ls88 4RT' ,"+"'Dr Gemma');";

    public static void createPatientTable(SQLiteDatabase db){
        db.execSQL(Table_Create);
        db.execSQL(Insert_1);
        db.execSQL(Insert_2);
        db.execSQL(Insert_3);
        db.execSQL(Insert_4);

        db.execSQL(Insert_5);
        db.execSQL(Insert_6);
        db.execSQL(Insert_7);
        db.execSQL(Insert_8);

        db.execSQL(Insert_9);
        db.execSQL(Insert_10);

    }

}
