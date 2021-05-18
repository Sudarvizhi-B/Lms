package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.SuggestedBooks;
import com.cg.lms.entity.Users;
import com.cg.lms.exception.BookNotFoundException;

@SpringBootTest
class SuggestedBooksTest {

	@Autowired
	ISuggestedBooksService suggestedbkService;

	// view suggested books
	@Test
	void testViewSuggestedBooks() {
		List<SuggestedBooks> suggestedBook = suggestedbkService.viewSuggestedBooksList();
		assertEquals(4, suggestedBook.size());
	}

	// update suggested books
	@Test
	void testUpdateSuggestedBooksDetails() throws BookNotFoundException {
		LocalDate d2 = LocalDate.of(2001, 10, 10);
		SuggestedBooks suggestedBook1 = suggestedbkService.viewSuggestedBookDetails(200);

		suggestedBook1.setTitle("Metabolism");
		suggestedBook1.setSubject("Science");
		suggestedBook1.setAuthor("SuryaPrabha");
		suggestedBook1.setPublications("Pearson");
		suggestedBook1.setDescription("Academia");
		suggestedBook1.setSuggested_date(d2);
		suggestedBook1.setStatus("Available Soon");
		Users user = new Users();
		user.setUserId(10);
		suggestedBook1.setUser(user);

		SuggestedBooks suggestedBook2 = suggestedbkService.updateSuggestedBookStatus(suggestedBook1);

		assertEquals("SuryaPrabha", suggestedBook2.getAuthor());
	}

	// delete book by id
	@Test
	void testsDeleteBookById() throws BookNotFoundException {
		SuggestedBooks suggestedBook1 = suggestedbkService.deleteSuggestedBooks(300);

		assertEquals(300, suggestedBook1.getId());
	}

	// view book by id
	@Test
	void testViewBookById() throws BookNotFoundException {
		SuggestedBooks suggestedBook = suggestedbkService.viewSuggestedBookDetails(400);

		assertEquals("Dohre", suggestedBook.getAuthor());
	}

	// suggest books
	@Test
	void testSuggestBooks() {
		LocalDate d1 = LocalDate.of(2002, 05, 06);
		SuggestedBooks suggestedBook2 = new SuggestedBooks(400, "GeoStationary", "Social Science", "Dohre",
				"Vidhya Publications", "Academic Book", d1, "Available");
		Users user = new Users();
		user.setUserId(10);
		suggestedBook2.setUser(user);

		SuggestedBooks suggestedBook = suggestedbkService.suggestBooks(suggestedBook2);

		assertEquals("GeoStationary", suggestedBook.getTitle());
	}

}
