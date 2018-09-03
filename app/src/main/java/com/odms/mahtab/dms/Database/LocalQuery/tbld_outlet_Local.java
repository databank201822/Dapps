package com.odms.mahtab.dms.Database.LocalQuery;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.odms.mahtab.dms.Database.Database;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.Model.M_SubRoute;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.gms.common.util.Strings.nullToEmpty;

public class tbld_outlet_Local {

    Context Contex;
    GlobalClass GC = new GlobalClass().getInstance();
    SQLiteDatabase db;
    Database LocDB;

    public tbld_outlet_Local(Context context) {
        LocDB = new Database(context);
        db = LocDB.getReadableDatabase();

    }//select DB

    public List<M_Outlet> getAllOutletlistbyroute(int subrouteid) {

        List<M_Outlet> Outletlistbyroute = new ArrayList<>();

        String selectQuery = "SELECT OutletId,OutletCode,OutletName FROM tbld_outlet where RouteID="+subrouteid;

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                M_Outlet outlet = new M_Outlet();
                outlet.setOutletId(Integer.parseInt(cursor.getString(0)));
                outlet.setOutletCode(Integer.parseInt(cursor.getString(1)));
                outlet.setOutletName(cursor.getString(2));



                // Adding contact to list
                Outletlistbyroute.add(outlet);
            } while (cursor.moveToNext());
        }
        db.close();
        return Outletlistbyroute;

    }

    public List<M_Outlet> getOutletbyid(int outletid) {

        List<M_Outlet> getOutlet = new ArrayList<>();

        String selectQuery = "SELECT OutletId,OutletCode,OutletName,OwnerName,ContactNo,Address,HaveVisicooler,outlet_category_name,RouteID,PSR_id,Distributorid FROM tbld_outlet where OutletId="+outletid;

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                M_Outlet outlet = new M_Outlet();
                outlet.setOutletId(Integer.parseInt(cursor.getString(0)));
                outlet.setOutletCode(Integer.parseInt(cursor.getString(1)));
                outlet.setOutletName(cursor.getString(2));
                outlet.setOwnerName(cursor.getString(3));
                outlet.setContactNo(cursor.getString(4));
                outlet.setAddress(cursor.getString(5));
                outlet.setHaveVisicooler(Integer.parseInt(cursor.getString(6)));
                outlet.setOutlet_category_name(cursor.getString(7));
                outlet.setRouteID(Integer.parseInt(cursor.getString(8)));
                outlet.setPSR_id(Integer.parseInt(cursor.getString(9)));
                outlet.setDistributorid(Integer.parseInt(cursor.getString(10)));





                // Adding contact to list
                getOutlet.add(outlet);
            } while (cursor.moveToNext());
        }
        db.close();
        return getOutlet;

    }


}
