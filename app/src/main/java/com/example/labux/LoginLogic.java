package com.example.labux;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginLogic extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView textViewUsernameError;
    private TextView textViewPasswordError;
    private Button buttonLogin;

    // Variabel global untuk menyimpan username dan password
    private String globalUsername;
    private String globalPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Referensi view dari layout XML
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewUsernameError = findViewById(R.id.textViewUsernameError);
        textViewPasswordError = findViewById(R.id.textViewPasswordError);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Set onClickListener untuk tombol login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        // Ambil input dari pengguna
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        // Validasi input pengguna
        if (validateInput(username, password)) {
            // Simpan data ke dalam variabel global
            globalUsername = username;
            globalPassword = password;

            // Lakukan proses login (misalnya, autentikasi ke server)
            // Untuk sekarang, kita hanya menampilkan pesan sukses
            Toast.makeText(LoginLogic.this, "Login successful!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validateInput(String username, String password) {
        boolean isValid = true;

        // Reset pesan kesalahan
        textViewUsernameError.setVisibility(View.GONE);
        textViewPasswordError.setVisibility(View.GONE);

        // Validasi username
        if (username.isEmpty()) {
            textViewUsernameError.setVisibility(View.VISIBLE);
            isValid = false;
        }

        // Validasi password
        if (password.length() < 8) {
            textViewPasswordError.setVisibility(View.VISIBLE);
            isValid = false;
        }

        return isValid;
    }
}
