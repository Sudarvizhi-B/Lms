package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Books;
import com.cg.lms.entity.BooksIssued;
import com.cg.lms.entity.Users;

@SpringBootTest
class BooksIssuedServiceTest {

	Logger logger = LogManager.getLogger(UsersServiceTest.class);

	@Autowired
	IBooksIssuedService issueService;

	// Testing whether issuedBooks added into database or not
	@Test

	void testAddIssuedBook() {
		BooksIssued issuedBook = new BooksIssued();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);

		issuedBook.setIssueId(20);
		Date issueDate = Date.valueOf("2020-10-01");
		issuedBook.setIssueDate(issueDate);
		issuedBook.setQuantity(20);
		Date dueDate = Date.valueOf("2020-12-01");
		issuedBook.setDueDate(dueDate);
		issuedBook.setBooks(books);
        
		Date dateOfBirth = Date.valueOf("1998-08-15");
		Date subscriptionDate = Date.valueOf("2021-06-09");
		Date subExpireDate = Date.valueOf("2021-05-09");

		Users user = new Users(102,"abcdefgh1","Noel","Sigh","9876543210","abc@gmail.com",dateOfBirth);
		issuedBook.setUsers(user);
		BooksIssued booksIssued = issueService.addBook(issuedBook);

		logger.info("Added Books Successfully");

		assertAll(() -> assertEquals(20, booksIssued.getIssueId()),
				() -> assertEquals(issueDate, booksIssued.getIssueDate()),
				() -> assertEquals(20, booksIssued.getQuantity()),
				() -> assertEquals(dueDate, booksIssued.getDueDate()));
	}

	// Testing whether issuedBooks Updated
	@Test
	
	void testUpdateIssueBookDetails() {
		BooksIssued issued = new BooksIssued();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);

		issued.setIssueId(25);
		Date issueDate = Date.valueOf("2020-10-02");
		issued.setIssueDate(issueDate);
		issued.setQuantity(25);
		Date dueDate = Date.valueOf("2020-11-01");
		issued.setDueDate(dueDate);

		assertEquals(25, issued.getQuantity());
	}

	// Testing whether issuedBook is removed from database
	@Test
	
	void testDeleteIssuedBookDetails() {
		BooksIssued deleteBook = issueService.deleteById(30);
		System.out.println(deleteBook);
		logger.info(deleteBook);
		logger.info("Deleted issuedBooks Successfully");

		assertEquals(20, deleteBook.getQuantity());
	}

	// Testing whether issuedBook database has issuedBooks or not
	@Test
    
	void testViewAllBooksIssued() {
		List<BooksIssued> issuedList = issueService.findAll();
		System.out.println(issuedList);
		logger.info(issuedList);

		assertEquals(1, issuedList.size());
	}

	// Testing whether the issuedBook is fetched by given id or not
	@Test
	
	void testFindById() {
		BooksIssued issued = new BooksIssued();

		Date issueDate = Date.valueOf("2020-11-01");
		issued.setIssueDate(issueDate);
		issued.setQuantity(21);
		Date dueDate = Date.valueOf("2020-12-01");
		issued.setDueDate(dueDate);

		BooksIssued issuedBook = issueService.findById(25);
		assertEquals(issueDate, issuedBook.getIssueDate());
		assertEquals(dueDate, issuedBook.getDueDate());
		assertEquals(25, issuedBook.getQuantity());
	}

}
