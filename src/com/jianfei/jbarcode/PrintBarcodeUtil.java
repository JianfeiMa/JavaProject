package com.jianfei.jbarcode;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-05-25 10:40
 */

import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code128Encoder;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.WideRatioCodedPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.io.*;

public class PrintBarcodeUtil {

    public static void main(String[] args) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("F:\\Q20052417.png"));
            ByteArrayOutputStream byteArrayOutputStream = getPrintBarcodeUtil("Q20052417");
            byteArrayOutputStream.writeTo(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ByteArrayOutputStream getPrintBarcodeUtil(String text) {
        try {
            JBarcode jBarcode = new JBarcode(Code128Encoder.getInstance(), WidthCodedPainter.getInstance(), BaseLineTextPainter.getInstance());
//            BufferedImage localBufferedImage = jBarcode.createBarcode(text);
            //saveToPNG(localBufferedImage, "Test.png");
            jBarcode.setEncoder(Code128Encoder.getInstance());
            jBarcode.setPainter(WideRatioCodedPainter.getInstance());
            jBarcode.setTextPainter(BaseLineTextPainter.getInstance());
            jBarcode.setShowCheckDigit(false);
            // xx
            //text = "JBARCODE-39";
            BufferedImage bufferedImage = jBarcode.createBarcode(text);
            ByteArrayOutputStream byteArrayOutputStream = saveToFile(bufferedImage, "Code128Encoder", "png");
            return byteArrayOutputStream;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return null;
    }

    private static ByteArrayOutputStream saveToFile(BufferedImage paramBufferedImage, String paramString1, String paramString2) {
        ByteArrayOutputStream localFileOutputStream = null;
        try {
            localFileOutputStream = new ByteArrayOutputStream();
            ImageUtil.encodeAndWrite(paramBufferedImage, paramString2, localFileOutputStream, 96, 96);
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return localFileOutputStream;
    }
}
