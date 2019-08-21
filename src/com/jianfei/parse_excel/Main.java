package com.jianfei.parse_excel;

import org.apache.poi.ss.usermodel.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<ExcelBean> excelBeanList = getExcelBeanList();

        List<String> collaborateSpotList = new ArrayList<>();
        Document document = null;
        NodeList nodeList = null;
        try {
            File file = new File("F:/JianfeiMa/2019_05_22_ziqudian_xml_excel/ziqudian.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
            nodeList = document.getElementsByTagName("ziqudian");
            for (int i = 0; i < nodeList.getLength(); i ++) {
                Element element = (Element) nodeList.item(i);
                Node node = element.getElementsByTagName("name").item(0);
                Element elementName = (Element) node;

                String collaborateSpotName = elementName.getTextContent();
                int spaceIndex = collaborateSpotName.indexOf(" ");
                collaborateSpotName = collaborateSpotName.substring(0, spaceIndex);
                System.out.println("xml-->>" + collaborateSpotName);
                collaborateSpotList.add(collaborateSpotName);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //List<String> collaborateSpot = parseXML();
        int equalTotal = 0;
        int gdExchangeTotal = 0;
        int googleExchangeTotal = 0;
        for (int i = 0; i < excelBeanList.size(); i ++) {
            ExcelBean excelBean = excelBeanList.get(i);
            String excelBeanName = excelBean.getCollaborateName();
            for (int j = 0; j < nodeList.getLength(); j ++) {
                Element element = (Element) nodeList.item(j);
                Element elementName = (Element) element.getElementsByTagName("name").item(0);
                String name = elementName.getTextContent();
                int spaceIndex = name.indexOf(" ");
                name = name.substring(0, spaceIndex);
                if (excelBeanName.equals(name)) {
                    System.out.println("相等");
                    Element elementLatGd = (Element) element.getElementsByTagName("lat_gd").item(0);
                    Element elementLngGd = (Element) element.getElementsByTagName("lng_gd").item(0);
                    Element elementLat = (Element) element.getElementsByTagName("lat").item(0);
                    Element elementLng = (Element) element.getElementsByTagName("lng").item(0);
                    String latGd = excelBean.getLatGd();
                    String lngGd = excelBean.getLngGd();
                    String lat = excelBean.getLat();
                    String lng = excelBean.getLng();
                    if (latGd != null && !latGd.equals("")) {
                        elementLatGd.setTextContent(latGd);
                        gdExchangeTotal ++;
                    }
                    if (lngGd != null && !lngGd.equals("")) {
                        elementLngGd.setTextContent(lngGd);
                    }
                    if (lat != null && !lat.equals("")) {
                        elementLat.setTextContent(lat);
                        googleExchangeTotal ++;
                    }
                    if (lng != null && !lng.equals("")) {
                        elementLng.setTextContent(lng);
                    }
                    break;
                }
            }
        }
        System.out.println("相等数量-->>" + equalTotal);
        System.out.println("gd-->>" + gdExchangeTotal);
        System.out.println("google-->>" + googleExchangeTotal);
        saveDocument(document);
    }

    private static List<ExcelBean> getExcelBeanList() {
        List<ExcelBean> excelBeans = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("F:/JianfeiMa/2019_05_22_ziqudian_xml_excel/强哥拾取之后我整理的无空格.xls");
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            if (workbook != null) {
                Sheet sheet = workbook.getSheetAt(0);
                if (sheet != null) {
                    int lastRowNum = sheet.getLastRowNum();
                    for (int i = 0; i <= lastRowNum; i ++) {
                        Row row = sheet.getRow(i);
                        String latGd = "";
                        String lngGd = "";
                        String lat = "";
                        String lng = "";

                        String collaborateSpotName = row.getCell(0).getStringCellValue();
                        if (collaborateSpotName != null)
                            collaborateSpotName = collaborateSpotName.trim();
                        if (row.getCell(1) != null) {
                            Cell cellLatGd = row.getCell(1);
                            cellLatGd.setCellType(CellType.STRING);
                            latGd = cellLatGd.getStringCellValue();
                            if (latGd != null)
                                latGd = latGd.trim();
                        }
                        if (row.getCell(2) != null) {
                            Cell cellLngGd = row.getCell(2);
                            cellLngGd.setCellType(CellType.STRING);
                            lngGd = cellLngGd.getStringCellValue();
                            if (lngGd != null)
                                lngGd = lngGd.trim();
                        }
                        if (row.getCell(3) != null) {
                            Cell cellLat = row.getCell(3);
                            cellLat.setCellType(CellType.STRING);
                            lat = cellLat.getStringCellValue();
                            if (lat != null)
                                lat = lat.trim();
                        }
                        if (row.getCell(4) != null) {
                            Cell cellLng = row.getCell(4);
                            cellLng.setCellType(CellType.STRING);
                            lng = cellLng.getStringCellValue();
                            if (lng != null)
                                lng = lng.trim();
                        }
                        ExcelBean excelBean = new ExcelBean();
                        excelBean.setCollaborateName(collaborateSpotName);
                        excelBean.setLatGd(latGd);
                        excelBean.setLngGd(lngGd);
                        excelBean.setLat(lat);
                        excelBean.setLng(lng);
                        excelBeans.add(excelBean);
                        //System.out.println("第" + i + "行的自取点名称--->>>" + collaborateSpotName + latGd + "," + lngGd + "|" + lat + "," + lng);
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return excelBeans;
    }

    /*private static List<String> parseXML() {
        List<ExcelBean> excelBeans = new ArrayList<>();
        List<String> collaborateSpotList = new ArrayList<>();
        try {
            File file = new File("F:/JianfeiMa/2019_05_22_ziqudian_xml_excel/ziqudian.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList nodeList = document.getElementsByTagName("ziqudian");
            for (int i = 0; i < nodeList.getLength(); i ++) {
                ExcelBean excelBean = new ExcelBean();
                Element element = (Element) nodeList.item(i);
                Node node = element.getElementsByTagName("name").item(0);
                Element elementName = (Element) node;
                //Node nodeLatGd = element.getElementsByTagName("lat_gd").item(0);
                //Node nodeLngGd = element.getElementsByTagName("lng_gd").item(0);
                //Node lat = element.getElementsByTagName("lat").item(0);
                //Node lng = element.getElementsByTagName("lng").item(0);
                String collaborateSpotName = elementName.getTextContent();
                int spaceIndex = collaborateSpotName.indexOf(" ");
                collaborateSpotName = collaborateSpotName.substring(0, spaceIndex);
                System.out.println("xml-->>" + collaborateSpotName);
                collaborateSpotList.add(collaborateSpotName);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collaborateSpotList;
    }*/

    private static void saveDocument(Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("F:/JianfeiMa/2019_05_22_ziqudian_xml_excel/ziqudian_new.xml"));
            transformer.transform(domSource, streamResult);
        }  catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
