package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;
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

import com.cg.lms.entity.SuggestedBooks;
import com.cg.lms.entity.Users;
import com.cg.lms.repository.ISuggestedBooksRepository;

@ExtendWith(SpringExtension.class)
class SuggestedBooksMockitoTest {

	@InjectMocks
	SuggestedBooksServiceImpl suggestedBookImpl;

	@MockBean
	ISuggestedBooksRepository suggestedBookRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	LocalDate d1 = LocalDate.of(2002, 05, 06);
	LocalDate d2 = LocalDate.of(1998, 07, 03);

	// suggest book by id
	@Test
	void testSuggestedBooskById() {
		SuggestedBooks s = new SuggestedBooks(400, "GeoStationary", "Social Science", "Dohre", "Vidhya Publications",
				"Academic Book", d1, "Available");

		Mockito.when(suggestedBookRepo.findById(400)).thenReturn(Optional.of(s));

		SuggestedBooks sb = suggestedBookImpl.viewSuggestedBookDetails(400);

		assertEquals("GeoStationary", sb.getTitle());
	}

	// suggest book
	@Test
	void testSuggestBooks() {
		SuggestedBooks s = new SuggestedBooks(400, "GeoStationary", "Social Science", "Dohre", "Vidhya Publications",
				"Academic Book", d1, "Available");
		Date dob = Date.valueOf("1998-12-17");
		Date d3 = Date.valueOf("1998-10-1");
		Date d4 = Date.valueOf("1998-09-12");
		Users users = new Users();
		s.setUser(users);

		Mockito.when(suggestedBookRepo.save(s)).thenReturn(s);

		SuggestedBooks sb = suggestedBookImpl.suggestBooks(s);

		assertEquals("Social Science", sb.getSubject());
	}

	// view all suggested book
	@Test
	void testAllSuggestedBooks() {
		SuggestedBooks s = new SuggestedBooks(400, "GeoStationary", "Social Science", "Dohre", "Vidhya Publications",
				"Academic Book", d1, "Available");
		SuggestedBooks s1 = new SuggestedBooks(500, "Thoughts To BuildOn", "Personality", "CopMeyer",
				"Sara Publications", "General", d2, "Available");

		List<SuggestedBooks> sbk = new ArrayList<>();
		sbk.add(s1);
		sbk.add(s);

		Mockito.when(suggestedBookRepo.findAll()).thenReturn(sbk);

		List<SuggestedBooks> sbk1 = suggestedBookImpl.viewSuggestedBooksList();

		assertEquals(2, sbk1.size());

	}

	// update suggested books
	@Test
	void testUpdateSuggestedBooks() {
		SuggestedBooks s1 = new SuggestedBooks(500, "Thoughts To BuildOn", "Personality", "CopMeyer",
				"Sara Publications", "General", d2, "Not Available");
		Mockito.when(suggestedBookRepo.findById(500)).thenReturn(Optional.of(s1));
		Mockito.when(suggestedBookRepo.save(s1)).thenReturn(s1);
		Users user = new Users();
		user.setUserId(10);
		s1.setUser(user);
		SuggestedBooks sugbk = suggestedBookImpl.updateSuggestedBookStatus(500,s1);

		assertEquals("Not Available", sugbk.getStatus());
	}

	// delete suggested book
	@Test
	void testDeleteSuggestedBook() {
		SuggestedBooks s1 = new SuggestedBooks(500, "Thoughts To BuildOn", "Personality", "CopMeyer",
				"Sara Publications", "General", d2, "Available");

		Mockito.when(suggestedBookRepo.findById(500)).thenReturn(Optional.of(s1));

		suggestedBookRepo.deleteById(500);

		SuggestedBooks sbk = suggestedBookImpl.deleteSuggestedBooks(500);

		assertEquals("Thoughts To BuildOn", sbk.getTitle());
	}

}