package com.spring.files.excel.springbootuploadexcelfiles.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.spring.files.excel.springbootuploadexcelfiles.madel.Tutorial;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Order_ID", "Order_Date", "Order_Quantity", "Sales", "Ship_Mode", "Product_Category",
			"Customer_Segment", "Customer", "Unit_Price", "Profit" };
	static String SHEET = "Tutorials";

	public static boolean hasExcelFormat(MultipartFile file) {
		System.out.println("Debug");
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Tutorial> excelToTutorials(InputStream is) {
		try {
			System.out.println("Debug 7");
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();
			System.out.println("Debug 8");
			List<Tutorial> tutorials = new ArrayList<Tutorial>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Tutorial tutorial = new Tutorial();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						tutorial.setId((int) currentCell.getNumericCellValue());
						break;

					case 1:
						tutorial.setOrderDate(currentCell.getStringCellValue());
						break;

					case 2:
						tutorial.setOrderQuantity(currentCell.getNumericCellValue());
						break;

					case 3:
						tutorial.setSales(currentCell.getNumericCellValue());
						break;
					case 4:
						tutorial.setShipMode(currentCell.getStringCellValue());
						break;
					case 5:
						tutorial.setProfit(currentCell.getNumericCellValue());
						break;
					case 6:
						tutorial.setUnitPrice(currentCell.getNumericCellValue());
						break;
					case 7:
						tutorial.setCustomer(currentCell.getStringCellValue());
						break;
					case 8:
						tutorial.setCustomerSegment(currentCell.getStringCellValue());
						break;
					case 9:
						tutorial.setProductCategory(currentCell.getStringCellValue());
						break;

					default:
						break;
					}

					cellIdx++;
				}

				tutorials.add(tutorial);
			}

			workbook.close();

			return tutorials;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}