package com.odms.mahtab.dms.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.odms.mahtab.dms.Model.M_OrderOutlet;
import com.odms.mahtab.dms.Model.M_SubRoute;
import com.odms.mahtab.dms.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Mahtab on 08-Feb-2018.
 */

public class SubRouteListAdapter extends ArrayAdapter<M_SubRoute> {

    List<M_SubRoute> RouteList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;


    public SubRouteListAdapter(Context Context, int resource, List<M_SubRoute> subrouteList) {
        super(Context, resource, subrouteList);
        this.context = Context;
        this.resource = resource;
        this.RouteList = subrouteList;

        List<M_SubRoute> Conts = subrouteList;
        for (M_SubRoute Cont : Conts) {
          //  outletArrayList.add(new M_SubRoute(Cont.get_Subrouteid(),Cont.get_SubrouteName()));

            Log.e("get_SubrouteName"," "+Cont.get_SubrouteName());
        }

    }

    // return position here
    @Override
    public long getItemId(int position) {
        return position;
    }

    // return size of list
    @Override
    public int getCount() {

        return RouteList.size();
    }

    //get Object from each position
    @Override
    public M_SubRoute getItem(int position) {
        return RouteList.get(position);
    }


    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(resource, null, false);

        TextView label = view.findViewById(R.id.label);

        LinearLayout ListItemLayout = view.findViewById(R.id.ListItemLayout);

        M_SubRoute message = RouteList.get(position);

        label.setText(message.get_SubrouteName());


        return view;
    }
    // Defined Array values to show in ListView


}
