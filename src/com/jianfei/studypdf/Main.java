package com.jianfei.studypdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
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
import com.jianfei.print_test.ImageTagProcessor;
import com.jianfei.print_test.PrintClass;
import com.mysun.misc.BASE64Encoder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2021-03-20 14:06
 */
public class Main {
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
                    File file = new File("G:\\test\\test.png");
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
                    stringBuilder.append("\" with=\"50px\" height=\"30px\"/>");
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
}
