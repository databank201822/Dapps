package com.odms.mahtab.dms.Database.LocalQuery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.odms.mahtab.dms.Database.Database;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.Model.M_SKU;
import com.odms.mahtab.dms.Model.M_temp_order_line;

import java.util.ArrayList;
import java.util.List;

public class temp_order_line {

    Context Contex;
    GlobalClass GC = new GlobalClass().getInstance();
    SQLiteDatabase db;
    Database LocDB;

    public temp_order_line(Context context) {
        LocDB = new Database(context);
        db = LocDB.getReadableDatabase();

    }//select DB
    public void DeleteAllOrderLine() {
        db.delete("temp_order_line", null, null);
        Log.e("temp_order_line", "Data deleted");
    }
    public void insertOrderLine(M_temp_order_line sku) {
        ContentValues values = new ContentValues();
        values.put("SKUId", sku.getSKUId()); //
        values.put("linetype",sku.getLinetype() ); //
        values.put("SKUName", sku.getSKUName()); //
        values.put("SKUlpc", sku.getSKUlpc()); //
        values.put("batch_id", sku.getBatch_id()); //
        values.put("PackSize", sku.getPackSize()); //
        values.put("TP", sku.getTP()); //
        values.put("MRP", sku.getMRP()); //

        db.insert("temp_order_line", null, values);

        Log.e("temp_order_line", "" + values.toString());

    }





}
