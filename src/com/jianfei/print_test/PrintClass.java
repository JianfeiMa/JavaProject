package com.jianfei.print_test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.spire.pdf.PdfDocument;
import org.junit.Test;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;

public class PrintClass {

    /**
     * 获取打印机设备
     *
     * @param flavor
     * @param pas
     * @return
     */
    private PrintService[] getPrintServiceList(DocFlavor flavor, PrintRequestAttributeSet pas) {
        return PrintServiceLookup.lookupPrintServices(flavor, pas);
    }

    public void printService(String filePath) {

        File file = new File(filePath);

        System.out.println("文件名 >>>" + file.getName() + "文件大小 >>>" + file.getTotalSpace());

        // 构建打印请求属性集
        PrintRequestAttributeSet pas = new HashPrintRequestAttributeSet();

        // 设置打印格式
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

        // 默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

        System.out.println("默认打印机 >>>" + defaultService.getName());

        // 显示打印对话框
//        PrintService service = ServiceUI.printDialog(null, 200, 200, printService, defaultService, flavor, pas);

        FileInputStream fis = null;

        try {
            // 创建打印任务
            DocPrintJob job = defaultService.createPrintJob();
            fis = new FileInputStream(file);
            DocAttributeSet das = new HashDocAttributeSet();
            Doc doc = new SimpleDoc(fis, flavor, das);
            job.print(doc, pas);
        } catch (IOException | PrintException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void testPrint2(String file) {
        //加载文档
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromFile(file);
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat  = printerJob.defaultPage();
        Paper paper = pageFormat.getPaper();
        //删除默认页边距
        paper.setImageableArea(0, 0, pageFormat.getWidth(), pageFormat.getHeight());
        //设置打印份数
        printerJob.setCopies(1);
        pageFormat.setPaper(paper);
        printerJob.setPrintable(pdfDocument, pageFormat);
        try {
            printerJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

    private void testPrint3() {
        //加载文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("Sample.pdf");
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat  = loPrinterJob.defaultPage();
        Paper loPaper = loPageFormat.getPaper();
        //删除默认页边距
        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(pdf,loPageFormat);
        //显示打印对话框
        if (loPrinterJob.printDialog()) {
            try {
                loPrinterJob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }

    private void testPrint4() {
        //加载文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("Sample.pdf");
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat  = loPrinterJob.defaultPage();
        //设置打印纸张大小
        Paper loPaper = loPageFormat.getPaper();
        loPaper.setSize(500,600);
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(pdf,loPageFormat);
        try {
            loPrinterJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

    private void testPrint1() {
//        File file = new File("D:\\advertisement_sub24.png");
        File file = new File("G:\\test\\test.pdf");

        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        DocFlavor[] docFlavors = defaultService.getSupportedDocFlavors();
        for (DocFlavor docFlavor : docFlavors) {
            System.out.println("support type:" + docFlavor.toString());
        }

        Object inputStream = null;
        if (defaultService != null)
            try {
                DocPrintJob docPrintJob = defaultService.createPrintJob();
                inputStream = new FileInputStream(file);
                HashDocAttributeSet docAttributeSet = new HashDocAttributeSet();
                String testContent = "abc123";
                Doc doc = new SimpleDoc(testContent, DocFlavor.CHAR_ARRAY.TEXT_PLAIN, docAttributeSet);
                System.out.println("print job start");
                docPrintJob.print(doc, printRequestAttributeSet);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null)
                    try {
                        ((InputStream)inputStream).close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
    }

    private String createPDFDocument() {
        String file = "G:\\test\\Helloworld.PDF";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            document.add(new Paragraph("Hello World"));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void main(String[] args) {
//        new PrintClass().printService("G:/test/test.docx");
        PrintClass printClass = new PrintClass();
        String file = printClass.createPDFDocument();
        printClass.testPrint2(file);
    }
}
