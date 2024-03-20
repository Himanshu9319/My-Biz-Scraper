package utilities;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import static utilities.EmailConfig.*;
import static utilities.EmailConfig.SUBJECT;

public class ExcelUtility {


    @DataProvider(name = "MyBizzUrl", parallel = true)
    public Object[][] myBizzUrl() {
        Object[][] arrobj = getExcelData((System.getProperty("user.dir") + "//src//test//resources//input.xlsx"), "3500");
        return arrobj;

    }

//    @DataProvider(name = "Auto fetched sheet")
//    public Object[][] sheetname() {
//        Object[][] arrobj = getExcelData((System.getProperty("user.dir") + "//src//test//resources//Sheetname.xlsx"), "Price Comparison Set3");
//        return arrobj;
//
//    }

    public Object[][] getExcelData(String fileName, String sheetName) {

        Object[][] data = null;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            String fileExtensionName = fileName.substring(fileName.indexOf("."));

            if (fileExtensionName.equals(".xlsx"))
                wb = new XSSFWorkbook(fis);
            else if (fileExtensionName.equals(".xls")) {
                wb = new HSSFWorkbook(fis);
            }
            Sheet sh = wb.getSheet(sheetName);
            Row row = sh.getRow(0);
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new Object[noOfRows - 1][noOfCols];
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sh.getRow(i);
                    cell = row.getCell(j); //1,1

                    switch (cell.getCellType()) {
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue(); //1,1
                            break;
                        case NUMERIC:
                            data[i - 1][j] = (int) cell.getNumericCellValue();
                            break;
                        case BLANK:
                            data[i - 1][j] = "";
                            break;
                        default:
                            data[i - 1][j] = null;
                            break;
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }

        return data;
    }
}