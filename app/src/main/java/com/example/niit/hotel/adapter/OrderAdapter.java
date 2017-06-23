package com.example.niit.hotel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.niit.hotel.R;
import com.example.niit.hotel.db.OrderInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyejun on 2017/6/22.
 */

public class OrderAdapter extends BaseAdapter {

    private Context context;
    private List<OrderInfo> list = new ArrayList<OrderInfo>();

    public OrderAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<OrderInfo> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_order, null);
            holder.tv_order_city = (TextView) view.findViewById(R.id.tv_order_city);
            holder.tv_order_inTime = (TextView) view.findViewById(R.id.tv_order_inTime);
            holder.tv_order_outTime = (TextView) view.findViewById(R.id.tv_order_outTime);
            holder.tv_order_addr = (TextView) view.findViewById(R.id.tv_order_addr);
            holder.tv_order_price = (TextView) view.findViewById(R.id.tv_order_price);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        OrderInfo info=list.get(i);
        holder.tv_order_city.setText("城市："+info.getCity());
        holder.tv_order_inTime.setText("入住时间："+info.getInTime());
        holder.tv_order_outTime.setText("离开时间："+info.getOutTime());
        holder.tv_order_addr.setText("关键字/地点："+info.getAddr());
        holder.tv_order_price.setText("价格："+info.getPrice());
        return view;
    }

    class ViewHolder {
        private TextView tv_order_city;
        private TextView tv_order_inTime;
        private TextView tv_order_outTime;
        private TextView tv_order_addr;
        private TextView tv_order_price;
    }
}
