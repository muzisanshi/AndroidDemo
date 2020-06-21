package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.androiddemo.MainActivity3;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    int age = 0;
    Button button = null;
    TextView tv = null;

    public void add(int diff){
        age += diff;
        Log.d("----age+diff----",String.valueOf(age));
        age += 10;
        age *= 2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null && savedInstanceState.containsKey("age")){
            age = (int)savedInstanceState.get("age") + 30;
            Log.d("----log----",String.valueOf(age));
        }

        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.appname);
        tv.setText(R.string.user_name);
        add(30);

        button = findViewById(R.id.nav);
        button.setOnClickListener(this);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data != null && data.getStringExtra("msg") != null) {
            tv.setText(data.getStringExtra("msg"));
        }
    }

    public void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);
        state.putInt("age",age);
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

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.nav:
//                Intent i = new Intent(MainActivity2.this,MainActivity3.class);
//                startActivity(i);
                Intent i = new Intent("com.example.androiddemo.mainactivity3");
                i.putExtra("name","lilei");
                i.putExtra("age",31);
//                startActivity(i);
//                startActivityForResult(99,i);
                startActivityForResult(i,99);
                break;
            default:
        }
    }
}