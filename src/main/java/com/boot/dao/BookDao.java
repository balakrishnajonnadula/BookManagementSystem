package com.boot.dao;

import java.util.List;

import com.boot.model.Book;

public interface BookDao {
	public boolean saveBook(Book book);
	public List<Book> getAllBooks();
	public Book findBookById(int id);
	public boolean deleteBookById(int id);
	public boolean updateBook(Book book);
	
}
