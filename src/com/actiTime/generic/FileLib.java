package com.actiTime.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

	public String getPropertyData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/actitimelogin.property");
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	public String getExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./data/testscript1.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getCell(cell).toString();
	}
	public void setExceldata(String sheetName,int row,int cell, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./data/testscript1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fout =new FileOutputStream("./data/testscript1.xlsx");
		wb.write(fout);
		wb.close();
	}
}
