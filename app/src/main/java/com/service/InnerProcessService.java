package com.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.example.service.IMyAidlInterface;

/**
 * 作者：lilei
 * 日期： 2021/6/23 13:58
 */
public class InnerProcessService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends IMyAidlInterface.Stub {
        @Override
        public String getName() {
            return "我来自火星";
        }
    }
}
