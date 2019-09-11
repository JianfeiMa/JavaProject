package com.jianfei.weakreference;

import java.lang.ref.WeakReference;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-07 08:41
 */
public class TestWeakReference {
    public static void main(String[] args) {
        Car car = new Car(80000, "silver");
        WeakReference<Car> carWeakReference = new WeakReference<Car>(car);
        int i = 0;
        while (true) {
            if (carWeakReference.get() != null) {
                i ++;
                System.out.println("Object is alive for" + i + "loops-" + carWeakReference);
            } else {
                System.out.println("对象被回收");
                break;
            }
        }
    }
}
