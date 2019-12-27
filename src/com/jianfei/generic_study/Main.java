package com.jianfei.generic_study;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-12-26 09:07
 */
public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<Integer, String>(1, "a");
        Pair<Integer, String> pair2 = new Pair<Integer, String>(2, "b");
        Main main = new Main();
        boolean result = main.<Integer, String>compare(pair1, pair2);
    }

    public <K, V> boolean compare(Pair<K, V> pair1, Pair<K, V> pair2) {
        return false;
    }
}
