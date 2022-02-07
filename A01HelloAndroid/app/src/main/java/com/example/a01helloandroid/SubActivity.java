package com.example.a01helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button button = findViewById(R.id.btnBackMain);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        finish();
    }
}