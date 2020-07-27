package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.model.SerializeClass;

public class SerializeActivity extends AppCompatActivity {
    private TextView tv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialize);
        tv = findViewById(R.id.serial);
        SerializeClass serialObj = (SerializeClass) getIntent().getSerializableExtra("serial");
        tv.setText(serialObj.getName());
    }
}