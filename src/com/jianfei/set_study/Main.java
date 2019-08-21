package com.jianfei.set_study;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("JianfeiMa");
        set.add("JianxiaMa");
        set.add("JianfeiMa");
        for (String a : set) {
            System.out.println(a);
        }
        System.out.println("-------------");
        List<String> list = new ArrayList<>();
        list.add("JianfeiMa");
        list.add("JianxiaMa");
        list.add("JianfeiMa");
        for (String z : list) {
            System.out.println(z);
        }
        System.out.println("-------------");
        Set<String> set1 = new TreeSet<>();
        set1.add("JianfeiMa");
        set1.add("JianxiaMa");
        set1.add("JianfeiMa");
        System.out.println("-------------");
        for (String y : set1) {
            System.out.println(y);
        }
    }
}
