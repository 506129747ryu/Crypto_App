package com.tutorial.cryptoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tutorial.cryptoapp.R;

public class IntroActivity extends AppCompatActivity {
    private ImageView goBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        initView();
        setVariable();

    }


    private void initView() {
        goBtn = findViewById(R.id.gobtn);

    }

    private void setVariable() {
        goBtn.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this, LoginActivity.class)));
    }
}