package com.boot.generators;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.boot.model.Book;

public class ExcelGenerator {
	public static boolean excelReport(List<Book> books) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		boolean flag = false;
		try {
			FileOutputStream out = new FileOutputStream(new File("D:\\bookslist.xls"));
			HSSFSheet sheet = workbook.createSheet("sheet1");
			int rownum = 0;
			for (Book emp : books) {
				Row row = sheet.createRow(rownum++);
				Cell cell1 = row.createCell(0);
				Cell cell2 = row.createCell(1);
				Cell cell3 = row.createCell(2);
				Cell cell4 = row.createCell(3);
				cell1.setCellValue((Integer) emp.getBookId());
				cell2.setCellValue((String) emp.getBookName());
				cell3.setCellValue((String) emp.getBookAuthor());
				cell4.setCellValue((Double) emp.getPrice());
			}
			try {
				workbook.write(out);
				out.flush();
				out.close();
				flag = true;
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Written successfully on disk.");
		return flag;
	}
}
