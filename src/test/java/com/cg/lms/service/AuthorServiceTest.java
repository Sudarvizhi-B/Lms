package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.lms.entity.Author;
import com.cg.lms.entity.Books;
import com.cg.lms.exception.AuthorNotFoundException;

@SpringBootTest
public class AuthorServiceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@Autowired
	IAuthorService authorService;

	// Test to View AuthorList
	@Test
	//@Disabled
	void testShouldViewAuthorsList() {
		List<Author> author1 = authorService.viewAuthorsList();
		System.out.println(author1);
		assertEquals(3, author1.size()); // Size - Total no. of Rows
	}

	// To Update Author Details
	@Test
	//@Disabled
	void testShoudlUpdateAuthorDetails() throws AuthorNotFoundException {
		Author author2 = authorService.viewAuthorById(9);
		author2.setFirstName("Vikram");
		author2.setLastName("kumar");
		author2.setEmail("vk@gmail.com");
		author2.setContactno("777777778");
		Books book = new Books(102, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);
		author2.setBooks(books);

		Author updatedAr = authorService.updateAuthorDetails(author2,9);

		assertEquals("Vikram", updatedAr.getFirstName());
		assertEquals("kumar", updatedAr.getLastName());
		assertEquals("vk@gmail.com", updatedAr.getEmail());
		assertEquals("777777778", updatedAr.getContactno());
	}

	// Delete Author Details
	@Test
	//@Disabled
	void testShouldDeleteAuthorDetails() throws AuthorNotFoundException {
		Author author3 = authorService.deleteAuthorDetails(12);
		assertEquals(12, author3.getAuthorId());
	}

	// View Author by Id
	@Test
	//@Disabled
	void testShouldViewAuthorById() throws AuthorNotFoundException {
		Author author4 = authorService.viewAuthorById(9);
		assertEquals("Vikram", author4.getFirstName());
	}

	// Add Author Details
	@Test
	//@Disabled
	void testShouldAddAuthorDetail() {

		Author author = new Author(12, "sudha", "kumar", "srk@gmail.com", "555555556");
		Books book = new Books(25, "AbdulKalam", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf Z");
		List<Books> books = new ArrayList<>();
		books.add(book);
		author.setBooks(books);

		Author persistedAr = authorService.addAuthorDetails(author);
		assertEquals("srk@gmail.com", persistedAr.getEmail());

	}

}
