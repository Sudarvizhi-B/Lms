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
	IBooksReturnedRepository booksReturnedRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	LocalDate localDate1 = LocalDate.of(2021, 07, 11);
	LocalDate localDate2 = LocalDate.of(2002, 9, 23);
	LocalDate localDate3 = LocalDate.of(1999, 2, 10);

	// To Return Books
	@Test
	void testReturnedBooks() {
		BooksReturned booksReturned = new BooksReturned(10, localDate1, 22, 30.0, "Paid");
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		booksReturned.setBooks(book);

		Date dob1 = Date.valueOf("1998-12-17");
		Date dob2 = Date.valueOf("1998-12-16");
		Date dob3 = Date.valueOf("1998-12-15");
		Users users = new Users(101, dob1, dob2, dob3, "Active");
		booksReturned.setUsers(users);
		Mockito.when(booksReturnedRepo.save(booksReturned)).thenReturn(booksReturned);
		BooksReturned br1 = booksReturnedService.returnBooks(booksReturned);
		assertEquals(localDate1, br1.getReturnedDate());
	}

	// To Update ReturnedBooks
	@Test
	void testUpdateReturnedBooksDetails() {
		BooksReturned booksReturned = new BooksReturned(11, localDate2, 12, 30.0, "Pending");
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		booksReturned.setBooks(book);
		Date dob1 = Date.valueOf("1998-12-17");
		Date dob2 = Date.valueOf("1998-12-16");
		Date dob3 = Date.valueOf("1998-12-15");
		Users users = new Users(101, dob1, dob2, dob3, "Active");
		booksReturned.setUsers(users);
		Mockito.when(booksReturnedRepo.findById(11)).thenReturn(Optional.of(booksReturned));
		Mockito.when(booksReturnedRepo.save(booksReturned)).thenReturn(booksReturned);
		BooksReturned br2 = booksReturnedService.updateReturnedBookDetails(booksReturned);
		assertEquals("Pending", br2.getPenalty_Status());
		assertEquals(11, br2.getId());
	}

	// View ReturnedBooks List
	@Test
	void testviewReturnedBooksList() {
		BooksReturned booksReturned1 = new BooksReturned(11, localDate1, 12, 30.0, "Pending");
		BooksReturned booksReturned2 = new BooksReturned(5, localDate2, 15, 33.0, "Paid");
		BooksReturned booksReturned3 = new BooksReturned(6, localDate3, 0, 0.0, "Null");
		List<BooksReturned> brList = new ArrayList<>();
		brList.add(booksReturned1);
		brList.add(booksReturned2);
		brList.add(booksReturned3);

		Mockito.when(booksReturnedRepo.findAll()).thenReturn(brList);
		List<BooksReturned> bl = booksReturnedService.viewReturnedBooksList();
		assertEquals(3, bl.size());

		for (BooksReturned br : brList)
			System.out.println(br);
	}

	// View Delayed BookList
	@Test
	void testViewDelayedBookList() {

		BooksReturned booksReturned1 = new BooksReturned(11, localDate1, 12, 30.0, "Pending");
		BooksReturned booksReturned2 = new BooksReturned(5, localDate2, 15, 33.0, "Paid");
		BooksReturned booksReturned3 = new BooksReturned(6, localDate3, 8, 18.0, "Pending");
		List<BooksReturned> brList = new ArrayList<>();
		brList.add(booksReturned1);
		brList.add(booksReturned2);
		brList.add(booksReturned3);

		Mockito.when(booksReturnedRepo.findAll()).thenReturn(brList);
		List<BooksReturned> booksList = (List<BooksReturned>) booksReturnedService.findByDelayedDaysGreaterThanEqual(8);
		for (BooksReturned book : booksList) {
			System.out.println(book);
		}

	}

}
