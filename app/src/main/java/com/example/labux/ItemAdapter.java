package com.example.labux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item current_item = Item.items.get(position);

        holder.item_name.setText(current_item.getItem_name());
        holder.item_desc.setText(current_item.getItem_desc());
        holder.item_image.setImageResource(current_item.getItem_image());
    }

    @Override
    public int getItemCount() {
        return Item.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView item_name;
        TextView item_desc;
        ImageView item_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_desc = itemView.findViewById(R.id.item_desc);
            item_image = itemView.findViewById(R.id.item_image);
        }
    }
}
