package com.example.labux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.labux.databinding.ActivityItemsDetailBinding;

public class ItemsDetailActivity extends AppCompatActivity {

    ActivityItemsDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityItemsDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null)
        {
            String item_detail_name = intent.getStringExtra("item_detail_name");
            int item_detail_desc = intent.getIntExtra("item_detail_desc", R.string.little_mouse_desc);
            int item_detail_detail_desc = intent.getIntExtra("item_detail_detail_desc", R.string.little_mouse_detail_desc);
            int item_detail_image = intent.getIntExtra("item_detail_image", R.drawable.little_mouse);

            binding.itemDetailName.setText(item_detail_name);
            binding.itemDetailDesc.setText(item_detail_desc);
            binding.itemDetailDetailDesc.setText(item_detail_detail_desc);
            binding.itemDetailImage.setImageResource(item_detail_image);
        }
    }
}