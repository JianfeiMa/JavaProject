package com.jianfei.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-11-12 09:50
 */
public class Main {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXParserHandler saxParserHandler = new SAXParserHandler();
            File file = new File("C:\\china_warehouse_compute_fee.xml");
            saxParser.parse(file, saxParserHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
