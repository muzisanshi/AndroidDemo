package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.adapter.RecyclerAdapter;
import com.example.model.ListData;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recycler = null;
    private ListData<String> list = null;
    private RecyclerAdapter adapter = null;
    private Handler handler = null;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        handler = new Handler();
        recycler = findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recycler.setLayoutManager(llm);
        ArrayList<String> arr = new ArrayList<String>();
        for(int i = 0;i < 40;i++){
            arr.add("列表项" + i);
        }
        list = new ListData<String>(arr);
        adapter = new RecyclerAdapter(list);
        recycler.setAdapter(adapter);

        Runnable run = new Runnable() {
            @Override
            public void run() {
                adapter.add("新增项" + String.valueOf(count));
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