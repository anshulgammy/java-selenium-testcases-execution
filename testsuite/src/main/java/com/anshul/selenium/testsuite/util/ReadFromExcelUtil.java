package com.anshul.selenium.testsuite.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.anshul.selenium.testsuite.main.TestSuiteExecute;

public class ReadFromExcelUtil {
	public static void readFromExcel(final String xlsPath) {
		Workbook workbook = null;
		try {
			// Picking up the testcase file.
			final File excelFile = new File(CommonUtil.TEST_CASE_PATH);
			// Reading the testcase file
			final FileInputStream inputStream = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(inputStream);
			// Entire excel sheet has been now obtained in excelSheet object.
			final Sheet excelSheet = workbook.getSheetAt(0);
			final Iterator<Row> rowIterator = excelSheet.iterator();
			while (rowIterator.hasNext()) {
				final Row currentRow = rowIterator.next();
				// As the fist row of excel sheet is column titles, we are skipping that.
				if (currentRow.getRowNum() != 0) {
					final Iterator<Cell> cellIterator = currentRow.iterator();
					while (cellIterator.hasNext()) {
						final Cell currentCell = cellIterator.next();
						if (currentCell.getColumnIndex() != 0) {
							final String testCaseString = currentCell.getStringCellValue();
							TestSuiteExecute.RunTestCase(testCaseString);
						}
					}
					if (currentRow.getRowNum() != 0) {
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (!CommonUtil.isNullOrEmpty(workbook)) {
				try {
					// Closing the workbook file.
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
