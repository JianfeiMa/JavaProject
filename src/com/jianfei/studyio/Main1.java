package com.jianfei.studyio;

import java.io.*;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-18 09:31
 */
public class Main1 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("C:\\info.2019-10-10.log");
            byte[] myByte = new byte[1024];
            int result = inputStream.read(myByte);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < myByte.length; i ++) {
                stringBuilder.append(String.valueOf(myByte[i]));
            }
            System.out.println(stringBuilder.toString());
            String test = "A";
            byte a = Byte.valueOf(test);
            System.out.println(a);
//            File file = new File("G:\\info.2019-10-10.log");
//            OutputStream outputStream = new FileOutputStream(file);
//            byte[] myByte = new byte[1024];
//            while (inputStream.read(myByte) != -1) {
//                outputStream.write(myByte);
//            }
//            inputStream.close();
//            outputStream.close();
//            Reader reader = new FileReader("C:\\info.2019-10-10.log");
//            char[] myChar = new char[1024];
//            int result = reader.read(myChar);
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < myChar.length; i ++) {
//                stringBuilder.append(myChar[i]);
//            }
//            System.out.println("打印字符->" + stringBuilder.toString());
////            File file = new File("G:\\exception.xml");
////            Writer writer = new FileWriter(file);
////            char[] myCharArray = new char[1024];
////            while (reader.read(myCharArray) != -1) {
////                //writer.write(myCharArray);
////                System.out.println(myCharArray);
////                System.out.println("-----------------");
////            }
////            reader.close();
////            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
