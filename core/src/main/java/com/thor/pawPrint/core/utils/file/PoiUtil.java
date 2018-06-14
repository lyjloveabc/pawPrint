package com.thor.pawPrint.core.utils.file;

import com.thor.pawPrint.core.common.constant.BeanVariable;
import com.thor.pawPrint.core.common.constant.FileConstant;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.ObjectUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * EXCEL操作工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class PoiUtil {
    private static final short DEFAULT_COLUMN_WIDTH = 15;
    private static final int HSSFSHEET_TITLE_ROW_INDEX = 0;
    private static final int HSSFSHEET_HEADERS_ROW_INDEX = HSSFSHEET_TITLE_ROW_INDEX + 1;
    private static final int HSSFSHEET_CONTENT_ROW_INDEX = HSSFSHEET_HEADERS_ROW_INDEX + 1;

    //输出excel到文件
    public static boolean writeExcelToFile(Workbook wb, String excelPath, String excelName) {
        boolean flag = true;

        if (!ObjectUtils.isEmpty(excelPath)) {
            File excelDir = new File(excelPath);

            //没有文件夹则创建文件夹
            if (!excelDir.exists() && !excelDir.isDirectory()) {
                //创建文件夹成功
                if (!excelDir.mkdir()) {
                    //创建文件夹失败
                    flag = false;
                }
            }
        }

        String fileName = excelName + FileConstant.FILE_TYPE_2003;
        String fileNamePath = ObjectUtils.isEmpty(excelPath) ? fileName : excelPath + File.separator + fileName;

        //已经存在该名字的文件则删除该文件
        File file = new File(fileName);
        if (file.exists()) {
            if (!file.delete()) {
                //删除文件失败
                flag = false;
            }
        }

        if (flag) {
            flag = false;
            FileOutputStream fOut = null;

            try {
                //写入文件
                fOut = new FileOutputStream(fileNamePath);
                wb.write(fOut);
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert fOut != null;
                    fOut.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }

    public static <T> HSSFWorkbook toCreateWorkbook(Class<T> clz, List<T> data, String title, String[] headers, String sheetName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = getHSSFWorkbook();

        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(DEFAULT_COLUMN_WIDTH);

        //设置表格头部
        setHSSFSheetTitle(sheet, title);

        // 产生表格标题行
        setHSSFSheetHeaders(sheet, headers);

        //设置内容
        setHSSFSheetContent(sheet, clz, data);

        return wb;
    }

    public static HSSFWorkbook getHSSFWorkbook() {
        return new HSSFWorkbook();
    }

    public static <T> void setHSSFSheet(HSSFSheet sheet, Class<T> clz, List<T> data, String[] headers, String title) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(DEFAULT_COLUMN_WIDTH);

        //设置表格头部
        setHSSFSheetTitle(sheet, title);

        // 产生表格标题行
        setHSSFSheetHeaders(sheet, headers);

        //设置内容
        setHSSFSheetContent(sheet, clz, data);
    }

    private static void setHSSFSheetTitle(HSSFSheet sheet, String title) {
        //合并第一行
        sheet.addMergedRegion(new CellRangeAddress(HSSFSHEET_TITLE_ROW_INDEX, HSSFSHEET_TITLE_ROW_INDEX, 0, 16));

        // 生成一个样式
        HSSFCellStyle style = getHSSFCellStyleForTitle(sheet.getWorkbook());

        HSSFRow firstRow = sheet.createRow(HSSFSHEET_TITLE_ROW_INDEX);
        HSSFCell cell = firstRow.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue(title);
    }

    private static void setHSSFSheetHeaders(HSSFSheet sheet, String[] headers) {
        HSSFRow firstRow = sheet.createRow(HSSFSHEET_HEADERS_ROW_INDEX);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = firstRow.createCell(i);
            cell.setCellValue(headers[i]);
        }
    }

    private static <T> void setHSSFSheetContent(HSSFSheet sheet, Class<T> clz, List<T> data) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        //获取类属性
        BeanInfo beanInfo = Introspector.getBeanInfo(clz);
        //属性
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        int rowIndex = HSSFSHEET_CONTENT_ROW_INDEX;
        for (T temp : data) {
            HSSFRow row = sheet.createRow(rowIndex);

            int colIndex = 0;
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String key = propertyDescriptor.getName();

                //除去class属性
                if (!BeanVariable.CLASS.equals(key)) {
                    Method getter = propertyDescriptor.getReadMethod();
                    Object value = getter.invoke(temp);

                    HSSFCell cell = row.createCell(colIndex);
                    cell.setCellValue(String.valueOf(value));

                    colIndex++;
                }
            }

            rowIndex++;
        }
    }

    private static HSSFCellStyle getHSSFCellStyleForTitle(Workbook wb) {
        // 生成一个样式
        HSSFCellStyle style = (HSSFCellStyle) wb.createCellStyle();

        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        return style;
    }

}
