package com.odms.mahtab.dms.Database.LocalQuery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.odms.mahtab.dms.Database.Database;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.Model.M_SubRoute;
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
        values.put("qty",sku.getQty());

        db.insert("temp_order_line", null, values);

        Log.e("temp_order_line", "" + values.toString());

    }

    public int alreadyOrder(int skuid) {
        String countQuery = "select * from temp_order_line where linetype=1 and SKUId="+skuid;
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public List<M_temp_order_line> getorderskulist() {

        List<M_temp_order_line> Allorderedskulist = new ArrayList<>();

        String selectQuery = "Select A.SKUId,A.SKUName,A.PackSize,A.TP,A.MRP,IFNULL(B.TotalPs,0),IFNULL(C.TotalFreePs,0) from (select DISTINCT SKUId,SKUName,PackSize,TP,MRP from temp_order_line) as A Left join( select SKUId,sum(qty) as TotalPs from temp_order_line where linetype=1  Group by SKUId )as B on A.SKUId= B.SKUId Left join( select SKUId,sum(qty) as TotalFreePs from temp_order_line where linetype=2  Group by SKUId )as C on A.SKUId= C.SKUId";

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                M_temp_order_line skuline = new M_temp_order_line();
                skuline.setSKUId(Integer.parseInt(cursor.getString(0)));
                skuline.setSKUName(cursor.getString(1));
                skuline.setPackSize(Integer.parseInt(cursor.getString(2)));
                skuline.setTP(Double.parseDouble(cursor.getString(3)));
                skuline.setMRP(Double.parseDouble(cursor.getString(4)));
                skuline.setQty(Integer.parseInt(cursor.getString(5)));
                skuline.setFreeqty(Integer.parseInt(cursor.getString(6)));
                // Adding contact to list
                Allorderedskulist.add(skuline);
                Log.e("order line ", "SKU: " +cursor.getString(1));
            } while (cursor.moveToNext());
        }
        db.close();
        return Allorderedskulist;

    }


    public void DeleteOrderLine(int skuid) {
        db.delete("temp_order_line", "linetype =1 AND SKUId="+skuid, null);
        Log.e("temp_order_line", "Data order line deleted-"+skuid);


    }

    public M_temp_order_line getorderitem(int skuid) {



        String selectQuery = "select SKUId,SKUName,PackSize,TP,MRP,qty from temp_order_line where linetype=1 and SKUId="+skuid;

        Cursor cursor = db.rawQuery(selectQuery, null);
        M_temp_order_line skuline = new M_temp_order_line();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                skuline.setSKUId(Integer.parseInt(cursor.getString(0)));
                skuline.setSKUName(cursor.getString(1));
                skuline.setPackSize(Integer.parseInt(cursor.getString(2)));
                skuline.setTP(Double.parseDouble(cursor.getString(3)));
                skuline.setMRP(Double.parseDouble(cursor.getString(4)));
                skuline.setQty(Integer.parseInt(cursor.getString(5)));

                // Adding contact to list

                Log.e("order line ", "SKU: " +cursor.getString(1));
            } while (cursor.moveToNext());
        }
        db.close();
        return skuline;

    }


    public void updateorderLine(int skuid,int qty) {

      String strSQL = "UPDATE temp_order_line SET qty = "+qty+" WHERE SKUId = " + skuid;
      db.execSQL(strSQL);

      Log.e("temp_order_line", skuid+"Data-"+qty);
    }

}
