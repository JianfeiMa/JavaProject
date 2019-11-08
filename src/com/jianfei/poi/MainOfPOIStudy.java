package com.jianfei.poi;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-11-08 10:51
 */
public class MainOfPOIStudy {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("H:/F/JianfeiMa/2019_05_06/a.xls");
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获得一个工作薄中的所有纸张
            int numberOfSheets = workbook.getNumberOfSheets();
            //循环所有纸张
            for (int i = 0; i < numberOfSheets; i ++) {
                Sheet sheet = workbook.getSheetAt(i);
                int lastRowNum = sheet.getLastRowNum();
                System.out.println("打印第" + i + "张纸张的的最后一行的行数->" + lastRowNum);
                //开始遍历行
                for (int j = 0; j < lastRowNum; j ++) {
                    Row row = sheet.getRow(j);
                    //得到每一行的最后一个列的数字
                    int lastCellNum = row.getLastCellNum();
                    Cell cell = row.getCell(0);
                    String cellValue = cell.getStringCellValue();
                    System.out.println("打印每行第一个单元格的值:" + cellValue);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
