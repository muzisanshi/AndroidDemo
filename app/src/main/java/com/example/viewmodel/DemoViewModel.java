package com.example.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.androiddemo.R;

/**
 * 作者：lilei
 * 日期： 2021/2/19 10:44
 */
public class DemoViewModel extends AndroidViewModel {

    private MyData md;
    private Activity ctx;

    public DemoViewModel(@NonNull Application application) {
        super(application);
        md = new MyData();
    }

    public void init(Activity ctx){
        this.ctx = ctx;
        final TextView tv = ctx.findViewById(R.id.content);
        tv.setText(md.getContent());
        md.observe((LifecycleOwner) ctx, new Observer<MyData>() {
            @Override
            public void onChanged(DemoViewModel.MyData myData) {
                tv.setText(myData.getContent());
            }
        });

        ctx.findViewById(R.id.modify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                md.setContent("hello,viewModel");
            }
        });
    }

    public class MyData extends LiveData {
        private String content = "viewModel";
        public String getContent(){
            return content;
        }
        public void setContent(String content){
            this.content = content;
            postValue(this);
        }
    }
}
