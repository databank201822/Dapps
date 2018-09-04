package com.odms.mahtab.dms.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.odms.mahtab.dms.Model.M_SKU;
import com.odms.mahtab.dms.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.graphics.Color.parseColor;
import static java.lang.Math.round;

/**
 * Created by Mahtab on 08-Feb-2018.
 */

public class OrderSkuListAdapter extends ArrayAdapter<M_SKU> {

    List<M_SKU> SKUList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;
    private ArrayList<M_SKU> arraylist;

    public OrderSkuListAdapter(Context Context, int resource, List<M_SKU> skuList) {
        super(Context, resource, skuList);
        this.context = Context;
        this.resource = resource;
        this.SKUList = skuList;
        this.arraylist = new ArrayList<M_SKU>();
        this.arraylist.addAll(SKUList);
    }

    // return position here
    @Override
    public long getItemId(int position) {
        return position;
    }

    // return size of list
    @Override
    public int getCount() {
        return SKUList.size();
    }

    //get Object from each position
    @Override
    public M_SKU getItem(int position) {
        return SKUList.get(position);
    }


    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        TextView tvSkuname = view.findViewById(R.id.tvSkuname);
        TextView tvPrice = view.findViewById(R.id.tvPrice);
        TextView tvPromo = view.findViewById(R.id.tvPromo);

        LinearLayout ListItemLayout = view.findViewById(R.id.ListItemLayout);

        M_SKU sku = SKUList.get(position);

        tvSkuname.setText(sku.getSKUName());
        tvPrice.setText(String.valueOf(Math.round(sku.getTP()*sku.getPackSize()))+" Tk");
        tvPromo.setText(String.valueOf(sku.getOrderflag()));
        if (Integer.parseInt(String.valueOf(sku.getOrderflag()))==1){

            ListItemLayout.setBackgroundColor(Color.parseColor("#34a853"));
        }


       //Use for change color on order status
       // ListItemLayout.setBackgroundColor(Color.parseColor("#34a853"));


        return view;
    }
    // Defined Array values to show in ListView

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        SKUList.clear();
        if (charText.length() == 0) {
            SKUList.addAll(arraylist);
        } else {
            for (M_SKU wp : arraylist) {
                if (wp.getSKUName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    SKUList.add(wp);
                }
            }
        }
        notifyDataSetChanged();

    }
}
