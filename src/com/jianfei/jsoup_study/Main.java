package com.jianfei.jsoup_study;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-01-07 15:21
 */
public class Main {
    public static void main(String[] args) {
        String html = "<html><head><title>First Parse<title/></head><body><p>Parsed HTML int a doc</p></body></html>";
        Document document = Jsoup.parse(html);
        Element headElement = document.head();
        Element bodyElement = document.body();
        Elements elements = bodyElement.getAllElements();
        for (int i = 0; i < elements.size(); i ++) {
            String text = elements.text();
            System.out.println("text:" +text);
        }
        System.out.println("-------------------------------");
        Connection connection = Jsoup.connect("http://www.baidu.com");
        try {
            Document documentOfBaidu = connection.get();
            String title = documentOfBaidu.title();
            System.out.println("title:" + title);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
