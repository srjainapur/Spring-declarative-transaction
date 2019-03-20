package com.zensar.transaction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BOOK_ID", length=10, nullable=false, unique=true)
	private int bookId;

	@Column(name = "AUOTHER_NAME")
	private String auotherName;

	@Column(name = "PRICE")
	private int price;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuotherName() {
		return auotherName;
	}

	public void setAuotherName(String auotherName) {
		this.auotherName = auotherName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	
}
