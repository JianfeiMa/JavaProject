package com.jianfei.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-11-12 09:45
 */
public class SAXParserHandler extends DefaultHandler {

    private Entity entity;

    public SAXParserHandler() {
        entity = new Entity();
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //System.out.println("SAX解析开始" + "uri:" + uri + "localName:" + localName + "qName:" + qName + "attributes:" + attributes.toString());
        System.out.println("startElement:qName->" + qName);
        if (qName.equals("delivery")) {
            
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("SAX解析结束" + "uri:" + uri + "localName:" + localName + "qName:" + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println("节点值为：" + value);
        }
    }
}
