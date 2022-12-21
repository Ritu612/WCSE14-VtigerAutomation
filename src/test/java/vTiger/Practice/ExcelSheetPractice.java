package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step1: Load file Location Into File Input Stream
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//Step2: Create a work book
		Workbook wb=WorkbookFactory.create(fis);
		//Step3: Navigate to required sheet
		Sheet sh=wb.getSheet("Organizations");
		//Step4: Navigate to required Row
		Row rw=sh.getRow(7);
		//Step5 : Navigate to required Cell
		Cell ce=rw.getCell(4);
		//Step6:Capture the data present in that cell
        String value=ce.getStringCellValue();
        System.out.println(value);
	}

}
