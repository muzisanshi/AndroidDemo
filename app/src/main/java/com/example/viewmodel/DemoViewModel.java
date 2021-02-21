package com.example.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.androiddemo.R;
import com.example.androiddemo.databinding.ActivityViewModelBinding;
import com.example.model.ModelDemo;

/**
 * 作者：lilei
 * 日期： 2021/2/19 10:44
 */
public class DemoViewModel extends AndroidViewModel {

    private MyData md;
    private Activity ctx;
    private ActivityViewModelBinding binding;
    private ModelDemo model;

    public DemoViewModel(@NonNull Application application) {
        super(application);
//        md = new MyData();
        model = new ModelDemo();
    }

    public void init(Activity ctx, final ActivityViewModelBinding binding){
        this.ctx = ctx;
        this.binding = binding;
        this.binding.setDemoModel(model);
//        final TextView tv = ctx.findViewById(R.id.content);
//        tv.setText(md.getContent());
//        md.observe((LifecycleOwner) ctx, new Observer<MyData>() {
//            @Override
//            public void onChanged(DemoViewModel.MyData myData) {
//                tv.setText(myData.getContent());
//            }
//        });

//        ctx.findViewById(R.id.modify).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                md.setContent("hello,viewModel");
//                // 手动刷新方式(ModelDemo不继承BaseObservable)
////                model.setName("hello,ModelDemo");
////                binding.setDemoModel(model);
//                // 自动刷新方式(ModelDemo继承BaseObservable)
//                model.setName("hello,ModelDemo");
//            }
//        });
    }

    public void onClickModify(View v){
        model.setName("hello,ModelDemo");
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
