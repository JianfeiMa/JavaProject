package com.jianfei.sort;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 7, 4, 8, 9, 2, 3, 7, 47, 238, 9, 0, 64, 790, 2, 649, 1, 2379, 8, 6, 2, 3, 6, 4};
        int outCondition = arr.length - 1;
        int i = 0;
        for (; i < outCondition; i ++) {
            /**
             * 内层循环结束的条件=外层循环结束的条件-1
             */
            int innerCondition = outCondition - i;

            int j = 0;
            for (; j < innerCondition; j ++) {

                System.out.println("打印j->" + j);

                /**
                 * 两两相邻从数组拿出来比较
                 */
                int z = arr[j];
                int y = arr[j + 1];

                System.out.println("前一个->" + z + ";后一个->" + y);

                /**
                 * 从大到小排序，先冒泡出最小，再冒泡出次小的，以此类推，最后一轮剩下就是最大的
                 */
                if (z > y) {
                    int temporary = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temporary;
                }

            }
            System.out.println("-----外层结束-----");
            for (int z = 0; z < arr.length; z++) {
                System.out.println("打印一下排序先->" + arr[z]);
            }
        }
        System.out.println("----------最终排序结果----------");
        for (int z = 0; z < arr.length; z++) {
            System.out.println(arr[z]);
        }

//        int[][] brr = new int[3][4];
//        brr[0][0] = 88;
//        brr[0][1] = 22;
//        brr[0][2] = 55;
//        brr[0][3] = 99;
//
//        brr[1][0] = 10;
//        brr[1][1] = 11;
//        brr[1][2] = 12;
//        brr[1][3] = 13;
//
//        brr[2][0] = 20;
//        brr[2][1] = 21;
//        brr[2][2] = 22;
//        brr[2][3] = 23;
//        for (int i = 0; i < brr.length; i++) {
//            int[] z = brr[i];
//            for (int j = 0; j < z.length; j++) {
//                System.out.print(z[j] + " ");
//            }
//            System.out.print("\n");
//        }

        String[] s = {"190608", "190608", "190608", "190607", "190607", "190606"};
        //TreeSet<String> treeSet = new TreeSet<>();
        Set<String> set = new TreeSet<String>();
        for (int ii = 0; ii < s.length; ii++) {
            set.add(s[ii]);
        }
        for (String ts : set) {
            System.out.println("->" + ts);
        }
        Set<String> hashSet = new HashSet<String>();
        Set<String> treeSet = new TreeSet<String>();
        Set<String> linkedHashSet = new LinkedHashSet<String>();

    }
}
