package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.androiddemo.databinding.ActivityEventBusBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity {
    private ActivityEventBusBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_event_bus);
        EventBus.getDefault().register(this);
        binding.btn.setOnClickListener(v -> {
            EventBus.getDefault().post(new Object());
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Object obj){
        binding.tv.setText("已触发事件");
    }

    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}