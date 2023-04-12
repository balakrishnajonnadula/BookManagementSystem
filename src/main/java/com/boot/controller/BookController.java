package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.daoimpl.BookDaoImpl;
import com.boot.generators.EmailGenerator;
import com.boot.generators.ExcelGenerator;
import com.boot.generators.PdfGenerator;
import com.boot.model.Book;

@Controller
public class BookController {

	@Autowired
	private BookDaoImpl bServ;

	@RequestMapping({ "/" })
	public String loadForm(Model model) {
		Book b = new Book();
		model.addAttribute("book", b);
		return "addbook";
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book, Model model) {
		boolean saveBook = bServ.saveBook(book);
		String msg = "";
		if (saveBook) {
			msg = "Book Added..!";
		}
		model.addAttribute("msg", msg);
		return "addbook";
	}

	@RequestMapping(value = "/viewallbooks", method = RequestMethod.GET)
	public String viewAllBooks(Model model) {
		List<Book> books = bServ.getAllBooks();
		model.addAttribute("books", books);
		return "viewallbooks";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int id, Model model) {
		Book book = bServ.findBookById(id);
		model.addAttribute("book", book);
		return "edit";
	}

	@RequestMapping("/udpatebook")
	public String updateBook(@ModelAttribute("book") Book book, Model model) {
		boolean saveBook = bServ.updateBook(book);
		String msg = "";
		if (saveBook) {
			msg = "Book Updated..!";
		}
		model.addAttribute("msg", msg);
		return "redirect:/viewallbooks";
	}

	@RequestMapping("/view")
	public String viewBook(@RequestParam("id") int id, Model model) {
		Book book = bServ.findBookById(id);
		model.addAttribute("book", book);
		return "view";
	}

	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("id") int id, Model model) {
		boolean delete = bServ.deleteBookById(id);
		String msg = "";
		if (delete) {
			msg = "Book Delete..!";
		}
		model.addAttribute("msg", msg);
		return "redirect:/viewallbooks";
	}

	@RequestMapping("/pdf")
	public String pdfGeneration(Model model) {
		List<Book> books = bServ.getAllBooks();

		boolean pdfGen = PdfGenerator.pdfGen(books);

		String msg = "";
		String path = "";
		if (pdfGen) {
			msg = "Pdf created successfully";
			path = "D:\\bookslist.pdf";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("path", path);
		return "pdf";

	}

	@RequestMapping("/excel")
	public String excelGeneration(Model model) {
		List<Book> books = bServ.getAllBooks();
		boolean excelReport = ExcelGenerator.excelReport(books);
		String msg = "";
		String path = "";
		if (excelReport) {
			msg = "Excel created successfully";
			path = "D:\\bookslist.xls";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("path", path);

		return "excel";
	}

	@RequestMapping("/email")
	public String emailGenerator(Model model) {

		String fileName = "D:\\bookslist" + ".pdf";
		String toEmail = "myself.jbk@gmail.com";
		String subject = "Books List";
		EmailGenerator.generator(fileName, toEmail, subject);
		String msg = "Mail sent to respected email address..!";
		model.addAttribute("msg", msg);

		return "email";
	}

	@RequestMapping("/gotolist")
	public String goToList() {
		return "redirect:/viewallbooks";
	}
}
