package com.odms.mahtab.dms.Database.ServerQuery;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.odms.mahtab.dms.Database.Database;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.Model.M_SubRoute;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class tbld_subroute_server {

    Context Contex;
    GlobalClass GC = new GlobalClass().getInstance();
    SQLiteDatabase db;
    Database LocDB;

    public tbld_subroute_server(Context context) {
        LocDB = new Database(context);
        db = LocDB.getReadableDatabase();

    }//select DB


    public void DeleteAllinTblSubroute(){
        db.delete("tbld_subroute", null, null);
        Log.e("SubrouteDelte", "Data deleted");
    }

    public void SubrouteServerResponse(String Data ){
        DeleteAllinTblSubroute();

        Log.e("Subroute", Data.toString());

        JSONArray storesArray = null;
        try {
            storesArray = new JSONArray(Data);
            for(int i = 0; i < storesArray.length(); i++){

                JSONObject subroute = storesArray.getJSONObject(i);
                int Psrid=GC.getPSRid();
               int Subrouteid= Integer.parseInt(subroute.getString("Subrouteid"));
               String SubrouteName=subroute.getString("SubrouteName");
               int Todayvisit=Integer.parseInt(subroute.getString("Todayvisit"));

                insertSubroute(new M_SubRoute(Psrid,Subrouteid,SubrouteName,Todayvisit));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }




    public void insertSubroute(M_SubRoute Subroute) {
        ContentValues values = new ContentValues();
        values.put("Psrid", Subroute.get_Psrid()); //
        values.put("Subrouteid", Subroute.get_Subrouteid()); //
        values.put("SubrouteName", Subroute.get_SubrouteName()); //
        values.put("Todayvisit",Subroute.get_Todayvisit()); //
        db.insert("tbld_subroute", null, values);
        //Log.e("InsertIntotbld_outlet",""+values.toString());

    }

}
