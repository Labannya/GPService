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

    public static final String Doctor_2="Dr Nathan";
    public static final String Doctor_3="Dr Gemma";





    public static final String Table_Create="create table "+Table_name+" ("+Col_1+" varchar(20)"+", "+Col_2+" varchar(20)"+", "+Col_3+" varchar(20));";

    public static final String Insert_1="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'01/05/2018' ,"+"'10:00' ,'"+Doctor_1+"');";
    public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'01/05/2018' ,"+"'12:00' ,'"+Doctor_1+"');";
    public static final String Insert_3="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'01/05/2018' ,"+"'15:00' ,'"+Doctor_1+"');";
    public static final String Insert_4="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'01/05/2018' ,"+"'16:00' ,'"+Doctor_1+"');";

    public static final String Insert_5="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'02/05/2018' ,"+"'11:00' ,'"+Doctor_1+"');";
    public static final String Insert_6="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'02/05/2018' ,"+"'14:00' ,'"+Doctor_1+"');";
    public static final String Insert_7="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'02/05/2018' ,"+"'16:00' ,'"+Doctor_1+"');";
    public static final String Insert_8="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'02/05/2018' ,"+"'17:00' ,'"+Doctor_1+"');";

    public static final String Insert_9="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'03/05/2018' ,"+"'10:00' ,'"+Doctor_1+"');";
    public static final String Insert_10="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'03/05/2018' ,"+"'11:00' ,'"+Doctor_1+"');";
    public static final String Insert_11="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'03/05/2018' ,"+"'12:00' ,'"+Doctor_1+"');";
    public static final String Insert_12="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'03/05/2018' ,"+"'17:00' ,'"+Doctor_1+"');";

    public static final String Insert_13="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'04/05/2018' ,"+"'14:00' ,'"+Doctor_1+"');";
    public static final String Insert_14="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'04/05/2018' ,"+"'15:00' ,'"+Doctor_1+"');";
    public static final String Insert_15="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'04/05/2018' ,"+"'16:00' ,'"+Doctor_1+"');";
    public static final String Insert_16="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'04/05/2018' ,"+"'17:00' ,'"+Doctor_1+"');";

    public static final String Insert_17="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'08/05/2018' ,"+"'09:00' ,'"+Doctor_1+"');";
    public static final String Insert_18="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'08/04/2018' ,"+"'10:00' ,'"+Doctor_1+"');";
    public static final String Insert_19="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'08/05/2018' ,"+"'11:00' ,'"+Doctor_1+"');";
    public static final String Insert_20="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'08/05/2018' ,"+"'12:00' ,'"+Doctor_1+"');";

    public static final String Insert_21="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'09:00' ,'"+Doctor_1+"');";
    public static final String Insert_22="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'10:00' ,'"+Doctor_1+"');";
    public static final String Insert_23="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'14:00' ,'"+Doctor_1+"');";
    public static final String Insert_24="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'15:00' ,'"+Doctor_1+"');";

    public static final String Insert_25="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'14/05/2018' ,"+"'15:00' ,'"+Doctor_1+"');";
    public static final String Insert_26="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'14/05/2018' ,"+"'16:00' ,'"+Doctor_1+"');";
    public static final String Insert_27="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'14/05/2018' ,"+"'17:00' ,'"+Doctor_1+"');";
    public static final String Insert_28="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'14/05/2018' ,"+"'18:00' ,'"+Doctor_1+"');";

    public static final String Insert_29="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'16/05/2018' ,"+"'10:00' ,'"+Doctor_1+"');";
    public static final String Insert_30="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'16/05/2018' ,"+"'12:00' ,'"+Doctor_1+"');";
    public static final String Insert_31="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'16/05/2018' ,"+"'15:00' ,'"+Doctor_1+"');";
    public static final String Insert_32="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'16/05/2018' ,"+"'16:00' ,'"+Doctor_1+"');";

    public static final String Insert_33="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'25/05/2018' ,"+"'12:00' ,'"+Doctor_1+"');";
    public static final String Insert_34="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'25/05/2018' ,"+"'14:00' ,'"+Doctor_1+"');";
    public static final String Insert_35="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'25/05/2018' ,"+"'15:00' ,'"+Doctor_1+"');";
    public static final String Insert_36="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'25/05/2018' ,"+"'16:00' ,'"+Doctor_1+"');";

    public static final String Insert_37="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'30/05/2018' ,"+"'11:00' ,'"+Doctor_1+"');";
    public static final String Insert_38="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'30/05/2018' ,"+"'12:00' ,'"+Doctor_1+"');";
    public static final String Insert_39="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'30/05/2018' ,"+"'15:00' ,'"+Doctor_1+"');";
    public static final String Insert_40="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'30/05/2018' ,"+"'16:00' ,'"+Doctor_1+"');";

    public static final String Insert_41="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'04/06/2018' ,"+"'11:00' ,'"+Doctor_1+"');";
    public static final String Insert_42="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'04/06/2018' ,"+"'12:00' ,'"+Doctor_1+"');";
    public static final String Insert_43="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'04/06/2018' ,"+"'14:00' ,'"+Doctor_1+"');";
    public static final String Insert_44="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'04/06/2018' ,"+"'16:00' ,'"+Doctor_1+"');";

    public static final String Insert_45="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'11/06/2018' ,"+"'14:00' ,'"+Doctor_1+"');";
    public static final String Insert_46="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'11/06/2018' ,"+"'15:00' ,'"+Doctor_1+"');";
    public static final String Insert_47="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'11/06/2018' ,"+"'16:00' ,'"+Doctor_1+"');";
    public static final String Insert_48="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'11/06/2018' ,"+"'17:00' ,'"+Doctor_1+"');";

    public static final String Insert_49="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'12/06/2018' ,"+"'15:00' ,'"+Doctor_1+"');";
    public static final String Insert_50="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'12/06/2018' ,"+"'16:00' ,'"+Doctor_1+"');";


    public static final String Insert_51="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'02/05/2018' ,"+"'10:00' ,'"+Doctor_2+"');";
    public static final String Insert_52="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'02/05/2018' ,"+"'12:00' ,'"+Doctor_2+"');";
    public static final String Insert_53="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'02/05/2018' ,"+"'15:00' ,'"+Doctor_2+"');";
    public static final String Insert_54="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'02/05/2018' ,"+"'16:00' ,'"+Doctor_2+"');";

    public static final String Insert_55="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'07/05/2018' ,"+"'11:00' ,'"+Doctor_2+"');";
    public static final String Insert_56="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'07/05/2018' ,"+"'14:00' ,'"+Doctor_2+"');";
    public static final String Insert_57="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'07/05/2018' ,"+"'16:00' ,'"+Doctor_2+"');";
    public static final String Insert_58="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'07/05/2018' ,"+"'17:00' ,'"+Doctor_2+"');";

    public static final String Insert_59="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'09/05/2018' ,"+"'10:00' ,'"+Doctor_2+"');";
    public static final String Insert_60="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'09/05/2018' ,"+"'11:00' ,'"+Doctor_2+"');";
    public static final String Insert_61="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'09/05/2018' ,"+"'12:00' ,'"+Doctor_2+"');";
    public static final String Insert_62="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'09/05/2018' ,"+"'17:00' ,'"+Doctor_2+"');";

    public static final String Insert_63="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'14:00' ,'"+Doctor_2+"');";
    public static final String Insert_64="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'15:00' ,'"+Doctor_2+"');";
    public static final String Insert_65="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'16:00' ,'"+Doctor_2+"');";
    public static final String Insert_66="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'17:00' ,'"+Doctor_2+"');";

    public static final String Insert_67="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'08/05/2018' ,"+"'09:00' ,'"+Doctor_2+"');";
    public static final String Insert_68="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'08/04/2018' ,"+"'10:00' ,'"+Doctor_2+"');";
    public static final String Insert_69="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'08/05/2018' ,"+"'11:00' ,'"+Doctor_2+"');";
    public static final String Insert_70="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'08/05/2018' ,"+"'12:00' ,'"+Doctor_2+"');";

    public static final String Insert_71="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'09:00' ,'"+Doctor_2+"');";
    public static final String Insert_72="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'10:00' ,'"+Doctor_2+"');";
    public static final String Insert_73="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'14:00' ,'"+Doctor_2+"');";
    public static final String Insert_74="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'10/05/2018' ,"+"'15:00' ,'"+Doctor_2+"');";

    public static final String Insert_75="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'15/05/2018' ,"+"'15:00' ,'"+Doctor_2+"');";
    public static final String Insert_76="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'15/05/2018' ,"+"'16:00' ,'"+Doctor_2+"');";
    public static final String Insert_77="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'15/05/2018' ,"+"'17:00' ,'"+Doctor_2+"');";
    public static final String Insert_78="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'15/05/2018' ,"+"'18:00' ,'"+Doctor_2+"');";

    public static final String Insert_79="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'17/05/2018' ,"+"'10:00' ,'"+Doctor_2+"');";
    public static final String Insert_80="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'17/05/2018' ,"+"'12:00' ,'"+Doctor_2+"');";
    public static final String Insert_81="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'17/05/2018' ,"+"'15:00' ,'"+Doctor_2+"');";
    public static final String Insert_82="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'17/05/2018' ,"+"'16:00' ,'"+Doctor_2+"');";

    public static final String Insert_83="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'18/05/2018' ,"+"'12:00' ,'"+Doctor_2+"');";
    public static final String Insert_84="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'18/05/2018' ,"+"'14:00' ,'"+Doctor_2+"');";
    public static final String Insert_85="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'18/05/2018' ,"+"'15:00' ,'"+Doctor_2+"');";
    public static final String Insert_86="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'18/05/2018' ,"+"'16:00' ,'"+Doctor_2+"');";

    public static final String Insert_87="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'22/05/2018' ,"+"'11:00' ,'"+Doctor_2+"');";
    public static final String Insert_88="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'22/05/2018' ,"+"'12:00' ,'"+Doctor_2+"');";
    public static final String Insert_89="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'22/05/2018' ,"+"'15:00' ,'"+Doctor_2+"');";
    public static final String Insert_90="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'22/05/2018' ,"+"'16:00' ,'"+Doctor_2+"');";

    public static final String Insert_91="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'28/05/2018' ,"+"'11:00' ,'"+Doctor_2+"');";
    public static final String Insert_92="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'28/05/2018' ,"+"'12:00' ,'"+Doctor_2+"');";
    public static final String Insert_93="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'29/05/2018' ,"+"'14:00' ,'"+Doctor_2+"');";
    public static final String Insert_94="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'29/05/2018' ,"+"'16:00' ,'"+Doctor_2+"');";

    public static final String Insert_95="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'31/05/2018' ,"+"'14:00' ,'"+Doctor_2+"');";
    public static final String Insert_96="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'31/06/2018' ,"+"'14:00' ,'"+Doctor_2+"');";
    public static final String Insert_97="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'03/06/2018' ,"+"'16:00' ,'"+Doctor_2+"');";
    public static final String Insert_98="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'03/06/2018' ,"+"'17:00' ,'"+Doctor_2+"');";

    public static final String Insert_99="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'05/06/2018' ,"+"'15:00' ,'"+Doctor_2+"');";
    public static final String Insert_100="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+") "+"values ("+"'07/06/2018' ,"+"'16:00' ,'"+Doctor_2+"');";

    // public static final String Insert_2="insert into "+Table_name+" ("+Col_1+", "+Col_2+", "+Col_3+", "+Col_4+", "+Col_5+", "+Col_6+") "+"values ("+"'2' ,"+"'Hello' ,"+"'World' ,"+"'01.01.2002' ,"+"'Patient2' ,"+"'P102');";
    public static void createAvailabilityTable(SQLiteDatabase db){
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
        db.execSQL(Insert_11);
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
        db.execSQL(Insert_29);
        db.execSQL(Insert_30);
        db.execSQL(Insert_31);
        db.execSQL(Insert_32);
        db.execSQL(Insert_33);
        db.execSQL(Insert_34);
        db.execSQL(Insert_35);
        db.execSQL(Insert_36);
        db.execSQL(Insert_37);
        db.execSQL(Insert_38);
        db.execSQL(Insert_39);
        db.execSQL(Insert_40);
        db.execSQL(Insert_41);
        db.execSQL(Insert_42);
        db.execSQL(Insert_43);
        db.execSQL(Insert_44);
        db.execSQL(Insert_45);
        db.execSQL(Insert_46);
        db.execSQL(Insert_47);
        db.execSQL(Insert_48);
        db.execSQL(Insert_49);
        db.execSQL(Insert_50);
        db.execSQL(Insert_51);
        db.execSQL(Insert_52);
        db.execSQL(Insert_53);
        db.execSQL(Insert_54);
        db.execSQL(Insert_55);
        db.execSQL(Insert_56);
        db.execSQL(Insert_57);
        db.execSQL(Insert_58);
        db.execSQL(Insert_59);
        db.execSQL(Insert_60);
        db.execSQL(Insert_61);
        db.execSQL(Insert_62);
        db.execSQL(Insert_63);
        db.execSQL(Insert_64);
        db.execSQL(Insert_65);
        db.execSQL(Insert_66);
        db.execSQL(Insert_67);
        db.execSQL(Insert_68);
        db.execSQL(Insert_69);
        db.execSQL(Insert_70);
        db.execSQL(Insert_71);
        db.execSQL(Insert_72);
        db.execSQL(Insert_73);
        db.execSQL(Insert_74);
        db.execSQL(Insert_75);
        db.execSQL(Insert_76);
        db.execSQL(Insert_77);
        db.execSQL(Insert_78);
        db.execSQL(Insert_79);
        db.execSQL(Insert_80);
        db.execSQL(Insert_81);
        db.execSQL(Insert_82);
        db.execSQL(Insert_83);
        db.execSQL(Insert_84);
        db.execSQL(Insert_85);
        db.execSQL(Insert_86);
        db.execSQL(Insert_87);
        db.execSQL(Insert_88);
        db.execSQL(Insert_89);
        db.execSQL(Insert_90);
        db.execSQL(Insert_91);
        db.execSQL(Insert_92);
        db.execSQL(Insert_93);
        db.execSQL(Insert_94);
        db.execSQL(Insert_95);
        db.execSQL(Insert_96);
        db.execSQL(Insert_97);
        db.execSQL(Insert_98);
        db.execSQL(Insert_99);
        db.execSQL(Insert_100);


    }
}
