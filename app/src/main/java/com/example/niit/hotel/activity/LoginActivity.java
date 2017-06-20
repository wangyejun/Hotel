package com.example.niit.hotel.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.niit.hotel.MainActivity;
import com.example.niit.hotel.R;
import com.example.niit.hotel.Utils.CustomVideoView;
import com.example.niit.hotel.model.MyUser;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static android.text.TextUtils.isEmpty;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    /*声明控件是对象*/
    private EditText et_login_name;
    private EditText et_login_pwd;
    private Button btn_login;
    private Button btn_register;
    private CustomVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        /*控件id对应*/
        et_login_name  = (EditText) findViewById(R.id.et_login_name);
        et_login_pwd = (EditText) findViewById(R.id.et_login_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        //加载视频资源控件
        videoView = (CustomVideoView) findViewById(R.id.videoview);
        //设置播放加载路径
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));
        //播放
        videoView.start();
        //循环播放
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });

        //按键点击监听
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击登录按钮后对输入的用户名和密码进行比对正确则跳转到主界面错误则提示
            case R.id.btn_login:
                login();
                break;
            //点击注册按钮后跳转到注册界面
            case R.id.btn_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
                break;
        }
    }
    private void login(){
        String name = et_login_name.getText().toString();
        String pwd1 = et_login_pwd.getText().toString();
        //对输入框进行判断，isEmpty是判断输入框是否有字符存在
        if (name.isEmpty()&&pwd1.isEmpty()) {
            Toast.makeText(this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
        }else if (name.isEmpty()){
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
        }else if (pwd1.isEmpty()){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
        }

        //使用Bmob云进行登录
        BmobUser user = new BmobUser();
        user.setUsername(name);
        user.setPassword(pwd1);
        user.login(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if (e == null){
                    //提示登录成功并跳转到主界面
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                }else {
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //返回重启加载
    @Override
    protected void onRestart() {
        initView();
        super.onRestart();
    }

    //防止锁屏或者切出的时候，音乐在播放
    @Override
    protected void onStart() {
        videoView.stopPlayback();
        super.onStart();
    }
}
