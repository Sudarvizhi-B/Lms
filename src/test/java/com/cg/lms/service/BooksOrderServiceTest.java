package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Books;
import com.cg.lms.entity.BooksOrder;
import com.cg.lms.entity.Publishers;
import com.cg.lms.exception.BookNotFoundException;

@SpringBootTest
class BooksOrderServiceTest {
	
	@Autowired
	IBooksOrderService booksOrderService;

	//Test case to add order in the table
	@Test
	public void testPlaceBooksOrder() {
		BooksOrder booksorder = new BooksOrder();
		Publishers publisher = new Publishers(304, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
			"Chennai", "Tamilnadu", 641006);
		Books book = new Books(109, "Ephipany", "Wings", "Jin", 2016, "965-7-153018-8",
				14, 160, "Shelf B");
		
		booksorder.setOrderId(3);
		booksorder.setOrderDate("2021-05-01");
		booksorder.setOrderStatus("Delivered");
		booksorder.setQuantity(13);
		booksorder.setBooks(book);
		booksorder.setPublisher(publisher);
		
		BooksOrder orderedbooks = booksOrderService.placeBooksOrder(booksorder);
		System.out.println(orderedbooks);
		
		assertEquals("2021-05-01",orderedbooks.getOrderDate());
		assertEquals("Delivered", orderedbooks.getOrderStatus());
		assertEquals(13,orderedbooks.getQuantity());
	}
	
	//Test case to cancel order
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
	
	//Test case to update order in the table
	@Test
	@Disabled
	public void testUpdateOrderDetails() {
		BooksOrder booksorder = new BooksOrder();
		Publishers publisher = new Publishers(304, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		Books book = new Books(104, "Winter Bear", "Love Yourself", "Taehyung", 2013, "985-2-151245-7",
				20, 200, "Shelf B");
		
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
	
	//Test case to get list of orders from the table
	@Test
	@Disabled
	public void testViewOrderList() {
		List<BooksOrder> booksOrderList = booksOrderService.viewOrdersList();
		System.out.println(booksOrderList);
		
		assertEquals(3,booksOrderList.size());
	}
	
	//Test case to get order from the table
	@Test
	@Disabled
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
