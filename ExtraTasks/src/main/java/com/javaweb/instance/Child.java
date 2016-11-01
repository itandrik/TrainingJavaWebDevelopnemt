package com.javaweb.instance;

/**
 * Created by Dron on 01-Nov-16.
 */
public class Child extends Parent {
    int value;

    public Child(int value) {
        super(value);
    }

    public void increment(){
        this.value++;
    }
}
