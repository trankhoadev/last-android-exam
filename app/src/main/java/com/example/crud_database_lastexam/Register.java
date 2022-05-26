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

public class Register extends AppCompatActivity {
    private Button btnReg;
    private TextView txtEmail, txtPassword, txtRepassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnReg = findViewById(R.id.btnRegister);
        txtEmail = findViewById(R.id.txtRegEmail);
        txtPassword = findViewById(R.id.txtRegPassword);
        txtRepassword = findViewById(R.id.txtRegRepassword);

        mAuth = FirebaseAuth.getInstance();

        btnReg.setOnClickListener(v -> {
            checkRegister();
        });
    }

    private void checkRegister() {
        String email =  txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        String rePassword = txtRepassword.getText().toString();

        if(email.isEmpty()) {
            txtEmail.setError("Email không được rỗng !");
            txtEmail.requestFocus();
        }
        else if(password.isEmpty()){
            txtPassword.setError("Password không được rỗng !");
            txtPassword.requestFocus();
        }
        else if(rePassword.isEmpty()) {
            txtRepassword.setError("Repassword không được rỗng !");
        }
        else if(!password.equals(rePassword)) {
            txtRepassword.setError("Mật khẩu nhập lại không đúng !");
            txtRepassword.requestFocus();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(Register.this, "Đăng kí thành công, vui lòng đăng nhập lại !", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, SignIn.class));
                    }
                    else {
                        Toast.makeText(Register.this, "Error: " + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}