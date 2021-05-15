package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public BooksOrder viewOrderById(@PathVariable("id") int orderId) {
		if( booksOrderService.viewOrderById(orderId)==null) {
			throw new BookNotFoundException("Order not found with Id "+orderId);
		}
		return booksOrderService.viewOrderById(orderId);
	}
	
	@GetMapping("/booksorder")
	public List<BooksOrder>viewAllOrders(){
		return booksOrderService.viewOrdersList();
	}
	
	@GetMapping("/booksorder/order/{id}")
	public BooksOrder viewBooksOrderByBookId(int bookId) {
		return booksOrderService.viewOrderByBookId(bookId);
	}
	
	// WRITE
	@PostMapping("/booksorder")
	public BooksOrder placeBooksOrder(@RequestBody BooksOrder booksOrder) {
		return booksOrderService.placeBooksOrder(booksOrder);
	}
	
	//UPDATE
	@PatchMapping("/booksorder/{id}")
	public BooksOrder updateOrder(@PathVariable("id") int orderId, @RequestBody BooksOrder booksorder) {
		if( booksOrderService.viewOrderById(orderId)==null) {
			throw new BookNotFoundException("Order not found with Id "+orderId);
		}
		return booksOrderService.updateOrder(booksorder);
	}
	
	//DELETE
	@DeleteMapping("/booksorder/{id}")
	public BooksOrder removeOrder(@PathVariable("id") int orderId) {
		if( booksOrderService.viewOrderById(orderId)==null) {
			throw new BookNotFoundException("Order not found with Id "+orderId);
		}
		return booksOrderService.cancelOrder(orderId);
	}
	
}
