package com.cg.lms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BooksOrder {
	
	@Id
	private int orderId;
	private int quantity;
	private String orderDate;
	private String orderStatus;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="bookId")
	private Books books;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="publisher_id")
	public Publishers publisher;
	
	//Constructors
	public BooksOrder() {}

	public BooksOrder(int orderId, int quantity, String orderDate, String orderStatus, Books books) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.books = books;
	}
	
	//Getters & Setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Publishers getPublisher() {
		return publisher;
	}

	public void setPublisher(Publishers publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "BooksOrder [orderId=" + orderId + ", quantity=" + quantity + ", orderDate=" + orderDate
				+ ", orderStatus=" + orderStatus + ", books=" + books + "]\n";
	}

}
