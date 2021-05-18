package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Books;
import com.cg.lms.entity.BooksOrder;
import com.cg.lms.entity.Publishers;
//import com.cg.lms.entity.Publishers;
import com.cg.lms.exception.BookNotFoundException;

@SpringBootTest
class BooksOrderServiceTest {
	
	@Autowired
	IBooksOrderService booksOrderService;

	@Test
	public void testPlaceBooksOrder() {
		BooksOrder booksorder = new BooksOrder();
		Publishers publisher = new Publishers(304, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
			"Chennai", "Tamilnadu", 641006);
		Books book = new Books(102, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",
				25, 170, "Shelf A");
		
		booksorder.setOrderId(2);
		booksorder.setOrderDate("2021-05-12");
		booksorder.setOrderStatus("Cancelled");
		booksorder.setQuantity(10);
		booksorder.setBooks(book);
		booksorder.setPublisher(publisher);
		
		BooksOrder orderedbooks = booksOrderService.placeBooksOrder(booksorder);
		System.out.println(orderedbooks);
		
		assertEquals("2021-05-12",orderedbooks.getOrderDate());
		assertEquals("Cancelled", orderedbooks.getOrderStatus());
		assertEquals(10,orderedbooks.getQuantity());
	}
	
	@Test
	@Disabled
	public void testCancelOrder() {
		BooksOrder cancelorder = booksOrderService.cancelOrder(2);
		
		if(cancelorder==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(cancelorder);
		
		assertEquals(15, cancelorder.getQuantity());
	}
	
	@Test
	public void testUpdateOrderDetails() {
		BooksOrder booksorder = new BooksOrder();
		Publishers publisher = new Publishers(304, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		Books book = new Books(102, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",
				25, 170, "Shelf A");
		
		booksorder.setOrderId(2);
		booksorder.setOrderDate("2021-04-01");
		booksorder.setOrderStatus("Delivered");
		booksorder.setQuantity(15);
		booksorder.setBooks(book);
		booksorder.setPublisher(publisher);
		
		BooksOrder orderedbooks = booksOrderService.placeBooksOrder(booksorder);
		System.out.println(orderedbooks);
		
		assertEquals("2021-04-01",orderedbooks.getOrderDate());
		assertEquals("Delivered", orderedbooks.getOrderStatus());
		assertEquals(15,orderedbooks.getQuantity());
	}
	
	@Test
	public void testViewOrderList() {
		List<BooksOrder> booksOrderList = booksOrderService.viewOrdersList();
		System.out.println(booksOrderList);
		
		assertEquals(2,booksOrderList.size());
	}
	
	@Test
	public void testViewOrderById() {
		BooksOrder orderById = booksOrderService.viewOrderById(2);
		
		if(orderById==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(orderById);
		
		assertEquals("2021-04-01",orderById.getOrderDate());
		assertEquals("Delivered", orderById.getOrderStatus());
		assertEquals(15,orderById.getQuantity());
	}
	
}
