package com.jianfei.extend_test;

public class Dog extends Animal {
    private String name;

    public Dog(String name, byte age) {
        super(age);
        this.name = name;
    }
}
