package com.jianfei.testmd5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-11-25 14:01
 */
public class TestMd {
    public static void main(String[] args) {
//        String a = Md5Security.getMD5("oiv1hddkf45nitcfy3kkjhbkt3dadxgbcompanyCodeOTHERoutSid511258532057tid1402490234017605617timestamp1606703071854oiv1hddkf45nitcfy3kkjhbkt3dadxgb");
//        System.out.println(a);

        ((Object) null).getClass();

        int test = 0;
        while (test++ < 5) {
            System.out.println(test);
        }

        int pp = 15;
        int mm = 0;
        int jj = 0;
        int ff = mm++;
        int fff = ++jj;
        System.out.println("mmm->" + mm);
        System.out.println("ff->" + ff);
        System.out.println("jjj->" + jj);
        System.out.println("fff->" + fff);

        String[] a = {"蓝色", "红色"};
        String[] b = {"大码", "中码", "小码"};
        List<List<String>> result = cartesianProduct(a, b);
        for (int i = 0; i < result.size(); i ++) {
            List<String> z = result.get(i);
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < z.size(); j ++) {
                stringBuilder.append(z.get(j));
            }
            System.out.println("输出->" + stringBuilder.toString());
        }
    }

    private static <T> List<List<T>> cartesianProduct(T[]... sets) {
        if (sets == null || sets.length == 0) {
            return Collections.emptyList();
        }
        int total = 1;
        //声明sets总数组进位指针cIndex
        int cIndex = sets.length - 1;
        //声明counterMap(角标 - counter)
        int[] counterMap = new int[sets.length];
        for (int i = 0; i < sets.length; i++) {
            counterMap[i] = 0;
            total *= (sets[i] == null || sets[i].length == 0 ? 1 : sets[i].length);
        }
        System.out.println("总共有->" + total + "种结果");
        List<List<T>> resultList = new ArrayList<>(total);
        //开始求笛卡尔积
        while (cIndex >= 0) {
            List<T> element = new ArrayList<>(sets.length);
            //循环拿出每组属性值
            System.out.println("循环的次数->" + sets.length);
            for (int j = 0; j < sets.length; j++) {
                T[] set = sets[j];

                StringBuilder stringBuilder = new StringBuilder();
                for (int m = 0; m < set.length; m ++) {
                    stringBuilder.append(set[m]);
                }
                System.out.println("是哪一组->" + stringBuilder.toString());

                int counterMapIndex = counterMap[j];
                System.out.println(set[counterMapIndex]);
                element.add(set[counterMapIndex]);
                //从末位触发指针进位
                if (j == sets.length - 1 && ++counterMap[j] > set.length - 1) {
                    System.out.println("从末位触发指针进位");
                    //重置指针
                    counterMap[j] = 0;
                    //进位
                    int cIdx = j;
                    while (--cIdx >= 0) {
                        //判断如果刚好前一位也要进位继续重置指针进位
                        if (sets[cIdx] == null || ++counterMap[cIdx] > sets[cIdx].length - 1) {
                            counterMap[cIdx] = 0;
                            System.out.println("最外的一层循环结束");
                            continue;
                        }
                        break;
                    }
                    if (cIdx < cIndex) {
                        //移动进位指针
                        cIndex = cIdx;
                    }
                }
            }
            System.out.println("打印数组数量->" + element.size());
            if (element.size() > 0) {
                System.out.println("加入一组");
                resultList.add(element);
            }
        }
        return resultList;
    }
}
