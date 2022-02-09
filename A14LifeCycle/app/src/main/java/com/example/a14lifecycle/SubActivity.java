package com.example.a14lifecycle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
Activity 의 lIFECYCLE메서드
    :액티비티가 실행되면 아래순서대로 메서드가 실행된다.
    ONCREATE() -> onstart() -> onresume()
    액티비티가 종료되면
    onPause() -> onstop() -> ondestroy()

    안드로이드에서 수명주기 메서드는 앱이 비정상적으로 종료되는
    시점의 상태를 저장하거나, 맵이 실행될때 자동으로 실행하고자 하는
    경우 사용한다.
 */
public class SubActivity extends AppCompatActivity {

    private static final String TAG = "KOSMO123";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Log.d(TAG, "onCreate: 서브액티비티 시작됨");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void subBtnClicked(View view){
        Log.d(TAG, "subBtnClicked: 서브액티비티 종료버튼 클릭");
        finish();
    }
}
