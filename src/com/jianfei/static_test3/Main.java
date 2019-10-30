package com.jianfei.static_test3;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-21 11:20
 */
public class Main {
    public static void main(String[] args) {
        TestEntity testEntity = new TestEntity();
        testEntity.memberMethodAdd();
        testEntity.testPrint();
        System.out.println("------------------------");
        TestEntity testEntity1 = new TestEntity();
        testEntity1.memberMethodAdd();
        testEntity1.testPrint();
    }
}
