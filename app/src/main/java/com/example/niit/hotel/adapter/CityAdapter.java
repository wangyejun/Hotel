package com.example.niit.hotel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.niit.hotel.entity.Cityentity;

import java.util.List;

/**
 * Created by wangyejun on 2017/6/22.
 */

public class CityAdapter extends BaseAdapter {
    private List<Cityentity> data;
    private LayoutInflater inflater;
    private Context context;

    public CityAdapter(List<Cityentity>data, Context context){
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
