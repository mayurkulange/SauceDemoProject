package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelStates {
	@DataProvider(name = "Excel")
	public Object[][] dataProvider() throws IOException {
		Object[][] obj = null;

		FileInputStream fis = new FileInputStream("E:\\States.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		obj = new Object[rows][sheet.getRow(0).getLastCellNum() - 1];

		for (int i = 1; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);
			int cells = row.getLastCellNum();
			for (int j = 1; j < cells; j++) {
				Cell cell = row.getCell(j);
				obj[i - 1][j - 1] = cell.getStringCellValue();
			}
		}

		return obj;

	}
}
