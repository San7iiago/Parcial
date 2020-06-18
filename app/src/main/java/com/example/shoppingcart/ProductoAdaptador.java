package com.example.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductoAdaptador extends BaseAdapter {

    private Context context;
    private ArrayList<productos> listItems;

    public ProductoAdaptador(Context context, ArrayList<productos> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        productos Item = (productos) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.producto_card_view, null);
        TextView name = (TextView) convertView.findViewById(R.id.lproduct);
        TextView quantity = (TextView) convertView.findViewById(R.id.lcantidad);

        name.setText(Item.getNombre());
        quantity.setText(Item.getCantidad());

        return convertView;
    }
}
