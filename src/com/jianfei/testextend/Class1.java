package com.jianfei.testextend;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-12 13:02
 */
public abstract class Class1 {

    public void method1() {
        System.out.println("父类方法执行了");
        abstractMethod("传递给抽象方法的参数");
    }

    abstract void abstractMethod(String message);

    public void otherMethod() {
        abstractMethod("其他方法传递的参数");
    }
}
