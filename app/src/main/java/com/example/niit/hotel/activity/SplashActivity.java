package com.example.niit.hotel.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.niit.hotel.MainActivity;
import com.example.niit.hotel.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class SplashActivity extends AppCompatActivity {
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };
    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //对Bmob进行初始化，需要在setContentView方法之前
        Bmob.initialize(this, "849af1025fcfccdd5cd728d8b8aa3ef7");
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        //获取当前用户信息，登录过一次后下一次登录无需登录
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if (bmobUser!=null){
            handler.postDelayed(runnable1,3000);
        }else {
            handler.postDelayed(runnable,3000);
        }
    }
}
