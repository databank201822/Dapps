package com.odms.mahtab.dms.Controller;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.R;

import java.util.ArrayList;
import java.util.List;

public class OrderSkuListActivity extends AppCompatActivity {
    ListView listView;
    List<M_Outlet> outletArrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_sku_list);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view =getSupportActionBar().getCustomView();
        TextView tvOutlet = view.findViewById(R.id.actionbar);
        tvOutlet.setText("Order Sku List");

        ImageButton btnBack= (ImageButton)view.findViewById(R.id.action_back_btn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton homeBack= (ImageButton)view.findViewById(R.id.action_home_btn);
        homeBack.setVisibility(View.GONE);





        listView = (ListView) findViewById(R.id.outlet_list_view);
        //getAllMsg();


    }




}
