package com.jianfei.stack;

/**
 * author: JianfeiMa
 * email:showmarkm@gmail.com
 * created date: 2019-07-07 15:17
 */
public class Main {
    public static void main(String[] args) {
        char test = '\u0000';
        String test1 = String.valueOf(test);
        System.out.println("test->" + test);
        System.out.println("test1->" + test1);
        int i = 0;
        Student s = new Student(25, "JianfeiMa");
        s.getAge();
        s.getName();
        Student s1 = new Student(23, "JianfeiXia");
        s1.getAge();
        s1.getName();
        m1(s);
        System.out.println("所有方法执行完之后的输出原始数据->" + s.getAge());
    }

    public static void m1(Student i) {
        System.out.println("方法1执行");
        //i ++;
        i.setAge(26);
        m2(i);
    }

    public static void m2(Student i) {
        System.out.println("方法2执行");
        //i ++;
        i.setAge(27);
        m3(i);
    }

    public static void m3(Student i) {
        System.out.println("方法3执行");
        //i ++;
        i.setAge(28);
        System.out.println(i);
    }
}
