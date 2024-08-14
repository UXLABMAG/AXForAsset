package com.example.labux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TrendingSearchAdapter extends RecyclerView.Adapter<TrendingSearchAdapter.TrendingViewHolder> {

    private List<TrendingItem> trendingItems;

    public TrendingSearchAdapter(List<TrendingItem> trendingItems) {
        this.trendingItems = trendingItems;
    }

    @NonNull
    @Override
    public TrendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trending_search, parent, false);
        return new TrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingViewHolder holder, int position) {
        TrendingItem currentItem = trendingItems.get(position);
        holder.trendingImage.setImageResource(currentItem.getImageResId());
        holder.trendingText.setText(currentItem.getText());
    }

    @Override
    public int getItemCount() {
        return trendingItems.size();
    }

    public static class TrendingViewHolder extends RecyclerView.ViewHolder {
        ImageView trendingImage;
        TextView trendingText;

        public TrendingViewHolder(@NonNull View itemView) {
            super(itemView);
            trendingImage = itemView.findViewById(R.id.trendingImage);
        }
    }
}
