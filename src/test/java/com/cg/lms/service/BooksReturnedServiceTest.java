package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Author;
import com.cg.lms.entity.Books;
import com.cg.lms.entity.BooksReturned;
import com.cg.lms.entity.Users;
import com.cg.lms.exception.AuthorNotFoundException;
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
	IBooksReturnedService booksReturnedService;

	// To View Returned BookList
	@Test
	@Disabled
	void testShouldViewReturnedBookList() {
		List<BooksReturned> booksReturned1 = booksReturnedService.viewReturnedBooksList();
		System.out.println(booksReturned1);
		assertEquals(2, booksReturned1.size()); // size() - total no. of rows
	}

	// View Delayed BookList
	@Test
	//@Disabled
	void testShouldViewDelayedBookList() {
		List<BooksReturned> booksReturned2 = booksReturnedService.findByDelayedDaysGreaterThanEqual(8);
		System.out.println(booksReturned2);
		assertEquals(2, booksReturned2.size()); // size() - total no. of rows
	}

	// To Update ReturnedBooks Details
	@Test
	//@Disabled
	void testShoudlUpdateReturnedBookDetails() throws BookNotFoundException {
		LocalDate localDate1 = LocalDate.of(2021, 07, 11);
		BooksReturned returned = new BooksReturned();
		returned.setId(202);
		returned.setDelayedDays(22);
		returned.setPenalty(30.0);
		returned.setPenalty_Status("Paid");
		returned.setReturnedDate(localDate1);

		Books book = new Books(102, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		returned.setBooks(book);

		Date dob1 = Date.valueOf("1998-12-17");
		Date dob2 = Date.valueOf("1998-12-16");
		Date dob3 = Date.valueOf("1998-12-15");
		Users users = new Users(101, dob1, dob2, dob3, "Active");
		returned.setUsers(users);
		BooksReturned br = booksReturnedService.updateReturnedBookDetails(returned);
		assertEquals(22, br.getDelayedDays());
	}


	// Delete Author Details
	@Test
	//@Disabled
	void testShouldDeleteReturnedBooks() throws BookNotFoundException {
		  BooksReturned booksReturned4 = booksReturnedService.deleteReturnedBooks(10);
		assertEquals(10, booksReturned4.getId());
	}

	// To Return Book
	@Test
	//@Disabled
	void testShouldReturnBooks() {
		LocalDate d1 = LocalDate.of(2021, 02, 11);
		BooksReturned booksReturned3 = new BooksReturned(203, d1, 23, 33.0, "Paid");
		Users user = new Users();
		user.setUserId(22);
		booksReturned3.setUsers(user);

		Books book = new Books(102, "Iron Man", "Comics", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		booksReturned3.setBooks(book);
		BooksReturned booksReturned4 = booksReturnedService.returnBooks(booksReturned3);
		assertEquals(23, booksReturned4.getDelayedDays());
	}

}
