package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androiddemo.R;
import com.service.MyService;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    MyReciever mr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Button start = findViewById(R.id.start);
        start.setOnClickListener(this);
        Button stop = findViewById(R.id.stop);
        stop.setOnClickListener(this);
        tv = findViewById(R.id.count);

        IntentFilter inf = new IntentFilter("counter");
        mr = new MyReciever();
        this.registerReceiver(mr,inf);
    }

    class MyReciever extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int count = intent.getIntExtra("count",0);
            tv.setText(String.valueOf(count));
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.start:
                Intent i = new Intent(ServiceActivity.this, MyService.class);
                startService(i);
                break;
            case R.id.stop:
                Intent s = new Intent(ServiceActivity.this, MyService.class);
                stopService(s);
                break;
            default:
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        this.unregisterReceiver(mr);
    }
}