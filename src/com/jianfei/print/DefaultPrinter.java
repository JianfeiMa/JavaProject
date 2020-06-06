package com.jianfei.print;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintJobAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-06-03 14:03
 */
public class DefaultPrinter {
    public static void main(String[] args) {
        String printObject = "this is print content";
        DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob docPrintJob = printService.createPrintJob();

        DocAttributeSet docAttributeSet = new HashDocAttributeSet();

        File file = new File("C:\\study_char_one.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Doc doc = new SimpleDoc(fileInputStream, docFlavor, docAttributeSet);

        HashPrintRequestAttributeSet hashPrintRequestAttributeSet = new HashPrintRequestAttributeSet();
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
//        HashPrintJobAttributeSet hashPrintJobAttributeSet = new HashPrintJobAttributeSet();

        try {
            docPrintJob.print(doc, hashPrintRequestAttributeSet);
        } catch (PrintException e) {
            e.printStackTrace();
        }
    }
}
