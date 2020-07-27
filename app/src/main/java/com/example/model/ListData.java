package com.example.model;

import java.util.ArrayList;

public class ListData <T>{
    private ArrayList<T> list = null;
    public ListData(ArrayList<T> list){
        this.list = list;
    }
    public int getSize(){
        return list.size();
    }

    ArrayList<T> getData(){
        return list;
    }
    public void setData(ArrayList<T> list){
        this.list = list;
    }

    public void add(T title){
        list.add(title);
    }

    public T getItem(int index){
        return list.get(index);
    }
}
