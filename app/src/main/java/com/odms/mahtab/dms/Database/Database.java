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
        Log.e("DATABASE_NAME", "Database Created-"+DATABASE_NAME);
        String tbld_subroute = "CREATE TABLE tbld_subroute (id INTEGER PRIMARY KEY,psrid INTEGER,Subrouteid INTEGER,SubrouteName INTEGER,Todayvisit INT)";
        db.execSQL(tbld_subroute);
        Log.e("tbld_subroute", tbld_subroute);

        String tbld_outlet = "CREATE TABLE tbld_outlet (id INTEGER PRIMARY KEY ,OutletId INTEGER,PSR_id INTEGER,RouteID INTEGER,OutletCode INTEGER,OutletName TEXT,OwnerName TEXT,ContactNo TEXT,Address TEXT,Distributorid INTEGER,HaveVisicooler INTEGER,IsActive INTEGER,channel_name TEXT,outlet_category_name TEXT,Outlet_grade TEXT)";
        Log.e("tbl_order_outlet", tbld_outlet);
        db.execSQL(tbld_outlet);

        String tbld_sku = "CREATE TABLE tbld_sku (id INTEGER PRIMARY KEY ,SKUId INTEGER,SKUName Text,SKUlpc INTEGER,batch_id INTEGER,PackSize INTEGER,TP REAL,MRP REAL)";
        Log.e("tbld_sku", tbld_sku);
        db.execSQL(tbld_sku);

        String temp_order_line = "CREATE TABLE temp_order_line (id INTEGER PRIMARY KEY ,SKUId INTEGER,SKUName Text,linetype INTEGER,SKUlpc INTEGER,batch_id INTEGER,PackSize INTEGER,TP REAL,MRP REAL,int qty)";
        Log.e("temp_order_line", temp_order_line);
        db.execSQL(temp_order_line);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbld_outlet");
        db.execSQL("DROP TABLE IF EXISTS tbld_subroute");
        db.execSQL("DROP TABLE IF EXISTS tbld_sku");
        db.execSQL("DROP TABLE IF EXISTS temp_order_line");
        onCreate(db);
    }

}

