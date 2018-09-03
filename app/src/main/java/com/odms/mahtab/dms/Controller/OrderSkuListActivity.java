package com.odms.mahtab.dms.Controller;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.odms.mahtab.dms.Adapter.OrderOutletListAdapter;
import com.odms.mahtab.dms.Adapter.OrderSkuListAdapter;
import com.odms.mahtab.dms.Database.LocalQuery.Order_list_Local;
import com.odms.mahtab.dms.Database.LocalQuery.tbld_Sku_Local;
import com.odms.mahtab.dms.Database.LocalQuery.tbld_outlet_Local;
import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.Model.M_SKU;
import com.odms.mahtab.dms.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderSkuListActivity extends AppCompatActivity {



    ListView listView;
    List<M_SKU> skuArrayList = new ArrayList<>();
    int subrouteid, Todayvisit;


    // Search EditText
    EditText inputSearch;
    OrderSkuListAdapter adapter;
    //Kpi

    TextView SC, Memo, NotOrder, Pending, Ordercs, TLSD, LPSC, Drop;

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

        Log.e("sku", "SKU LIST");
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        inputSearch.setSelected(false);


        listView = (ListView) findViewById(R.id.list_view);
        ListViewShow();


        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });



    }




    void ListViewShow() {

        skuArrayList = new ArrayList<>();
        tbld_Sku_Local sku_local = new tbld_Sku_Local(getApplicationContext());

        List<M_SKU> Conts = sku_local.getAllSkulist();

        for (M_SKU Cont : Conts) {
            skuArrayList.add(new M_SKU(Cont.getId(),Cont.getSKUId(),Cont.getPackSize(),Cont.getTP(), Cont.getSKUName(), Cont.getPromo_name()));
              Log.e("sku","sku function"+Cont.getSKUName());
        }

        adapter = new OrderSkuListAdapter(this, R.layout.order_sku_listview_row, skuArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                M_SKU data=skuArrayList.get(position);

                Toast.makeText(getApplicationContext(),"SKU Id",Toast.LENGTH_SHORT).show();
            }
        });

    }



}
