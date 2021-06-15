package com.cg.lms.service;

import java.util.List;

import com.cg.lms.entity.BooksOrder;

public interface IBooksOrderService {
	
	public BooksOrder placeBooksOrder(BooksOrder book);
	public BooksOrder cancelOrder(int orderId);
	public BooksOrder updateOrder(BooksOrder order);
	public List<BooksOrder> viewOrdersList();
	public BooksOrder viewOrderById(int orderId);
	public BooksOrder viewOrderByBookId(int bookId);
	public List<BooksOrder> findOrderByQuantityGreaterThan(int quantity);
}
