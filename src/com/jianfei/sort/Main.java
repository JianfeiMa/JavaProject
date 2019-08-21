package com.jianfei.sort;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        /*int[] arr = {3, 7, 4, 8, 9, 2, 3, 7,47, 238, 9, 0, 64, 790, 2, 649, 1, 2379, 8, 6, 2, 3, 6, 4};
        for (int i = 0; i < arr.length -1; i ++) {
            for (int j = 0; j < arr.length - 1 - i; j ++) {
                if (arr[j] < arr[j + 1]) {
                    int temporary = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temporary;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/

        /*int[][] brr = new int[3][4];
        brr[0][0] = 88;
        brr[0][1] = 22;
        brr[0][2] = 55;
        brr[0][3] = 99;

        brr[1][0] = 10;
        brr[1][1] = 11;
        brr[1][2] = 12;
        brr[1][3] = 13;

        brr[2][0] = 20;
        brr[2][1] = 21;
        brr[2][2] = 22;
        brr[2][3] = 23;
        for (int i = 0; i < brr.length; i++) {
            int[] z = brr[i];
            for (int j = 0; j < z.length; j++) {
                System.out.print(z[j] + " ");
            }
            System.out.print("\n");
        }*/

        String[] s = {"190608", "190608", "190608", "190607", "190607", "190606"};
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < s.length; i++) {
            treeSet.add(s[i]);
        }
        for (String ts : treeSet) {
            System.out.println("->" + ts);
        }
    }
}
