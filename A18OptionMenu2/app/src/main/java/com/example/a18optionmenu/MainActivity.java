package com.example.a18optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout layout;
    private ImageView imageView;

    private float rotation;
    private float scaleXY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (RelativeLayout) findViewById(R.id.layout);
        imageView = (ImageView) findViewById(R.id.imageview);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.optmenu_1:
                Toast.makeText(this,"메뉴선택1",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.optmenu_2:
                Toast.makeText(this,"메뉴선택2",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.optmenu_3:
                Toast.makeText(this,"메뉴선택3",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.bg_red:
                layout.setBackgroundColor(Color.RED);
                break;
            case R.id.bg_green:
                layout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.bg_blue:
                layout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.image_rotation:
                if(rotation==360) rotation = 0;
                rotation += 90;
                imageView.setRotation(rotation);
                break;
            case R.id.image_scale_inc:
                if(scaleXY!=5) scaleXY +=2;
                imageView.setScaleX(scaleXY);
                imageView.setScaleY(scaleXY); //2배씩 확대
                break;
            case R.id.image_scale_desc:
                if(scaleXY >1) scaleXY -=2;
                imageView.setScaleX(scaleXY);
                imageView.setScaleY(scaleXY); //2배씩 축소
                break;
         }
         return super.onOptionsItemSelected(item);
    }
}