package com.jianfei.print_test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFilesImpl;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.html.TagProcessorFactory;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.mysun.misc.BASE64Encoder;
import com.spire.pdf.PdfDocument;
import org.junit.Test;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.nio.charset.Charset;

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

    public void htmlToPdf(String targetPdfFilePath, String htmlContent) {
//        Document document = new Document();
//        try {
//            // 建立书写器
//            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(targetPdfFilePath));
//            document.open();
//            XMLWorkerFontProvider xmlWorkerFontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
//            xmlWorkerFontProvider.register("simhei.ttf");
//            XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
//            xmlWorkerHelper.parseXHtml(pdfWriter, document, new ByteArrayInputStream(htmlContent.getBytes()), Charset.forName("UTF-8"), xmlWorkerFontProvider);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } finally {
//            document.close();
//        }

        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(targetPdfFilePath));
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(htmlContent.getBytes("Utf-8")), Charset.forName("UTF-8"));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * HTML TO PDF 到指定目录
     * @param html  html内容
     * @param os PDF文件生成目录
     */
    public static void writeToOutputStreamAsPDF(InputStream html, OutputStream os) {
        try {
            Document document = new Document(PageSize.A4,36, 36, 36, 36);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, os);
            document.open();
            //BASE64图片处理
            final TagProcessorFactory tagProcessorFactory = Tags.getHtmlTagProcessorFactory();
            tagProcessorFactory.removeProcessor(HTML.Tag.IMG);
            tagProcessorFactory.addProcessor(new ImageTagProcessor(), HTML.Tag.IMG);

            final CssFilesImpl cssFiles = new CssFilesImpl();
            cssFiles.add(XMLWorkerHelper.getInstance().getDefaultCSS());
            final StyleAttrCSSResolver cssResolver = new StyleAttrCSSResolver(cssFiles);
            final HtmlPipelineContext hpc = new HtmlPipelineContext(new CssAppliersImpl(new XMLWorkerFontProvider()));
            hpc.setAcceptUnknown(true).autoBookmark(true).setTagFactory(tagProcessorFactory);
            final HtmlPipeline htmlPipeline = new HtmlPipeline(hpc, new PdfWriterPipeline(document, pdfWriter));
            final Pipeline<?> pipeline = new CssResolverPipeline(cssResolver, htmlPipeline);

            final XMLWorker worker = new XMLWorker(pipeline, true);
            final Charset charset = Charset.forName("UTF-8");
            final XMLParser xmlParser = new XMLParser(true, worker, charset);

            xmlParser.parse(html,charset);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String createPDFDocument(String content) {
        String file = "G:\\test\\Helloworld-" + content + ".pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            document.add(new Paragraph("Hello World  这是第" + content + "张打印"));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        Container container = jFrame.getContentPane();
        container.setLayout(new BorderLayout());
        jFrame.setBounds(0, 0, 400, 500);
        jFrame.setDefaultCloseOperation(2);

        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new FlowLayout());
        jPanelNorth.add(new JLabel("test"));
        JButton button = new JButton("批量打印3张");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("G:\\test\\4308977999254.png");
                    InputStream inputStream = null;
                    byte[] bytes = null;
                    inputStream = new FileInputStream(file.getAbsolutePath());
                    bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    inputStream.close();
                    BASE64Encoder base64Encoder = new BASE64Encoder();
                    String message = base64Encoder.encode(bytes);
//            message = message.replace("+", "%2B");
                    message = message.replaceAll("[\\s*\t\n\r]", "");
                    message = message.replace("\\n", "");
                    message = "data:image/png;base64," + message;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("<!doctype html>");
                    stringBuilder.append("<html lang=\"en\">");
                    stringBuilder.append("<head>");
                    stringBuilder.append("<title>Document</title>");
                    stringBuilder.append("</head>");
                    stringBuilder.append("<body style=\"font-size:12.0pt; font-family:微软雅黑\">");
                    stringBuilder.append("<div>");
                    stringBuilder.append("This is English");
                    stringBuilder.append("</div>");
                    stringBuilder.append("<div>");
                    stringBuilder.append("这是中文文字");
                    stringBuilder.append("</div>");
                    stringBuilder.append("<div>");
                    stringBuilder.append("123456");
                    stringBuilder.append("</div>");
                    stringBuilder.append("<img src=\"");
                    stringBuilder.append(message);
                    stringBuilder.append("\" with=\"40px\" height=\"20px\"/>");
                    stringBuilder.append("</body>");
                    stringBuilder.append("</html>");
                    PrintClass printClass = new PrintClass();
                    //printClass.htmlToPdf("G:\\test\\test_english_chines_digital.pdf", stringBuilder.toString());
                    writeToOutputStreamAsPDF(new ByteArrayInputStream(stringBuilder.toString().getBytes()), new FileOutputStream(new File("G:\\test\\test_english_chines_digital.pdf")));
                    for (int i = 0; i < 5; i ++) {
                        System.out.println("on click");
                        //PrintClass printClass = new PrintClass();
                        //String file = printClass.createPDFDocument(String.valueOf(i));
                        //printClass.testPrint2(file);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        container.add(jPanelNorth, "North");
        container.add(button);

        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setName("jPanelCenter");
        jPanelCenter.setLayout(null);
        JLabel jLabelOutGoodsNumberKey = new JLabel("OutGoodsNumber：");
        jLabelOutGoodsNumberKey.setBounds(10, 0, 120, 20);
        jLabelOutGoodsNumberKey.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jLabelOutGoodsNumberValue = new JLabel("888");
        jLabelOutGoodsNumberValue.setBounds(130, 0, 120, 20);
        jLabelOutGoodsNumberValue.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jLabelGoodsTypeKey = new JLabel("GoodsType：");
        jLabelGoodsTypeKey.setBounds(10, 20, 120, 20);
        jLabelGoodsTypeKey.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jLabelGoodsTypeValue = new JLabel("GeneralGoods");
        jLabelGoodsTypeValue.setBounds(130, 20, 120, 20);
        jLabelGoodsTypeValue.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jLabelChannelKey = new JLabel("Channel：");
        jLabelChannelKey.setBounds(10, 40, 120, 20);
        jLabelChannelKey.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jLabelChannelValue = new JLabel("Sea");
        jLabelChannelValue.setBounds(130, 40, 120, 20);
        jLabelChannelValue.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(jPanelCenter, "South");
        jFrame.setVisible(true);
    }
}
