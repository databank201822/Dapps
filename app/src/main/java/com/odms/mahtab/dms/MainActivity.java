package com.odms.mahtab.dms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.odms.mahtab.dms.Controller.MyProfileActivity;
import com.odms.mahtab.dms.Controller.OtherActivity;
import com.odms.mahtab.dms.Controller.OutletListSubrouteActivity;
import com.odms.mahtab.dms.Controller.SubRouteActivity;
import com.odms.mahtab.dms.Model.GlobalClass;
import com.odms.mahtab.dms.R;

public class MainActivity extends AppCompatActivity {


    GridView androidGridView;
    GlobalClass GC = new GlobalClass().getInstance();

    String[] gridViewString = {"Order", "Ready Sale", "Outlet List", "New Outlet", "Target", "Offer", "Outlet verify", "My Account", "Sync", "Other Activity", "Logout"};
    int[] gridViewImageId = {R.drawable.order, R.drawable.delivery_module, R.drawable.outlets, R.drawable.outlet_data_collection, R.drawable.target, R.drawable.offer, R.drawable.verification, R.drawable.my_profile, R.drawable.sync, R.drawable.otheractity, R.drawable.logout};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HomeGridView adapterViewAndroid = new HomeGridView(MainActivity.this, gridViewString, gridViewImageId);
        androidGridView = (GridView) findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int a, long id) {

                Intent I;
                switch (a) {
                    case 0:


                         I = new Intent(MainActivity.this, SubRouteActivity.class);
                        I.putExtra("Todayvisit",1);
                        startActivity(I);
                        Toast.makeText(MainActivity.this, "Order", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        I = new Intent(MainActivity.this, SubRouteActivity.class);
                        I.putExtra("Todayvisit",0);
                        startActivity(I);

                        Toast.makeText(MainActivity.this, "Ready Sale", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        I = new Intent(MainActivity.this, OutletListSubrouteActivity.class);
                        startActivity(I);
                        Toast.makeText(MainActivity.this, "Outlet List", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "New Outlet", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "Target", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(MainActivity.this, "Trade Promotion", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(MainActivity.this, "Outlet verify", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        I = new Intent(MainActivity.this, MyProfileActivity.class);
                        startActivity(I);
                        Toast.makeText(MainActivity.this, "My Account", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(MainActivity.this, "Sync", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        int connection=CheckConnection();
                        if(connection==1) {


                            I = new Intent(MainActivity.this, OtherActivity.class);
                            startActivity(I);
                            Toast.makeText(MainActivity.this, "Other Activity", Toast.LENGTH_SHORT).show();
                        }else{
                            Snackbar.make(view, "Please Connected Internet", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                        break;
                    case 10:
                        Intent Logout = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(Logout);
                        Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                        finish();

                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public int CheckConnection() {
        int con = 1;
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null) {
            return 0;
        }

        return con;


    }

    @Override
    public void onBackPressed() {
    }
    public class HomeGridView extends BaseAdapter {

        private Context mContext;
        private final String[] gridViewString;
        private final int[] gridViewImageId;

        public HomeGridView(Context context, String[] gridViewString, int[] gridViewImageId) {
            mContext = context;
            this.gridViewImageId = gridViewImageId;
            this.gridViewString = gridViewString;
        }

        @Override
        public int getCount() {
            return gridViewString.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View gridViewAndroid;
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {

                gridViewAndroid = new View(mContext);
                gridViewAndroid = inflater.inflate(R.layout.gridview_layout, null);
                TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.android_gridview_text);
                ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.android_gridview_image);
                textViewAndroid.setText(gridViewString[i]);
                imageViewAndroid.setImageResource(gridViewImageId[i]);
            } else {
                gridViewAndroid = (View) convertView;
            }

            return gridViewAndroid;
        }
    }


}