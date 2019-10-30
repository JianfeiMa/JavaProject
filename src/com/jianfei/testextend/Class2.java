package com.jianfei.testextend;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-12 13:04
 */
public class Class2 extends Class1 {
    private int a;
    private int b;
    private int c;

    @Override
    public void method1() {
        //super.method1();
        System.out.println("子类方法执行了");
        method1(1);
    }

    @Override
    void abstractMethod(String message) {
        System.out.println("抽象方法的实现" + message);
    }

    public void method1(int a) {
        this.a = a;
        method1(a, 2);
    }

    public void method1(int a, int b) {
        this.a = a;
        this.b = b;
        method1(a, b, 5);
    }

    public void method1(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void sayHello() {
        System.out.println("hello Java");
    }

}
