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
	ISuggestedBooksService sb;

	@Test
	void testViewSuggestedBooks() {
		List<SuggestedBooks> sugbk = sb.viewSuggestedBooksList();
		assertEquals(4, sugbk.size());
	}

	@Test
	void testUpdateSuggestedBooksDetails() throws BookNotFoundException {
		LocalDate d2 = LocalDate.of(2001, 10, 10);
		SuggestedBooks sb1 = sb.viewSuggestedBookDetails(200);
		
		sb1.setTitle("Metabolism");
		sb1.setSubject("Science");
		sb1.setAuthor("SuryaPrabha");
		sb1.setPublications("Pearson");
		sb1.setDescription("Academia");
		sb1.setSuggested_date(d2);
		sb1.setStatus("Available Soon");
		Users user = new Users();
		user.setUserId(10);
		sb1.setUser(user);

		SuggestedBooks sugbk1 = sb.updateSuggestedBookStatus(sb1);
		
		assertEquals("SuryaPrabha", sugbk1.getAuthor());
	}

	@Test
	void testsDeleteBookById() throws BookNotFoundException {
		SuggestedBooks s1 = sb.deleteSuggestedBooks(300);
		
		assertEquals(300, s1.getId());
	}

	@Test
	void testViewBookById() throws BookNotFoundException {
		SuggestedBooks s = sb.viewSuggestedBookDetails(200);
		
		assertEquals("SuryaPrabha", s.getAuthor());
	}

	@Test
	void testSuggestBooks() {
		LocalDate d1 = LocalDate.of(2002, 05, 06);
		SuggestedBooks s2 = new SuggestedBooks(400, "GeoStationary", "Social Science", "Dohre", "Vidhya Publications",
				"Academic Book", d1, "Available");
		Users user = new Users();
		user.setUserId(10);
		s2.setUser(user);
		
		SuggestedBooks add = sb.suggestBooks(s2);
		
		assertEquals("GeoStationary", add.getTitle());
	}

}
