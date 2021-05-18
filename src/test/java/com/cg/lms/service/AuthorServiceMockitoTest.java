package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.cg.lms.repository.IAuthorRepository;
import com.cg.lms.entity.Author;
import com.cg.lms.entity.Books;

@ExtendWith(SpringExtension.class)
public class AuthorServiceMockitoTest {

	@InjectMocks
	AuthorServiceImpl authorService;

	@MockBean
	IAuthorRepository authorRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	// To Add AuthorDetails
	@Test
	void testAddAuthorDetails() {
		Author author = new Author(9, "sudha", "kumar", "srk@gmail.com", "555555555");
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);
		author.setBooks(books);
		Mockito.when(authorRepo.save(author)).thenReturn(author);
		Author a1 = authorService.addAuthorDetails(author);
		assertEquals(9, a1.getAuthorId());
		assertEquals("sudha", a1.getFirstName());
		System.out.println(a1);
	}

	// To Update Author Details
	@Test
	void testUpdateAuthorDetails() {
		Author author = new Author(9, "sudheer", "kumar", "sdk@gmail.com", "444444444");
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7", 25, 170, "Shelf A");
		List<Books> books = new ArrayList<>();
		books.add(book);
		author.setBooks(books);
		Mockito.when(authorRepo.findById(9)).thenReturn(Optional.of(author));
		Mockito.when(authorRepo.save(author)).thenReturn(author);
		Author a2 = authorService.updateAuthorDetails(author);
		assertEquals(9, a2.getAuthorId());
		assertEquals("444444444", a2.getContactno());
	}

	// To Delete Author Details
	@Test
	void testDeleteAuthorDetails() {
		Author author = new Author(20, "sudharao", "kumarrao", "srkrao@gmail.com", "111111111");
		Mockito.when(authorRepo.findById(20)).thenReturn(Optional.of(author));
		authorRepo.deleteById(20);
		Author a3 = authorService.deleteAuthorDetails(20);
		assertEquals(20, a3.getAuthorId());
		assertEquals("kumarrao", a3.getLastName());
	}

	// To view Author List
	@Test
	void testViewAuthorList() {
		Author author1 = new Author(21, "kandhan", "kumar", "k1@gmail.com", "222222222");
		Author author2 = new Author(22, "kadamban", "kumar", "k2@gmail.com", "333333333");
		Author author3 = new Author(23, "kadhirvelan", "kumar", "k3@gmail.com", "888888888");
		List<Author> ar = new ArrayList<>();
		ar.add(author1);
		ar.add(author2);
		ar.add(author3);
		Mockito.when(authorRepo.findAll()).thenReturn(ar);

		List<Author> ar1 = authorService.viewAuthorsList();
		assertEquals(3, ar1.size());

		for (Author authorList : ar1) {
			System.out.println(authorList);
		}
	}

	// View Author by Id
	@Test
	void testViewAuthorById() {
		Author ar2 = new Author(24, "sam", "ram", "sr@gmail.com", "212121212");
		Mockito.when(authorRepo.findById(24)).thenReturn(Optional.of(ar2));
		Author ar = authorService.viewAuthorById(24);
		assertEquals(24, ar.getAuthorId());
		assertEquals("212121212", ar.getContactno());

	}

}
