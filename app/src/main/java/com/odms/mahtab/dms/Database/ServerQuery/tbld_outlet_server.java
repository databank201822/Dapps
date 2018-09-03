package com.odms.mahtab.dms.Database.ServerQuery;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.odms.mahtab.dms.Database.Database;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.Model.M_SubRoute;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.google.android.gms.common.util.Strings.nullToEmpty;

public class tbld_outlet_server {

    Context Contex;
    GlobalClass GC = new GlobalClass().getInstance();
    SQLiteDatabase db;
    Database LocDB;

    public tbld_outlet_server(Context context) {
        LocDB = new Database(context);
        db = LocDB.getReadableDatabase();

    }//select DB


    public void DeleteAllinTbloutlet() {
        db.delete("tbld_outlet", null, null);
        Log.e("SubrouteDelte", "Data deleted");
    }

    public void OutletServerResponse(String Data) {
        DeleteAllinTbloutlet();

        Log.e("alloutlet", Data.toString());

        JSONArray storesArray = null;
        try {
            storesArray = new JSONArray(Data);
            int a = 0;
            for (int i = 0; i < storesArray.length(); i++) {

                JSONObject Outlet = storesArray.getJSONObject(i);


                insertOutlet(new M_Outlet(Integer.parseInt(Outlet.getString("OutletId")),
                        Integer.parseInt(Outlet.getString("PSR_id")),
                        Integer.parseInt(Outlet.getString("RouteID")),
                        Integer.parseInt(Outlet.getString("OutletCode")),
                        Integer.parseInt(Outlet.getString("Distributorid")),
                        Integer.parseInt(Outlet.getString("HaveVisicooler")),
                        1,
                        Outlet.getString("OutletName"),
                        nullToEmpty(Outlet.getString("OwnerName")),
                        nullToEmpty(Outlet.getString("ContactNo")),
                        nullToEmpty(Outlet.getString("Address")),
                        nullToEmpty(Outlet.getString("channel_name")),
                        nullToEmpty(Outlet.getString("outlet_category_name")),
                        nullToEmpty(Outlet.getString("Outlet_grade"))));
                a = i;

            }
            Log.e("Outlet", "Total Outlet :" + +a);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    public void insertOutlet(M_Outlet outlet) {
        ContentValues values = new ContentValues();
        values.put("OutletId", outlet.getOutletId()); //
        values.put("PSR_id", outlet.getPSR_id()); //
        values.put("RouteID", outlet.getRouteID()); //
        values.put("OutletCode", outlet.getOutletCode()); //
        values.put("OutletName", outlet.getOutletName()); //
        values.put("OwnerName", outlet.getOwnerName()); //
        values.put("ContactNo", outlet.getContactNo()); //
        values.put("Address", outlet.getAddress()); //
        values.put("Distributorid", outlet.getDistributorid()); //
        values.put("HaveVisicooler", outlet.getHaveVisicooler()); //
        values.put("IsActive", outlet.getIsActive()); //
        values.put("channel_name", outlet.getChannel_name()); //
        values.put("outlet_category_name", outlet.getOutlet_category_name()); //
        values.put("Outlet_grade", outlet.getOutlet_grade()); //

        db.insert("tbld_outlet", null, values);
       // Log.e("InsertInto_tbld_outlet", "" + values.toString());

    }

}
