package com.jianfei.list_move;

import java.util.ArrayList;
import java.util.List;

/**
 * author: JianfeiMa
 * email:showmarkm@gmail.com
 * created date: 2019-06-25 8:53
 */
public class Main {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("JianfeiMa");
        test.add("JianxiaMa");
        System.out.println(test.get(0));
        System.out.println(test.get(1));
        test.add(0, "JianxiaMa");
        test.remove(2);
        System.out.println("-------------");
        //test.add(0, "Jianfei's Wife");
        for (int i = 0; i < test.size(); i ++) {
            System.out.println("->" + test.get(i));
        }
        System.out.println("-------------");

    }
}
