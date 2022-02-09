package com.example.a13animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.kakao_con);

        Button btnMove = (Button) findViewById(R.id.btn_move);
        Button btnScale = (Button) findViewById(R.id.btn_scale);
        Button btnAlpha = (Button) findViewById(R.id.btn_alpha);

        final Animation anim1 = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.move);
        final Animation anim2 = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.alpha);
        final Animation anim3 = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.size);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(anim1);
            }
        });
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(anim3);
            }
        });
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(anim2);
            }
        });

    }
}