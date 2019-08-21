package com.jianfei.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CellBean> rowList = new ArrayList<>();
    public static void main() throws IOException {
        //Workbook workbook = new HSSFWorkbook();
        openFile();
        System.out.println("-----------------以下是解析到数据放在内存中---------------------");
        System.out.println("--------------------------------------");
        for (int i = 0; i < rowList.size(); i++) {
            System.out.println("第" + i + "行的自取点名" + rowList.get(i).getName());
        }
    }

    public static List<CellBean> getRowList() {
        return rowList;
    }

    private static void openFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream = new FileInputStream("F:/JianfeiMa/2019_05_06/a.xls");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        if (workbook != null) {
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                if (sheet == null) {
                    continue;
                }
                sb.append(readExcelSheet(sheet));
            }
        }
        System.out.println(sb.toString());
    }

    private static String readExcelSheet(Sheet sheet) {
        StringBuilder sb = new StringBuilder();
        if(sheet != null){
            int rowNos = sheet.getLastRowNum();// 得到excel的总记录条数
            for (int i = 0; i <= rowNos; i++) {// 遍历行
                Row row = sheet.getRow(i);
                if(row != null){
                    int columNos = row.getLastCellNum();// 表头总共的列数
                    CellBean cellBean = new CellBean();
                    for (int j = 0; j < columNos; j++) {
                        Cell cell = row.getCell(j);
                        if(cell != null){
                            cell.setCellType(CellType.STRING);
                            sb.append(cell.getStringCellValue() + " ");
                            // System.out.print(cell.getStringCellValue() + " ");
                            System.out.println(cell.getStringCellValue());
                            switch (j) {
                                case 0:
                                    cellBean.setName(cell.getStringCellValue());
                                    break;
                                case 1:
                                    cellBean.setLat_gd(cell.getStringCellValue());
                                    break;
                                case 2:
                                    cellBean.setLng_gd(cell.getStringCellValue());
                                    break;
                                case 3:
                                    cellBean.setRemark(cell.getStringCellValue());
                                    break;
                            }
                        } else {
                            System.out.println("空的单元格");
                        }
                    }
                    rowList.add(cellBean);
                }
                System.out.println("----------------------");
            }
        }
        return sb.toString();
    }
}
