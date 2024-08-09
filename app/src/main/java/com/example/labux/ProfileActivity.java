package com.example.labux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends MainActivity {

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.menu_home:
//                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.menu_items:
//                Toast.makeText(this, "Items", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.menu_profile:
//                Intent intent = new Intent(ProfileActivity.this, ItemActivity.class);
//                return true;
//
//            case R.id.menu_logout:
//                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
//        User user = intent.getParcelableExtra("user");
        User user = MainActivity.getUser();

        TextView greetings = findViewById(R.id.greetings);
        greetings.setText("Hi, " + user.getUsername());

        TextView txt_email = findViewById(R.id.txt_email);
        txt_email.setText(user.getUsername() + "@gmail.com");
    }
}