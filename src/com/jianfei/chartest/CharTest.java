package com.jianfei.chartest;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-08-20 09:47
 */
public class CharTest {
    public static void main(String[] args) {
        String str = "您好hello";
        byte[] bytes = str.getBytes();
        System.out.println("打印字节的长度->" + bytes.length);
        System.out.println("系统默认编码->" + System.getProperty("file.encoding"));
        String str1 = "abc123";
        byte[] bytes1 = str1.getBytes();
        for (int i = 0; i < bytes1.length; i ++) {
            System.out.println("遍历字节数组->" + bytes1[i]);
        }
        System.out.println("打印英文字节的长度->");

    }
}
