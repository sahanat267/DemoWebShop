package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	public String getPropertyData(String key) throws IOException {
		FileInputStream fs = new FileInputStream("./data/CommonData.properties");
		Properties pro = new Properties();
		pro.load(fs);
		String data = pro.getProperty(key);
		return data;
	}
	
	public String getExcelData(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fs = new FileInputStream("./Data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		String data = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return data;
	}
	
	public void setDataIntoExcel(String sheetName, int rowIndex, int cellIndex, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fs = new FileInputStream("./Data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex).setCellValue(value);
		FileOutputStream fos = new FileOutputStream("./Data/TestScriptData.xlsx");
		wb.write(fos);
	}
}
