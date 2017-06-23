package com.example.niit.hotel.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.niit.hotel.R;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView paymentback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getWindow().setStatusBarColor(getResources().getColor(R.color.login));
        initView();
    }
    private void initView(){
        paymentback = (ImageView) findViewById(R.id.payment_back);
        paymentback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.payment_back:
                finish();
                break;
        }
    }
}
