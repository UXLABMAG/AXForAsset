package com.example.labux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.example.labux.ItemList;

import com.example.labux.databinding.ActivityItemsBinding;
import com.example.labux.databinding.ItemsListBinding;

import java.util.ArrayList;

public class ItemsActivity extends AppCompatActivity {

    ActivityItemsBinding binding;
    ListAdapter list_adapter;
    ArrayList<ItemList> item_array_list;
    ItemList items_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

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
        String[] items_name = {"Little Mouse",
                                "Jumping Tribal Mask",
                                "Falling Alien",
                                "Red Hooded Ghost",
                                "Frustrated Block"};

        for (int i = 0; i < items_image.length; i++)
        {
            items_list = new ItemList(items_name[i], items_desc[i], items_detail_desc[i], items_image[i]);
            item_array_list.add(items_list);
        }

        list_adapter = new ItemListAdapter(ItemsActivity.this, item_array_list);
        binding.itemsList.setAdapter(list_adapter);
        binding.itemsList.setClickable(true);

        binding.itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(ItemsActivity.this, ItemsDetailActivity.class);
                intent.putExtra("item_detail_name", items_name[i]);
                intent.putExtra("item_detail_desc", items_desc[i]);
                intent.putExtra("item_detail_detail_desc", items_detail_desc[i]);
                intent.putExtra("item_detail_image", items_image[i]);

                startActivity(intent);
            }
        });
    }
}