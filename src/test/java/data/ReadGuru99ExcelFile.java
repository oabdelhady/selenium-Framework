package data;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadGuru99ExcelFile {

    public String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{

        //Create an object of File class to open xlsx file

        File file =    new File(filePath+"\\"+fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook guru99Workbook = null;

        //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

            //If it is xlsx file then create object of XSSFWorkbook class

            guru99Workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of HSSFWorkbook class

            guru99Workbook = new HSSFWorkbook(inputStream);

        }

        //Read sheet inside the workbook by its name

        Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
        Row row = guru99Sheet.getRow(0);
//calculate how many rows in the sheet (add +1 bec row counts starts from 0)
        int rowCount = guru99Sheet.getLastRowNum()+1;
        //calculate how many columns in the sheet ( add +1 is not added as cell counts starts from 1 already)
        int colCount = row.getLastCellNum();

        String testData [][] = new String[rowCount][colCount];
//Create a loop over all the rows of excel file to read it
        for (int i = 0; i < rowCount; i++) {
// Read from row i
            row = guru99Sheet.getRow(i);

            //Create a loop to print cell values in a row

            for (int j = 0; j < colCount ; j++) {

                //Print Excel data in console

              //  System.out.print(row.getCell(j).getStringCellValue()+"|| ");
                testData [i][j] = row.getCell(j).getStringCellValue();

            }

            //System.out.println();
        }
        return testData;
    }

    //Main function is calling readExcel function to read data from excel file

    public static void main(String...strings) throws IOException{

        //Create an object of ReadGuru99ExcelFile class

        ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();

        //Prepare the path of excel file

        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data";

        //Call read file method of the class to read data

        objExcelFile.readExcel(filePath,"TestData.xlsx","Sheet1");

    }

}
