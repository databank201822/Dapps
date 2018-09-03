package com.odms.mahtab.dms.service.ServerSync;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.odms.mahtab.dms.Database.ServerQuery.tbld_outlet_server;
import com.odms.mahtab.dms.Database.ServerQuery.tbld_sku_server;
import com.odms.mahtab.dms.Model.GlobalClass;

import java.util.HashMap;
import java.util.Map;

public class SyncSku {

    Context myContext;
    GlobalClass GC = new GlobalClass().getInstance();
    int getDBId = GC.getDBId();
    String url = GC.getSERVER_URL() + "SkuApi/GetSku/"+getDBId;//Get SKU


    public SyncSku(Context Context) {
        myContext = Context;
        SyncServerSkuData();
    }


    public void SyncServerSkuData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tbld_sku_server tbld_sku_server=new tbld_sku_server(myContext);
                        tbld_sku_server.SKUServerResponse(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error_SKUNotsync", error.toString());
                SyncServerSkuData();
            }
        }) {
            //adding parameters to the request
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
               return parameters;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(myContext);
        stringRequest.setShouldCache(false);
        queue.getCache().clear();
        queue.add(stringRequest);
    }

}