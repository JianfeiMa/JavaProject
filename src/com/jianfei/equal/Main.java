package com.jianfei.equal;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-18 10:59
 */
public class Main {
    public static void main(String[] args) {
        String s = "true";
        System.out.println("是否相等->" + s.equals("True"));
        boolean is = Boolean.valueOf("truE");
        System.out.println(is);
    }
}
