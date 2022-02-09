package com.kosmo.a20edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KOSMO";

    TextView textView1;

    EditText etId;
    EditText etPwd;
    EditText etYear;
    EditText etMonth;
    EditText etDay;

    String sId;
    String sPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);

        etId = findViewById(R.id.etId);
        etPwd = findViewById(R.id.etPwd);
        etYear = findViewById(R.id.etYear);
        etMonth = findViewById(R.id.etMonth);
        etDay = findViewById(R.id.etDay);
        //비밀번호 입력상자에 텍스트가 변경될때의 리스너를 부착한후 watcher를 연결한다.
        etPwd.addTextChangedListener(watcher);

    }

    TextWatcher watcher = new TextWatcher() {

        String beforeText;
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            beforeText = s.toString();
            Log.d(TAG, "beforeTextChanged :" + beforeText);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            byte[] bytes = null;
            try{
                bytes = s.toString().getBytes("8859_1");
                int strCount = bytes.length;
                textView1.setText(strCount +" / 8바이트");
            }
            catch(UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            String str = s.toString();
            Log.d(TAG,"afterTextChanged:"+str);
            try{
                byte[] strBytes = str.getBytes("8859_1");
                if(strBytes.length>8){
                    etPwd.setText(beforeText);
                    etPwd.setSelection(beforeText.length()-9,
                            beforeText.length()-1);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    };
    public void onKeydownClicked(View v){
        InputMethodManager mgr =
                (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

    public void onLoginClicked(View v){
        sId = etId.getText().toString();
        sPwd = etPwd.getText().toString();

        if(sId.length()<3){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("알림")
                    .setMessage("아이디를입력")
                    .setCancelable(false)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("닫기", null)
                    .show();
            etId.requestFocus();
            return;
        } else if(sPwd.length() < 5){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("알림")
                    .setMessage("비밀번호를 정확히 입력해주세요")
                    .setCancelable(false)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("닫기", null)
                    .show();
            etPwd.requestFocus();
            return;
        }
    }
}