package com.jianfei.jlist;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.EventObject;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.BevelBorder;

public class test3 extends JFrame{

    //代替JList的JPanel
    JPanel list=new JPanel(){
        //覆寫
        public Component add(Component c)
        {
            /*
             *c就是加入List的JPanel，它的x、width、height都是固定的，
             *只有y需要跟著加入的數量而跟著變動，
             * 所以要先取得list的元件數，然後再乘與適當的距離
             * 因為c的固定高度是50，加上給它5的間距，所以是乘與55
             * 另外的+5是第一個元件與上邊框的距離                ，
             */
            c.setBounds(5,getComponentCount()*55+5,290,50);
            super.add(c);//設定好之後，加入list

            /*
             *如果加入的數量總高度超過list的高度，就動態的增加高度，
             *JPanel要用setPreferredSize(new Dimension(int,int))這個方法改變大小，
             *才能讓捲軸有作用
             */
            if(getHeight()<=getComponentCount()*55+5)
                setPreferredSize(new Dimension(300, getComponentCount()*55+5));

            return c;
        }
    };

    JScrollPane jscrollPane=new JScrollPane(list);//捲軸

    //這是用來控制List點選時，底色的切換
    JPanel tmpPnl=null;
    //做List點選時底色切換的事件處理
    MouseAdapter listener=new MouseAdapter(){
        public void mousePressed(MouseEvent e){
            JPanel pnl=(JPanel)e.getSource();

            //將前一次的底色還原
            if(tmpPnl!=null)
                tmpPnl.setBackground(Color.white);
            //設定點選的底色
            pnl.setBackground(Color.cyan);
            tmpPnl=pnl;//標記起來，作為下一次切換時，還原底色使用
        }
    };

    //JButton的事件處理
    ActionListener Alistener=new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
            JButton btn= (JButton)e.getSource();
            System.out.println("JButton 事件:"+btn.getText());
        }
    };

    public test3() {
        setBounds(200,200,500,500);
        setLayout(null);

        list.setBackground(Color.white);
        jscrollPane.setBounds(10,10,325,400);

        list.setLayout(null);
        add(jscrollPane);

        /*要加入List的項目的設置
         *將元件放入JPanel中，再把這個JPanel放進List
         */
        for(int i=0;i<15;i++)
        {
            JPanel pnl=new JPanel();
            pnl.setLayout(null);
            pnl.setBackground(Color.white);

            JButton btn=new JButton("按鈕"+(i+1));
            btn.setBounds(5,5,100,35);
            pnl.add(btn);
            btn.addActionListener(Alistener);

            if (i % 2 == 0) {
                ImageIcon imageIcon = null;
                try {
                    File file = new File("C:/Pictures/1595580269141.png");
                    imageIcon = new ImageIcon(ImageIO.read(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JLabel jLabelImage = new JLabel(imageIcon);
                jLabelImage.setBounds(130, 5, 100, 35);
                pnl.add(jLabelImage);

                list.add(pnl);//加入list
            } else {
                JLabel lab=new JLabel("文字");
                lab.setBounds(130,5,100,35);
                pnl.add(lab);
                list.add(pnl);
            }

            pnl.addMouseListener(listener);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
//        String version = "1.1.1";
//        String[] versions = version.split(".");
//        for (int i = 0; i < versions.length; i ++) {
//            System.out.println(versions[i]);
//        }
        new test3();
    }

}
