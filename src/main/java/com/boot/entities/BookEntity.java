package com.boot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOOK")
public class BookEntity {
	@Id
	@Column(name = "BOOK_ID")
	@GenericGenerator(name = "myGen", strategy = "increment")
	@GeneratedValue(generator = "myGen", strategy = GenerationType.AUTO)
	private int bookId;
	@Column(name = "BOOK_NAME")
	private String bookName;
	@Column(name = "BOOK_AUTHOR")
	private String bookAuthor;
	@Column(name = "PRICE")
	private double price;

}
