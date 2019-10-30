package com.jianfei.studyio;

import java.io.*;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-18 08:38
 */
public class Main {
    public static void main(String[] args) {
        try {
            //输入字节节点流
            InputStream fileInputStream = new FileInputStream("");
            InputStream pipedInputStream = new PipedInputStream(30);
            InputStream byteArrayInputStream = new ByteArrayInputStream(new byte[5]);
            //输入字节处理流
            InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            InputStream dataInputStream = new DataInputStream(pipedInputStream);
            InputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            InputStream sequenceInputStream = new SequenceInputStream(bufferedInputStream, dataInputStream);

            //输出字节节点流
            OutputStream fileOutputStream = new FileOutputStream("");
            OutputStream pipedOutputStream = new PipedOutputStream();
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream(30);
            //输出字节节点流
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            OutputStream dataOutStream = new DataOutputStream(pipedOutputStream);
            OutputStream objectOutStream = new ObjectOutputStream(byteArrayOutputStream);
            OutputStream printStream = new PrintStream("");

            //输入字符节点流
            Reader fileReader = new FileReader("");
            Reader pipedReader = new PipedReader();
            Reader charArrayReader = new CharArrayReader(new char[1]);
            //输入字符处理流
            Reader bufferedReader = new BufferedReader(fileReader);
            Reader inputStreamReader = new InputStreamReader(pipedInputStream);

            //输出字符节点流
            Writer fileWriter = new FileWriter("");
            Writer pipedWriter = new PipedWriter();
            Writer charArrayWriter = new CharArrayWriter();
            //输出字符处理流
            Writer bufferedWriter = new BufferedWriter(fileWriter);
            Writer printWriter = new PrintWriter("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.print("finally");
        }
    }
}
