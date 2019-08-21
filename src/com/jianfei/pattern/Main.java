package com.jianfei.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            throw new Exception("抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("捕获异常");
        }
        String sendSMSResult = "363233282";
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(sendSMSResult);
        System.out.println("是否全是数字->" + isNum.matches());
    }
}
