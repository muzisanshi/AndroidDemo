package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.adapter.PagerViewAdapter;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager pagerView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        pagerView = findViewById(R.id.pagerView);

        PagerViewAdapter adapter = new PagerViewAdapter(this);
        pagerView.setAdapter(adapter);
    }
}