package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *  This class contains generic methods related to excel sheet
 * @author DELL
 *
 */
public class ExcelFileUtility
{
   
	/**
	 * This method will take the value from excel sheet for respective sheet name 
	 * row number and cell number
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
   {
	   FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
	     Workbook wb = WorkbookFactory.create(fis);
	     Sheet sh=wb.getSheet(sheetName);
	     Row rw = sh.getRow(rowNum);
	     Cell cell = rw.getCell(cellNum);
	     String value = cell.getStringCellValue();
	     wb.close();
	     return value;
   }
	
	/**
	 * This method will give the total row count in the sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	/**
	 * This method will write data into excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNum);
		Cell ce = rw.createCell(cellNum);
		// Set the value in cell
		ce.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(IConstantUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
		
		
	}
	/**
	 * This method will read multiple data into  the data provider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataIntoDataProvider(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum(); //----row
		int lastCell=sh.getRow(0).getLastCellNum(); //----cell
		
		Object[][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	

}



