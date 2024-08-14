package com.example.labux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    protected static User user;

    public static void setUser(User user) {
        MainActivity.user = user;
    }

    public static User getUser() {
        return user;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.menu_home:
                intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_items:
                intent = new Intent(this, ItemActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_profile:
                intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_logout:
                intent = new Intent(this, LoginLogic.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.secondary_color)));

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
            if(Item.items.size() >= 5)
            {
                break;
            }

            new Item(items_name[i], items_desc[i], items_detail_desc[i], items_image[i]);
        }
    }
}