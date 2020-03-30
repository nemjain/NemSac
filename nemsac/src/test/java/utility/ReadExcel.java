package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel {

	public String[][] readExcel(String filePath, String fileName, String sheetName) throws IOException {

		File file = new File(filePath + "\\" + fileName);
		// Create an object of FileInputStream class to read excel file
		String arrInput[][] = new String[5][5];
		FileInputStream inputStream = new FileInputStream(file);

		Workbook InputDataWorkBook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			//InputDataWorkBook = new Workbook(inputStream);

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of HSSFWorkbook class

			InputDataWorkBook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		Sheet InputDataSheet = InputDataWorkBook.getSheet(sheetName);

		// Find number of rows in excel file

		int rowCount = InputDataSheet.getLastRowNum() - InputDataSheet.getFirstRowNum();
		// System.out.println(rowCount);
		/*
		 * Row row = InputDataSheet.getRow(0); userID =
		 * row.getCell(0).getStringCellValue(); passWord =
		 * row.getCell(1).getStringCellValue();
		 */

		// return new Pair<String, String>(userID, passWord);

		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i < rowCount + 1; i++) {

			Row row = InputDataSheet.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console
				arrInput[i][j] = row.getCell(j).getStringCellValue();
				// System.out.println(arrInput[i][j]);
				// System.out.print(row.getCell(j).getStringCellValue() + "|| ");
				/*
				 * userID = row.getCell(j).getStringCellValue(); passWord =
				 * row.getCell(j+1).getStringCellValue();
				 */

			}

		}

		return arrInput;
	}

}
