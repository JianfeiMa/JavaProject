package com.jianfei.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-11-08 10:51
 */
public class MainOfPOIStudy {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("C:/A.xlsx");
            //File file = new File("C:/Users/Administrator/Downloads/outexpres_ziqu.xls");
            //Workbook workbook = WorkbookFactory.create(inputStream);
            Workbook workbook = new HSSFWorkbook(inputStream);
            //获得一个工作薄中的所有纸张
            int numberOfSheets = workbook.getNumberOfSheets();
            //循环所有纸张
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            //开始遍历行
            for (int j = 0; j < lastRowNum; j ++) {
                Row row = sheet.getRow(j);
                //得到每一行的最后一个列的数字
                int lastCellNum = row.getLastCellNum();
                Cell cell = row.getCell(0);
                String cellValue = cell.getStringCellValue();
                System.out.println("打印每行第一个单元格的值:" + cellValue);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
