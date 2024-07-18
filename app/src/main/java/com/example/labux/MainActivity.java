package com.example.labux;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mulai LoginLogic saat aplikasi dimulai
        Intent intent = new Intent(MainActivity.this, LoginLogic.class);
        startActivity(intent);

        // Tutup MainActivity agar pengguna tidak bisa kembali ke sini dengan menekan tombol kembali
        finish();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

}