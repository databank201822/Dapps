package com.odms.mahtab.dms.Database.LocalQuery;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.odms.mahtab.dms.Database.Database;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.Model.M_SKU;

import java.util.ArrayList;
import java.util.List;

public class tbld_Sku_Local {

    Context Contex;
    GlobalClass GC = new GlobalClass().getInstance();
    SQLiteDatabase db;
    Database LocDB;

    public tbld_Sku_Local(Context context) {
        LocDB = new Database(context);
        db = LocDB.getReadableDatabase();

    }//select DB

    public List<M_SKU> getAllSkulist() {

        List<M_SKU> skuList = new ArrayList<>();

        String selectQuery = "SELECT * FROM tbld_sku";

        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                M_SKU sku = new M_SKU();

                sku.setSKUId(Integer.parseInt(cursor.getString(1)));
                sku.setSKUName(cursor.getString(2));
                sku.setSKUlpc(Integer.parseInt(cursor.getString(3)));
                sku.setBatch_id(Integer.parseInt(cursor.getString(4)));
                sku.setPackSize(Integer.parseInt(cursor.getString(5)));
                sku.setTP(Double.parseDouble(cursor.getString(6)));
                sku.setMRP(Double.parseDouble(cursor.getString(7)));


                // Adding contact to list
                skuList.add(sku);


            } while (cursor.moveToNext());
        }
        db.close();
        return skuList;

    }




}
