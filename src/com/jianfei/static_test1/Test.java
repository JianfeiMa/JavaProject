package com.jianfei.static_test1;

public class Test {
    Person person = new Person("Test1");
    static {
        System.out.println("test static");
    }
    public Test() {
        System.out.println("test constructor");
    }
    public static void main(String[] arg) {
        Person.sayHallo("BuyUp物流中转站");
        new MyClass();
    }
}

class Person {
    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person" + str);
    }

    public static void sayHallo(String name) {
        long a = 10000000;
        long b = 20000000;
        long c = 30000000;
        long d = 40000000;
        String z = "zzzzzzzzz";
        String y = "yyyyyyyyy";
        String x = "xxxxxxxxx";
        System.out.println("Hello " + name);
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        z = null;
        y = null;
        x = null;
    }
}

class MyClass extends Test {
    Person person = new Person("MyClass");
    static {
        System.out.println("myClass static");
    }
    public MyClass() {
        System.out.println("myClass constructor");
    }
}

//test static
//myClass static
//person static
//person Test1
//test constructor
//person myClass
//myClass constructor
