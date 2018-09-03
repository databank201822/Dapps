package com.odms.mahtab.dms.Database.LocalQuery;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.odms.mahtab.dms.Database.Database;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.Model.M_Outlet;

import java.util.ArrayList;
import java.util.List;

public class Order_list_Local {

    Context Contex;
    GlobalClass GC = new GlobalClass().getInstance();
    SQLiteDatabase db;
    Database LocDB;

    public Order_list_Local(Context context) {
        LocDB = new Database(context);
        db = LocDB.getReadableDatabase();

    }//select DB

    public List<M_Outlet> getAllOutletlistbyroute(int subrouteid) {

        List<M_Outlet> Outletlistbyroute = new ArrayList<>();

        String selectQuery = "SELECT OutletId,OutletCode,OutletName FROM tbld_outlet where RouteID="+subrouteid;


        return Outletlistbyroute;

    }
    public int ScCount(int subrouteid) {
        String countQuery = "SELECT  * FROM tbld_outlet where RouteID="+subrouteid;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

}
