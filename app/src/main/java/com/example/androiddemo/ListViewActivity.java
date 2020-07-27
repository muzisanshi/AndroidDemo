package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ListView;

import com.example.adapter.ListViewAdapter;
import com.example.model.ListData;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ListView vlist = null;
    private ListData<String> list = null;
    private ListViewAdapter adapter = null;
    private Handler handler = null;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        handler = new Handler();
        vlist = findViewById(R.id.vlist);
        ArrayList<String> arr = new ArrayList<String>();
        for(int i = 0;i < 40;i++){
            arr.add("列表项" + i);
        }
        list = new ListData<String>(arr);
        adapter = new ListViewAdapter(list,this);
        vlist.setAdapter(adapter);
        Runnable run = new Runnable() {
            @Override
            public void run() {
                adapter.add();
                count ++;
                Log.d("--------log--------","" + count);
                if(count > 5) {
                    Log.d("--------log--------","remove");
                    handler.removeCallbacks(this);
                }
            }
        };
        handler.postDelayed(run,3000);
        handler.postDelayed(run,6000);
    }
}