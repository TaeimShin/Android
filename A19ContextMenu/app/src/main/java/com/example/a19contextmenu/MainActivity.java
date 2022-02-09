package com.example.a19contextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private Button btnImageScale, btnBackground;
    private ImageView imageView;
    private LinearLayout layout;
    private float rotation, scaleXY=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBackground = (Button)findViewById(R.id.btn_background);
        btnImageScale = (Button)findViewById(R.id.btn_imagescale);
        imageView = (ImageView)findViewById(R.id.imageview);
        layout = (LinearLayout)findViewById(R.id.layout);


        registerForContextMenu(btnBackground);
        registerForContextMenu(btnImageScale);
        registerForContextMenu(layout);

        //버튼에 롱클릭 이벤트리스너 부착
        btnBackground.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                //배경색 변경 버튼을 롱클릭 할 경우 토스트를 띄워줌
                Toast toast = Toast.makeText(v.getContext(),
                        "버튼롱클릭됨",
                        Toast.LENGTH_SHORT);
                //토스트를 화면 중간에 뜨게 설정한다.
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                return false;
            }
        });
    }////onCreate메소드끝

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater = getMenuInflater();
        if(v.getId()==R.id.btn_background) {
            menu.setHeaderTitle("배경색 변경하기");
            menuInflater.inflate(R.menu.menu_background, menu);
        }
        else if(v.getId()==R.id.btn_imagescale) {
            menuInflater.inflate(R.menu.menu_imagescale, menu);
        }
        else {
            menuInflater.inflate(R.menu.menu_layout, menu);
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }////onCreateContextMenu메소드끝

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.item_red:
                layout.setBackgroundColor(Color.RED);
                break;

            case R.id.item_green:
                layout.setBackgroundColor(Color.GREEN);
                break;

            case R.id.item_blue:
                layout.setBackgroundColor(Color.BLUE);
                break;

            case R.id.rotate:
                if(rotation==360) rotation=0;
                rotation += 90;
                imageView.setRotation(rotation);
                break;

            case R.id.increase:
                if(scaleXY != 5) scaleXY += 2;
                imageView.setScaleX(scaleXY);
                imageView.setScaleY(scaleXY);
                break;

            case R.id.decrease:
                if(scaleXY > 1) scaleXY -= 2;
                imageView.setScaleX(scaleXY);
                imageView.setScaleY(scaleXY);
                break;

            case R.id.menu_layout:
                Toast.makeText(MainActivity.this,
                        "메인엑티비티용 컨텍스트 메뉴 눌러짐(XML)",
                        Toast.LENGTH_LONG).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
