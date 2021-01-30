package com.jianfei.imagetobase64;


import com.mysun.misc.BASE64Encoder;

import java.io.*;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2021-01-30 12:21
 */
public class Main {
    public static void main(String[] args) {
//        try {
//            File file = new File("H:\\ic_launcher.png");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            byte[] buffer = new byte[1024 * 4];
//            int n;
//            while (-1 != (n = fileInputStream.read(buffer))) {
//                byteArrayOutputStream.write(buffer, 0, n);
//            }
//            BASE64Encoder base64Encoder = new BASE64Encoder();
//            String result = base64Encoder.encode(byteArrayOutputStream.toByteArray());
//            System.out.println(result);
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("<!doctype html>");
//            stringBuilder.append("<html lang=\"en\">");
//            stringBuilder.append("<head>");
//            stringBuilder.append("<meta charset=\"UTF-8\">");
//            stringBuilder.append("<title>Document</title>");
//            stringBuilder.append("</head>");
//            stringBuilder.append("<body>");
//            stringBuilder.append("<img src=\"");
//            stringBuilder.append(result);
//            stringBuilder.append("\"/>");
//            stringBuilder.append("</body>");
//            stringBuilder.append("</html>");
//            FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\JianfeiMa\\html\\file_to_base64.html"));
//            fileOutputStream.write(stringBuilder.toString().getBytes());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        File file = new File("H:\\ic_launcher.png");
        InputStream inputStream = null;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(file.getAbsolutePath());
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            inputStream.close();
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String message = base64Encoder.encode(bytes);
//            message = message.replace("+", "%2B");
            message = message.replaceAll("[\\s*\t\n\r]", "");
            message = message.replace("\\n", "");
            message = "data:image/png;base64," + message;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!doctype html>");
            stringBuilder.append("<html lang=\"en\">");
            stringBuilder.append("<head>");
            stringBuilder.append("<meta charset=\"UTF-8\">");
            stringBuilder.append("<title>Document</title>");
            stringBuilder.append("</head>");
            stringBuilder.append("<body>");
            stringBuilder.append("<img src=\"");
            stringBuilder.append(message);
            stringBuilder.append("\"/>");
            stringBuilder.append("</body>");
            stringBuilder.append("</html>");
            FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\JianfeiMa\\html\\file_to_base64.html"));
            fileOutputStream.write(stringBuilder.toString().getBytes());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
