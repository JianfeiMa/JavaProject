package com.jianfei.bubbleshort;

import java.util.*;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-16 08:31
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {2, 9, 3, 7, 9, 10, 24, 0, 4};
        for (int z = array.length - 1; z > -1; z --) {
            System.out.println("反向遍历->" + array[z]);
        }
        System.out.println("-------------------------");
        int y = 0;
        while (y < array.length) {
            System.out.println("while遍历->" + array[y]);
            y ++;
        }

        int i;
        int j;
        for (i = 1; i < array.length; i ++) {
            int temporary = array[i];
            for (j = i - 1; j > -1; j --) {
                if (temporary > array[j]) {
                    break;
                } else {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = temporary;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("--------------------------");
        Map<Integer, String> mapData = new HashMap<Integer, String>();
        mapData.put(0, "张三");
        mapData.put(1, "李四");
        mapData.put(2, "王五");
        mapData.put(3, "赵六");
        Set<Map.Entry<Integer, String>> a = mapData.entrySet();
        Iterator<Map.Entry<Integer, String>> b = a.iterator();
        while (b.hasNext()) {
            Map.Entry<Integer, String> c = b.next();
            System.out.println("遍历map:key->" + c.getKey() + ";value->" + c.getValue());
        }
    }
}
