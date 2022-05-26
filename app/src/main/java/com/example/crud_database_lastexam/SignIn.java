package com.example.crud_database_lastexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private Button btnSignin;
    private TextView txtEmail, txtPassword;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnSignin = findViewById(R.id.btnRegister);
        txtEmail = findViewById(R.id.txtSigninEmail);
        txtPassword = findViewById(R.id.txtSigninPassword);
        mAuth = FirebaseAuth.getInstance();

        btnSignin.setOnClickListener(v -> {
            checkSignIn();
        });
    }

    private void checkSignIn() {
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        if(email.isEmpty()) {
            txtEmail.setError("Email không được rỗng !");
            txtEmail.requestFocus();
        }
        else if(password.isEmpty()) {
            txtPassword.setError("Mật khẩu không được rỗng !");
            txtPassword.requestFocus();
        }
        else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(SignIn.this, "Đăng nhập thành công !", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignIn.this, ListMainScreen.class));
                    }
                    else {
                        Toast.makeText(SignIn.this, "Error: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}