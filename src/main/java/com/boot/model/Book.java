package com.boot.model;

import lombok.Data;

@Data
public class Book {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double price;
}
