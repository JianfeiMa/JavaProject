package com.jianfei.studyreference;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-16 09:11
 */
public class Main {
    private TestEntity testEntity;

    public static void main(String[] args) {
        Main main = new Main();
        main.testReference();
        while(true) {
            if (main.testEntity == null) {
                System.out.println("对象被回收");
            } else {
                System.out.println("对象还存在于内存中");
            }
        }
    }

    public void testReference() {
        testEntity = new TestEntity(2);
    }
}
