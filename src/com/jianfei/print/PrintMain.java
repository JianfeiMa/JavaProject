package com.jianfei.print;

import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-11-25 10:31
 */
public class PrintMain {
    public static void main(String[] args) {
        File file = new File("C:\\study_char_one.txt");
        HashPrintRequestAttributeSet hashPrintRequestAttributeSet = new HashPrintRequestAttributeSet();
        DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(docFlavor, hashPrintRequestAttributeSet);
        for (int i = 0; i < printServices.length; i ++) {
            System.out.println(printServices[i]);
        }
        PrintService myPrintService = printServices[0];
        AttributeSet attributeSet = myPrintService.getAttributes();
        Attribute[] attributes = attributeSet.toArray();
        for (Attribute attribute : attributes) {
            System.out.println("属性名：" + attribute.getName() + ";属性值：" + attribute.getClass().toString());
        }
        // 显示打印对话框
        try {
            PrintService printService = ServiceUI.printDialog(null, 200, 200, printServices, printServices[0], docFlavor, hashPrintRequestAttributeSet);
            DocPrintJob docPrintJob = printService.createPrintJob();
            FileInputStream fileInputStream = new FileInputStream(file);
            DocAttributeSet docAttributeSet = new HashDocAttributeSet();
            Doc doc = new SimpleDoc(fileInputStream, docFlavor, docAttributeSet);
            //请求一个彩色打印机
            hashPrintRequestAttributeSet.add(Chromaticity.COLOR);
            //请求横向模式
            hashPrintRequestAttributeSet.add(OrientationRequested.LANDSCAPE);
            //美国Letter大小的纸质属性
            hashPrintRequestAttributeSet.add(MediaSizeName.NA_LETTER);
            // European A4 paper
            hashPrintRequestAttributeSet.add(MediaSizeName.ISO_A4);
            //请求装订
            hashPrintRequestAttributeSet.add(Finishings.STAPLE);
            //整理多个副本
            hashPrintRequestAttributeSet.add(SheetCollate.COLLATED);
            //请求双面
            hashPrintRequestAttributeSet.add(Sides.DUPLEX);
            // 2页到一个工作表
            hashPrintRequestAttributeSet.add(new NumberUp(2));
            //多少个副本
            hashPrintRequestAttributeSet.add(new Copies(2));
            docPrintJob.print(doc, hashPrintRequestAttributeSet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (PrintException e) {
            e.printStackTrace();
        }
    }

//    private void printFrameAction() {
//        Toolkit kit = Toolkit.getDefaultToolkit(); // 获取工具箱
//        Properties props = new Properties();
//        props.put("awt.print.printer", "durango");// 设置打印属性
//        props.put("awt.print.numCopies", "2");
//        if(kit != null) {
//            // 获取工具箱自带的打印对象
//            PrintJob printJob = kit.getPrintJob(this, "Print Frame", props);
//            if(printJob != null) {
//                Graphics pg = printJob.getGraphics();// 获取打印对象的图形环境
//                if(pg != null) {
//                    try {
//                        this.printAll(pg);// 打印该窗体及其所有的组件
//                    } finally {
//                        pg.dispose();// 注销图形环境
//                    }
//                }
//                printJob.end();// 结束打印作业
//            }
//        }
//    }
}
