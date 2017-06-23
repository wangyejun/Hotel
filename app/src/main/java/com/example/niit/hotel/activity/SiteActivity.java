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

public class SiteActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);
        getWindow().setStatusBarColor(getResources().getColor(R.color.login));

        listView = (ListView) findViewById(R.id.sitelistview);

        final String[]site = {"地铁站","旅游景点","生活区","商业区","高校附近","城区"};

        arrayAdapter = new ArrayAdapter<String>(SiteActivity.this,android.R.layout.simple_list_item_1,site);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SiteActivity.this, MainActivity.class);
                intent.putExtra("site",site[i]);
                setResult(2,intent);
                finish();
            }
        });
    }
}
