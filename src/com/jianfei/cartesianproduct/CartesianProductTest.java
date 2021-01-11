package com.jianfei.cartesianproduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-12-01 10:51
 */
public class CartesianProductTest {
    public static void main(String[] args) {
        String[] a = new String[2];
        a[0] = "红色";
        a[1] = "蓝色";
        String[] b = new String[2];
        b[0] = "大码";
        b[1] = "中码";
        cartesian(a, b);
//        cartesianProduct(a, b);
    }

    private static void cartesian(String[] ... strings) {
        int[] counter = new int[strings.length];
        for (int z = 0; z < strings.length; z ++) {
            counter[z] = 0;
        }
        int a = strings.length - 1;
        while (a >= 0) {
            for (int i = 0; i < strings.length; i ++) {
                String[] specificationArray = strings[i];
                int counterIndex = counter[i];
                String specification = specificationArray[counterIndex];
                System.out.println("取出属性->" + specification);
                if (i == strings.length - 1) {
                    if (++counter[i] > specificationArray.length - 1) {
                        counter[i] = 0;
                        int j = i;
                        while (--j >= 0) {
                            if (strings[j] == null || ++counter[j] > strings[j].length - 1) {
                                counter[j] = 0;
                                continue;
                            }
                            break;
                        }

                        if (j < a) {
                            a = j;
                        }
                    }
                }
            }
        }
        List<String> element = new ArrayList<>();
    }

//    private static void cartesianProduct(String[]... sets) {
//        int cIndex = sets.length - 1;
//        int[] counter = new int[sets.length];
//        for (int i = 0; i < sets.length; i++) {
//            counter[i] = 0;
//        }
//        while (cIndex >= 0) {
//            for (int j = 0; j < sets.length; j++) {
//                int counterIndex = counter[j];
//                String[] specificationArray = sets[counterIndex];
//                if (j == sets.length - 1 && ++counter[j] > specificationArray.length - 1) {
//                    counter[j] = 0;
//                    int cIdx = j;
//                    while (--cIdx >= 0) {
//                        if (sets[cIdx] == null || ++counter[cIdx] > sets[cIdx].length - 1) {
//                            counter[cIdx] = 0;
//                            continue;
//                        }
//                        break;
//                    }
//                    if (cIdx < cIndex) {
//                        cIndex = cIdx;
//                    }
//                }
//            }
//        }
//    }
}
