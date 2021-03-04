package com.example.androiddemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.example.androiddemo.MainActivity3;
import com.example.model.SerializeClass;
import com.example.service.ServiceActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    int age = 0;
    Button button = null;
    Button listView = null;
    Button listView2 = null;
    Button constraint = null;
    Button serialize = null;
    Button pager = null;
    Button dialog = null;
    Button sqlite = null;
    Button intent = null;
    Button service = null;
    Button viewModel = null;
    Button algorithm = null;
    Button annotation = null;
    TextView tv = null;
    private Bundle state;

    public void add(int diff){
        age += diff;
        Log.d("----age+diff----",String.valueOf(age));
        age += 10;
        age *= 2;
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("---MainActivity2----","onCreate");
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
        pager = findViewById(R.id.pager);
        pager.setOnClickListener(this);
        dialog = findViewById(R.id.dialog);
        dialog.setOnClickListener(this);
        sqlite = findViewById(R.id.sqlite);
        sqlite.setOnClickListener(this);
        intent = findViewById(R.id.intent);
        intent.setOnClickListener(this);
        service = findViewById(R.id.service);
        service.setOnClickListener(this);
        viewModel = findViewById(R.id.viewModel);
        viewModel.setOnClickListener(this);
        algorithm = findViewById(R.id.algorithm);
        algorithm.setOnClickListener(this);
        annotation = findViewById(R.id.annotation);
        annotation.setOnClickListener(this);

        // 添加fragment
        FragmentManager fm = getSupportFragmentManager();
        Fragment fr = new MyFragment();
        Bundle bd = new Bundle();
        bd.putSerializable("serial",new SerializeClass());
        fr.setArguments(bd);
        fm.beginTransaction().add(R.id.container,fr).commit();

        // 请求相机权限
        PackageManager pm = getPackageManager();
        if(
            pm.checkPermission("android.permission.CAMERA",getPackageName())
            == PackageManager.PERMISSION_DENIED
        ){
            String[] permissions = {"android.permission.CAMERA"};
            ActivityCompat.requestPermissions(this,permissions,4);
        };
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
        Log.d("---MainActivity2----","onSaveInstanceState");
    }

    public void onRestart(){
        super.onRestart();
        Log.d("---MainActivity2----","onRestart");
    }

    public void onStart(){
        super.onStart();
        Log.d("---MainActivity2----","onStart");
    }

    public void onResume(){
        super.onResume();
        Log.d("---MainActivity2----","onResume");
    }

    public void onPause(){
        super.onPause();
        Log.d("---MainActivity2----","onPause");
    }

    public void onStop(){
        super.onStop();
        Log.d("---MainActivity2----","onStop");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d("---MainActivity2----","onDestroy");
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("---MainActivity2----","onRestoreInstanceState");
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
            case R.id.pager:
                i = new Intent(MainActivity2.this, ViewPagerActivity.class);
                startActivity(i);
                break;
            case R.id.dialog:
                i = new Intent(MainActivity2.this, DialogActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(i);
                break;
            case R.id.sqlite:
                i = new Intent(MainActivity2.this, SQLiteActivity.class);
                startActivity(i);
                break;
            case R.id.intent:
                i = new Intent(MainActivity2.this, IntentActivity.class);
                startActivity(i);
                break;
            case R.id.service:
                i = new Intent(MainActivity2.this, ServiceActivity.class);
                startActivity(i);
                break;
            case R.id.viewModel:
                i = new Intent(MainActivity2.this, ViewModelActivity.class);
                startActivity(i);
                break;
            case R.id.algorithm:
                i = new Intent(MainActivity2.this, AlgorithmActivity.class);
                startActivity(i);
                break;
            case R.id.annotation:
                i = new Intent(MainActivity2.this, AnnotationActivity.class);
                startActivity(i);
                break;
            default:
        }
    }
}