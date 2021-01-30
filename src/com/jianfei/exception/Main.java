package com.jianfei.exception;

import java.lang.String;
import java.lang.Exception;
import java.lang.System;
import java.lang.Math;
import java.lang.Object;


/**
 * author: JianfeiMa
 * email:showmarkm@gmail.com
 * created date: 2019-06-24 8:33
 */
public class Main{
    public static void main(String[] args) {
        test2();
        Main m = new Main();
        Class<?> y = m.getClass();
        System.out.println(y);
    }

    private void z() {
        System.out.println(hashCode());
    }

    public static void test() throws Exception {
        throw new Exception("参数越界异常");

    }

    public static void test1() {
        try{
            throw new Exception("参数异常");
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("异常后");
    }

    private static void test2() {
        if (true) {
            try {
                throw new RuntimeException("参数异常");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("异常之后");
    }
}
