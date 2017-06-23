package com.example.niit.hotel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.niit.hotel.MainActivity;
import com.example.niit.hotel.R;

import java.util.HashMap;
import java.util.Map;

public class CityActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        getWindow().setStatusBarColor(getResources().getColor(R.color.login));


        listView  = (ListView) findViewById(R.id.citylistview);

        final String[]city = {"南京","上海","北京","广州","深圳","浙江","苏州","杭州"};

        arrayAdapter = new ArrayAdapter<String>(CityActivity.this,android.R.layout.simple_list_item_1,city);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(CityActivity.this, MainActivity.class);
                intent.putExtra("city",city[i]);
                setResult(1,intent);
                finish();
            }
        });
    }

}
