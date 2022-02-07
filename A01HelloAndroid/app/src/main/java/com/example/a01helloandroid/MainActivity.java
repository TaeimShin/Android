package com.example.a01helloandroid;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNate = findViewById(R.id.btnNate);

        btnNate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "잠시후 네이트로 이동합니다.",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://nate.com"));
                startActivity(intent);
            }
        });

        editText = findViewById(R.id.editText);
        Button btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(listener);

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(listener);

    }////end of onCreate()


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            if(v.getId()==R.id.btnCall){
                String callNumber = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:"+callNumber));
                startActivity(intent);
            }
            else if(v.getId()==R.id.btnNext){
                Intent intent = new Intent(v.getContext(), SubActivity.class);
                startActivity(intent);
            }
        }

    };

    public void myBtnClick(View view){
        Toast.makeText(view.getContext(),
                "onClick속성을 이용한 버튼입니다 짧아요",
                Toast.LENGTH_SHORT).show();
    }
}////end of MainActivity