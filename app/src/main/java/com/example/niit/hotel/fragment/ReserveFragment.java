package com.example.niit.hotel.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niit.hotel.R;
import com.example.niit.hotel.activity.CalendarViewActivity;
import com.example.niit.hotel.activity.CalendarViewTwoActivity;
import com.example.niit.hotel.activity.CityActivity;
import com.example.niit.hotel.activity.PriceActivity;
import com.example.niit.hotel.activity.SiteActivity;
import com.example.niit.hotel.db.OrderInfo;

public class ReserveFragment extends Fragment implements View.OnClickListener {
    private RelativeLayout checkin;
    private RelativeLayout city;
    private RelativeLayout likaijiudian;
    private RelativeLayout site;
    private RelativeLayout rprice;
    private TextView textView;
    private TextView tv_toponymy;
    private TextView tv_rili;
    private TextView tv_rililikai;
    private TextView tv_price;
    private Button btn_uploading;

    private String cityName="";
    private String inTime="";
    private String outTime="";
    private String addr="";
    private String price="";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reserve, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        checkin = (RelativeLayout) getActivity().findViewById(R.id.ruzhujiudian);
        likaijiudian  = (RelativeLayout) getActivity().findViewById(R.id.likaijiudian);
        city = (RelativeLayout) getActivity().findViewById(R.id.city);
        site = (RelativeLayout) getActivity().findViewById(R.id.site);
        rprice = (RelativeLayout) getActivity().findViewById(R.id.price);
        textView = (TextView) getActivity().findViewById(R.id.show);
        tv_toponymy = (TextView) getActivity().findViewById(R.id.tv_toponymy);
        tv_rili= (TextView) getActivity().findViewById(R.id.tv_rili);
        tv_rililikai = (TextView) getActivity().findViewById(R.id.tv_rililikai);
        tv_price = (TextView) getActivity().findViewById(R.id.tv_price);
        btn_uploading= (Button) getActivity().findViewById(R.id.btn_uploading);

        btn_uploading.setOnClickListener(this);
        checkin.setOnClickListener(this);
        likaijiudian.setOnClickListener(this);
        city.setOnClickListener(this);
        site.setOnClickListener(this);
        rprice.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ruzhujiudian:
                startActivityForResult(new Intent(getActivity(), CalendarViewActivity.class), 0);
                break;
            case R.id.city:
                startActivityForResult(new Intent(getActivity(), CityActivity.class), 1);
                break;
            case R.id.site:
                startActivityForResult(new Intent(getActivity(), SiteActivity.class), 2);
                break;
            case R.id.likaijiudian:
                startActivityForResult(new Intent(getActivity(), CalendarViewTwoActivity.class), 3);
                break;
            case R.id.price:
                startActivityForResult(new Intent(getActivity(), PriceActivity.class), 4);
                break;
            case R.id.btn_uploading:
                Toast.makeText(getActivity(),"成功提交订单，可在我的订单中查看",Toast.LENGTH_SHORT).show();
                OrderInfo info=new OrderInfo(cityName,inTime,outTime,addr,price);
                info.save();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            cityName = data.getStringExtra("city");
            textView.setText(cityName);
        } else if (resultCode == 0) {
            inTime=data.getStringExtra("rili");
            tv_rili.setText(inTime);
        } else if (requestCode == 2){
            addr = data.getStringExtra("site");
            tv_toponymy.setText(addr);
        }else if (requestCode == 4){
            price = data.getStringExtra("price");
            tv_price.setText(price);
        }else if (requestCode == 3){
            outTime = data.getStringExtra("likairili");
            tv_rililikai.setText(outTime);
        }
    }
}
