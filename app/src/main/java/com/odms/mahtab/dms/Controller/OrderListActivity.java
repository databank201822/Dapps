package com.odms.mahtab.dms.Controller;

import android.app.ActionBar;
import android.content.Intent;
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
import com.odms.mahtab.dms.Database.LocalQuery.Order_list_Local;
import com.odms.mahtab.dms.Database.LocalQuery.tbld_outlet_Local;
import com.odms.mahtab.dms.MainActivity;
import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.Model.M_SubRoute;
import com.odms.mahtab.dms.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderListActivity extends AppCompatActivity {

    ListView listView;
    List<M_Outlet> outletArrayList = new ArrayList<>();
    int subrouteid, Todayvisit;
    HorizontalScrollView KPI;

    // Search EditText
    EditText inputSearch;
    OrderOutletListAdapter adapter;
    //Kpi

    TextView SC, Memo, NotOrder, Pending, Ordercs, TLSD, LPSC, Drop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        KPI = (HorizontalScrollView) findViewById(R.id.KPI);
        subrouteid = getIntent().getIntExtra("subrouteid", 0);
        Todayvisit = getIntent().getIntExtra("todayvisit", 0);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();
        TextView tvOutlet = view.findViewById(R.id.actionbar);
        tvOutlet.setText("Order Outlet List");

        ImageButton btnBack = (ImageButton) view.findViewById(R.id.action_back_btn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton btnHome = (ImageButton) view.findViewById(R.id.action_home_btn);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(OrderListActivity.this, MainActivity.class);
                startActivity(I);
                finish();
            }
        });


        inputSearch = (EditText) findViewById(R.id.inputSearch);
        inputSearch.setSelected(false);


        listView = (ListView) findViewById(R.id.outlet_list_view);
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

        todayKPI();

    }

    @Override
    public void onResume() {
        todayKPI();
        Toast.makeText(this, "Activity Resume", Toast.LENGTH_LONG).show();
        super.onResume();


    }


    void todayKPI() {
        if (Todayvisit == 1) {


            KPI.setVisibility(View.VISIBLE);
            Order_list_Local Order_list_Local = new Order_list_Local(getApplicationContext());

            SC = (TextView) findViewById(R.id.SC);
            Memo = (TextView) findViewById(R.id.Memo);
            NotOrder = (TextView) findViewById(R.id.NotOrder);
            Pending = (TextView) findViewById(R.id.Pending);
            Ordercs = (TextView) findViewById(R.id.Ordercs);
            TLSD = (TextView) findViewById(R.id.TLSD);
            LPSC = (TextView) findViewById(R.id.LPSC);
            Drop = (TextView) findViewById(R.id.Drop);

            int SCcount = Order_list_Local.ScCount(subrouteid);
            int MemoCount = 12;
            int NotOrderCount = 3;
            int PendingCount = SCcount - MemoCount - NotOrderCount;
            double TLSDCount = 9;
            double LPSCCount = TLSDCount / MemoCount;
            double OrdercsCount = 130.50;
            double DorpCount = OrdercsCount / MemoCount;

            SC.setText(String.valueOf(SCcount));
            Memo.setText(String.valueOf(MemoCount));
            NotOrder.setText(String.valueOf(NotOrderCount));
            Pending.setText(String.valueOf(PendingCount));
            Ordercs.setText(String.valueOf(OrdercsCount));
            TLSD.setText(String.valueOf(TLSDCount));
            LPSC.setText(String.valueOf(LPSCCount));
            Drop.setText(String.valueOf(DorpCount));


        } else {
            KPI.setVisibility(View.GONE);
        }

    }

    void ListViewShow() {

        outletArrayList = new ArrayList<>();
        tbld_outlet_Local order_outlet_local = new tbld_outlet_Local(getApplicationContext());
        List<M_Outlet> Conts = order_outlet_local.getAllOutletlistbyroute(subrouteid);

        for (M_Outlet Cont : Conts) {
            outletArrayList.add(new M_Outlet(Cont.getOutletId(), Cont.getOutletCode(), Cont.getOutletName()));
            //   Log.e("getAllMsg","Message function"+Cont.getOutletName());
        }

        adapter = new OrderOutletListAdapter(this, R.layout.order_outlet_listview_row, outletArrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                M_Outlet data=outletArrayList.get(position);

                int outletid=data.getOutletId();

                Log.e("msg_id","msg_id :"+outletid);

                Intent I = new Intent(OrderListActivity.this, OrderActivity.class);
                I.putExtra("outletid",outletid);
                startActivity(I);

                Toast.makeText(getApplicationContext(),"Outlet List",Toast.LENGTH_SHORT).show();
            }
        });

    }


}


