package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.io.FileHandler;

public class Parametrization {
	
	public static String getData(String sheetname,int row ,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("D:\\ExcelFile\\TextBook1.xlsx");
	    String value =WorkbookFactory.create(file).getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	    return value;
	    
	}

}
