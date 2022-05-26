package com.example.crud_database_lastexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin, btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnSigninFirstScreen);
        btnRegister = findViewById(R.id.btnRegisterFirstScreen);

        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SignIn.class));
        });

        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Register.class));
        });

    }
}