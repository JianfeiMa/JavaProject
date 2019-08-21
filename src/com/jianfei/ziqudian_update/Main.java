package com.jianfei.ziqudian_update;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("F:/JianfeiMa/ziqudian_2019_05_29_update_price/ziqudian.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList nodeList = document.getElementsByTagName("ziqudian");
            for (int i = 0; i < nodeList.getLength(); i ++) {
                Element element = (Element) nodeList.item(i);
                Node nodeName = element.getElementsByTagName("name").item(0);
                Node nodefirstweight_ustohk = element.getElementsByTagName("firstweight_twtohk").item(0);
                Node nodeaddweight_ustohk = element.getElementsByTagName("addweight_twtohk").item(0);
                Element elementName = (Element) nodeName;
                Element elementfirstweight_ustohk = (Element) nodefirstweight_ustohk;
                Element elementaddweight_ustohk = (Element) nodeaddweight_ustohk;
                String collaborateSpotName = elementName.getTextContent();
                String firstweight_ustohk = elementfirstweight_ustohk.getTextContent();
                String addweight_ustohk = elementaddweight_ustohk.getTextContent();
                //System.out.println("自取点->" + collaborateSpotName + "美国首重->" + firstweight_ustohk + "美国续重->" + addweight_ustohk);
                System.out.println("台首->" + firstweight_ustohk + "台续->" + addweight_ustohk);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
