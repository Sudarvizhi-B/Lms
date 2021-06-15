package com.cg.lms.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lms.entity.BooksOrder;
import com.cg.lms.repository.IBooksOrderDao;

@Service
public class BooksOrderServiceImpl implements IBooksOrderService {
	
	@Autowired
	IBooksOrderDao booksOrderDao;
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BooksOrderServiceImpl.class);

	//Method to place an order
	@Override
	public BooksOrder placeBooksOrder(BooksOrder book) {
		logger.info(book);
		return booksOrderDao.save(book);
	}

	//Method to cancel an order
	@Override
	public BooksOrder cancelOrder(int orderId) {
		//Getting order by id
		Optional<BooksOrder> booksOrder = booksOrderDao.findById(orderId);
		if(!booksOrder.isPresent()) {
			return null;
		}
		
		booksOrderDao.deleteById(orderId);
		logger.info(booksOrder);
		return booksOrder.get();
	}

	//Method to update values of an order
	@Override
	public BooksOrder updateOrder(BooksOrder order) {
		//Getting order by id
		Optional<BooksOrder> opt = booksOrderDao.findById(order.getOrderId());
		if(!opt.isPresent()) {
			return null;
		}
		
		//Updating values
		BooksOrder updateBook = opt.get();
		updateBook.setOrderDate(order.getOrderDate());
		updateBook.setOrderStatus(order.getOrderStatus());
		updateBook.setQuantity(order.getQuantity());
		
		booksOrderDao.save(updateBook);
		logger.info(updateBook);
		return updateBook;
	}

	//Method to get list of all orders from the table
	@Override
	public List<BooksOrder> viewOrdersList() {
		return booksOrderDao.findAll();
	}

	//method to get order by id
	@Override
	public BooksOrder viewOrderById(int orderId) {
		//Getting order by id
		Optional<BooksOrder> booksOrder = booksOrderDao.findById(orderId);
		if(!booksOrder.isPresent()) {
			return null;
		}
		
		logger.info(booksOrder);
		return booksOrder.get();
	}

	//Method to get order by book id 
	@Override
	public BooksOrder viewOrderByBookId(int bookId) {
		return booksOrderDao.findBooksOrderByBookId(bookId);
	}

	@Override
	public List<BooksOrder> findOrderByQuantityGreaterThan(int quantity) {
		return booksOrderDao.findAllBooksOrderByQuantityGreaterThan(quantity);
	}
}
