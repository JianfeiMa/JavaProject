package com.jianfei.static_test3;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-21 11:21
 */
public class TestEntity {
    private static final int testStaticFinalVariable = 88;
    private final int testFinalVariable = 99;
    private static int testStaticVariable;
    private int testMemberVariable;

    public void memberMethodAdd() {
        testStaticVariable = testStaticVariable + 1;
        testMemberVariable = testMemberVariable + 1;
        int z = testFinalVariable;
    }

    public static void staticMethodAdd() {
        testStaticVariable = testStaticVariable + 1;
    }

    public void testPrint() {
        System.out.println("打印情态变量，所有对象共享的->" + testStaticVariable);
        System.out.println("打印成员变量，只有该类的实例才能可见->" + testMemberVariable);
        int z = testStaticFinalVariable;
        //testStaticFinalVariable = 89;
        int y = testFinalVariable;
        //testFinalVariable = 100;
    }
}
