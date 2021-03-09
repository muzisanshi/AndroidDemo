package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class AlgorithmActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView position;
    private Button search;

    private TextView sorted;
    private Button sort;

    private TextView inserted;
    private Button insert;

    private TextView shelled;
    private Button shell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);
        getSupportActionBar().setTitle("算法");
        initView();
    }

    public void initView(){
        position = findViewById(R.id.position);
        search = findViewById(R.id.search);
        search.setOnClickListener(this);

        sorted = findViewById(R.id.sorted);
        sort = findViewById(R.id.sort);
        sort.setOnClickListener(this);

        inserted = findViewById(R.id.inserted);
        insert = findViewById(R.id.insert);
        insert.setOnClickListener(this);

        shelled = findViewById(R.id.shelled);
        shell = findViewById(R.id.shell);
        shell.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search:
                int val = 13;
                int[] arr = {1,4,6,9,13,19,30,31,40};
                int posi = Algorithm.binarySearch(val,arr);
                position.setText("位置是:" + posi);
                break;
            case R.id.sort:
                int[] arr2 = {31,9,19,4,40,13,30,6,1};
                Algorithm.chooseSort(arr2);
                sorted.setText("排序后是:" + Arrays.toString(arr2));
                break;
            case R.id.insert:
                int[] arr3 = {31,9,19,4,40,13,30,6,1};
                Algorithm.insertSort(arr3);
                inserted.setText("排序后是:" + Arrays.toString(arr3));
                break;
            case R.id.shell:
                int[] arr4 = {31,9,19,4,40,13,30,6,1};
                Algorithm.shellSort(arr4);
                shelled.setText("排序后是:" + Arrays.toString(arr4));
                break;
        }
    }
}