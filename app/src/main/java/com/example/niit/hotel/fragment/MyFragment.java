package com.example.niit.hotel.fragment;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.niit.hotel.R;
import com.example.niit.hotel.activity.CommentActivity;
import com.example.niit.hotel.activity.IndentActivity;
import com.example.niit.hotel.activity.PaymentActivity;
import com.example.niit.hotel.activity.TripActivity;

public class MyFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView(){
        radioGroup = (RadioGroup) getActivity().findViewById(R.id.radiogroup);

        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup,int i) {
        switch (i){
            case R.id.indent:
//                startActivity(new Intent(getActivity(), IndentActivity.class));
                startActivityForResult(new Intent(getContext(),IndentActivity.class),0);
                break;
            case R.id.payment:
                startActivity(new Intent(getActivity(),PaymentActivity.class));
                break;
            case R.id.trip:
                startActivity(new Intent(getActivity(), TripActivity.class));
                break;
            case R.id.comment:
                startActivity(new Intent(getActivity(), CommentActivity.class));
                break;
        }

    }

}
