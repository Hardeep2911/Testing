package com.inetBanking.utillities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XlUtils {

	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static Row row;
	public static Cell cell;
	public static FileOutputStream fos;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {

		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;

	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {

		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row  = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;

	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException {

		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row  = sheet.getRow(rownum);
		cell = row.getCell(column);
		String data;
		DataFormatter formatter = new DataFormatter();
		String celldata =formatter.formatCellValue(cell);
		workbook.close();
		fis.close();
		return celldata;

	}
	
	public static void setCellData (String xlfile, String xlsheet, int rownum, int column, String data) throws IOException
	{
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.createCell(column);
		cell.setCellValue(data);
		fos = new FileOutputStream(xlfile);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();		
		
	}
}
