package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.annotation.MyAnnotation;

import java.lang.reflect.Method;

public class AnnotationActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView content;
    private Button get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);

        content = findViewById(R.id.content);
        get = findViewById(R.id.get);
        get.setOnClickListener(this);

        getSupportActionBar().setTitle("JAVA注解");
    }

    @MyAnnotation(name = "testAnnotation")
    public void testAnnotation(){}

    @Override
    public void onClick(View v) {
        // 获取注解中的内容
        Class c = AnnotationActivity.class;
        try {
            Method m = c.getMethod("testAnnotation",new Class[]{});
            if(m.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation a = m.getAnnotation(MyAnnotation.class);
                String name = a.name();
                content.setText("Annotation内容:" + name);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}