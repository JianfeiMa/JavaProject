package com.jianfei.random;

import sun.rmi.runtime.Log;

import java.util.Random;
import java.util.StringTokenizer;

/**
 * author: JianfeiMa
 * email:showmarkm@gmail.com
 * created date: 2019-06-21 20:38
 */
public class Main1 {
    public static void main (String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        String plaintext = "SJY1906221924";
        String sExceptForLastSexBit = plaintext.substring(0, plaintext.length() - 6);
        plaintext = plaintext.substring(plaintext.length() - 6);

        System.out.println("后6位->" + plaintext);

        char lastCharacter = letters[random.nextInt(52)];
        String finalCiphertext = transferPatternPositive(plaintext.toCharArray());

        String afterEncryption = sExceptForLastSexBit + finalCiphertext + lastCharacter;
        System.out.println("加密之后->" + afterEncryption);
        System.out.println("------------------------------");
        decryption(afterEncryption);
    }

    private static void decryption(String ciphertext) {
        ciphertext = ciphertext.substring(0, ciphertext.length() - 1);
        System.out.println("去掉尾之后->" + ciphertext);
        ciphertext = transferPatternNegative(ciphertext.toCharArray());
        System.out.println("解密之后->" + ciphertext);
    }

    private static String transferPatternPositive(char[] ciphertextB) {
        StringBuilder s = new StringBuilder();
        for (char a : ciphertextB) {
            switch (a) {
                case '0':
                    s.append('p');
                    continue;
                case '1':
                    s.append('y');
                    continue;
                case '2':
                    s.append('u');
                    continue;
                case '3':
                    s.append('j');
                    continue;
                case '4':
                    s.append('h');
                    continue;
                case '5':
                    s.append('g');
                    continue;
                case '6':
                    s.append('m');
                    continue;
                case '7':
                    s.append('f');
                    continue;
                case '8':
                    s.append('n');
                    continue;
                case '9':
                    s.append('i');
            }
        }
        return s.toString();
    }

    private static String transferPatternNegative(char[] ciphertextZ) {
        StringBuilder s = new StringBuilder();
        for (char j : ciphertextZ) {
            switch(j) {
                case 'p':
                    s.append('0');
                    continue;
                case 'y':
                    s.append('1');
                    continue;
                case 'u':
                    s.append('2');
                    continue;
                case 'j':
                    s.append('3');
                    continue;
                case 'h':
                    s.append('4');
                    continue;
                case 'g':
                    s.append('5');
                    continue;
                case 'm':
                    s.append('6');
                    continue;
                case 'f':
                    s.append('7');
                    continue;
                case 'n':
                    s.append('8');
                    continue;
                case 'i':
                    s.append('9');
            }
        }
        return s.toString();
    }
}
