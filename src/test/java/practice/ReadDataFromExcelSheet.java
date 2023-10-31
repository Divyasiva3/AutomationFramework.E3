package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step1 open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\AdvanceTestData.xlsx");
		
		//step2 create workbook
		Workbook wb=WorkbookFactory.create(fis);
		
		//step3 Navigate to required sheet
		Sheet sh = wb.getSheet("contact");
		//step4 Navigate to required row
		Row rw = sh.getRow(1);
		//step5 navigate to required cell
		Cell cl = rw.getCell(2);
		//step6 capture the value and print
		String value = cl.getStringCellValue();
		System.out.println(value);

	}

}
