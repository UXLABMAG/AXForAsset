package com.example.labux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemListAdapter extends ArrayAdapter<ItemList> {

    public ItemListAdapter(@NonNull Context context, ArrayList<ItemList> item_array_list) {
        super(context, R.layout.items_list, item_array_list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ItemList item_list = getItem(position);

        if(view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.items_list, parent, false);
        }

        ImageView items_image = view.findViewById(R.id.items_image);
        TextView items_name = view.findViewById(R.id.items_name);
        TextView items_desc = view.findViewById(R.id.items_desc);

        items_image.setImageResource(item_list.image);
        items_name.setText(item_list.item_name);
        items_desc.setText(item_list.item_desc);

        return view;
    }
}
