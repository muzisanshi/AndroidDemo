package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.viewmodel.DemoViewModel;

public class ViewModelActivity extends AppCompatActivity {
    private DemoViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        vm = ViewModelProviders.of(this).get(DemoViewModel.class);
        vm.init(this);
        
    }
}