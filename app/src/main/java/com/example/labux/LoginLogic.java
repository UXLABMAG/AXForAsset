package com.example.labux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        if (validateInput(username, password)) {
            globalUsername = username;
            globalPassword = password;
            Toast.makeText(LoginLogic.this, "Login successful!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginLogic.this, DetailLogic.class);
            startActivity(intent);
        }
    }

    private boolean validateInput(String username, String password) {
        boolean isValid = false;
        textViewUsernameError.setVisibility(View.GONE);
        textViewPasswordError.setVisibility(View.GONE);
        if (username.isEmpty()) {
            textViewUsernameError.setText("text ga boleh kosong");
            textViewUsernameError.setVisibility(View.VISIBLE);
            isValid = false;
        }else if(username.length() < 8){
            textViewUsernameError.setText("text harus lebih dari 8 karakter");
            textViewUsernameError.setVisibility(View.VISIBLE);
            isValid = false;
        }
        else if (username.equals("akun12345678")) {
            textViewUsernameError.setVisibility(View.GONE);
            isValid = true;
        }else {
            textViewUsernameError.setText("Ada yang salah dengan username-mu!");
            textViewUsernameError.setVisibility(View.VISIBLE);
            isValid = false;
        }

        if (password.isEmpty()) {
            textViewPasswordError.setText("text ga boleh kosong");
            textViewPasswordError.setVisibility(View.VISIBLE);
            isValid = false;
        }else if(password.length() < 8){
            textViewPasswordError.setText("text harus lebih dari 8 karakter");
            textViewPasswordError.setVisibility(View.VISIBLE);
            isValid = false;
        }
        else if (password.equals("password123")) {
            textViewPasswordError.setVisibility(View.GONE);
            isValid = true;
        }else{
            textViewPasswordError.setText("Ada yang salah dengan passwordmu!");
            textViewPasswordError.setVisibility(View.VISIBLE);
            isValid = false;
        }
        return isValid;
    }


}
