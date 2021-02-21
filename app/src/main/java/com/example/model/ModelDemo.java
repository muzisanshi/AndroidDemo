package com.example.model;

import androidx.databinding.BaseObservable;
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

    private String name = "ModelName";
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
        notifyChange();
    }
}
