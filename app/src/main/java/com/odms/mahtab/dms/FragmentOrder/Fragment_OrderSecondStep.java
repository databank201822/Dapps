package com.odms.mahtab.dms.FragmentOrder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.odms.mahtab.dms.Controller.OrderSkuListActivity;

import com.odms.mahtab.dms.Database.LocalQuery.temp_order_line;
import com.odms.mahtab.dms.Model.M_temp_order_line;
import com.odms.mahtab.dms.R;

import java.text.DecimalFormat;
import java.util.List;

import static android.view.ViewGroup.*;
import static android.view.ViewGroup.LayoutParams.*;
import static java.lang.Math.round;

/**
 * Created by Anu on 22/04/17.
 */


public class Fragment_OrderSecondStep extends Fragment {
    TableLayout tl;
    DecimalFormat DecimalFormat = new DecimalFormat("0.00");
    double TotalTPAmount = 0;
    double TotalMRPAmount = 0;
    double totalCS = 0;

    public Fragment_OrderSecondStep() {
        // Required empty public constructor
    }

    public static Fragment_OrderSecondStep newInstance() {
        Fragment_OrderSecondStep fragment = new Fragment_OrderSecondStep();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_ordersecondstep, container, false);

        }


        tl = (TableLayout) mRootView.findViewById(R.id.tlskuindex);


        Button button = (Button) mRootView.findViewById(R.id.btn_addsku);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getActivity(),"Button Click",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), OrderSkuListActivity.class);
                startActivity(intent);
            }
        });

        Orderlist();
        return mRootView;

    }

    @Override
    public void onResume() {
        //  Toast.makeText(getActivity(),"System Resume",Toast.LENGTH_LONG).show();
        Orderlist();
        super.onResume();


    }

    void Orderlist() {

        TotalTPAmount = 0;
        TotalMRPAmount = 0;
        totalCS = 0;
        temp_order_line temp_order_line = new temp_order_line(getActivity());

        tl.removeAllViews();

        List<M_temp_order_line> Conts = temp_order_line.getorderskulist();


        tableheader();

        for (M_temp_order_line Cont : Conts) {

            M_temp_order_line data = new M_temp_order_line(Cont.getSKUId(), Cont.getSKUName(), Cont.getPackSize(), Cont.getTP(), Cont.getMRP(), Cont.getQty(), Cont.getFreeqty());
            tablebody(data);
        }

        Double Margin = ((TotalMRPAmount - TotalTPAmount) / TotalMRPAmount) * 100;

        tablefooter("Order Price :", DecimalFormat.format(TotalTPAmount));
        tablefooter("MRP Price :", DecimalFormat.format(TotalMRPAmount));
        tablefooter("Profit Margin :", DecimalFormat.format(TotalMRPAmount - TotalTPAmount));
        tablefooter("Margin :", DecimalFormat.format(Margin) + "%");


    }

    void tableheader() {
        tl.removeAllViews();
        TableRow row = new TableRow(getActivity());

        TextView tvSKUName = new TextView(getActivity());
        TextView tvCS = new TextView(getActivity());
        TextView tvPS = new TextView(getActivity());
        TextView tvFree = new TextView(getActivity());
        TextView tbValue = new TextView(getActivity());
        TextView tvAction = new TextView(getActivity());


        row.setBackgroundResource(R.drawable.table_header_row_bg);

        tvSKUName.setText("SKU Name");
        tvSKUName.setBackgroundResource(R.drawable.table_cell_bg);
        tvSKUName.setGravity(Gravity.CENTER);

        tvCS.setText("CS");
        tvCS.setBackgroundResource(R.drawable.table_cell_bg);
        tvCS.setGravity(Gravity.CENTER);

        tvPS.setText("PS");
        tvPS.setBackgroundResource(R.drawable.table_cell_bg);
        tvPS.setGravity(Gravity.CENTER);

        tvFree.setText("Free");
        tvFree.setBackgroundResource(R.drawable.table_cell_bg);
        tvFree.setGravity(Gravity.CENTER);

        tbValue.setText("Value");
        tbValue.setBackgroundResource(R.drawable.table_cell_bg);
        tbValue.setGravity(Gravity.CENTER);




        row.addView(tvSKUName);
        row.addView(tvCS);
        row.addView(tvPS);
        row.addView(tvFree);
        row.addView(tbValue);


        tl.addView(row);

    }

    void tablebody(final M_temp_order_line data) {
        final String getSKUName=data.getSKUName();
        int CS = data.getQty() / data.getPackSize();
        int ps = data.getQty() % data.getPackSize();


        double TPAmount = data.getQty() * data.getTP();
        double MRPAmount = (data.getQty() + data.getFreeqty()) * data.getMRP();

        totalCS = totalCS + (data.getQty() * data.getPackSize());
        TotalTPAmount = TotalTPAmount + TPAmount;
        TotalMRPAmount = TotalMRPAmount + MRPAmount;


        TableRow row = new TableRow(getActivity());

        TextView tvSKUName = new TextView(getActivity());
        TextView tvCS = new TextView(getActivity());
        TextView tvPS = new TextView(getActivity());
        final TextView tvFree = new TextView(getActivity());
        TextView tvValue = new TextView(getActivity());
        ImageButton btnRemove = new ImageButton(getActivity());
        ImageButton btnEdit = new ImageButton(getActivity());

        row.setBackgroundResource(R.drawable.table_header_row_bg);

        tvSKUName.setText(data.getSKUName());
        tvSKUName.setBackgroundResource(R.drawable.table_cell_bg);
        tvSKUName.setGravity(Gravity.LEFT);

        tvCS.setText(Integer.toString(CS));
        tvCS.setBackgroundResource(R.drawable.table_cell_bg);
        tvCS.setGravity(Gravity.CENTER);

        tvPS.setText(Integer.toString(ps));
        tvPS.setBackgroundResource(R.drawable.table_cell_bg);
        tvPS.setGravity(Gravity.CENTER);

        tvFree.setText(Integer.toString(data.getFreeqty()));
        tvFree.setBackgroundResource(R.drawable.table_cell_bg);
        tvFree.setGravity(Gravity.CENTER);

        tvValue.setText(Double.toString(round(TPAmount)));
        tvValue.setBackgroundResource(R.drawable.table_cell_bg);
        tvValue.setGravity(Gravity.CENTER);

        btnRemove.setBackgroundResource(R.drawable.remove);

        btnRemove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                AlertDialogMassage(data.getSKUId(),"Do you Remove SKU : "+ data.getSKUName());


            }});
        btnEdit.setBackgroundResource(R.drawable.edit);

        btnEdit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                AlertDialogMassage(data.getSKUId(),"Do you Edit SKU : "+ data.getSKUName());


            }});

        row.addView(tvSKUName);
        row.addView(tvCS);
        row.addView(tvPS);
        row.addView(tvFree);
        row.addView(tvValue);
        row.addView(btnEdit);
        row.addView(btnRemove);

        tl.addView(row);


    }

    void tablefooter(String mag, String value) {

        TableRow row = new TableRow(getActivity());

        TextView tvSKUName = new TextView(getActivity());
        TextView tbValue = new TextView(getActivity());
        TextView tbblank = new TextView(getActivity());

        row.setBackgroundResource(R.drawable.table_header_row_bg);

        tvSKUName.setText(mag);
        tvSKUName.setBackgroundResource(R.drawable.table_cell_bg);
        tvSKUName.setGravity(Gravity.RIGHT);


        tbValue.setText(value);
        tbValue.setBackgroundResource(R.drawable.table_cell_bg);
        tbValue.setGravity(Gravity.RIGHT);
        tbValue.setTypeface(tbValue.getTypeface(), Typeface.BOLD);

        tbblank.setBackgroundResource(R.drawable.table_cell_bg);

        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 4;

        row.addView(tvSKUName, 0, params);
        row.addView(tbblank);


        tl.addView(row);


    }

    public void AlertDialogMassage(final int skuid, String massage) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("DMS");

        alertDialog.setMessage(massage);
        alertDialog.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                temp_order_line temp_order_line = new temp_order_line(getActivity());
                temp_order_line.DeleteOrderLine(skuid);
                Orderlist();
                Toast.makeText(getActivity(), "removed " , Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });;


        alertDialog.show();
    }
}
