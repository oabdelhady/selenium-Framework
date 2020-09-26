package data;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class RegistrationTestData {
public String[][] readRegistrationDataExcel (String filePath, String fileName, String sheetName) throws IOException {
    File file = new File(filePath+"\\"+fileName );
    FileInputStream inputStream = new FileInputStream (file);
    Workbook guru99Workbook = null;
    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    if (fileExtensionName.equals(".xlsx")){
        guru99Workbook = new XSSFWorkbook(inputStream);
    }
    else if(fileExtensionName.equals(".xls")){
        guru99Workbook = new HSSFWorkbook(inputStream);
    }
    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
    // Ask Amr > ezai el i = 1 ma3 en el i initialized ta7t ba3d dah aslun? ans: dah index msh el i el parameter el ta7t
    Row row = guru99Sheet.getRow(0);
    // function returns last row no -1
    int rowCount = guru99Sheet.getLastRowNum();
    int colCount = row.getLastCellNum();
    String testData [][] = new String[rowCount][colCount];
    for (int i = 0; i<rowCount; i++) {
        for (int j = 0; j < colCount ; j++) {
            //7atena el i+1 3ashan ana 3ayza a2ra mn row number 1 msh mn row number zero
            row = guru99Sheet.getRow(i+1);
            testData [i][j] = row.getCell(j).getStringCellValue();
           // System.out.println(testData [i][j] + "||");
        }
    }

    return testData;
}
    public static void main(String...strings) throws IOException {

        RegistrationTestData objExcelFile = new RegistrationTestData();

        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data";

        objExcelFile.readRegistrationDataExcel(filePath,"TestData.xlsx","registration");

    }
}
