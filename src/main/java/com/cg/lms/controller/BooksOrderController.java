package com.cg.lms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.BooksOrder;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.IBooksOrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BooksOrderController {

	@Autowired
	IBooksOrderService booksOrderService;

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BooksOrderController.class);
	
	private static final String EXCEPTION = "Order not found with Book id ";
	
	//Get order by id
	@GetMapping("/booksorder/{id}")
	public ResponseEntity<BooksOrder> viewOrderById(@PathVariable("id") int orderId) {
		//Throw an exception if order id is not present
		if (booksOrderService.viewOrderById(orderId) == null) {
			throw new BookNotFoundException(EXCEPTION + orderId);
		}
		BooksOrder orderById = booksOrderService.viewOrderById(orderId);
		logger.info(orderById);
		return new ResponseEntity<>(orderById, HttpStatus.OK);
	}

	//Get books order list
	@GetMapping("/booksorder")
	public ResponseEntity<List<BooksOrder>> viewAllOrders() {
		List<BooksOrder> booksOrderList = booksOrderService.viewOrdersList();
		logger.info(booksOrderList);
		return new ResponseEntity<>(booksOrderList, HttpStatus.OK);
	}

	//Get books order by book id
	@GetMapping("/booksorder/order/{id}")
	public ResponseEntity<BooksOrder> viewBooksOrderByBookId(int bookId) {
		BooksOrder orderByBookId = booksOrderService.viewOrderByBookId(bookId);
		logger.info(orderByBookId);
		return new ResponseEntity<>(orderByBookId, HttpStatus.OK);
	}

	// Add new order in the table
	@PostMapping("/booksorder")
	public ResponseEntity<BooksOrder> placeBooksOrder(@RequestBody BooksOrder booksOrder) {
		BooksOrder order = booksOrderService.placeBooksOrder(booksOrder);
		logger.info(order);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	// Update values of an existing order
	@PutMapping("/booksorder/{id}")
	public ResponseEntity<BooksOrder> updateOrder(@PathVariable("id") int orderId, @RequestBody BooksOrder booksOrder) {
		//Throw an exception if order id is not present
		if (booksOrderService.viewOrderById(orderId) == null) {
			throw new BookNotFoundException(EXCEPTION + orderId);
		}
		BooksOrder update = booksOrderService.updateOrder(booksOrder);
		logger.info(update);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	// Delete a order from the table
	@DeleteMapping("/booksorder/{id}")
	public ResponseEntity<BooksOrder> removeOrder(@PathVariable("id") int orderId) {
		//Throw an exception if order id is not present
		if (booksOrderService.viewOrderById(orderId) == null) {
			throw new BookNotFoundException(EXCEPTION + orderId);
		}
		BooksOrder remove = booksOrderService.cancelOrder(orderId);
		logger.info(remove);
		return new ResponseEntity<>(remove, HttpStatus.OK);
	}

}
