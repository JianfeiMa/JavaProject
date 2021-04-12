package com.jianfei.binarysearch;

import java.util.Scanner;

//Exception in thread "main" java.lang.StackOverflowError:栈溢出
public class BinarySearch {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        boolean flag = true;
        System.out.println("请输入" + length + "个有序的整数：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();

        }
        for (int i = 0; i < arr.length - 1; i++) {
            // 判断数列是否有序
            if (arr[i] < arr[i + 1]) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        System.out.println("请输入要查询的数x：");
        Scanner sca = new Scanner(System.in);
        int x = sca.nextInt();
        if (flag) {
            System.out.println(BinarySort(arr, 0, arr.length, x));
        }

    }

    public static int BinarySort(int[] arr, int min, int max, int x) {
        // 定义中间的数的下标
        int mid = (min + max) / 2;
        // 如果中间的数与要查找的数一样则直接结束算法
        if (x == arr[mid]) {
            return mid;
        }
        if (min < max) {

            // 如果中间数比要找的数大就比较前一个数，然后继续再在前面的部分再分成两部分从中间查找
            if (arr[mid] > x) {
                max = mid - 1;
            }
            // 如果中间数比要找的数小就比较后一个数，然后继续再在后面的部分再分成两部分从中间查找
            if (arr[mid] < x) {
                min = mid + 1;
            }
        }
        // 每次从数组的中间开始查找，一次之后找不到又把数组分成两部分继续从小的数组的中间开始查找
        return BinarySort(arr, min, max, x);

    }
}
