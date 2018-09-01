package com.odms.mahtab.dms.Controller;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.odms.mahtab.dms.Adapter.SubRouteListAdapter;
import com.odms.mahtab.dms.Database.LocalQuery.tbld_subroute_Local;
import com.odms.mahtab.dms.MainActivity;
import com.odms.mahtab.dms.Model.M_SubRoute;
import com.odms.mahtab.dms.R;

import java.util.ArrayList;
import java.util.List;

public class SubRouteActivity extends AppCompatActivity {

    ListView listView;
    List<M_SubRoute> outletArrayList=new ArrayList<>();

    // Search EditText
    EditText inputSearch;
    SubRouteListAdapter adapter;

    int Todayvisit=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_route);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view =getSupportActionBar().getCustomView();

        Todayvisit = getIntent().getIntExtra("Todayvisit",1);

        TextView tvRoute = view.findViewById(R.id.actionbar);
        tvRoute.setText("Sub Route");

        ImageButton btnBack= (ImageButton)view.findViewById(R.id.action_back_btn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton btnHome= (ImageButton)view.findViewById(R.id.action_home_btn);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(SubRouteActivity.this, MainActivity.class);
                startActivity(I);
                finish();
            }
        });




        listView = (ListView) findViewById(R.id.subroute_list);
        // getAllMsg();

        ListViewShow();



    }


    void ListViewShow(){

        outletArrayList=new ArrayList<>();
        tbld_subroute_Local db = new tbld_subroute_Local(getApplicationContext());
        final List<M_SubRoute> SubRoutelist = db.getAllSubRoutelist(Todayvisit);



        adapter = new SubRouteListAdapter(getApplicationContext(), R.layout.listview_row, SubRoutelist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                M_SubRoute data=SubRoutelist.get(position);

                int subrouteid=data.get_Subrouteid();

                Log.e("msg_id","msg_id :"+subrouteid);

                Toast.makeText(getApplicationContext()," "+subrouteid,Toast.LENGTH_SHORT).show();

            }
        });
    }


}


