package com.boot.daoimpl;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.boot.dao.BookDao;
import com.boot.entities.BookEntity;
import com.boot.model.Book;
import com.boot.repo.BookRepo;

@Service
public class BookDaoImpl implements BookDao {
	@Autowired
	private BookRepo bRepo;

	@Override
	public boolean saveBook(Book book) {
		BookEntity entity = new BookEntity();
		BeanUtils.copyProperties(book, entity);
		BookEntity save = bRepo.save(entity);
		boolean flag = false;

		if (save != null)
			flag = true;

		return flag;
	}

	@Override
	public List<Book> getAllBooks() {

		List<BookEntity> getAllBooks = bRepo.findAll();
		List<Book> books = new ArrayList<Book>();
		getAllBooks.stream().forEach(b -> {
			Book book = new Book();
			BeanUtils.copyProperties(b, book);
			books.add(book);
		});
		return books;
	}

	@Override
	public Book findBookById(int id) {
		Optional<BookEntity> findById = bRepo.findById(id);
		BookEntity bookEntity = findById.get();
		Book book = new Book();
		BeanUtils.copyProperties(bookEntity, book);
		return book;
	}

	@Override
	public boolean deleteBookById(int id) {
		Optional<BookEntity> findById = bRepo.findById(id);
		BookEntity bookEntity = findById.get();
		boolean flag = false;
		if (bookEntity != null) {
			bRepo.deleteById(id);
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateBook(Book book) {
		BookEntity entity = new BookEntity();

		BeanUtils.copyProperties(book, entity);
		BookEntity update = bRepo.save(entity);
		boolean flag = false;
		if (update != null) {
			flag = true;
		}
		return flag;
	}

}
