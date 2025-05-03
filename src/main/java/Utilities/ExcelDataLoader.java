package Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;

import java.io.FileInputStream;

public class ExcelDataLoader {
    private static Workbook workbook;
    public static ExcelDataLoader excelDataLoader = null;

    // using singleton pattern inorder to avoid multiple object creation
    public static ExcelDataLoader getInstance(String filePath) throws Throwable {
      if(excelDataLoader == null){
          FileInputStream fis = new FileInputStream(filePath);
          workbook = new XSSFWorkbook(fis);
          excelDataLoader = new ExcelDataLoader();
      }else{
          return excelDataLoader;
      }
        return excelDataLoader;
    }

    private ExcelDataLoader(){}

    // Get single row data by sheet name (first data row only)
    public Map<String, String> getRowDataBySheet(String sheetName) {
        Map<String, String> rowData = new LinkedHashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) return rowData;

        Row headerRow = sheet.getRow(0);
        Row dataRow = sheet.getRow(1); // First data row (after header)

        if (headerRow == null || dataRow == null) return rowData;

        int colCount = headerRow.getLastCellNum();
        for (int i = 0; i < colCount; i++) {
            String key = headerRow.getCell(i).getStringCellValue().trim();
            Cell cell = dataRow.getCell(i);
            String value = (cell == null) ? "" : cell.toString().trim();
            rowData.put(key, value);
        }

        return rowData;
    }

    public void close() throws Exception {
        workbook.close();
    }
}
