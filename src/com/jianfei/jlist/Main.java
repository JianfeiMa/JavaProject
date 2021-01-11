package com.jianfei.jlist;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-07-24 17:46
 */
public class Main {
    public static void main(String[] args) {
        String path = "C:/Pictures/";
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        //DefaultListModel<JPanel> listModel = new DefaultListModel<JPanel>();
        Vector<JPanel> data = new Vector<>();
        int count = 0;
        try {
            for (int i = 0; i < listOfFiles.length; i++) {
                String name = listOfFiles[i].toString();
                if (name.endsWith("png")) {
                    ImageIcon ii = new ImageIcon(ImageIO.read(listOfFiles[i]));
                    JLabel jLabel = new JLabel("test");
                    JLabel jLabel1 = new JLabel(ii);
                    JPanel jPanel = new JPanel();
                    jPanel.add(jLabel);
                    //jPanel.add(jLabel1);
                    //listModel.add(count++, jPanel);
                    data.add(jPanel);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JList lsm = new JList(data);
        lsm.setVisibleRowCount(1);

        frame.add(new JScrollPane(lsm));

        frame.pack();
        frame.setVisible(true);
    }
}
