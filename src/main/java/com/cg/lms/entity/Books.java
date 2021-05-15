package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Books {
	
	@Id
	private int bookid;
	private String title;
	private String subject;
	private String author;
	private int publishedYear;
	private String isbnCode;
	private int quantity;
	private double bookCost;
	private String shelfDetails;
	
	@OneToOne(mappedBy="books")
	private BooksOrder booksOrder;
	
	@OneToOne(mappedBy="books")
	private DamagedBooks damagedBooks;
	
	//Constructors
	
	public Books() {}

	public Books(int bookid, String title, String subject, String author, int publishedYear, String isbnCode,
			int quantity, double bookCost, String shelfDetails) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publishedYear = publishedYear;
		this.isbnCode = isbnCode;
		this.quantity = quantity;
		this.bookCost = bookCost;
		this.shelfDetails = shelfDetails;
	}
	
	//Getters & Setters
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBookCost() {
		return bookCost;
	}

	public void setBookCost(double bookCost) {
		this.bookCost = bookCost;
	}

	public String getShelfDetails() {
		return shelfDetails;
	}

	public void setShelfDetails(String shelfDetails) {
		this.shelfDetails = shelfDetails;
	}
	
	// Overriding toString() method
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", title=" + title + ", subject=" + subject + ", author=" + author
				+ ", publishedYear=" + publishedYear + ", isbnCode=" + isbnCode + ", quantity=" + quantity
				+ ", bookCost=" + bookCost + ", shelfDetails=" + shelfDetails + "]\n";
	}

}
