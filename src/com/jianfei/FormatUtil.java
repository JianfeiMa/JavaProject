package com.jianfei;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatUtil {

    public static void main(String[] args) {
        String test = "363200559";
        System.out.println("是否是->" + isNumeric(test));
    }

    /**
     * 判断是否全是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}

