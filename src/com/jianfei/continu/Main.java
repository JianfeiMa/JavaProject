package com.jianfei.continu;

public class Main {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < test.length; i++) {
            if (test[i] == 5) {
                continue;
            }
            System.out.println(test[i]);
        }
    }
}
