package com.jianfei.print_test;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2021-01-11 15:13
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrintJFrame
{
    private JFrame jFrame;

    public PrintJFrame(String subOutGoodsNumber, String codeUrl)
    {
        this.jFrame = new JFrame();
        Container container = this.jFrame.getContentPane();
        container.setLayout(new BorderLayout());
        this.jFrame.setBounds(0, 0, 400, 500);
        this.jFrame.setDefaultCloseOperation(2);

        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new FlowLayout());
        jPanelNorth.add(new JLabel("QiuPing Express Print"));
        container.add(jPanelNorth, "North");

        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setName("jPanelCenter");
        jPanelCenter.setLayout(null);
        JLabel jLabelOutGoodsNumberKey = new JLabel("OutGoodsNumber：");
        jLabelOutGoodsNumberKey.setBounds(10, 0, 120, 20);
        jLabelOutGoodsNumberKey.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel jLabelOutGoodsNumberValue = new JLabel(subOutGoodsNumber);
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
        Image image = null;
        try {
            String sUrl = "http://129.226.119.115/" + codeUrl;
            System.out.println("codeUrl:" + sUrl);

            URL url = new URL(sUrl);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel jLabelImageIcon = new JLabel(new ImageIcon(image));
        jLabelImageIcon.setBounds(10, 60, 200, 60);

        jPanelCenter.add(jLabelOutGoodsNumberKey);
        jPanelCenter.add(jLabelOutGoodsNumberValue);
        jPanelCenter.add(jLabelGoodsTypeKey);
        jPanelCenter.add(jLabelGoodsTypeValue);
        jPanelCenter.add(jLabelChannelKey);
        jPanelCenter.add(jLabelChannelValue);
        jPanelCenter.add(jLabelImageIcon);
        container.add(jPanelCenter, "Center");

        JPanel jPanelSouth = new JPanel();
        JButton jButton = new JButton("Print");
        jButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                PrintJFrame.this.printFrameAction(PrintJFrame.this.jFrame);
            }
        });
        jPanelSouth.add(jButton);
        container.add(jPanelSouth, "South");

        this.jFrame.setVisible(true);
    }

    public void close() {
        if (this.jFrame != null)
            this.jFrame.dispose();
    }

    private void printFrameAction(JFrame jFrame)
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Properties props = new Properties();
        props.put("awt.print.printer", "durango");
        props.put("awt.print.numCopies", "2");
        if (kit != null)
        {
            PrintJob printJob = kit.getPrintJob(jFrame, "Print Frame", props);
            if (printJob != null) {
                Graphics pg = printJob.getGraphics();

                if (pg != null) {
                    try
                    {
                        System.out.println("start print jJframe");
                        jFrame.printAll(pg);
                    }
                    finally
                    {
                        pg.dispose();
                    }
                }
                printJob.end();
            }
        }
    }
}
