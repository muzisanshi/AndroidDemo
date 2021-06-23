package com.example.model;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

/**
 * 作者：lilei
 * 日期： 2021/2/21 13:42
 */
public class ModelDemo extends BaseObservable {
//public class ModelDemo{
//    private ObservableField<String> name;
//    public ObservableField<String> getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name = new ObservableField<String>(name);
//    }
//    public ModelDemo(){
//        name = new ObservableField<String>("ModelName");
//    }

    public String name = "ModelName";

    @Bindable
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String age = "32";

    @Bindable({"name"})
    public String getAge(){
        Log.d("----getAge----",age);
        return name + age;
    }
    public void setAge(String age){
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

//    public final ObservableField<String> name = new ObservableField<>("来呀,互相伤害!");
}
