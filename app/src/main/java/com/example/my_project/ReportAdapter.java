package com.example.my_project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReportAdapter extends ArrayAdapter<Client> {
    private Context ctx;
    private int reportSourceId;
    private ArrayList<Client> data;
    public ReportAdapter(Context context, int resource, ArrayList<Client> objects)
    {

        super(context, resource, objects);
        this.ctx = (Report)context;
        this.reportSourceId = resource;
        this.data = objects;


    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater li = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(this.reportSourceId, null);
        Client c = this.data.get(position);
        TextView businessName= v.findViewById(R.id.clientName);
        businessName.setText(c.getClientName());
        Log.w("myApp", ""+ c.toString());
        TextView info= v.findViewById(R.id.infoView);
        info.setText(c.getOrderInfo());
        Log.w("myApp", ""+ c.getOrderInfo());
        TextView price=  v.findViewById(R.id.priceView);
        price.setText(""+ c.getSumOfMoney());

        return v;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
