package com.jianfei.jlist;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class test2 extends JFrame{

    public test2(){
        setBounds(200,200,500,500);
        setLayout(null);

        Vector<JPanel> v=new Vector<JPanel>();

        //JPanel的設置，並加入到Vector中
        for(int i=0;i<20;i++)
        {
            JPanel pnl=new JPanel();
            JButton btn=new JButton("按鈕");
            JLabel lab=new JLabel("文字");
            pnl.setLayout(null);
            btn.setBounds(5,5,60,30);
            lab.setBounds(70,5,50,30);
            pnl.add(btn);
            pnl.add(lab);

            v.add(pnl);
        }

        //用v建立JList
        JList list=new JList(v);
        list.setBounds(10,10,300,400);
        list.setLayout(null);
        list.setFixedCellHeight(50);//設定每個JList的高度

        //這個決定JPanel的顯示，參數是一個ListCellRenderer介面的實作
        list.setCellRenderer(new ImageListCellRenderer());

        add(list);
        //JScrollPane ps = new JScrollPane(list);
        //getContentPane().add(ps, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args){
        new test2();

    }

    //這個就是實作了 ListCellRenderer的class
    private class ImageListCellRenderer implements ListCellRenderer
    {
        public Component getListCellRendererComponent(JList jlist, Object value,
                                                      int cellIndex, boolean isSelected, boolean cellHasFocus) {

            if (value instanceof JPanel)
            {
                Component component = (Component) value;
                component.setBackground (isSelected ? Color.cyan : Color.white);//設定JList被選取時的底色改變
                return component;
            }else
                return new JLabel("???");

        }

    }
}
