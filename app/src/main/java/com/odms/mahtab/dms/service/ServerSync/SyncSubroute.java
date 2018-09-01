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
import com.odms.mahtab.dms.Database.ServerQuery.tbld_subroute_server;
import com.odms.mahtab.dms.Model.GlobalClass;

import java.util.HashMap;
import java.util.Map;

public class SyncSubroute {

    Context myContext;
    GlobalClass GC = new GlobalClass().getInstance();
    int psrid = GC.getPSRid();
    String url = GC.getSERVER_URL() + "SubRouteApi/GetSubRoute/"+psrid;//Loging chcek


    public SyncSubroute(Context Context) {
        myContext = Context;
        SyncServerSubrouteData();
    }


    public void SyncServerSubrouteData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        tbld_subroute_server tbld_subroute_server=new tbld_subroute_server(myContext);
                        tbld_subroute_server.SubrouteServerResponse(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error_subrouteNotsync", error.toString());
                SyncServerSubrouteData();
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