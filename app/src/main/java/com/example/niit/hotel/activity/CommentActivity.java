package com.example.niit.hotel.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.niit.hotel.R;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView commentback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
    }

    private void initView(){
        commentback = (ImageView) findViewById(R.id.comment_back);
        commentback.setOnClickListener(this);
        getWindow().setStatusBarColor(getResources().getColor(R.color.login));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.comment_back:
                finish();
                break;
        }
    }
}
