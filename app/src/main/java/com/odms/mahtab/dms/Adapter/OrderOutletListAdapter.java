package com.odms.mahtab.dms.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.odms.mahtab.dms.Model.M_Outlet;
import com.odms.mahtab.dms.R;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Mahtab on 08-Feb-2018.
 */

public class OrderOutletListAdapter extends ArrayAdapter<M_Outlet> {

    List<M_Outlet> outletList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;
    private ArrayList<M_Outlet> arraylist;

    public OrderOutletListAdapter(Context Context, int resource, List<M_Outlet> outletList) {
        super(Context, resource, outletList);
        this.context = Context;
        this.resource = resource;
        this.outletList = outletList;

        this.arraylist = new ArrayList<M_Outlet>();
        this.arraylist.addAll(outletList);
    }

    // return position here
    @Override
    public long getItemId(int position) {
        return position;
    }

    // return size of list
    @Override
    public int getCount() {
        return outletList.size();
    }

    //get Object from each position
    @Override
    public M_Outlet getItem(int position) {
        return outletList.get(position);
    }


    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        TextView tvOutlet = view.findViewById(R.id.tvOutletname);
        TextView tvCode = view.findViewById(R.id.tvCode);
        TextView tvOrderCS = view.findViewById(R.id.tvOrderCS);
        TextView tvStatus = view.findViewById(R.id.tvStatus);
        LinearLayout ListItemLayout = view.findViewById(R.id.ListItemLayout);


        M_Outlet message = outletList.get(position);



        tvOutlet.setText(message.getOutletName());
        tvCode.setText(String.valueOf(message.getOutletCode()));



        return view;
    }
    // Defined Array values to show in ListView

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        outletList.clear();
        if (charText.length() == 0) {
            outletList.addAll(arraylist);
        } else {
            for (M_Outlet wp : arraylist) {
                if (wp.getOutletName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    outletList.add(wp);
                }else if(String.valueOf(wp.getOutletCode()).contains(charText)) {
                    outletList.add(wp);

                }
            }
        }
        notifyDataSetChanged();

    }
}
