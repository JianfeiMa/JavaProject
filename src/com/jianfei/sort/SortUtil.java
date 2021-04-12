package com.jianfei.sort;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2021-01-29 09:44
 */
public class SortUtil {
    public int[] sort() {
        int[] arr = {3, 7, 4, 8, 9, 2, 3, 7,47, 238, 9, 0, 64, 790, 2, 649, 1, 2379, 8, 6, 2, 3, 6, 4};
//        for (int i = 0; i < arr.length -1; i ++) {
//            for (int j = 0; j < arr.length - 1 - i; j ++) {
//                int p = arr.length - 1 - i;
//                System.out.println("内层循环结束条件:" + p);
//                int z = arr[j];
//                int y = arr[j + 1];
//                System.out.println("z->" + z);
//                System.out.println("y->" + y);
//                if (z < y) {
//                    int temporary = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temporary;
//                }
//                System.out.println("--------------------");
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//        String[] s = {"190608", "190608", "190608", "190607", "190607", "190606"};
//        Set<String> set = new TreeSet<String>();
//        for (int i = 0; i < s.length; i++) {
//            set.add(s[i]);
//        }
//        for (String ts : set) {
//            System.out.println("->" + ts);
//        }
//        Set<String> hashSet = new HashSet<String>();
//        Set<String> treeSet = new TreeSet<String>();
//        Set<String> linkedHashSet = new LinkedHashSet<String>();
        return arr;
    }
}
