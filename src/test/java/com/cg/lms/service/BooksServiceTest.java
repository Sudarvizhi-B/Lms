package com.cg.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.lms.entity.Books;
import com.cg.lms.exception.BookNotFoundException;

@SpringBootTest
class BooksServiceTest {
	
	@Autowired
	IBooksService booksService;
	
	@Test
	@Disabled
	public void testAddBook() {
		Books books = new Books(101, "Harry Potter", "Novel", "J.K.Rowling", 1999, "986-7-180715-7",
				25, 170, "Shelf A");
		Books book = booksService.addBook(books);
		System.out.println(book);
		
		assertEquals(101, book.getBookid());
		assertEquals("Harry Potter", book.getTitle());
		assertEquals("Novel", book.getSubject());
		assertEquals("J.K.Rowling", book.getAuthor());
		assertEquals(1999, book.getPublishedYear());
		assertEquals(25, book.getQuantity());
		assertEquals(170, book.getBookCost());
		assertEquals("Shelf A", book.getShelfDetails());
	}
	
	@Test
	@Disabled
	public void testUpdateBookDetails() {
		Books books = new Books();
		
		books.setBookid(101);
		books.setAuthor("J.K.Rowling");
		books.setBookCost(170);
		books.setIsbnCode("986-7-180715-7");
		books.setQuantity(12);
		books.setPublishedYear(1999);
		books.setShelfDetails("Shelf A");
		books.setSubject("Novel");
		books.setTitle("Harry Potter");
		
		Books book = booksService.updateBookDetails(books);
		System.out.println(book);
		
		assertEquals(101, book.getBookid());
		assertEquals("Harry Potter", book.getTitle());
		assertEquals("Novel", book.getSubject());
		assertEquals("J.K.Rowling", book.getAuthor());
		assertEquals(1999, book.getPublishedYear());
		assertEquals(12, book.getQuantity());
		assertEquals(170, book.getBookCost());
		assertEquals("Shelf A", book.getShelfDetails());
	}
	
	@Test
	@Disabled
	public void testRemoveBook() throws BookNotFoundException{
		Books book = booksService.removeBook(109);
		
		if(book==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(book);
		
		assertEquals(10,book.getQuantity());
	}
	
	@Test
	@Disabled
	public void testViewById() throws BookNotFoundException{
		Books book = booksService.viewBookById(102);
		
		if(book==null) {
			throw new BookNotFoundException("Book Not Found with the given Id");
		}
		System.out.println(book);
		
		assertEquals("Harry Potter",book.getTitle());
	}
	
	@Test
	@Disabled
	public void testViewAllBooks() {
		List<Books> books = booksService.viewAllBooks();
		System.out.println(books);
		
		assertEquals(4,books.size());
	}
	
	@Test
	@Disabled
	public void testFindAllByTitle() throws BookNotFoundException{
		List<Books> books = booksService.findAllByTitle("Harry Potter");
		System.out.println(books);
		
		assertEquals(2,books.size());
	}
	
	@Test
	@Disabled
	public void testFindAllBySubject() throws BookNotFoundException{
		List<Books> books = booksService.findAllBySubject("Novel");
		System.out.println(books);
		
		assertEquals(3,books.size());
	}
}
