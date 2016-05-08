package com.example.kbpark.mylist;

/**
 * Created by KBPark on 2016. 4. 29..
 */
public class SingerItem {

    String name;
    String age;

    public SingerItem(){}

    public SingerItem(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
