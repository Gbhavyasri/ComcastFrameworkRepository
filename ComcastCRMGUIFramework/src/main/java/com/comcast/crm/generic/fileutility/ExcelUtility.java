package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
   public String getDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
	   FileInputStream fs=new FileInputStream("./testdata/TestData.xlsx");
	   Workbook book=WorkbookFactory.create(fs);
	   Sheet sheet1=book.getSheet(sheet);
	   Row row1=sheet1.getRow(row);
	   Cell cell1=row1.getCell(cell);
	   String data=cell1.getStringCellValue();
	   book.close();
	   return data;
   }
   
   public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
	   FileInputStream fs=new FileInputStream("./testdata/TestData.xlsx");
	   Workbook book=WorkbookFactory.create(fs);
	   int rowCount=book.getSheet(sheet).getLastRowNum();
	   book.close();
	   return rowCount;
   }
   
   public void SetDataIntoExcel(String sheet,int RowNum,int cellNum,String Data) throws EncryptedDocumentException, IOException {
	   FileInputStream fs=new FileInputStream("./testdata/TestData.xlsx");
	   Workbook book=WorkbookFactory.create(fs);
	  Cell cell1= book.getSheet(sheet).getRow(RowNum).createCell(cellNum);
	  FileOutputStream fos=new FileOutputStream("./testdata/TestData.xlsx");
	  book.write(fos);
	  book.close();
	  
	   
   }
}
