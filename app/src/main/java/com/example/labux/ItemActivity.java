package com.example.labux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ItemActivity extends MainActivity {

    RecyclerView recyclerView;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        int[] items_image = {R.drawable.little_mouse,
                R.drawable.jumping_tribal_mask,
                R.drawable.falling_alien,
                R.drawable.red_hooded_ghost,
                R.drawable.frustrated_block};

        int[] items_desc = {R.string.little_mouse_desc,
                R.string.jumping_tribal_mask_desc,
                R.string.falling_alien_desc,
                R.string.red_hooded_ghost_desc,
                R.string.frustrated_block_desc};

        int[] items_detail_desc = {R.string.little_mouse_detail_desc,
                R.string.jumping_tribal_mask_detail_desc,
                R.string.falling_alien_detail_desc,
                R.string.red_hooded_ghost_detail_desc,
                R.string.frustrated_block_detail_desc};

        int[] items_name = {R.string.little_mouse_name,
                R.string.jumping_tribal_mask_name,
                R.string.falling_alien_name,
                R.string.red_hooded_ghost_name,
                R.string.frustrated_block_name};

        for (int i = 0; i < items_image.length; i++)
        {
            new Item(items_name[i], items_desc[i], items_detail_desc[i], items_image[i]);
        }

        recyclerView = findViewById(R.id.recycler_view);
        itemAdapter = new ItemAdapter();

        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    }
}