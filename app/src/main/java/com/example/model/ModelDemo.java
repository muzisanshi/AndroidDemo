package com.example.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

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
        notifyChange();
    }

    public int age = 32;

    @Bindable
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
        notifyChange();
    }

//    public final ObservableField<String> name = new ObservableField<>("来呀,互相伤害!");
}
