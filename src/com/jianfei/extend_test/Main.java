package com.jianfei.extend_test;

public class Main {
    public static void main(String[] args) {
        byte catAge = 1;
        byte dogAge = 2;
        Cat cat = new Cat("猫", catAge);
        Dog dog = new Dog("狗", dogAge);
        cat.printAnimalAge();
        dog.printAnimalAge();
    }
}
