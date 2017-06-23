package com.example.niit.hotel.activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.niit.hotel.R;
import com.example.niit.hotel.adapter.OrderAdapter;
import com.example.niit.hotel.db.OrderInfo;
import com.example.niit.hotel.fragment.MyFragment;

import org.litepal.crud.DataSupport;

import java.util.List;


public class IndentActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView indentback;

    private ListView lv_order;
    private OrderAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent);
        initView();

        adapter = new OrderAdapter(IndentActivity.this);
        lv_order.setAdapter(adapter);

        getWindow().setStatusBarColor(getResources().getColor(R.color.login));


        final List<OrderInfo> list = DataSupport.findAll(OrderInfo.class);
        Log.e("list", list.size() + "\t" + list.toString());
        adapter.setData(list);

        lv_order.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (DataSupport.deleteAll(OrderInfo.class, "city=?",
                        DataSupport.findAll(OrderInfo.class).get(i).getCity()) > 0) {
                    adapter.setData( DataSupport.findAll(OrderInfo.class));
                    return true;
                }
                return false;
            }
        });


    }

    private void initView() {
        indentback = (ImageView) findViewById(R.id.indent_back);
        lv_order = (ListView) findViewById(R.id.lv_order);
        indentback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.indent_back:
                setResult(0);
                finish();
                break;
        }
    }
}
