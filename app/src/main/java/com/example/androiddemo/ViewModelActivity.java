package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.ArraySet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.androiddemo.databinding.ActivityViewModelBinding;
import com.example.viewmodel.DemoViewModel;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class ViewModelActivity extends AppCompatActivity {
    private DemoViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_model);
        ActivityViewModelBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_view_model);
        vm = ViewModelProviders.of(this).get(DemoViewModel.class);
        vm.init(this,binding);
        binding.setViewModel(vm);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Log.d("----vma----",sdf.format(new Date()));
        HashSet<Object> set = new HashSet<>();

//        final Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("----vma----","I'm thread t1");
//            }
//        });
//        t1.start();
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Log.d("----vma----","I'm thread t");
//            }
//        });
//        t.start();

        // 模拟两个线程对一个数据进行写操作,第三个线程进行读操作
//        final ThreadSyncDemo tsd = new ThreadSyncDemo();
//        Thread add = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final int[] i = {0};
//                final Timer timer = new Timer();
//                TimerTask tt = new TimerTask(){
//                    @Override
//                    public void run() {
//                        i[0]++;
//                        if(i[0] > 10){
//                            timer.cancel();
//                        }else{
//                            tsd.setCount(tsd.getCount() + 1);
//                            Log.d("----vma----add",String.valueOf(tsd.getCount()));
//                        }
//                    }
//                };
//                timer.schedule(tt,0,1000);
//            }
//        });
//        Thread minus = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final int[] i = {0};
//                final Timer timer = new Timer();
//                TimerTask tt = new TimerTask(){
//                    @Override
//                    public void run() {
//                        i[0]++;
//                        if(i[0] > 10){
//                            timer.cancel();
//                        }else{
//                            tsd.setCount(tsd.getCount() - 2);
//                            Log.d("----vma----minus",String.valueOf(tsd.getCount()));
//                        }
//                    }
//                };
//                timer.schedule(tt,0,3000);
//            }
//        });
//        add.start();
//        minus.start();

    }

    class ThreadSyncDemo{
        int count = 0;

        public synchronized void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }

}