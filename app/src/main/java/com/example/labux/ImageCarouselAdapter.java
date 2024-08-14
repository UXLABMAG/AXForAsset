package com.example.labux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageCarouselAdapter extends RecyclerView.Adapter<ImageCarouselAdapter.CarouselViewHolder> {

    private Context context;
    private List<Integer> imageList;

    public ImageCarouselAdapter(Context context, List<Integer> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_trending_search, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        int currentItem = imageList.get(position);
        holder.imageView.setImageResource(currentItem);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class CarouselViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.trendingImage); // Reusing the existing ImageView
        }
    }
}
