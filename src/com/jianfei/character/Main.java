package com.jianfei.character;

public class Main {
    public static void main(String[] args) {
        String test = "57297434243";
        char firstCharacter = test.charAt(0);
        System.out.println("首位字符->" + firstCharacter);
        if (firstCharacter == '5') {
            System.out.println("首位字符等于5");
        }
    }
}
