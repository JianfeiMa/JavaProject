package com.jianfei.poi;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-08-21 17:55
 */
public class Test33 {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\A.xlsx");
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int row = sheet.getLastRowNum();
            for (int i = 0; i < row; i ++) {
                Row row0 = sheet.getRow(i);
                Cell cell = row0.getCell(0);
                cell.setCellType(CellType.STRING);
                String va = cell.getStringCellValue();
                System.out.println(va);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
