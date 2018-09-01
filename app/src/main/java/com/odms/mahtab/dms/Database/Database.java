package com.odms.mahtab.dms.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;                     //DATABASE_VERSION
    private static final String DATABASE_NAME = "ODMS";  //DATABASE_NAME
    Context Contex;

    public Database(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }//select DB

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbld_subroute = "CREATE TABLE tbld_subroute (id INTEGER PRIMARY KEY,psrid INTEGER,Subrouteid INTEGER,SubrouteName INTEGER,Todayvisit INT)";
        db.execSQL(tbld_subroute);
        Log.e("tbld_subroute", tbld_subroute);

        String tbld_outlet = "CREATE TABLE tbld_outlet (id INTEGER PRIMARY KEY,outletId INTEGER,outletCode INTEGER,outletName TEXT,routeId INTEGER ,orderCS TEXT,orderStatus INTEGER)";
        Log.e("tbl_order_outlet", tbld_outlet);
        db.execSQL(tbld_outlet);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbld_outlet");
        db.execSQL("DROP TABLE IF EXISTS tbld_subroute");
        onCreate(db);
    }

}

