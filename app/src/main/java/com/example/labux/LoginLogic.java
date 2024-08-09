package com.example.labux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

//        Remove Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

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
//            globalUsername = username;
//            globalPassword = password;
            Toast.makeText(LoginLogic.this, "Login successful!", Toast.LENGTH_SHORT).show();
            //            ini scrip buat pindahan ke halaman detail
            User user = new User(username);
            MainActivity.setUser(user);

            Intent intent = new Intent(LoginLogic.this, ProfileActivity.class);


            startActivity(intent);
            finish();
        }
    }

    private boolean validateInput(String username, String password) {
        boolean isValid = true;
        textViewUsernameError.setVisibility(View.GONE);
        textViewPasswordError.setVisibility(View.GONE);
        if (username.isEmpty()) {
            textViewUsernameError.setText("Username must be filled in!");
            textViewUsernameError.setVisibility(View.VISIBLE);
            isValid = false;
        }
//        else if(username.length() < 8){
//            textViewUsernameError.setText("text harus lebih dari 8 karakter");
//            textViewUsernameError.setVisibility(View.VISIBLE);
//            isValid = false;
//        }
//        else if (username.equals("akun12345678")) {
//            textViewUsernameError.setVisibility(View.GONE);
//            isValid = true;
//        }else {
//            textViewUsernameError.setText("Ada yang salah dengan username-mu!");
//            textViewUsernameError.setVisibility(View.VISIBLE);
//            isValid = false;
//        }

        if (password.isEmpty()) {
            textViewPasswordError.setText("Password must be filled in!");
            textViewPasswordError.setVisibility(View.VISIBLE);
            isValid = false;
        }else if(password.length() < 8){
            textViewPasswordError.setText("Password length must be at least 8 characters!");
            textViewPasswordError.setVisibility(View.VISIBLE);
            isValid = false;
        }
//        else if (password.equals("password123")) {
//            textViewPasswordError.setVisibility(View.GONE);
//            isValid = true;
//        }else{
//            textViewPasswordError.setText("Ada yang salah dengan passwordmu!");
//            textViewPasswordError.setVisibility(View.VISIBLE);
//            isValid = false;
//        }
        return isValid;
    }


}
