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
	IAuthorRepository authorDao;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testAddAuthorDetails() {
		Author a = new Author(9,"sudha","kumar","srk@gmail.com","555555555");
		Books book = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",25, 170, "Shelf A");
		List <Books> books = new ArrayList<>();
		books.add(book);
		a.setBooks(books);
		Mockito.when(authorDao.save(a)).thenReturn(a);
		Author a1 = authorService.addAuthorDetails(a);
		assertEquals(9,a1.getAuthorId());
		assertEquals("sudha",a1.getFirstName());
		System.out.println(a1);
	}
	
	@Test
	void testUpdateAuthorDetails() {
		Author a = new Author(9,"sudheer","kumar","sdk@gmail.com","444444444");
		Mockito.when(authorDao.findById(9)).thenReturn(Optional.of(a));
		Mockito.when(authorDao.save(a)).thenReturn(a);
		Author a2 = authorService.updateAuthorDetails(a);
		assertEquals(9,a2.getAuthorId());
		assertEquals("444444444",a2.getContactno());	
	}
	
	@Test
	void testDeleteAuthorDetails() {
		Author a = new Author(20,"sudharao","kumarrao","srkrao@gmail.com","111111111");
		Mockito.when(authorDao.findById(20)).thenReturn(Optional.of(a));
		authorDao.deleteById(20);
		Author a3 = authorService.deleteAuthorDetails(20);
		assertEquals(20,a3.getAuthorId());
		assertEquals("kumarrao",a3.getLastName());
	}
	
	@Test
	void testViewAuthorList() {
		Author at1 = new Author(21,"kandhan","kumar","k1@gmail.com","222222222");
		Author at2 = new Author(22,"kadamban","kumar","k2@gmail.com","333333333");
		Author at3 = new Author(23,"kadhirvelan","kumar","k3@gmail.com","888888888");
		List <Author> ar = new ArrayList<> ();
		ar.add(at1);
		ar.add(at2);
		ar.add(at3);
		Mockito.when(authorDao.findAll()).thenReturn(ar);
		
		List <Author> ar1 = authorService.viewAuthorsList();
		assertEquals(3,ar1.size());
		
		for(Author authorList :ar1) {
			System.out.println(authorList);
		}
	}
	
	@Test
	void testViewAuthorById() {
		Author ar3 = new Author(24,"sam","ram","sr@gmail.com","212121212");
		Mockito.when(authorDao.findById(24)).thenReturn(Optional.of(ar3));
		Author ar = authorService.viewAuthorById(24);
		assertEquals(24,ar.getAuthorId());
		assertEquals("212121212",ar.getContactno());
		
	}
}
