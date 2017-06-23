package com.example.niit.hotel.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.niit.hotel.R;

public class TripActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView tripback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
        getWindow().setStatusBarColor(getResources().getColor(R.color.login));
        initView();
    }
    private void initView(){
        tripback = (ImageView) findViewById(R.id.trip_back);
        tripback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.trip_back:
                finish();
                break;
        }
    }
}
