package com.example.model;

import java.io.Serializable;

public class SerializeClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name = "lilei";
    private int age = 31;
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
