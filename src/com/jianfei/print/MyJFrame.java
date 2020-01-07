package com.jianfei.print;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-11-30 16:59
 */
public class MyJFrame extends JFrame {

    public static void main(String[] args) {
        new MyJFrame("aa").printFrameAction();
    }

    public MyJFrame(String title) throws HeadlessException {
        super(title);
    }

    private void printFrameAction() {
        Toolkit kit = Toolkit.getDefaultToolkit(); // 获取工具箱
        Properties props = new Properties();
        props.put("awt.print.printer", "durango");// 设置打印属性
        props.put("awt.print.numCopies", "2");
        if(kit != null) {
            // 获取工具箱自带的打印对象
            PrintJob printJob = kit.getPrintJob(this, "Print Frame", props);
            if(printJob != null) {
                Graphics pg = printJob.getGraphics();// 获取打印对象的图形环境
                if(pg != null) {
                    try {
                        this.printAll(pg);// 打印该窗体及其所有的组件
                    } finally {
                        pg.dispose();// 注销图形环境
                    }
                }
                printJob.end();// 结束打印作业
            }
        }
    }
}
