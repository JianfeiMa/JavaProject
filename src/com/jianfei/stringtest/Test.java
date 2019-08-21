package com.jianfei.stringtest;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-08-19 14:37
 */
public class Test {
    public static void main(String[] args) {
        String testString = "[{" + "key" + ":" + "real_name" + ", " + "value" + ":" + "土豪" + "}]";
        System.out.println("打印测试字符串->" + testString);
        KeyValueObject realNameObject = new KeyValueObject();
        realNameObject.setKey("real_name");
        realNameObject.setValue("土豪");
        KeyValueObjectMobile mobilePhone = new KeyValueObjectMobile();
        mobilePhone.setMobile_phone("13138742085");
        KeyValueObject emailObject = new KeyValueObject();
        emailObject.setKey("email");
        emailObject.setValue("majianfei93@163.com");
        KeyValueObject avatarObject = new KeyValueObject();
        avatarObject.setKey("avatar");
        avatarObject.setValue("https://qiyukf.com/def_avatar.png");
        List<Object> list = new ArrayList<>();
        list.add(realNameObject);
        list.add(mobilePhone);
        list.add(emailObject);
        list.add(avatarObject);
        Gson gson = new Gson();
        String result = gson.toJson(list);
        System.out.println("输出json->" + result);
    }
}
