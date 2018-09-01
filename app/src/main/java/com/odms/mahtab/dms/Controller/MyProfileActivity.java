package com.odms.mahtab.dms.Controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.R;
import com.odms.mahtab.dms.BuildConfig;
public class MyProfileActivity extends AppCompatActivity {

TextView psrName,Dbname,Psrcode,mobile,versionName ;
    GlobalClass GC = new GlobalClass().getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        psrName=(TextView)findViewById(R.id.psrname);
        Dbname=(TextView)findViewById(R.id.dbname);
        Psrcode=(TextView)findViewById(R.id.psrcode);
        mobile=(TextView)findViewById(R.id.mobile);
        versionName=(TextView)findViewById(R.id.versionName );
        String version = BuildConfig.VERSION_NAME;

        psrName.setText(GC.getPSRName());
        Dbname.setText(GC.getDBName());
        Psrcode.setText(GC.getEmp_code());
        mobile.setText(GC.getMobileNo());
        versionName.setText(version);

    }

}
