package com.jianfei.extend_test;

public class Animal {
    private byte age;
    protected static byte testData;

    static {
        String z = "zzzzzzzzzzzzzzzzzz";
        String y = "yyyyyyyyyyyyyyyyyy";
        String x = "xxxxxxxxxxxxxxxxxx";
        System.out.println("静态代码块初始化z->" + z);
        System.out.println("静态代码块初始化y->" + y);
        System.out.println("静态代码块初始化x->" + x);
    }

    public Animal() {
        System.out.println("默认父类构造函数创建");
    }

    public Animal(byte age) {
        System.out.println("父类构造函数创建-->>" + age);
        this.age = age;
    }

    protected void printAnimalAge() {
        System.out.println("父类中打印动物年龄-->>" + age);
    }

    protected static void printTestData() {
        System.out.println("打印测试数据-->>" + testData);
    }
}
