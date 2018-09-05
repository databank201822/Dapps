package com.odms.mahtab.dms;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.odms.mahtab.dms.Controller.SubRouteActivity;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.service.GPSTracker;
import com.odms.mahtab.dms.service.ServerDataSync;
import com.odms.mahtab.dms.service.ServerSync.SyncSubroute;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText user,pass;
    Button btnLogin;
    String PSRid, Emp_code, PSRName,DBId,MobileNo,DBName;

    GPSTracker gps;
    GlobalClass GC = new GlobalClass().getInstance();

    String url = GC.getSERVER_URL() + "LoginApi/Checkuser";//Loging chcek


     //String url ="http://192.168.0.106:11111/api/LoginApi/Checkuser/";//Loging chcek
    ProgressDialog progressDialog;
    TelephonyManager telephonyManager;
    String IMEI_Number_Holder;

    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gps = new GPSTracker(LoginActivity.this);
        Button btnLogin=(Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GPSTracker gps;
                gps = new GPSTracker(LoginActivity.this);
                GlobalClass gs = new GlobalClass().getInstance();

                AutoLoging();

             //   Intent I = new Intent(LoginActivity.this, MainActivity.class);
              //  startActivity(I);
            }
        });


    }

    void AutoLoging() {
        progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        if (gps.canGetLocation()) {

            GPSTracker gps;
            gps = new GPSTracker(LoginActivity.this);
            GlobalClass gs = new GlobalClass().getInstance();

            user=(EditText) findViewById(R.id.user);
            pass=(EditText) findViewById(R.id.password);



            double lat= gps.getLatitude();
            double lon=gps.getLongitude();
if(user.getText()!=null ||pass.getText()!=null) {
    UserCheck(user.getText().toString(), pass.getText().toString(), lat, lon, getIMEINumber());
}else{
    progressDialog.dismiss();
    AlertDialogMassage("Please Enter User & Passwor");
}
        } else {
            progressDialog.dismiss();
            gps.showSettingsAlert();
        }

    }

    public String getIMEINumber() {
        telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
        } else {

            IMEI_Number_Holder = telephonyManager.getDeviceId();
        }
        return IMEI_Number_Holder;
    }

    public void UserCheck(final String user,final String pass,final double lat,final double lon,final String IMEI) {


            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Logincheck(response);
                            //  progressDialog.dismiss();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("AllError", error.toString());
                    progressDialog.dismiss();
                    ErrorAlertDialogMassage("No Internet Connection");
                }
            }) {
                //adding parameters to the request
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parameters = new HashMap<String, String>();
                    parameters.put("User", user);
                    parameters.put("Pass", pass);
                    parameters.put("Lat", Double.toString(lat));
                    parameters.put("Lon", Double.toString(lon));
                    parameters.put("Imei", Double.toString(lon));
                    return parameters;
                }
            };
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            stringRequest.setShouldCache(false);
            queue.getCache().clear();
            queue.add(stringRequest);

    }

    public void Logincheck(String data) {
        if(data== null || data.isEmpty()) {
            progressDialog.dismiss();
            Log.e("NODATA", data);
            ErrorAlertDialogMassage("Please Enter Valid User & Password");
        } else {
            try {
                Log.e("DATA", data);
                JSONObject obj = new JSONObject(data);

                PSRid=obj.getString("PSRid");
                Emp_code=obj.getString("Emp_code");
                PSRName=obj.getString("PSRName");
                DBId=obj.getString("DBId");
                MobileNo=obj.getString("MobileNo");
                DBName=obj.getString("DBName");

                GC.setPSRid(Integer.parseInt(PSRid));
                GC.setPSRName(PSRName);
                GC.setDBId(Integer.parseInt(DBId));
                GC.setDBName(DBName);
                GC.setEmp_code(Emp_code);
                GC.setMobileNo(MobileNo);




                ServerDataSync ServerDataSync =new ServerDataSync(getApplicationContext()); //Sync process start
                progressDialog.dismiss();
                AlertDialogMassage(GC.getPSRName());

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
            }
        }

    }




    public void AlertDialogMassage(String massage) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("DMS");

        alertDialog.setMessage(massage);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent I = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(I);
                finish();
            }
        });

        alertDialog.show();
    }
    public void ErrorAlertDialogMassage(String massage) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("DMS");

        alertDialog.setMessage(massage);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialog.show();
    }
    @Override
    public void onBackPressed() {
    }
}
