package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.androiddemo.MainActivity3;
import com.example.model.SerializeClass;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    int age = 0;
    Button button = null;
    Button listView = null;
    Button listView2 = null;
    Button constraint = null;
    Button serialize = null;
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
        listView = findViewById(R.id.listView);
        listView.setOnClickListener(this);
        listView2 = findViewById(R.id.listView2);
        listView2.setOnClickListener(this);
        constraint = findViewById(R.id.constraint);
        constraint.setOnClickListener(this);
        serialize = findViewById(R.id.serialize);
        serialize.setOnClickListener(this);

        // 添加fragment
        FragmentManager fm = getSupportFragmentManager();
        Fragment fr = new MyFragment();
        Bundle bd = new Bundle();
        bd.putSerializable("serial",new SerializeClass());
        fr.setArguments(bd);
        fm.beginTransaction().add(R.id.container,fr).commit();
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
        Intent i = null;
        switch(view.getId()){
            case R.id.nav:
//                i = new Intent(MainActivity2.this,MainActivity3.class);
//                startActivity(i);
                i = new Intent("com.example.androiddemo.mainactivity3");
                i.putExtra("name","lilei");
                i.putExtra("age",31);
//                startActivity(i);
//                startActivityForResult(99,i);
                startActivityForResult(i,99);
                break;
            case R.id.listView:
                i = new Intent(MainActivity2.this,ListViewActivity.class);
                startActivity(i);
                break;
            case R.id.listView2:
                i = new Intent(MainActivity2.this,RecyclerViewActivity.class);
                startActivity(i);
                break;
            case R.id.constraint:
                i = new Intent(MainActivity2.this,ConstraintActivity.class);
                startActivity(i);
                break;
            case R.id.serialize:
                i = new Intent(MainActivity2.this,SerializeActivity.class);
                i.putExtra("serial",new SerializeClass());
                startActivity(i);
                break;
            default:
        }
    }
}