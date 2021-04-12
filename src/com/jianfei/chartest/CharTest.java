package com.jianfei.chartest;

import java.io.*;

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
        System.out.println("------------------------------------------");
        char testCharOne = '1';
        System.out.println("输出1字符的二进制->" + Integer.toBinaryString(testCharOne));
        System.out.println("输出1字符的十进制->" + Integer.toUnsignedLong(testCharOne));
        System.out.println("------------------------------------------");


        System.out.println("开始打印16进制的0");
        //0 1 2 3 4 5 6 7 8 9 A B C D E F
        char aa = '}';
        System.out.println("打印}字符的ASCII->" + Integer.toUnsignedLong(aa));
        byte myTest1 = 0x10;
        System.out.println(myTest1);

        File file = new File("C:\\study_char_one.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

//            OutputStream outputStream = new FileOutputStream(new File("D:\\study_char_one.txt"));
//            byte[] myByteArray = new byte[1024];
//            while(inputStream.read(myByteArray) != -1) {
//                outputStream.write(myByteArray);
//            }
//            outputStream.flush();

//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            char[] myCharArray = new char[1024];
//            while (inputStreamReader.read(myCharArray) != -1) {
//                StringBuilder stringBuilder = new StringBuilder();
//                for (char c : myCharArray) {
//                    stringBuilder.append(c);
//                }
//                System.out.println("打印从输入流转到Reader" + stringBuilder.toString());
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------");
        byte storageOctOne = 37;
        System.out.println(Integer.toBinaryString(storageOctOne));
        storageOctOne ++;
        System.out.println(Integer.toBinaryString(storageOctOne));
        System.out.println("---------------开始复制文件-----------------------");
        studyOfBufferedInputStreamAndBufferedOutputStream();
    }

    private static void studyOfBufferedInputStreamAndBufferedOutputStream() {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream("C:\\Buyup-release-service-1.27.apk");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            fileOutputStream = new FileOutputStream("D:\\Buyup-release-service-1.27.apk");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
//        try {
//            int asciiOfChar;
//            asciiOfChar = fileInputStream.read();
//            while(-1 != asciiOfChar) {
//                fileOutputStream.write(asciiOfChar);
//                asciiOfChar = fileInputStream.read();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 512);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 512);
        int asciiOfChar;
        try {
            asciiOfChar = bufferedInputStream.read();
            while (-1 != asciiOfChar) {
                bufferedOutputStream.write(asciiOfChar);
                asciiOfChar = bufferedInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("---------------复制文件结束-----------------------");
    }
}
