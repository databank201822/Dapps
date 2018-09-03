package com.odms.mahtab.dms.FragmentOrder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.odms.mahtab.dms.Controller.OrderActivity;
import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.R;

import static com.google.android.gms.common.util.Strings.nullToEmpty;


public class Fragment_OrderFirstStep extends Fragment {


    TextView OutletCode,OutletName,OwnerName,ContactNo,Address,HaveVisicooler,outlet_category_name,RouteID,PSR_id,Distributorid;
    public Fragment_OrderFirstStep() {
        // Required empty public constructor
    }
    public static Fragment_OrderFirstStep newInstance() {


            Fragment_OrderFirstStep fragment = new Fragment_OrderFirstStep();

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private View mRootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        OrderActivity activity = (OrderActivity) getActivity();
        M_Outlet Outlet = activity.getOutletbyid();

        if(mRootView==null){

            mRootView = inflater.inflate(R.layout.fragment_orderfirststep, container, false);

            OutletCode=(TextView) mRootView.findViewById(R.id.OutletCode);
            OutletName=(TextView) mRootView.findViewById(R.id.OutletName);
            OwnerName=(TextView) mRootView.findViewById(R.id.OwnerName);

            ContactNo=(TextView) mRootView.findViewById(R.id.MobileNo);
            Address=(TextView) mRootView.findViewById(R.id.Address);
            outlet_category_name=(TextView) mRootView.findViewById(R.id.Category);

            OutletCode.setText(String.valueOf(Outlet.getOutletCode()));
            OutletName.setText(String.valueOf(Outlet.getOutletName()));
            OwnerName.setText(nullToEmpty(String.valueOf(Outlet.getOwnerName())));
           ContactNo.setText(nullToEmpty(String.valueOf(Outlet.getContactNo())));
            Address.setText(nullToEmpty(String.valueOf(Outlet.getAddress())));

            outlet_category_name.setText(nullToEmpty(String.valueOf(Outlet.getOutlet_category_name())));



        }
        return mRootView;

    }

}