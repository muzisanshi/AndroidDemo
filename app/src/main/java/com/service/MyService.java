package com.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Thread th;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("----MyService----", "onCreate");
    }

    public void startCount(){
        Log.d("----MyService----","startCount");
        th = new Thread(){
            public void run(){
                int count = 0;
                while (count <= 60){
                    try {
                        Thread.sleep(1000);
                        Intent i = new Intent("counter");
                        i.putExtra("count",count);
                        sendBroadcast(i);
                        count++;
                        Log.d("----MyService----",String.valueOf(count));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        th.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("----MyService----", "onStartCommand");
        this.startCount();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("----MyService----", "onBind");
        return new MyBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("----MyService----", "onDestroy");
        th.interrupt();
    }

    public class MyBinder extends Binder {
        public MyService getService(){
            return MyService.this;
        }
    }
}
