package com.boot.generators;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.boot.model.Book;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {

	public static boolean pdfGen(List<Book> books) {
		boolean flag  = false;
		try {
			// Create Document instance.
			Document document = new Document();

			// Create OutputStream instance.
			FileOutputStream outputStream = new FileOutputStream(new File("D:\\bookslist.pdf"));

			// Create PDFWriter instance.
			PdfWriter.getInstance(document, outputStream);

			// Open the document.
			document.open();

			// Add content to the document.
			document.add(new Paragraph(
					"Book Id" + "		" + "Book Name" + "		" + "Book Author" + "		" + "Book Price"));

			books.stream().forEach(b -> {

				try {
					document.add(new Paragraph(b.getBookId() + "		" + b.getBookName() + "		"
							+ b.getBookAuthor() + "		" + b.getPrice()));
				} catch (DocumentException e) {
					e.printStackTrace();
				}

			});

			// Close document and outputStream.
			document.close();
			outputStream.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
