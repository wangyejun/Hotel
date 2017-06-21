package com.example.niit.hotel.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.niit.hotel.R;
import com.example.niit.hotel.model.MyUser;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    /*声明控件对象*/
    private EditText et_register_name;
    private EditText et_register_pwd1;
    private EditText et_register_pwd2;

    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (Build.VERSION.SDK_INT>=21){
            View devorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            devorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        intView();
    }

    private void intView() {
        /*控件id对应*/
        et_register_name = (EditText) findViewById(R.id.et_register_name);
        et_register_pwd1 = (EditText) findViewById(R.id.et_register_pwd);
        et_register_pwd2 = (EditText) findViewById(R.id.et_register_pwd2);
        btn_register = (Button) findViewById(R.id.btn_register);

        //控件点击监听
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击注册后调用submit中所写的内容
            case R.id.btn_register:
                submit();
                break;
        }
    }

    private void submit() {
        final String name = et_register_name.getText().toString();
        final String pwd1 = et_register_pwd1.getText().toString();
        final String pwd2 = et_register_pwd2.getText().toString();

        //对输入框进行判断，isEmpty是判断输入框是否有字符存在
        if (name.isEmpty()&& pwd1.isEmpty()) {
            Toast.makeText(this, "密码或账号不能为空", Toast.LENGTH_SHORT).show();
        }else if (name.isEmpty()){
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
        }else if (pwd1.isEmpty()){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
        }else if (pwd2.isEmpty()){
            Toast.makeText(this,"请确认密码",Toast.LENGTH_SHORT).show();
        }

        //使用BmobUser类进行注册
        BmobUser user = new BmobUser();
        user.setUsername(name);
        user.setPassword(pwd1);
        
        user.signUp(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser,BmobException e) {
                if (e == null && pwd1 == pwd2){
                    //signup方法进行注册并且需要两次密码输入相同的情况下提示注册成功并跳转到登录界面
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    finish();
                }
            }
        });
    }

}
