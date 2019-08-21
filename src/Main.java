import com.jianfei.poi.CellBean;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.rmi.runtime.Log;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //File file = new File("F:/JianfeiMa/2019_05_04/ziqudian.xml");
        List<ZiQuDian> a = parseOld();
        /*if (file.exists()) {
            System.out.println("文件存在");
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(file);
                NodeList nodeList = document.getElementsByTagName("ziqudians");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node instanceof Element) {
                        Element element = (Element) node;
                        NodeList nodeList1 = element.getElementsByTagName("ziqudian");
                        for (int j = 0; j < nodeList1.getLength(); j++) {
                            Node node1 = nodeList1.item(j);
                            if (node1 instanceof Element) {
                                Element element1 = (Element) node1;
                                String id = element1.getAttribute("id");
                                System.out.println("外循环id--->>>" + id);
                                for (int k = 0; k < a.size(); k++) {
                                    System.out.println("内循环id--->>>" + String.valueOf(a.get(k).getId()));
                                    if (Integer.valueOf(id) == a.get(k).getId()) {
                                        System.out.println("--->>>id相等" + id);
                                        Node nodeLatGD = element1.getElementsByTagName("lat_gd").item(0);
                                        if (nodeLatGD instanceof  Element) {
                                            Element elementLatGD = (Element) nodeLatGD;
                                            elementLatGD.setTextContent(a.get(k).getLatGD());
                                            //String latGD = elementLatGD.getTextContent();
                                            //System.out.println("lat_gd--->>>" + latGD);
                                        }
                                        Node nodeLngGD = element1.getElementsByTagName("lng_gd").item(0);
                                        if (nodeLngGD instanceof Element) {
                                            Element elementLngGD = (Element) nodeLngGD;
                                            elementLngGD.setTextContent(a.get(k).getLngGD());
                                            //String lngGD = elementLngGD.getTextContent();
                                            //System.out.println("lng_gd--->>>" + lngGD);
                                        }
                                        doc2XmlFile(document, "F:/JianfeiMa/ziqudian1.xml");
                                        break;
                                    }
                                }
                                //element1.appendChild(document.createElement("lat_gd"));
                                //element1.appendChild(document.createElement("lng_gd"));
                                //doc2XmlFile(document, "F:/JianfeiMa/ziqudian1.xml");
                            }
                        }
                    }
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        com.jianfei.poi.Main.main();
        //这个是Excel表中的数据
        List<CellBean> cellBeanList = com.jianfei.poi.Main.getRowList();
        for (int i = 0; i < cellBeanList.size(); i++) {
            CellBean cellBean = cellBeanList.get(i);
            String excelName = cellBean.getName();
            //System.out.println("表格中的name--->>>" + excelName);
            for (int j = 0; j < a.size(); j++) {
                String xmlName = a.get(j).getName();
                //System.out.println("xml中的name--->>>" + xmlName);
                if (xmlName.equals(excelName)) {
                    System.out.println("相同的自取点-->>" + excelName);
                    cellBean.setLat_gd(a.get(j).getLatGD());
                    cellBean.setLng_gd(a.get(j).getLngGD());
                    break;
                }
            }
        }
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("ziqudian");
        for (int i = 0; i < cellBeanList.size(); i++) {
            Row row = sheet.createRow(i);
            CellBean cellBean = cellBeanList.get(i);
            String[] bean = {"name", "lat_gd", "lng_gd", "remark"};
            for (int j = 0; j < bean.length; j++) {
                switch (j) {
                    case 0:
                        row.createCell(j).setCellValue(cellBean.getName());
                        break;
                    case 1:
                        row.createCell(j).setCellValue(cellBean.getLat_gd());
                        break;
                    case 2:
                        row.createCell(j).setCellValue(cellBean.getLng_gd());
                        break;
                    case 3:
                        row.createCell(j).setCellValue(cellBean.getRemark());
                        break;
                }
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("F:/JianfeiMa/2019_05_12_xml_excel/b.xls");
        workbook.write(fileOutputStream);
    }

    private static List<ZiQuDian> parseOld() {
        File file = new File("F:/JianfeiMa/2019_05_06/ziqudian.xml");
        List<ZiQuDian> ziQuDianList = new ArrayList<>();
        if (file.exists()) {
            System.out.println("文件存在");
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(file);
                NodeList nodeList = document.getElementsByTagName("ziqudians");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node instanceof Element) {
                        Element element = (Element) node;
                        NodeList nodeList1 = element.getElementsByTagName("ziqudian");
                        for (int j = 0; j < nodeList1.getLength(); j++) {
                            Node node1 = nodeList1.item(j);
                            if (node1 instanceof Element) {
                                ZiQuDian ziQuDian = new ZiQuDian();
                                Element element1 = (Element) node1;
                                String id = element1.getAttribute("id");
                                System.out.println("---自取点ID->>>>" + id);
                                ziQuDian.setId(Integer.valueOf(id));
                                NodeList nameNode = element1.getElementsByTagName("name");
                                NodeList lat_gd = element1.getElementsByTagName("lat_gd");
                                NodeList lng_gd = element1.getElementsByTagName("lng_gd");
                                String name = ((Element) nameNode.item(0)).getTextContent();
                                String latGD = ((Element) lat_gd.item(0)).getTextContent();
                                String lngGD = ((Element) lng_gd.item(0)).getTextContent();
                                int blackIndex = name.indexOf(" ");
                                name = name.substring(0, blackIndex);
                                System.out.println("------自取点的名字----->>>" + name);
                                System.out.println("------自取点的纬度----->>>" + latGD);
                                System.out.println("------自取点的经度----->>>" + lngGD);
                                ziQuDian.setName(name);
                                ziQuDian.setLatGD(latGD);
                                ziQuDian.setLngGD(lngGD);
                                ziQuDianList.add(ziQuDian);
                            }
                        }
                        //doc2XmlFile(document, "F:/JianfeiMa/2019_05_04_ziqudian_add_tw_1/ziqudian.xml");
                    }
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ziQuDianList;
    }

    public static boolean doc2XmlFile(Document document, String filename) {
        boolean flag = true;
        try {
            /** 将document中的内容写入文件中 */
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            /** 编码 */
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
        } catch (Exception ex) {
            flag = false;
            System.out.println("更新" + filename + "出错：" + ex);
            //System.out.println("更新" + filename + "出错：" + ex);
            ex.printStackTrace();
        }
        return flag;
    }
}
