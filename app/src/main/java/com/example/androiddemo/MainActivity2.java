package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv = findViewById(R.id.appname);
        tv.setText(R.string.user_name);
    }

    public void onRestart(){
        super.onRestart();
        Log.d("MainActivity2","onRestart");
    }

    public void onStart(){
        super.onStart();
        Log.d("MainActivity2","onStart");
    }

    public void onResume(){
        super.onResume();
        Log.d("MainActivity2","onResume");
    }

    public void onPause(){
        super.onPause();
        Log.d("MainActivity2","onPause");
    }

    public void onStop(){
        super.onStop();
        Log.d("MainActivity2","onStop");
    }
}