package com.example.niit.hotel.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.niit.hotel.MainActivity;
import com.example.niit.hotel.R;

public class CalendarViewTwoActivity extends AppCompatActivity {
    private Context context;
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view_two);
        getWindow().setStatusBarColor(getResources().getColor(R.color.login));

        context = this;

        calendarView = (CalendarView) findViewById(R.id.calendarviewtwo);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String content = year + "-" + (month + 1) + "-" + dayOfMonth;

                Intent intent = new Intent(CalendarViewTwoActivity.this, MainActivity.class);
                intent.putExtra("likairili", content);
                setResult(3, intent);



                Toast.makeText(context, "你选择了:\n" + content, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
