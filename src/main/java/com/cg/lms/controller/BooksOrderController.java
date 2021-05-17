package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.BooksOrder;
import com.cg.lms.exception.BookNotFoundException;
import com.cg.lms.service.IBooksOrderService;

@RestController
public class BooksOrderController {

	@Autowired
	IBooksOrderService booksOrderService;

	// READ
	@GetMapping("/booksorder/{id}")
	public ResponseEntity<BooksOrder> viewOrderById(@PathVariable("id") int orderId) {
		if (booksOrderService.viewOrderById(orderId) == null) {
			throw new BookNotFoundException("Order not found with Id " + orderId);
		}
		BooksOrder orderById = booksOrderService.viewOrderById(orderId);
		return new ResponseEntity<>(orderById, HttpStatus.OK);
	}

	@GetMapping("/booksorder")
	public ResponseEntity<List<BooksOrder>> viewAllOrders() {
		List<BooksOrder> booksOrderList = booksOrderService.viewOrdersList();
		return new ResponseEntity<>(booksOrderList, HttpStatus.OK);
	}

	@GetMapping("/booksorder/order/{id}")
	public ResponseEntity<BooksOrder> viewBooksOrderByBookId(int bookId) {
		BooksOrder orderByBookId = booksOrderService.viewOrderByBookId(bookId);
		return new ResponseEntity<>(orderByBookId, HttpStatus.OK);
	}

	// WRITE
	@PostMapping("/booksorder")
	public ResponseEntity<BooksOrder> placeBooksOrder(@RequestBody BooksOrder booksOrder) {
		BooksOrder order = booksOrderService.placeBooksOrder(booksOrder);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	// UPDATE
	@PatchMapping("/booksorder/{id}")
	public ResponseEntity<BooksOrder> updateOrder(@PathVariable("id") int orderId, @RequestBody BooksOrder booksorder) {
		if (booksOrderService.viewOrderById(orderId) == null) {
			throw new BookNotFoundException("Order not found with Id " + orderId);
		}
		BooksOrder update = booksOrderService.updateOrder(booksorder);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/booksorder/{id}")
	public ResponseEntity<BooksOrder> removeOrder(@PathVariable("id") int orderId) {
		if (booksOrderService.viewOrderById(orderId) == null) {
			throw new BookNotFoundException("Order not found with Id " + orderId);
		}
		BooksOrder remove = booksOrderService.cancelOrder(orderId);
		return new ResponseEntity<>(remove, HttpStatus.OK);
	}

}
