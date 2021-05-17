package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Books;
import com.cg.lms.entity.BooksIssued;
import com.cg.lms.entity.Users;

@SpringBootTest
class BooksIssuedServiceTest {

	@Autowired
	IBooksIssuedService issueService;

	@Test
	@Disabled
	void testAddIssuedBook() {
		BooksIssued issuedBook = new BooksIssued();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",
				25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);
		
		issuedBook.setIssueId(25);
		Date issueDate = Date.valueOf("2020-11-01");
		issuedBook.setIssueDate(issueDate);
		issuedBook.setQuantity(25);
		Date dueDate = Date.valueOf("2020-12-01");
		issuedBook.setDueDate(dueDate);
		issuedBook.setBooks(books);

		Date dateOfBirth = Date.valueOf("1998-03-02");
		Date subscriptionDate = Date.valueOf("2021-09-09");
		Date subExpireDate = Date.valueOf("2021-02-01");

		Users user = new Users(40, dateOfBirth, subscriptionDate, subExpireDate, "Accepted");
		issuedBook.setUsers(user);
		BooksIssued booksIssued = issueService.addBook(issuedBook);

		assertAll(() -> assertEquals(25, booksIssued.getIssueId()),
				() -> assertEquals(issueDate, booksIssued.getIssueDate()),
				() -> assertEquals(25, booksIssued.getQuantity()),
				() -> assertEquals(dueDate, booksIssued.getDueDate()));
	}

	@Test
	@Disabled
	void testUpdateIssueBookDetails() {
		BooksIssued issued = new BooksIssued();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",
				25, 170, "Shelf A");
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

	@Test
	@Disabled
	void testDeleteIssuedBookDetails() {
		BooksIssued deleteBook = issueService.deleteById(25);
		System.out.println(deleteBook);

		assertEquals(25, deleteBook.getQuantity());
	}

	@Test
	@Disabled
	void testViewAllBooksIssued() {
		List<BooksIssued> issuedList = issueService.findAll();
		System.out.println(issuedList);

		assertEquals(1, issuedList.size());
	}

	@Test
	@Disabled
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
