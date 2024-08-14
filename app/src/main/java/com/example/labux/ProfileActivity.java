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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("Profile Page");

        Intent intent = getIntent();
//        User user = intent.getParcelableExtra("user");
        User user = MainActivity.getUser();

        TextView greetings = findViewById(R.id.greetings);
        greetings.setText("Hi, " + user.getUsername());

        TextView txt_email = findViewById(R.id.txt_email);
        txt_email.setText(user.getUsername() + "@gmail.com");
    }
}