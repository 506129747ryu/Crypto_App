package com.tutorial.cryptoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorial.cryptoapp.R;

public class LoginActivity extends AppCompatActivity {
    private EditText userEdt, passEdt;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setVariable();
    }

    private void initView() {
        userEdt = findViewById(R.id.UserName);
        passEdt = findViewById(R.id.Password);
        loginBtn = findViewById(R.id.loginBtn);
    }

    private void setVariable(){
        loginBtn.setOnClickListener(view -> {
            if(userEdt.getText().toString().isEmpty() || passEdt.getText().toString().isEmpty()){
                Toast.makeText(LoginActivity.this, "Please fill the login form", Toast.LENGTH_SHORT).show();
            }else if(userEdt.getText().toString().equals("admin") && passEdt.getText().toString().equals("admin")){
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }else {
                Toast.makeText(LoginActivity.this, "Please correctly fill your Username and Password", Toast.LENGTH_SHORT).show();
            }
        });
    }



}