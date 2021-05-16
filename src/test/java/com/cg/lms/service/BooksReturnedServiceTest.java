package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.repository.IBooksReturnedRepository;
import com.cg.lms.entity.Books;
import com.cg.lms.entity.BooksReturned;
import com.cg.lms.entity.Users;
import com.cg.lms.exception.BookNotFoundException;

@SpringBootTest
public class BooksReturnedServiceTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}
	
	@Autowired
	BooksReturnedService ibs;
	
	@Autowired
	IBooksReturnedRepository ibd;
	
	@Test
	@Disabled
	void testShouldViewReturnedBookList() {
		List<BooksReturned> br = ibs.viewReturnedBooksList();             //passing
		System.out.println(br);
		assertEquals(5,br.size());                  //enter total no. of rows
	}
	
	@Test
	@Disabled
	void testShouldViewDelayedBookList() {
		List<BooksReturned> br1 = ibs.findByDelayedDaysGreaterThanEqual(8)  ;           //passing
		System.out.println(br1);
		assertEquals(3,br1.size());                  //enter total no. of rows
	}
	
	
	@Test
	//@Disabled
	void testShoudlUpdateReturnedBookDetails() throws BookNotFoundException{
		LocalDate d1= LocalDate.of(2021,05,11);
		BooksReturned returned = new BooksReturned();
		returned.setId(1);
		returned.setDelayedDays(11);
		returned.setPenalty(32.0);
		returned.setPenalty_Status("Pending");
		returned.setReturnedDate(d1);
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",25, 170, "Shelf A");
		List <Books> books = new ArrayList<>();
		books.add(book);
		returned.setBooks(books);
		Date dob1 = Date.valueOf("1998-12-17");
		Date dob2 = Date.valueOf("1998-12-16");
		Date dob3 = Date.valueOf("1998-12-15");
		Users users = new Users(101,dob1,dob2,dob3,"Active");
		returned.setUsers(users);
		BooksReturned br = ibs.updateReturnedBookDetails(returned); 
		assertEquals(11, br.getDelayedDays());
	}
	
	@Test
	@Disabled
	void testShouldReturnBooks() {
		LocalDate d1= LocalDate.of(2021,07,11);
		BooksReturned br = new BooksReturned(10,d1,22,30.0,"Paid");
		Users user = new Users();
		user.setUserId(40);
		br.setUsers(user);
		
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",25, 170, "Shelf A");
		List <Books> books = new ArrayList<>();
		books.add(book);
		br.setBooks(books);
		BooksReturned br1 = ibs.returnBooks(br);
		assertEquals(22,br1.getDelayedDays());
	}
	
	
	
}
