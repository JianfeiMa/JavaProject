package com.jianfei.bubbleshort;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-07 08:59
 */
public class BubbleShort {
    public static void main(String[] args) {
        short[] array = {3, 21, 3, 2789, 298, 32478, 3728, 289, 9, 874, 903, 42, 398, 897, 378, 9832, 398, 983, 3879, 3728, 8932, 9, 38};
        for (int i = 0; i < array.length - 1; i ++) {
            for (int j = 0; j < array.length - 1 - i; j ++) {
                short a = array[j];
                short b = array[j + 1];
                if (a > b) {
                    short temporary = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                }
            }
        }
        for (short m : array) {
            System.out.println(m);
        }

        System.out.println("--------------------");
        int result = sum(10);
        System.out.println(result);
    }

    private static int sum(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i + sum(i -1);
        }
    }
}
