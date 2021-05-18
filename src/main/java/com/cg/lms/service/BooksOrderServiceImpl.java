package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.BooksOrder;
import com.cg.lms.repository.IBooksOrderDao;

@Service
public class BooksOrderServiceImpl implements IBooksOrderService {
	
	@Autowired
	IBooksOrderDao booksOrderDao;

	@Override
	public BooksOrder placeBooksOrder(BooksOrder book) {
		return booksOrderDao.save(book);
	}

	@Override
	public BooksOrder cancelOrder(int orderId) {
		Optional<BooksOrder> booksOrder = booksOrderDao.findById(orderId);
		if(!booksOrder.isPresent()) {
			return null;
		}
		
		booksOrderDao.deleteById(orderId);
		return booksOrder.get();
	}

	@Override
	public BooksOrder updateOrder(BooksOrder order) {
		Optional<BooksOrder> opt = booksOrderDao.findById(order.getOrderId());
		if(!opt.isPresent()) {
			return null;
		}
		
		BooksOrder updatebook = opt.get();
		updatebook.setOrderDate(order.getOrderDate());
		updatebook.setOrderStatus(order.getOrderStatus());
		updatebook.setQuantity(order.getQuantity());
		
		booksOrderDao.save(updatebook);
		return updatebook;
	}

	@Override
	public List<BooksOrder> viewOrdersList() {
		return booksOrderDao.findAll();
	}

	@Override
	public BooksOrder viewOrderById(int orderId) {
		Optional<BooksOrder> booksOrder = booksOrderDao.findById(orderId);
		if(!booksOrder.isPresent()) {
			return null;
		}
		
		return booksOrder.get();
	}

	@Override
	public BooksOrder viewOrderByBookId(int bookId) {
		return booksOrderDao.findBooksOrderByBookId(bookId);
	}
}
