package com.jianfei.bubbleshort;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-03 10:02
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {7, 5, 8, 3, 6, 32, 21, 42, 42, 42412, 57893, 2412, 7098, 4738, 42679, 0, 3472};
        for (int i = 0; i < a.length - 1; i ++) {
            for (int j = 0; j < a.length - 1 - i; j ++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int z : a) {
            System.out.println(z);
        }
    }
}
