package Structural_DesignPatterns_3_DataDrivenFramework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	public static Object[][] readExcelData(String filePath, String sheetName) throws IOException  {
	String excelFilePath = "data.xlsx";
	FileInputStream fis = new FileInputStream(filePath);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheet(sheetName);

    int rowCount = sheet.getPhysicalNumberOfRows();
    int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

    Object[][] data = new Object[rowCount - 1][colCount];

    for (int i = 1; i < rowCount; i++) {
        Row row = sheet.getRow(i);
        for (int j = 0; j < colCount; j++) {
            Cell cell = row.getCell(j);
            data[i - 1][j] = cell.toString();
        }
    }

    workbook.close();
    fis.close();
    return data;
}}