package com.fanhanfei.springstudy;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.util.Lists;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
@Slf4j
public class readExcel {

    public static void main(String[] args) throws IOException {
//        fail("Not yet implemented");/Users/zhangjunshuai/Downloads/无标题.xlsx
        String file_dir = "/Users/zhangjunshuai/Downloads/789.xlsx";
        Workbook book = null;
        book = getExcelWorkbook(file_dir);
        Sheet sheet = getSheetByNum(book,0);

        int lastRowNum = sheet.getLastRowNum();

        ArrayList<HashMap<Integer, String>> listMaps = new ArrayList<>();

        for(int i = 0 ; i <= lastRowNum ; i++){
            Row row = null;
            row = sheet.getRow(i);
            if( row != null ) {
                int lastCellNum = row.getLastCellNum();
                Cell cell = null;
                HashMap<Integer, String> integerStringHashMap = new HashMap<>();

                for (int j = 0; j < lastCellNum; j++) {
                    cell = row.getCell(j);
                    String result = null;
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            result = cell.getRichStringCellValue().getString();
                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                // 处理日期格式、时间格式
                                SimpleDateFormat sdf = null;
                                if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                        .getBuiltinFormat("h:mm")) {
                                    sdf = new SimpleDateFormat("HH:mm");
                                } else {// 日期
                                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                                }
                                Date date = cell.getDateCellValue();
                                result = sdf.format(date);
                            } else if (cell.getCellStyle().getDataFormat() == 58) {
                                // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                double value = cell.getNumericCellValue();
                                Date date = org.apache.poi.ss.usermodel.DateUtil
                                        .getJavaDate(value);
                                result = sdf.format(date);
                            }  else {
                                result = String.valueOf(cell.getNumericCellValue());
                                result = String.format("%.0f", cell.getNumericCellValue());
                            }
                            break;

                        case Cell.CELL_TYPE_BOOLEAN:
                            result =  String.valueOf(cell.getBooleanCellValue());
                            break;

                        case Cell.CELL_TYPE_FORMULA:
                            result = String.valueOf(cell.getCellFormula());
                            break;

                        default:
                            break;
                    }
                    integerStringHashMap.put(j,result);
                }
                listMaps.add(integerStringHashMap);
            }
        }

//        selectSkuId(listMaps);
        updateStock(listMaps);
    }

    public  static void selectSkuId(ArrayList<HashMap<Integer, String>> listMaps){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from sku where sku_code in (");
        for (HashMap<Integer,String> map: listMaps
                ) {
            stringBuilder.append(map.get(0));
            stringBuilder.append(",");
        }
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
    }

    public  static void updateStock(ArrayList<HashMap<Integer, String>> listMaps){
        ArrayList<String> Sku0strings = new ArrayList<>();
        ArrayList<String> Sku0stringsprintPhy = new ArrayList<>();
        ArrayList<String> Sku0stringsprintsales = new ArrayList<>();

        for (HashMap<Integer,String> map: listMaps ) {
            Integer integer = Integer.valueOf(map.get(3)) - Integer.valueOf(map.get(4));
            if (!Integer.valueOf(map.get(3)).equals(0)) {
                System.out.println("UPDATE physical_ware_sku_sales set real_stock_num = real_stock_num" + integer + ",virtual_stock_num=virtual_stock_num" + integer + " WHERE ware_id=40 and real_stock_num>0 and sku_id=" + map.get(1) + ";");
                System.out.println("UPDATE sku_sales set real_stock_num = real_stock_num" + integer + ",virtual_stock_num =virtual_stock_num" + integer + " WHERE real_stock_num >0 and sku_id=" + map.get(1) + ";");
            } else {
                Sku0strings.add(map.get(0));
                String updatesales = "UPDATE sku_sales set real_stock_num = real_stock_num" + integer + ",virtual_stock_num =virtual_stock_num" + integer + " WHERE sku_id=" + map.get(1) + ";";
                String updatePhy = "UPDATE physical_ware_sku_sales set real_stock_num = real_stock_num =0 ,virtual_stock_num=virtual_stock_num =0 WHERE ware_id=40 and real_stock_num="+map.get(4)+" and sku_id=" + map.get(1) + ";";
                Sku0stringsprintPhy.add(updatePhy);
                Sku0stringsprintsales.add(updatesales);

            }
        }
        System.out.println("===========================");
        for (String str:Sku0stringsprintPhy) {
            System.out.println(str);
        }
        System.out.println("===========================");
        for (String str:Sku0stringsprintsales) {
            System.out.println(str);
        }

        System.out.println("===========================");
        for (String str:Sku0strings) {
            System.out.println(str);
        }
    }


    public  static void old(ArrayList<HashMap<Integer, String>> listMaps){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        for (HashMap<Integer,String> map: listMaps
                ) {
            String s = stringStringHashMap.get(map.get(0));
            if (s == null){
                stringStringHashMap.put(map.get(0),map.get(0));
            }else {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO purchase_order_kd( kpo_code, vendor, vendor_name, date_create)  VALUES (");
            stringBuilder.append("'");
            stringBuilder.append(map.get(0));
            stringBuilder.append("',");
            stringBuilder.append("'");
            stringBuilder.append("-1");
            stringBuilder.append("',");
            stringBuilder.append("'");
            stringBuilder.append(map.get(1));
            stringBuilder.append("',");
            stringBuilder.append("'2018-10-01 00:00:00');");
//            System.out.println(stringBuilder.toString());

        }
    }

    public static Sheet getSheetByNum(Workbook book,int number){
        Sheet sheet = null;
        try {
            sheet = book.getSheetAt(number);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return sheet;
    }
    public static Workbook getExcelWorkbook(String filePath) throws IOException{
        Workbook book = null;
        File file  = null;
        FileInputStream fis = null;

        try {
            file = new File(filePath);
            if(!file.exists()){
                throw new RuntimeException("文件不存在");
            }else{
                fis = new FileInputStream(file);
                book = WorkbookFactory.create(fis);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if(fis != null){
                fis.close();
            }
        }
        return book;
    }
}
