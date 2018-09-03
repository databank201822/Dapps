package com.odms.mahtab.dms.FragmentOrder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.odms.mahtab.dms.Controller.OrderActivity;
import com.odms.mahtab.dms.Controller.OutletListSubrouteActivity;
import com.odms.mahtab.dms.MainActivity;
import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.R;


public class Fragment_OrderForthStep extends Fragment {

    Button btnSave;
    Context thiscontext;

    public Fragment_OrderForthStep() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private View mRootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        thiscontext = container.getContext();
        if(mRootView==null){
            mRootView = inflater.inflate(R.layout.fragment_orderfourthstep, container, false);

        }
        OrderActivity activity = (OrderActivity) getActivity();
        M_Outlet Outlet = activity.getOutletbyid();

        btnSave=(Button) mRootView.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(thiscontext,"btnSave",Toast.LENGTH_SHORT).show();
            }
        });
        return mRootView;

    }

}