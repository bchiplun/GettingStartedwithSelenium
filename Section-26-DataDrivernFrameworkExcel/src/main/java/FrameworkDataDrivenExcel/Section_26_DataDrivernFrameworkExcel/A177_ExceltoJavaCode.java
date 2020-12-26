package FrameworkDataDrivenExcel.Section_26_DataDrivernFrameworkExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class A177_ExceltoJavaCode {
	
	public ArrayList<String> getData(String testcase) throws IOException {
		//Arraylist to store contents of test
		ArrayList<String> a = new ArrayList<String>();
		
		//to read excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\chipl\\Java\\Selenium-workspace\\Section-26-DataDrivernFrameworkExcel\\DatainExcel.xlsx");
		
		//access excel file using above stream
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//get number of sheets in excel
		int sheets = workbook.getNumberOfSheets();
		
		//iterating through all sheets to get correct sheet
		
		for(int i=0; i<sheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//to iterate through all rows of sheet
				Iterator<Row> rows = sheet.iterator();
				
				//to get first row
				Row row = rows.next();
				
				//to iterate through all columns of rows
				Iterator<Cell> ce = row.iterator();
				int k=0;  // to get column number
				int column=0;  // to get column number
				while(ce.hasNext()) {
					Cell value = ce.next(); //to store cell in variable
					if(value.getStringCellValue().equalsIgnoreCase("testcase1")) { // to check if cell contains desired value
						
						column = k; // to get the column number of the current cell 
					}
					k++;
				}
				System.out.println("column"+column);
				
				//To iterate through all rows for current column only to get into desired row
				while(rows.hasNext()) {
					Row r = rows.next();
					
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase)) {  // to match desired cell
						
						Iterator<Cell> cell = r.iterator();
						while(cell.hasNext()) {
							a.add(cell.next().getStringCellValue());
						}
						
					}
				}
			}

		}
		return a;	
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	}

}
