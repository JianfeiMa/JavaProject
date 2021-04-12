package com.jianfei.sort;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2021-03-30 13:56
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] myCollectData = {9, 3, 10, 2, 1, 8, 12, 0, 4, 7};
        int outerDeadCondition = myCollectData.length -1;
        int i = 0;
        for (; i < outerDeadCondition; i ++) {
            int innerDeadCondition = outerDeadCondition - i;
            int j = 0;
            for (; j < innerDeadCondition; j ++) {
                int front = myCollectData[j];
                int behind = myCollectData[j + 1];
                if (front < behind) {
                    int temporary = myCollectData[j];
                    myCollectData[j] = myCollectData[j + 1];
                    myCollectData[j + 1] = temporary;
                }
            }
        }
        for (int z = 0; z < myCollectData.length; z ++) {
            System.out.println(myCollectData[z]);
        }
    }
}
