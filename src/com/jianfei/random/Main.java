package com.jianfei.random;

import java.util.Random;

/**
 * Description: 自定义加密出货单号
 * 加密规则: 第5位移动到最后一位，再作如下规则加密
 * 0 -> P
 * 1 -> H
 * 2 -> V
 * 3 -> 9
 * 4 -> u
 * 5 -> T
 * 6 -> x
 * 7 -> 3
 * 8 -> G
 * 9 -> i
 * Created by JianfeiMa on 2019-06-21 18:41
 */
public class Main {
    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
        'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        System.out.println("随机的52个大小写字符->" + letters[random.nextInt(52)]);
        System.out.println("随机的0-9中的一个数字->" + random.nextInt(10));

        String firstCharacter = String.valueOf(random.nextInt(10));
        char lastCharacter = letters[random.nextInt(52)];
        String plaintext = "51112655581";
        StringBuilder s = new StringBuilder();
        char[] plaintextS = plaintext.toCharArray();
        char[] plaintextB = new char[plaintext.length()];
        char m = '\u0000';
        for (int i = 0; i < plaintextS.length; i ++) {
            if (i < 5) {
                plaintextB[i] = plaintextS[i];
            } else if (i == 5){
                m = plaintextS[i];
            } else {
                plaintextB[i - 1] = plaintextS[i];
            }
        }
        plaintextB[plaintextB.length-1] = m;
        for (char a : plaintextB) {
            switch (a) {
                case '0':
                    s.append('P');
                    continue;
                case '1':
                    s.append('H');
                    continue;
                case '2':
                    s.append('V');
                    continue;
                case '3':
                    s.append('9');
                    continue;
                case '4':
                    s.append('u');
                    continue;
                case '5':
                    s.append('T');
                    continue;
                case '6':
                    s.append('x');
                    continue;
                case '7':
                    s.append('3');
                    continue;
                case '8':
                    s.append('G');
                    continue;
                case '9':
                    s.append('i');
            }
        }
        System.out.println(firstCharacter + s.toString() + lastCharacter);
    }
}
