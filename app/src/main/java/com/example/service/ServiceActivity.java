package com.example.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androiddemo.R;
import com.example.androiddemo.databinding.ActivityServiceBinding;
import com.service.InnerProcessService;
import com.service.MyService;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    MyReciever mr;
    ServiceConnection sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityServiceBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_service);

        binding.aidl.setOnClickListener(v -> {
            Intent i = new Intent("com.example.androiddemo.IMyAidlInterface");
            i.setPackage("com.example.androiddemo");
            bindService(i, new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    IMyAidlInterface s = IMyAidlInterface.Stub.asInterface(service);
                    try {
                        binding.count.setText(s.getName());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            },BIND_AUTO_CREATE);
        });

        Button start = findViewById(R.id.start);
        start.setOnClickListener(this);
        Button stop = findViewById(R.id.stop);
        stop.setOnClickListener(this);

        Button bind = findViewById(R.id.bind);
        bind.setOnClickListener(this);
        Button unbind = findViewById(R.id.unbind);
        unbind.setOnClickListener(this);
        tv = findViewById(R.id.count);

        sc = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d("----ServiceActivity----","onServiceConnected");
                MyService ms = ((MyService.MyBinder) iBinder).getService();
                ms.startCount();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d("----ServiceActivity----","onServiceDisconnected");

            }
        };

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
            case R.id.bind:
                Intent b = new Intent(ServiceActivity.this,MyService.class);
                bindService(b,sc,BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                Intent ub = new Intent(ServiceActivity.this, MyService.class);
                unbindService(sc);
                break;
            default:
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        this.unregisterReceiver(mr);
    }
}