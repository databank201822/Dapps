package com.odms.mahtab.dms.Database.LocalQuery;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.odms.mahtab.dms.Database.Database;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.Model.M_SubRoute;

import java.util.ArrayList;
import java.util.List;

public class tbld_subroute_Local {

    Context Contex;
    GlobalClass GC = new GlobalClass().getInstance();
    SQLiteDatabase db;
    Database LocDB;

    public tbld_subroute_Local(Context context) {
        LocDB = new Database(context);
        db = LocDB.getReadableDatabase();

    }//select DB

    public List<M_SubRoute> getAllSubRoutelistbyid(int Todayvisit) {

        List<M_SubRoute> AllSubRoutelist = new ArrayList<>();

        String selectQuery = "SELECT * FROM tbld_subroute where Todayvisit="+Todayvisit;

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                M_SubRoute SubRoute = new M_SubRoute();
                SubRoute.set_Id(Integer.parseInt(cursor.getString(0)));
                SubRoute.set_Psrid(Integer.parseInt(cursor.getString(1)));
                SubRoute.set_Subrouteid(Integer.parseInt(cursor.getString(2)));
                SubRoute.set_SubrouteName(cursor.getString(3));
                SubRoute.set_Todayvisit(Integer.parseInt(cursor.getString(4)));


                // Adding contact to list
                AllSubRoutelist.add(SubRoute);
            } while (cursor.moveToNext());
        }
        db.close();
        return AllSubRoutelist;

    }

    public List<M_SubRoute> getAllSubRoutelist() {

        List<M_SubRoute> AllSubRoutelist = new ArrayList<>();

        String selectQuery = "SELECT * FROM tbld_subroute ";

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                M_SubRoute SubRoute = new M_SubRoute();
                SubRoute.set_Id(Integer.parseInt(cursor.getString(0)));
                SubRoute.set_Psrid(Integer.parseInt(cursor.getString(1)));
                SubRoute.set_Subrouteid(Integer.parseInt(cursor.getString(2)));
                SubRoute.set_SubrouteName(cursor.getString(3));
                SubRoute.set_Todayvisit(Integer.parseInt(cursor.getString(4)));


                // Adding contact to list
                AllSubRoutelist.add(SubRoute);
            } while (cursor.moveToNext());
        }
        db.close();
        return AllSubRoutelist;

    }




}
