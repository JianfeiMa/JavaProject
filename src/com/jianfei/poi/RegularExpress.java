package com.jianfei.poi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpress {
    public static void main(String[] args) {
        String pushMessage = "BUYUP集運貨物已到達[葵涌廣場]自取點,憑單號和電話儘早取貨,自取點介紹请點http://t.cn/Rl4amYx 發送時間:2019/5/8 11:14:03";
        String regularExpress = "(*)";
        Pattern pattern = Pattern.compile(regularExpress);
        Matcher matcher = pattern.matcher(pushMessage);
        System.out.println("分组数量--->>>" + matcher.groupCount());
        if (matcher.find()) {
            String result = matcher.group(1);
            System.out.println("匹配结果--->>>" + matcher.group(1));
        }

        System.out.println("-------------");
        String pattern1 = "([\\s\\S]){1,20}";
        Pattern p = Pattern.compile(pattern1);
        System.out.print(p.matcher("1234567890").matches());
    }
}
