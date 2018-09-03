package com.odms.mahtab.dms.Database.ServerQuery;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.odms.mahtab.dms.Database.Database;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.Model.M_SKU;
import com.odms.mahtab.dms.Model.M_SubRoute;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.google.android.gms.common.util.Strings.nullToEmpty;

public class tbld_sku_server {

    Context Contex;
    GlobalClass GC = new GlobalClass().getInstance();
    SQLiteDatabase db;
    Database LocDB;

    public tbld_sku_server(Context context) {
        LocDB = new Database(context);
        db = LocDB.getReadableDatabase();

    }//select DB


    public void DeleteAllinTblsku(){
        db.delete("tbld_sku", null, null);
        Log.e("tbld_sku Delete", "Data deleted");
    }

    public void SKUServerResponse(String Data ){
        DeleteAllinTblsku();


        int a=1;
        JSONArray storesArray = null;
        try {
            storesArray = new JSONArray(Data);
            for(int i = 0; i < storesArray.length(); i++){

                JSONObject sku = storesArray.getJSONObject(i);

                insertOutlet(new M_SKU(Integer.parseInt(sku.getString("SKUId")),sku.getString("SKUName"),
                        Integer.parseInt(sku.getString("SKUlpc")),
                        Integer.parseInt(sku.getString("batch_id")),
                        Integer.parseInt(sku.getString("PackSize")),
                        Double.parseDouble(sku.getString("TP")),
                        Double.parseDouble(sku.getString("MRP"))));
a++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("SKU", "Total SKU :" +a);


    }



    public void insertOutlet(M_SKU sku) {
        ContentValues values = new ContentValues();
        values.put("SKUId", sku.getSKUId()); //
        values.put("SKUName", sku.getSKUName()); //
        values.put("SKUlpc", sku.getSKUlpc()); //
        values.put("batch_id", sku.getBatch_id()); //
        values.put("PackSize", sku.getPackSize()); //
        values.put("TP", sku.getTP()); //
        values.put("MRP", sku.getMRP()); //

        db.insert("tbld_sku", null, values);
     //    Log.e("InsertInto_tbld_outlet", "" + values.toString());

    }

}
