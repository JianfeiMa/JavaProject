package com.jianfei.imageio;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-11-25 12:11
 */
public class Main {
    public static void main(String[] args) {
        Image image = null;
        try {
            URL url = new URL("http://www.buyuphk.com/webshop2/images/header/event_mainpages_banner_1100x475px.png");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }
}
