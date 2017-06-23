package com.example.niit.hotel.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.niit.hotel.MainActivity;
import com.example.niit.hotel.R;

public class PriceActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        getWindow().setStatusBarColor(getResources().getColor(R.color.login));

        listView = (ListView) findViewById(R.id.pricelistview);

        final String[]pricr = {"168","188","268","288","368","388","468","488"};


        arrayAdapter = new ArrayAdapter<String>(PriceActivity.this,android.R.layout.simple_list_item_1,pricr);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent  = new Intent(PriceActivity.this, MainActivity.class);
                intent.putExtra("price",pricr[i]);
                setResult(4,intent);
                finish();
            }
        });

    }
}
