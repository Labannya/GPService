package com.example.newpc.myapplication.table;

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
    public static final String Col_7="Dr_note";



    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20)"+", "+Col_2+" varchar(20)"+", "+Col_3+" varchar(20)"+", "+Col_4+" varchar(20)"
            +", "+Col_5+" varchar(20)"+", "+Col_6+" varchar(20)"+", "+Col_7+" varchar(20));";


    public static final String Insert_1="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'06' ,"+"'01/02/2009' ,"+"'Dr. Andy' ,"+"'Ferver' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";
    public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'06' ,"+"'11/06/2009' ,"+"'Dr. Andy' ,"+"'Headache' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";
    public static final String Insert_3="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'09' ,"+"'11/08/2010' ,"+"'Dr. Andy' ,"+"'Ferver' ,"+"'' ,"+"'Happened for cold and cough'"+");";
    public static final String Insert_4="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'09' ,"+"'11/12/2010' ,"+"'Dr. Andy' ,"+"'Stomachache' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";
    public static final String Insert_5="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'10' ,"+"'11/02/2011' ,"+"'Dr. Andy' ,"+"'Ferver' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";
    public static final String Insert_6="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'10' ,"+"'01/12/2011' ,"+"'Dr. Andy' ,"+"'Ferver' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";
    public static final String Insert_7="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'11' ,"+"'01/03/2012' ,"+"'Dr. Andy' ,"+"'Headache' ,"+"'' ,"+"'Happened for cold and cough'"+");";
//    public static final String Insert_8="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'11' ,"+"'18/05/2012' ,"+"'Dr. Andy' ,"+"'Ferver' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";
//    public static final String Insert_9="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'14' ,"+"'01/05/2015' ,"+"'Dr. Andy' ,"+"'Injury' ,"+"'Paracetamol' ,"+"'Injury is very minor. taking rest enough'"+");";
//    public static final String Insert_10="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'14' ,"+"'01/07/2015' ,"+"'Dr. Andy' ,"+"'Ferver' ,"+"'' ,"+"'Happened for cold and cough'"+");";
//    public static final String Insert_11="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'ASmith' ,"+"'17' ,"+"'01/02/2018' ,"+"'Dr. Andy' ,"+"'Headache' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";

    public static final String Insert_12="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'BJohn' ,"+"'15' ,"+"'02/01/2015' ,"+"'Dr. Andy' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";
    public static final String Insert_13="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'BJohn' ,"+"'15' ,"+"'12/05/2016' ,"+"'Dr. Andy' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";
    public static final String Insert_14="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'BJohn' ,"+"'15' ,"+"'22/07/2016' ,"+"'Dr. Andy' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";
    public static final String Insert_15="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'BJohn' ,"+"'15' ,"+"'02/02/2017' ,"+"'Dr. Andy' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";
    public static final String Insert_16="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'BJohn' ,"+"'06' ,"+"'01/08/2017' ,"+"'Dr. Andy' ,"+"'Ferver' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";
    public static final String Insert_17="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'BJohn' ,"+"'06' ,"+"'11/01/2018' ,"+"'Dr. Andy' ,"+"'Headache' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";
    public static final String Insert_18="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'BJohn' ,"+"'06' ,"+"'11/02/2018' ,"+"'Dr. Andy' ,"+"'Ferver' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";
    public static final String Insert_19="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'BJohn' ,"+"'06' ,"+"'11/03/2018' ,"+"'Dr. Andy' ,"+"'Headache' ,"+"'Paracetamol' ,"+"'Happened for cold and cough'"+");";




    public static final String Insert_20="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'RHill' ,"+"'25' ,"+"'02/01/2016' ,"+"'Dr. Andy' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";
    public static final String Insert_21="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'RHill' ,"+"'25' ,"+"'02/04/2016' ,"+"'Dr. Andy' ,"+"'Headache' ,'"+"' ,"+"'No brain pressure'"+");";
    public static final String Insert_22="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'RHill' ,"+"'25' ,"+"'22/08/2016' ,"+"'Dr. Andy' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";


    public static final String Insert_23="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'JAnderson' ,"+"'24' ,"+"'02/01/2015' ,"+"'Dr. Nathan' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";
    public static final String Insert_24="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'JAnderson' ,"+"'25' ,"+"'02/04/2016' ,"+"'Dr. Nathan' ,"+"'Headache' ,'"+"' ,"+"'No brain pressure'"+");";
    public static final String Insert_25="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'JAnderson' ,"+"'26' ,"+"'22/08/2017' ,"+"'Dr. Nathan' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";


    public static final String Insert_26="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'LRichard' ,"+"'33' ,"+"'02/01/2015' ,"+"'Dr. Nathan' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";
    public static final String Insert_27="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'LRichard' ,"+"'34' ,"+"'02/04/2016' ,"+"'Dr. Nathan' ,"+"'Headache' ,'"+"' ,"+"'No brain pressure'"+");";
    public static final String Insert_28="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+", "+Col_7+") "+"values ("+"'LRichard' ,"+"'35' ,"+"'22/08/2017' ,"+"'Dr. Natha' ,"+"'Ferver' ,'"+"' ,"+"'just take rest'"+");";

    public static void createPatientTable(SQLiteDatabase db){

        db.execSQL(Table_Create);
        db.execSQL(Insert_1);
        db.execSQL(Insert_2);
        db.execSQL(Insert_3);
        db.execSQL(Insert_4);

        db.execSQL(Insert_5);
        db.execSQL(Insert_6);
        db.execSQL(Insert_7);

        db.execSQL(Insert_12);
        db.execSQL(Insert_13);
        db.execSQL(Insert_14);
        db.execSQL(Insert_15);
        db.execSQL(Insert_16);
        db.execSQL(Insert_17);
        db.execSQL(Insert_18);
        db.execSQL(Insert_19);
        db.execSQL(Insert_20);
        db.execSQL(Insert_21);
        db.execSQL(Insert_22);


        db.execSQL(Insert_23);
        db.execSQL(Insert_24);
        db.execSQL(Insert_25);
        db.execSQL(Insert_26);
        db.execSQL(Insert_27);
        db.execSQL(Insert_28);






    }
}
