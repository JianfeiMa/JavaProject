package com.jianfei.regex;

/**
 * Description: JavaProject
 * Created by JianfeiMa on 2019-06-20 16:55
 */
public class Main {
    public static void main(String[] args) {
        //String a = "^(?:\\+?86)?1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[01356789]\\d{2}|4(?:0\\d|1[0-2]|9\\d))|9[189]\\d{2}|6[567]\\d{2}|4(?:[14]0\\d{3}|[68]\\d{4}|[579]\\d{2}))\\d{6}$";
        //String mobile = "828372";
        //System.out.println(mobile.matches(a));
        System.out.println("is->" + isHongKongMobileNumber("+85281324976"));
    }

    /**
     * 验证香港手机号码
     * @param mobile
     * @return
     * Revised By JianfeiMa on 2019-06-20 17:40
     */
    public static boolean isHongKongMobileNumber(String mobile) {
        if (mobile.startsWith("+852") || mobile.startsWith("852")) {
            mobile = mobile.substring(4);
        }
        char firstCharacter = mobile.charAt(0);
        if (firstCharacter == '5' || firstCharacter == '6' || firstCharacter == '8' || firstCharacter == '9') {
            return mobile.length() == 8;
        } else {
            return false;
        }
    }
}
