package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.lms.entity.Books;
import com.cg.lms.entity.BooksOrder;
import com.cg.lms.entity.Publishers;
//import com.cg.lms.entity.Publishers;
import com.cg.lms.repository.IBooksOrderDao;

@ExtendWith(SpringExtension.class)
class BooksOrderServiceMockitoTest {
	
	@InjectMocks
	BooksOrderServiceImpl booksOrderService;
	
	@MockBean
	IBooksOrderDao booksOrderDao;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void placeBooksOrder() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		Publishers publisher = new Publishers(301, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		BooksOrder booksOrder = new BooksOrder(1, 10, "2021-05-01", "Ordered", book, publisher);
		
		Mockito.when(booksOrderDao.save(booksOrder)).thenReturn(booksOrder);
		
		BooksOrder orderedBook = booksOrderService.placeBooksOrder(booksOrder);
		
		assertEquals("2021-05-01",orderedBook.getOrderDate());
		assertEquals("Ordered", orderedBook.getOrderStatus());
		assertEquals(10,orderedBook.getQuantity());
	}
	
	@Test
	public void updateBooksOrder() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		Publishers publisher = new Publishers(301, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		BooksOrder booksOrder = new BooksOrder(1, 15, "2021-05-01", "Ordered", book, publisher);
		
		Mockito.when(booksOrderDao.findById(1)).thenReturn(Optional.of(booksOrder));
		Mockito.when(booksOrderDao.save(booksOrder)).thenReturn(booksOrder);
		
		BooksOrder updateBook = booksOrderService.updateOrder(booksOrder);
		
		assertEquals(15,updateBook.getQuantity());
	}
	
	@Test
	public void testCancelOrder() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		Publishers publisher = new Publishers(301, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		BooksOrder booksOrder = new BooksOrder(1, 15, "2021-05-01", "Ordered", book, publisher);
		
		Mockito.when(booksOrderDao.findById(1)).thenReturn(Optional.of(booksOrder));
		booksOrderDao.deleteById(1);
		
		BooksOrder cancelOrder = booksOrderService.cancelOrder(1);
		
		assertEquals("2021-05-01",cancelOrder.getOrderDate());
		assertEquals("Ordered", cancelOrder.getOrderStatus());
		assertEquals(15, cancelOrder.getQuantity());
	}
	
	@Test
	public void viewOrderById() {
		Books book = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		Publishers publisher = new Publishers(301, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
			"Chennai", "Tamilnadu", 641006);
		BooksOrder booksOrder = new BooksOrder(1, 15, "2021-05-01", "Ordered", book, publisher);
		
		Mockito.when(booksOrderDao.findById(1)).thenReturn(Optional.of(booksOrder));
		
		BooksOrder orderById = booksOrderService.viewOrderById(1);
		
		assertEquals(15, orderById.getQuantity());
	}
	
	@Test
	public void viewOrderList() {
		Books book1 = new Books(105, "Wings of Fire", "India's journey to self-reliance in technology", "A.P.J.Abdul Kalam", 1999, "976-3-181530-2",
				25, 150, "Shelf C");
		Publishers publisher1 = new Publishers(301, "XY Publications", "7777788777", "xy@gmail.com", "3rd street", "k layout",
				"Chennai", "Tamilnadu", 641006);
		BooksOrder booksOrder1 = new BooksOrder(1, 15, "2021-05-01", "Ordered", book1, publisher1);
		
		Books book2 = new Books(104, "Harry Potter", "Novel", "J.K.Rowling", 2000, "986-8-151802-2",
				25, 150, "Shelf A");
		Publishers publisher2 = new Publishers(302, "Hybe", "9876543210", "string", "Lakshmi Street", "Nungambakam",
				"Chennai", "Tamilnadu", 600012);
		BooksOrder booksOrder2 = new BooksOrder(2, 10, "2021-05-05", "Ordered", book2, publisher2);
		
		List<BooksOrder> orderedBooksList = new ArrayList<>();
		orderedBooksList.add(booksOrder1);
		orderedBooksList.add(booksOrder2);
		
		Mockito.when(booksOrderDao.findAll()).thenReturn(orderedBooksList);
		
		List<BooksOrder> viewOrderList = booksOrderService.viewOrdersList();
		
		assertEquals(2, viewOrderList.size());
	}

}
