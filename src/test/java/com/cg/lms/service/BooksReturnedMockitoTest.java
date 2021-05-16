package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;
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

import com.cg.lms.repository.IBooksReturnedRepository;
import com.cg.lms.entity.Books;
import com.cg.lms.entity.BooksReturned;
import com.cg.lms.entity.Users;

@ExtendWith(SpringExtension.class)
class BooksReturnedMockitoTest {

	@InjectMocks
	BooksReturnedServiceImpl booksReturnedService;
	
	@MockBean
	IBooksReturnedRepository booksReturnedDao;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	LocalDate d1= LocalDate.of(2021,07,11);
	LocalDate d2 = LocalDate.of(2002,9,23);
	LocalDate d3 = LocalDate.of(1999, 2, 10);
	@Test
	void testReturnedBooks() {
		BooksReturned br = new BooksReturned(10,d1,22,30.0,"Paid");
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",25, 170, "Shelf A");
		List <Books> books = new ArrayList<>();
		books.add(book);
		br.setBooks(books);
		
		Date dob1 = Date.valueOf("1998-12-17");
		Date dob2 = Date.valueOf("1998-12-16");
		Date dob3 = Date.valueOf("1998-12-15");
		Users users = new Users(101,dob1,dob2,dob3,"Active");
		br.setUsers(users);
		Mockito.when(booksReturnedDao.save(br)).thenReturn(br);
		BooksReturned br1 = booksReturnedService.returnBooks(br);
		assertEquals(d1,br1.getReturnedDate());
	}
	
	@Test
	void testUpdateReturnedBooksDetails() {
		BooksReturned br = new BooksReturned(11,d2,12,30.0,"Pending");
		Mockito.when(booksReturnedDao.findById(11)).thenReturn(Optional.of(br));
		Mockito.when(booksReturnedDao.save(br)).thenReturn(br);
		BooksReturned br2 = booksReturnedService.updateReturnedBookDetails(br);
		assertEquals("Pending",br2.getPenalty_Status());
		assertEquals(11,br2.getId());	
	}
	
	@Test
	void testviewReturnedBooksList() {
		BooksReturned br1 = new BooksReturned(11,d1,12,30.0,"Pending");
		BooksReturned br2 = new BooksReturned(5,d2,15,33.0,"Paid");
		BooksReturned br3 = new BooksReturned(6,d3,0,0.0,"Null");
		List <BooksReturned> brList = new ArrayList<> ();
		brList.add(br1);
		brList.add(br2);
		brList.add(br3);
		
		Mockito.when(booksReturnedDao.findAll()).thenReturn(brList);
		List <BooksReturned> bl = booksReturnedService.viewReturnedBooksList();
		assertEquals(3,bl.size());
		
		for(BooksReturned br : brList)
			System.out.println(br);
	}
	
	@Test
	void testViewDelayedBookList() {
		
		BooksReturned br1 = new BooksReturned(11,d1,12,30.0,"Pending");
		BooksReturned br2 = new BooksReturned(5,d2,15,33.0,"Paid");
		BooksReturned br3 = new BooksReturned(6,d3,8,18.0,"Pending");
		List <BooksReturned> brList = new ArrayList<> ();
		brList.add(br1);
		brList.add(br2);
		brList.add(br3);
		
		Mockito.when(booksReturnedDao.findAll()).thenReturn(brList);
		List <BooksReturned> bList = (List <BooksReturned>)booksReturnedService.findByDelayedDaysGreaterThanEqual(8);
		//List <BooksReturned> bList = booksReturnedService.findByDelayedDaysGreaterThanEqual(8);
		for(BooksReturned b : bList) {
			System.out.println(b);
		}
		assertEquals(0,bList.size());
		
		
	}
	
	
	
	
	
	
}
