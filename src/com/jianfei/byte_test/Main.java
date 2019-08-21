package com.jianfei.byte_test;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            String strTest = "这是测试字符";
            byte[] bytes = strTest.getBytes();
            for (int i = 0; i < bytes.length; i ++) {
                System.out.println("打印字节->" + bytes[i]);
            }
            OutputStream outputStream = new FileOutputStream("F:/JianfeiMa/bytes_test_test.txt");
            outputStream.write(bytes);
            outputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String s = "ldashfdahfsahfslhjfosljhfglskhgaslhgsjd7901476392645296742983642163409281675908235629836419206498326hfds这是测试字符fajskdfhsahfsahfhsafhsjkghfjksagfsfaldkkkkkkkkkkkkhafdhslhfowiehowslahalhflsjdflasjflsaghsalghlfhsdahjgfshgssssssssssssfsklhsngabgnshgsjdfsdf";
            byte[] bs= s.getBytes();
            OutputStream out = new FileOutputStream("F:/JianfeiMa/bytes_test.txt");
            InputStream is = new ByteArrayInputStream(bs);
            //开辟1024字节的缓冲内存
            byte[] buff = new byte[1024];
            int len;
            while((len = is.read(buff)) != -1){
                out.write(buff, 0, len);
            }
            is.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
