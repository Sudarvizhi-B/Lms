package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
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
import com.cg.lms.entity.BooksIssued;
import com.cg.lms.entity.Users;
import com.cg.lms.repository.IBooksIssuedRepository;

@ExtendWith(SpringExtension.class)
class BooksIssuedMockitoTest {

	// @InjectMocks -injects service
	@InjectMocks
	BooksIssuedServiceImpl issueService;

	// @MockBean-injects external services
	@MockBean
	IBooksIssuedRepository issueRepo;

	@BeforeEach()
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddIssuedBook() {
		BooksIssued issued = new BooksIssued();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);
		Date dateOfBirth = Date.valueOf("1998-03-02");
		Date subscriptionDate = Date.valueOf("2021-09-09");
		Date subExpireDate = Date.valueOf("2021-02-01");
		Users user = new Users(40,"abc","Noel","Sigh","9876543210","abc@gmail.com",dateOfBirth);

		issued.setIssueId(16);
		Date issueDate = Date.valueOf("2021-05-01");
		issued.setIssueDate(issueDate);
		issued.setQuantity(11);
		Date dueDate = Date.valueOf("2021-06-01");
		issued.setDueDate(dueDate);
		issued.setUsers(user);

		Mockito.when(issueRepo.save(issued)).thenReturn(issued);

		BooksIssued booksIssued = issueService.addBook(issued);

		assertAll(() -> assertEquals(16, booksIssued.getIssueId()),
				() -> assertEquals(issueDate, booksIssued.getIssueDate()),
				() -> assertEquals(11, booksIssued.getQuantity()),
				() -> assertEquals(dueDate, booksIssued.getDueDate()));
	}

	@Test
	void testFindById() {
		BooksIssued issued = new BooksIssued();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);
		Date dateOfBirth = Date.valueOf("1998-03-02");
		Date subscriptionDate = Date.valueOf("2021-09-09");
		Date subExpireDate = Date.valueOf("2021-02-01");
		Users user = new Users(40,"abc","Noel","Sigh","9876543210","abc@gmail.com",dateOfBirth);

		issued.setIssueId(16);
		Date issueDate = Date.valueOf("2021-05-01");
		issued.setIssueDate(issueDate);
		issued.setQuantity(11);
		Date dueDate = Date.valueOf("2021-06-01");
		issued.setDueDate(dueDate);
		issued.setBooks(books);
		issued.setUsers(user);

		Mockito.when(issueRepo.findById(16)).thenReturn(Optional.of(issued));

		BooksIssued issuedBook = issueService.findById(16);

		assertEquals(11, issuedBook.getQuantity());
		assertEquals(issueDate, issuedBook.getIssueDate());
		assertEquals(dueDate, issuedBook.getDueDate());
		assertEquals(16, issuedBook.getIssueId());
	}

	@Test
	void testUpdateIssueBookDetails() {
		BooksIssued issued = new BooksIssued();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);
		Date dateOfBirth = Date.valueOf("1998-03-02");
		Date subscriptionDate = Date.valueOf("2021-09-09");
		Date subExpireDate = Date.valueOf("2021-02-01");
		Users user = new Users(40,"abc","Noel","Sigh","9876543210","abc@gmail.com",dateOfBirth);

		issued.setIssueId(25);
		Date issueDate = Date.valueOf("2020-10-02");
		issued.setIssueDate(issueDate);
		issued.setQuantity(25);
		Date dueDate = Date.valueOf("2020-11-01");
		issued.setDueDate(dueDate);
		issued.setBooks(books);
		issued.setUsers(user);

		Mockito.when(issueRepo.findById(25)).thenReturn(Optional.of(issued));
		Mockito.when(issueRepo.save(issued)).thenReturn(issued);

		BooksIssued booksIssued = issueService.update(issued);

		assertEquals(25, booksIssued.getQuantity());
	}

	@Test
	void testViewBooksIssued() {
		BooksIssued issued1 = new BooksIssued();
		BooksIssued issued2 = new BooksIssued();
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);
		Date dateOfBirth = Date.valueOf("1998-03-02");
		Date subscriptionDate = Date.valueOf("2021-09-09");
		Date subExpireDate = Date.valueOf("2021-02-01");
		Users user = new Users(40,"abc","Noel","Sigh","9876543210","abc@gmail.com",dateOfBirth);

		issued1.setIssueId(16);
		Date issueDate = Date.valueOf("2021-05-01");
		issued1.setIssueDate(issueDate);
		issued1.setQuantity(11);
		Date dueDate = Date.valueOf("2021-06-01");
		issued1.setDueDate(dueDate);
		issued1.setUsers(user);
		issued1.setBooks(books);

		issued2.setIssueId(17);
		Date issueDate1 = Date.valueOf("2021-05-01");
		issued1.setIssueDate(issueDate1);
		issued1.setQuantity(11);
		Date dueDate1 = Date.valueOf("2021-06-01");
		issued1.setDueDate(dueDate1);
		issued1.setUsers(user);
		issued1.setBooks(books);

		List<BooksIssued> issuedList = new ArrayList<>();
		issuedList.add(issued1);
		issuedList.add(issued2);

		Mockito.when(issueRepo.findAll()).thenReturn(issuedList);

		List<BooksIssued> issued = issueService.findAll();

		assertEquals(2, issued.size());
	}

}
