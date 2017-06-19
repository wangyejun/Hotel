package com.example.niit.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.niit.hotel.fragment.JourneyFragment;
import com.example.niit.hotel.fragment.MyFragment;
import com.example.niit.hotel.fragment.ReserveFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    /*声明控件是对象*/
    private RadioGroup radioGroup;

    ReserveFragment reserveFragment = new ReserveFragment();
    JourneyFragment journeyFragment = new JourneyFragment();
    MyFragment myFragment = new MyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intitView();
        initEvent();
    }

    private void intitView(){
        /*对控件进行监听*/
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        radioGroup.check(R.id.rb_reserve);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,reserveFragment).commit();
    }
    private void initEvent(){
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup,int i) {
        //点击控件后进行fragment之间的切换
        switch (i){
            case R.id.rb_reserve:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,reserveFragment).commit();
                break;
            case R.id.rb_journey:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,journeyFragment).commit();
                break;
            case R.id.rb_my:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,myFragment).commit();
        }
    }
}
